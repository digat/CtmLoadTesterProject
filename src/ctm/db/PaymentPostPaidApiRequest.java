/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.db;

import com.BillerInfo;
import com.Statics;
import com.google.common.collect.Lists;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import ctm.types.PostpaidDBRes;
import ctm.types.PostpaidPaymentData;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TareqSaleh
 */
public class PaymentPostPaidApiRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPostPaidApiRequest.class);

    public static List<PostpaidPaymentData> handlePaymentMessage(long inqRefNo, DataBaseClient client, BillerInfo billerInfo)
            throws SQLException {

        long time = Instant.now().toEpochMilli();
        List<PostpaidPaymentData> result = Lists.newArrayList();

        String spCall = "{call dbo.TSP_HandlePaymentMessage_CTM (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        LOGGER.trace("Start TSP_HandlePaymentMessage");
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    SQLServerDataTable dtPaymentMessage = fillPaymentDataTable(inqRefNo, billerInfo);
                    if (dtPaymentMessage != null) {
                        try {
                            SQLServerDataTable amlScreeningLogMessage = generateAmlLogDataTable();
                            stmt.setSQLXML(1, null); //"XmlMsg"
                            stmt.setString(2, UUID.randomUUID().toString()); //"GUID"
                            stmt.setInt(3, 4); //"Status"
                            stmt.setInt(4, 0); //"ErrorCode"
                            stmt.setInt(5, 21); //"BankCode"
                            stmt.setNull(6, Types.INTEGER); //"PSPCode"
                            stmt.setBigDecimal(7, null); //"IncreaseAmountPSP"
                            stmt.setNull(8, Types.INTEGER); //"NumberOFTrxPSP"
                            stmt.setBigDecimal(9, new BigDecimal("124689.182")); //"IncreaseAmountBank"
                            stmt.setInt(10, 995); //"NumberOFTrxBank"
                            stmt.setInt(11, 1); //"PaymentType"
                            stmt.setStructured(12, "dbo.HandleAMLScreeningLog", amlScreeningLogMessage);
                            stmt.setStructured(13, "dbo.TSP_HandlePaymentMessage_BankMessage", dtPaymentMessage);
                            stmt.registerOutParameter(14, Types.BIGINT);  // "PaymentID"
                            stmt.registerOutParameter(15, Types.NVARCHAR);  // "JOEBPPSTrx"
                            stmt.registerOutParameter(16, Types.NVARCHAR);  // "RefNo"
                            stmt.registerOutParameter(17, Types.INTEGER);  // "ErrorCodeOUT"
                            stmt.registerOutParameter(18, Types.BIGINT);  // "MsgID"
                            stmt.setQueryTimeout(30000);
                            stmt.setPoolable(true);
                            stmt.executeUpdate();
                            String jOEBPPSTrx = stmt.getString("JOEBPPSTrx");
                            Long paymentID = stmt.getString("PaymentID") != null ? stmt.getLong("PaymentID") : null;
                            Integer errorCode = stmt.getString("ErrorCodeOUT") != null ? stmt.getInt("ErrorCodeOUT") : null;
                            Long msgID = stmt.getString("MsgID") != null ? stmt.getLong("MsgID") : null;
                            LOGGER.info("[" + billerInfo.getServiceId() + "] PostPaid Payment values JOEBPPSTrx={}, PaymentID={} , ErrorCode={} , MsgID={}", jOEBPPSTrx, paymentID, errorCode, msgID);
                            result.add(new PostpaidPaymentData(null, new PostpaidDBRes(jOEBPPSTrx, paymentID, errorCode, msgID)));
                            Statics.getMoreResults(stmt);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            LOGGER.error("[DL] {} {}", spCall, ex.fillInStackTrace());
                            
                        }
                    } else {
                        //result.add(new PostpaidPaymentData(null, new PostpaidDBRes(jOEBPPSTrx, paymentID, errorCode, msgID)));
                        //result.addAll(postpaidProcessingDataList.stream().map(rec -> new PostpaidPaymentData(rec, null)).collect(Collectors.toList()));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
            throw ex;
        } finally {
            time = Instant.now().toEpochMilli() - time;
            LOGGER.trace("End TSP_HandlePaymentMessage spExecuteTime={} in ms ", time);
        }
        return result;
    }

    private static SQLServerDataTable generateAmlLogDataTable() throws SQLServerException {
        SQLServerDataTable dataTable = new SQLServerDataTable();
        dataTable.addColumnMetadata("AMLScreeningLogId", Types.INTEGER);
        dataTable.addColumnMetadata("RefNo", Types.INTEGER);
        return dataTable;
    }

    private static SQLServerDataTable generatePaymentsDataTable() throws SQLServerException {
        SQLServerDataTable dataTable = new SQLServerDataTable();
        dataTable.addColumnMetadata("JOEBPPSTrx", Types.NVARCHAR);
        dataTable.addColumnMetadata("BankTrxID", Types.NVARCHAR);
        dataTable.addColumnMetadata("BillerCode", Types.INTEGER);
        dataTable.addColumnMetadata("BillingNo", Types.NVARCHAR);
        dataTable.addColumnMetadata("BillNo", Types.NVARCHAR);
        dataTable.addColumnMetadata("Currency", Types.NVARCHAR);
        dataTable.addColumnMetadata("DueAmt", Types.DECIMAL);
        dataTable.addColumnMetadata("PaidAmt", Types.DECIMAL);
        dataTable.addColumnMetadata("ProcessDate", Types.TIMESTAMP);
        dataTable.addColumnMetadata("STMTDate", Types.DATE);
        dataTable.addColumnMetadata("ErrorCode", Types.INTEGER);
        dataTable.addColumnMetadata("PayerName", Types.NVARCHAR);
        dataTable.addColumnMetadata("PayerId", Types.VARCHAR);
        dataTable.addColumnMetadata("PayerIdType", Types.INTEGER);
        dataTable.addColumnMetadata("PayerAddress", Types.NVARCHAR);
        dataTable.addColumnMetadata("PayerPhone", Types.VARCHAR);
        dataTable.addColumnMetadata("PayerNation", Types.INTEGER);
        dataTable.addColumnMetadata("AccessChannelId", Types.INTEGER);
        dataTable.addColumnMetadata("PaymentMethodId", Types.INTEGER);
        dataTable.addColumnMetadata("PmtStatusId", Types.INTEGER);
        dataTable.addColumnMetadata("PaymentTypeId", Types.INTEGER);
        dataTable.addColumnMetadata("BillerServiceTypesId", Types.BIGINT);
        dataTable.addColumnMetadata("PrepaidCategoriesId", Types.INTEGER);
        dataTable.addColumnMetadata("PaymentID", Types.BIGINT);
        dataTable.addColumnMetadata("BillInquiryId", Types.BIGINT);
        dataTable.addColumnMetadata("JOEBPPSNo", Types.BIGINT);
        dataTable.addColumnMetadata("Email", Types.VARCHAR);
        dataTable.addColumnMetadata("FirstName", Types.NVARCHAR);
        dataTable.addColumnMetadata("SecondName", Types.NVARCHAR);
        dataTable.addColumnMetadata("ThirdName", Types.NVARCHAR);
        dataTable.addColumnMetadata("FamilyName", Types.NVARCHAR);
        dataTable.addColumnMetadata("NameAr", Types.NVARCHAR);
        dataTable.addColumnMetadata("SecondNameAr", Types.NVARCHAR);
        dataTable.addColumnMetadata("ThirdNameAr", Types.NVARCHAR);
        dataTable.addColumnMetadata("FamilyNameAr", Types.NVARCHAR);
        dataTable.addColumnMetadata("CivilNo", Types.NVARCHAR);
        dataTable.addColumnMetadata("DateOfBirth", Types.DATE);
        dataTable.addColumnMetadata("GenderId", Types.INTEGER);
        dataTable.addColumnMetadata("LifeStatusId", Types.INTEGER);
        dataTable.addColumnMetadata("MaritalStatusId", Types.INTEGER);
        dataTable.addColumnMetadata("CSPDVerificationStatusId", Types.INTEGER);
        dataTable.addColumnMetadata("CSPDVerificationTypeId", Types.INTEGER);
        dataTable.addColumnMetadata("IsLockedNow", Types.BIT);
        dataTable.addColumnMetadata("PaidAmountWithoutFees", Types.DECIMAL);
        dataTable.addColumnMetadata("BillerServiceTypesFeesTypeID", Types.INTEGER);
        dataTable.addColumnMetadata("RefNo", Types.INTEGER);
        return dataTable;
    }

    private static SQLServerDataTable fillPaymentDataTable(long inqRefNo, BillerInfo billerInfo) throws SQLServerException {
        SQLServerDataTable paymentDataTable = generatePaymentsDataTable();

        paymentDataTable.addRow(null, "RAJ11911111" + Statics.getReandomNumber(),
                billerInfo.getBillerCode(), "Test_123", "Test_123", null, "70.63",
                "70.63", Statics.PROCESS_DATE, "2022-10-09", 0, null, null, null,
                null, null, null, 1, 2, 1, 1, billerInfo.getServiceId(), null, null,
                inqRefNo, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, 1, 3, true, 69.0000, 2, 1);

        return paymentDataTable;
    }
}
