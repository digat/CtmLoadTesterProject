/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.db;

import com.BillerInfo;
import com.Statics;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TareqSaleh
 */
public class PaymentPrePaidApiRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentPrePaidApiRequest.class);

    public static int handlePrepaidTransaction(DataBaseClient client, BillerInfo billerInfo)
            throws SQLException {

        long time = Instant.now().toEpochMilli();
        String spCall = "{call dbo.SP_HandlePrepaidPayment(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
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
                    try {
                        stmt.setNull(1, Types.SQLXML);// "XmlMsg"
                        stmt.setString(2, UUID.randomUUID().toString());// "GUID"
                        stmt.setInt(3, 21);// "BankCode"
                        stmt.setNull(4, Types.INTEGER);// "PSPCode"
                        stmt.setInt(5, 2);// "Status"
                        stmt.setInt(6, 0);// "MsgErrorCode"
                        stmt.registerOutParameter(7, Types.NVARCHAR);// "JOEBPPSTrx"
                        stmt.setString(8, "RAJ321654212" + Statics.getReandomNumber());// "BankTrxID"
                        stmt.setInt(9, billerInfo.getBillerCode());// "BillerCode"
                        stmt.setString(10, "Test_Pre_1");// "BillingNo"
                        stmt.setInt(11, 1);// "AccessChannelId"
                        stmt.setInt(12, 2);// "PaymentMethodId"
                        stmt.setInt(13, 1);// "PaymentStatusId"
                        stmt.setInt(14, 2);// "PaymentTypeId"
                        stmt.setNull(15, Types.NVARCHAR);// "Currency"
                        stmt.setBigDecimal(16, new BigDecimal(11));// "DueAmt"
                        stmt.setBigDecimal(17, new BigDecimal(11));// "PaidAmt"
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]");
                        LocalDateTime dateTime = LocalDateTime.parse("2023-01-09T12:00:23", formatter);
                        Timestamp processDate = Timestamp.valueOf(dateTime);
                        stmt.setTimestamp(18, processDate);// "ProcessDate"
                        stmt.setDate(19, Date.valueOf("2022-10-09"));// "STMTDate"
                        stmt.setLong(20, billerInfo.getServiceId());// "BillerServiceTypeId"
                        stmt.setNull(21, Types.INTEGER);// "PrepaidCatId"
                        stmt.setInt(22, 0);// "TrxErrorCode"
                        stmt.setNull(23, Types.NVARCHAR);// "PayerName"
                        stmt.setNull(24, Types.VARCHAR);// "PayerId"
                        stmt.setNull(25, Types.INTEGER);// "PayerIdType"
                        stmt.setNull(26, Types.NVARCHAR);// "PayerAddress"
                        stmt.setNull(27, Types.VARCHAR);// "PayerPhone"
                        stmt.setNull(28, Types.INTEGER);// "PayerNation"
                        stmt.setNull(29, Types.BIGINT);// "JOEBPPSNo"
                        stmt.setBoolean(30, true);// "InsertPayment"
                        stmt.setBigDecimal(31, new BigDecimal("3189.029"));// "IncreaseAmount"
                        stmt.setInt(32, 43495);// "NumberOFTrx"
                        stmt.registerOutParameter(33, Types.BIGINT);// "PaymentId"
                        stmt.setNull(34, Types.VARCHAR);// "Email"
                        stmt.setLong(35, billerInfo.getValidationCode());// "ValidationCode"
                        stmt.setLong(36, billerInfo.getValidationCode());// "PrepaidProcessingDataId"
                        stmt.setNull(37, Types.BIGINT);// "CustomerProfileID"
                        stmt.setNull(38, Types.NVARCHAR);// "FirstName"
                        stmt.setNull(39, Types.NVARCHAR);// "SecondName"
                        stmt.setNull(40, Types.NVARCHAR);// "ThirdName"
                        stmt.setNull(41, Types.NVARCHAR);// "FamilyName"
                        stmt.setNull(42, Types.NVARCHAR);// "NameAr"
                        stmt.setNull(43, Types.NVARCHAR);// "SecondNameAr"
                        stmt.setNull(44, Types.NVARCHAR);// "ThirdNameAr"
                        stmt.setNull(45, Types.NVARCHAR);// "FamilyNameAr"
                        stmt.setNull(46, Types.NVARCHAR);// "CivilNo"
                        stmt.setNull(47, Types.DATE);// "DateOfBirth"
                        stmt.setNull(48, Types.TINYINT);// "CSPDVerificationStatusId"
                        stmt.setNull(49, Types.TINYINT);// "GenderId"
                        stmt.setNull(50, Types.TINYINT);// "MaritalStatusId"
                        stmt.setNull(51, Types.TINYINT);// "LifeStatusId"
                        stmt.setInt(52, 1);// "CSPDVerificationTypeId"
                        SQLServerDataTable amlScreeningLogDataTable = generateAmlLogDataTableForPrepaid();
                        stmt.setStructured(53, "dbo.HandlePrepaidAMLScreeningLog", amlScreeningLogDataTable);
                        stmt.setInt(54, 1); //"BillerServiceTypesFeesTypeID"
                        stmt.setBigDecimal(55, new BigDecimal("11"));  //"PaidAmountWithoutFee"
                        stmt.registerOutParameter(56, Types.INTEGER); //"Result"
                        stmt.registerOutParameter(57, Types.BIGINT); // "MsgIdOut"
                        stmt.setQueryTimeout(30000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        String jOEBPPSTrx = stmt.getString("JOEBPPSTrx");
                        Long paymentID = stmt.getString("PaymentId") != null ? stmt.getLong("PaymentId") : null;
                        Integer errorCode = stmt.getString("Result") != null ? stmt.getInt("Result") : null;
                        Long msgID = stmt.getString("MsgIdOut") != null ? stmt.getLong("MsgIdOut") : null;
                        LOGGER.info("[" + billerInfo.getServiceId() + "] PrePaid Payment with values JOEBPPSTrx={}, PaymentID={} , ErrorCode={} , MsgID={}", jOEBPPSTrx, paymentID, errorCode, msgID);
                        Statics.getMoreResults(stmt);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
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
        return -1;
    }

    private static SQLServerDataTable generateAmlLogDataTableForPrepaid() throws SQLServerException {
        SQLServerDataTable dataTable = new SQLServerDataTable();
        dataTable.addColumnMetadata("AMLScreeningLogId", Types.INTEGER);
        return dataTable;
    }
}
