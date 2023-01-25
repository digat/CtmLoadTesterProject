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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.time.Instant;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TareqSaleh
 */
public class InqueryPostPaidApiRequest {


    private static final Logger LOGGER = LoggerFactory.getLogger(InqueryPostPaidApiRequest.class);

    public static long insertBillInquiry(DataBaseClient client, BillerInfo billerInfo) throws SQLException {
        long result = -1L;
        String spCall = "{call dbo.SP_InsertBillInquiries (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        long time = Instant.now().toEpochMilli();
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    ////LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.set(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setNull(1, Types.SQLXML); // "RequestMessage"
                        stmt.setNull(2, Types.SQLXML); // "ResponseMessage"
                        stmt.setString(3, UUID.randomUUID().toString()); // "GUID"
                        stmt.setInt(4, 21); // "ParticipantCode"
                        stmt.setInt(5, 1); // "ParticipantType"
                        stmt.setInt(6, billerInfo.getBillerCode()); // "BillerCode"
                        stmt.setString(7, "Test_123"); // "BillingNo"
                        stmt.setString(8, "Test_123"); // "BillNo"
                        stmt.setString(9, billerInfo.getServiceType()); // "ServiceType"
                        stmt.setInt(10, 1); // "InquiryType"
                        stmt.setInt(11, 0); // "ErrorCode"
                        stmt.registerOutParameter(12, Types.FLOAT); // "BillInquiryID"
                        stmt.setNull(13, Types.VARCHAR); // "PayerId"
                        stmt.setNull(14, Types.VARCHAR); // "PayerIdType"
                        stmt.setNull(15, Types.VARCHAR); // "PayerNation"
                        stmt.setNull(16, Types.NVARCHAR); // "PayerName"
                        stmt.setNull(17, Types.VARCHAR); // "PayerPhone"
                        stmt.setNull(18, Types.NVARCHAR); // "PayerAddress"
                        stmt.setNull(19, Types.VARCHAR); // "Email"
                        stmt.setNull(20, Types.BIGINT); // "JOEBPPSNo"
                        stmt.setNull(21, Types.NVARCHAR); // "FirstName"
                        stmt.setNull(22, Types.NVARCHAR); // "SecondName"
                        stmt.setNull(23, Types.NVARCHAR); // "ThirdName"
                        stmt.setNull(24, Types.NVARCHAR); // "FamilyName"
                        stmt.setNull(25, Types.NVARCHAR); // "NameAr"
                        stmt.setNull(26, Types.NVARCHAR); // "SecondNameAr"
                        stmt.setNull(27, Types.NVARCHAR); // "ThirdNameAr"
                        stmt.setNull(28, Types.NVARCHAR); // "FamilyNameAr"
                        stmt.setNull(29, Types.NVARCHAR); // "CivilNo"
                        stmt.setNull(30, Types.DATE); // "DateOfBirth"
                        stmt.setNull(31, Types.TINYINT); // "CSPDVerificationStatusId"
                        stmt.setNull(32, Types.TINYINT); // "GenderId"
                        stmt.setNull(33, Types.TINYINT); // "MaritalStatusId"
                        stmt.setNull(34, Types.TINYINT); // "LifeStatusId"
                        stmt.setNull(35, Types.TINYINT); // "CSPDVerificationTypeId"
                        stmt.setBoolean(36, true); // "IsAutoCustomerProfileCreation"4
                        //stmt.setPoolable(true);
                        //int timeout = ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) != null ? ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) : 10;
                        stmt.setQueryTimeout(3000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        result = stmt.getLong("BillInquiryID");
                        Statics.getMoreResults(stmt);
                        ////LOGGER.info("result {}", result);
                        //System.err.println("BillInquiryID = " + result);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
            throw ex;
        } finally {
            time = Instant.now().toEpochMilli() - time;
            //LOGGER.trace("End SP_InsertBillInquiries spExecuteTime={} in ms", time);
        }
        return result;
    }

    public static Long insertBillMessage(DataBaseClient client, BillerInfo billerInfo) throws SQLException {
        String xmlRequest = "<MFEP><MsgHeader><TmStp>2023-01-06T22:20:35</TmStp>"
                + "<GUID>63957776-f08d-4581-956e-246f859a24b5</GUID><TrsInf><SdrCod"
                + "e>45</SdrCode><RcvCode>0</RcvCode><ResTyp>BILPULRS</ResTyp></T"
                + "rsInf><Result><ErrorCode>0</ErrorCode><ErrorDesc>Success</ErrorDesc><"
                + "Severity>Info</Severity></Result></MsgHeader><MsgBody><BillRec><list><"
                + "list><AcctInfo><BillingNo>Test_123</BillingNo><BillNo>Test_123</BillNo></"
                + "AcctInfo><BillStatus>BillNew</BillStatus><DueAmount>23</DueAmount><IssueDate>"
                + "2023-01-06T22:20:35</IssueDate><DueDate>2023-01-06T22:20:35</DueDate><ServiceType>Needy_Family_Sponsorship</ServiceType><PmtConst><AllowPart>true</AllowPart><Lower>1</Lower><Upper>500</Upper></PmtConst><AdditionalInfo><CustName>Support Madfooatcom</CustName><FreeText>Support Madfooatcom</FreeText><Email>aelaiwat@madfooat.com</Email><Phone>+962796696843</Phone></AdditionalInfo></list></list></BillRec><RecCount>1</RecCount></MsgBody><MsgFooter><Security><Signature>UR67UDYgelYN0UZqa/wte3YcJmBzHiFRVGbQriyN2o6RJA9leDzA5WduaH7cl+Gw3sRmYD8cLH8Nlor7UVUFC5kHZZYnhb1jERrtpIg3glq7MY7uaL+h9OYYvHjP/u9oTy+xpWZ5sRSy4cLD3pn/WqN/H+690QTV/qgESd39AnPHybHgfnrkICqW4tviru9mirsLsI8MvnB5pLdMNRTqNh84iLY7nI4eSzUXnfD14W+tHVNfWBAZkWeXKCwThKNRcs90Xn1AEhuJyd3y3/D+dXqzilFKb3xkOHm/7MWUw6HL6EpvjE3iJDXnDbiEw11C673j0XIxHsh1y9wVfwz7/wXcBpbYNM9FROgqq7qoYo2JsKaN2CbU3lxpmYN58EOc7Rhsv7HNC20ZIMJoaeK5CsoaYZ1SKXaoiIsevmpydMeIiOS6FoSgh8GoFN04g5vVaCMIEKBl6SZzfjCX3Ihz5nL0220dPS7F3PMcn8uBENMBRljSLtQEaVr748BlVE4C3gZa9roARn1dUKJJSxJS1FcDSkobE1CoflUm5n/h80pzO7IG/IQHbgsxtlUn/apq1IU93FXtRddltMYjeRTMfIHbUJZdD0d0M9KBzjD7kQZR17+3vIXlXZA72mguOoMxqvBrz2TB6Wh/d0agRLmTfwmfr9z0ImJaPzi/9/iqIoU=</Signature></Security></MsgFooter></MFEP>";

        Long msgId = null;
        long time = Instant.now().toEpochMilli();
        //LOGGER.info("Calling dbo.SP_InsertUpdateBillMessage");
        String spCall = "{call dbo.SP_InsertUpdateBillMessage (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    //LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.registerOutParameter(1, Types.BIGINT);  // "MsgID"
                        stmt.setString(2, xmlRequest);  // "XMLMsg"
                        stmt.setString(3, xmlRequest);  // "ConfirmationXMLMessage"
                        stmt.setNull(4, Types.INTEGER);  // "ConfirmationStatus"
                        stmt.setString(5, "63957776-f08d-4581-956e-246f859a24b5");  // "GUID"
                        stmt.setInt(6, billerInfo.getBillerCode());  // "BillerCode"
                        stmt.setInt(7, 2);  // "Status"
                        stmt.setInt(8, 3);  // "MsgType"
                        stmt.setInt(9, 0);  // "ErrorCode"
                        stmt.setString(10, "Success");  // "ErrorDesc"
                        stmt.setInt(11, 0); // When create billproccess recovery must change it  // "RetryCount"
                        stmt.setNull(12, Types.INTEGER); // When create billproccess recovery must change it  // "CreatedBy"
                        stmt.setNull(13, Types.INTEGER); // When create billproccess recovery must change it  // "UpdatedBy"
                        //int timeout = ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) != null ? ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) : 10;
                        //stmt.setPoolable(true);
                        stmt.setQueryTimeout(3000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        msgId = stmt.getLong("MsgID");
                        Statics.getMoreResults(stmt);
                        //LOGGER.info("Bill inserted with msgId={} ", msgId);
                        //System.err.println("MsgID = " + msgId);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
            throw ex;
        } finally {
            time = Instant.now().toEpochMilli() - time;
            //LOGGER.trace("End SP_InsertUpdateBillMessage spExecuteTime={} in ms ", time);
        }
        return msgId;
    }

    private static SQLServerDataTable generateBillDataTableColumns() throws SQLServerException {
        SQLServerDataTable bill = new SQLServerDataTable();
        bill.addColumnMetadata("BillingNo", Types.NVARCHAR);
        bill.addColumnMetadata("BillNo", Types.NVARCHAR);
        bill.addColumnMetadata("BillStatusId", Types.INTEGER);
        bill.addColumnMetadata("DueAmount", Types.DECIMAL);
        bill.addColumnMetadata("DueAmountWithFees", Types.DECIMAL);
        bill.addColumnMetadata("IssueDate", Types.TIMESTAMP);
        bill.addColumnMetadata("OpenDate", Types.TIMESTAMP);
        bill.addColumnMetadata("DueDate", Types.TIMESTAMP);
        bill.addColumnMetadata("ExpiryDate", Types.TIMESTAMP);
        bill.addColumnMetadata("CloseDate", Types.TIMESTAMP);
        bill.addColumnMetadata("ServiceType", Types.NVARCHAR);
        bill.addColumnMetadata("BillTypeId", Types.INTEGER);
        bill.addColumnMetadata("AllowPart", Types.BIT);
        bill.addColumnMetadata("Lower", Types.DECIMAL);
        bill.addColumnMetadata("Upper", Types.DECIMAL);
        bill.addColumnMetadata("SubPmts", Types.SQLXML);
        bill.addColumnMetadata("IsFeesAdded", Types.BIT);
        bill.addColumnMetadata("CBJFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPFees", Types.DECIMAL);
        bill.addColumnMetadata("CorridorID", Types.BIGINT);
        bill.addColumnMetadata("ErrorCode", Types.INTEGER);
        bill.addColumnMetadata("BillsCount", Types.INTEGER);
        bill.addColumnMetadata("CustomerName", Types.NVARCHAR);
        bill.addColumnMetadata("CustomerExtraInfo", Types.NVARCHAR);
        bill.addColumnMetadata("SenderNameEn", Types.NVARCHAR);
        bill.addColumnMetadata("SenderNameAr", Types.NVARCHAR);
        bill.addColumnMetadata("BeneficiaryNameEn", Types.NVARCHAR);
        bill.addColumnMetadata("BeneficiaryNameAr", Types.NVARCHAR);
        bill.addColumnMetadata("OfficialID", Types.NVARCHAR);
        bill.addColumnMetadata("OfficialTypeID", Types.INTEGER);
        bill.addColumnMetadata("NationallityID", Types.INTEGER);
        bill.addColumnMetadata("BeneficiaryNationallityID", Types.INTEGER);
        bill.addColumnMetadata("TransferReason", Types.VARCHAR);
        bill.addColumnMetadata("ReceivingCountryID", Types.INTEGER);
        bill.addColumnMetadata("CustomerEmail", Types.VARCHAR);
        bill.addColumnMetadata("CustomerPhone", Types.VARCHAR);
        bill.addColumnMetadata("MFEPCustomerFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPCustomerFixedFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPCustomerPercentageFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPBillerFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPBillerFixedFees", Types.DECIMAL);
        bill.addColumnMetadata("MFEPBillerPercentageFees", Types.DECIMAL);
        bill.addColumnMetadata("CBCustomerFees", Types.DECIMAL);
        bill.addColumnMetadata("CBCustomerFixedFees", Types.DECIMAL);
        bill.addColumnMetadata("CBCustomerPercentageFees", Types.DECIMAL);
        bill.addColumnMetadata("CBBillerFees", Types.DECIMAL);
        bill.addColumnMetadata("CBBillerFixedFees", Types.DECIMAL);
        bill.addColumnMetadata("CBBillerPercentageFees", Types.DECIMAL);
        bill.addColumnMetadata("CorridorFeesId", Types.INTEGER);
//		bill.addColumnMetadata("CurrencyId", Types.INTEGER);
        return bill;
    }

    public static long insertBatchBill(Long msgId, Long billInquiryId, DataBaseClient client, BillerInfo billerInfo) throws Exception {
        SQLServerDataTable billRecords = generateBillDataTableColumns();
        billRecords.addRow("Test_123", "Test_123", 1, 69.000, 70.630,
                Statics.ISSUE_DATE, null, Statics.DUE_DATE, null, null, billerInfo.getServiceType(), null, true, 2.63, 501.63, null, true,
                0.733, 0.897, Statics.CORD_ID, 0, 1, "Support Madfooatcom", "Support Madfooatcom", null, null, null, null, null, null, null,
                null, null, null, null, null, 0.897,
                0.138, 0.759, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 0.733, 0.112, 0.621, BigDecimal.ZERO,
                BigDecimal.ZERO, BigDecimal.ZERO, Statics.CORD_FEES_ID);
        long billId = 0;
        long time = Instant.now().toEpochMilli();
        //LOGGER.info("Calling dbo.SP_InsertBatchBill_CTM");
        String spCall = "{call dbo.SP_InsertBatchBill_CTM (?,?,?,?,?,?,?,?,?,?)}";
        //LOGGER.trace("execute SP_InsertBatchBill_CTM SP");
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    //LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setLong(1, msgId); // "MsgID"
                        stmt.setInt(2, billerInfo.getBillerCode()); // "BillerCode"
                        stmt.setStructured(3, "dbo.InsertBatchBill_BillInfo", billRecords); // "BillInfo"
                        stmt.setInt(4, 3); // "MessageType"
                        stmt.setLong(5, billInquiryId); // "BillInquiryID"
                        stmt.setString(6, "Mahmoudsa"); // "MachineName"
                        stmt.registerOutParameter(7, Types.BIGINT); // "BillID"
                        stmt.registerOutParameter(8, Types.INTEGER); // "BillerCodeOut"
                        stmt.registerOutParameter(9, Types.NVARCHAR); // "BillingNo"
                        stmt.registerOutParameter(10, Types.BIGINT); // "BillerServiceTypeId"
                        //int timeout = ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) != null ? ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) : 10;
                        stmt.setQueryTimeout(30000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        billId = stmt.getLong("BillID");
                        Statics.getMoreResults(stmt);
                        ////LOGGER.trace("Batchbill id={}", billId);
                        //System.err.println("BillID = " + billId);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
            throw new Exception(ex);
        } finally {
            time = Instant.now().toEpochMilli() - time;
            ////LOGGER.trace("End SP_InsertBatchBill_CTM spExecuteTime={} in ms ", time);
        }
        ////LOGGER.trace("SP_InsertBatchBill_CTM SP executed success");
        return billId;
    }

    public static void updateBillInquiryResponseMessage(long billInquiryId, DataBaseClient client) throws Exception {

        String spCall = "{call dbo.SP_UpdateBillInquiryResponseMessage (?,?,?)}";
        long time = Instant.now().toEpochMilli();
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    //LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setLong(1, billInquiryId);// "BillInquiryID"
                        stmt.setString(2, UUID.randomUUID().toString());// "BillPullGuid"
                        stmt.setInt(3, 0);// "ErrorCode"
                        //int timeout = ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) != null ? ProjectConfig.getConfig().getInteger(KEY_QUERY_TIMEOUT) : 10;
                        stmt.setQueryTimeout(3000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        Statics.getMoreResults(stmt);
                        //System.err.println("Done..");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //LOGGER.error("{} {}", spCall, ex.fillInStackTrace());
            throw new Exception(ex);
        } finally {
            time = Instant.now().toEpochMilli() - time;
            ////LOGGER.trace("End SP_UpdateBillInquiryResponseMessage spExecuteTime={} in ms ", time);
        }
    }
}
