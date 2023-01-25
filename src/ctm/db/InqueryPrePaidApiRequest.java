/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.db;

import com.BillerInfo;
import com.Statics;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TareqSaleh
 */
public class InqueryPrePaidApiRequest {

    private static final Logger LOGGER = LoggerFactory.getLogger(InqueryPrePaidApiRequest.class);
    public static long insertPrepaidProcessingData(DataBaseClient client, BillerInfo billerInfo) throws SQLException {
        long result = -1L;
        String spCall = "{call dbo.SP_HandlePrepaidValidation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        long time = Instant.now().toEpochMilli();
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    ////LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setInt(1, billerInfo.getBillerCode()); // "BillerCode"
                        stmt.setInt(2, 21); // "BankCode"
                        stmt.setNull(3, Types.INTEGER); // "PSPCode"
                        stmt.setString(4, "Test_Pre_1"); // "BillingNumber"
                        stmt.setInt(5, billerInfo.getServiceTypeId()); // "ServiceTypeId"
                        if (billerInfo.getPrepaidCategoryId() != null) {
                            stmt.setInt(6, billerInfo.getPrepaidCategoryId()); // "PrepaidCategoryId"
                        } else {
                            stmt.setNull(6, Types.INTEGER); // "PrepaidCategoryId"
                        }
                        stmt.setNull(7, Types.NVARCHAR);// "JOEBPPSTrx"
                        String uuid = billerInfo.getUuid();
                        stmt.setString(8, uuid); // "BankValidationGUID"
                        stmt.setString(9, uuid); // "BillerValidationGUID"
                        stmt.setNull(10, Types.VARCHAR); // always null in inquiry .... // "PaymentGUID"
                        stmt.setBoolean(11, true); // "BillerValidationRequired"
                        stmt.setInt(12, 2); // "CurrentStage"
                        stmt.setNull(13, Types.DECIMAL); // "Amount"
                        stmt.setInt(14, 1); // "BillerServiceTypesFeesTypeID"
                        stmt.setNull(15, Types.DECIMAL); // "CBJFees"
                        stmt.setNull(16, Types.DECIMAL); // "MFEPFees"
                        stmt.setNull(17, Types.INTEGER); // "CorridorID"
                        stmt.setInt(18, 0); // "ErrorCode"
                        stmt.setNull(19, Types.DECIMAL);// "TotalAmountWithFees
                        LocalDateTime vCodeExpiryDate = LocalDateTime.now().plusMinutes(60);
                        stmt.setTimestamp(20, Timestamp.valueOf(LocalDateTime.now())); // "VCodeExpiryDate"
                        stmt.registerOutParameter(21, Types.BIGINT);
                        stmt.setNull(22, Types.BIGINT); // "CustomerProfileID"
                        stmt.setNull(23, Types.VARCHAR); // "PayerId"
                        stmt.setNull(24, Types.VARCHAR); // "PayerIdType"
                        stmt.setNull(25, Types.VARCHAR); // "PayerNation"
                        stmt.setNull(26, Types.NVARCHAR); // "PayerName"
                        stmt.setNull(27, Types.VARCHAR); // "PayerPhone"
                        stmt.setNull(28, Types.NVARCHAR); // "PayerAddress"
                        stmt.setNull(29, Types.VARCHAR); // "Email"
                        stmt.setNull(30, Types.BIGINT); // "JOEBPPSNo"
                        stmt.setNull(31, Types.NVARCHAR); // "FirstName"
                        stmt.setNull(32, Types.NVARCHAR); // "SecondName"
                        stmt.setNull(33, Types.NVARCHAR); // "ThirdName"
                        stmt.setNull(34, Types.NVARCHAR); // "FamilyName"
                        stmt.setNull(35, Types.NVARCHAR); // "NameAr"
                        stmt.setNull(36, Types.NVARCHAR); // "SecondNameAr"
                        stmt.setNull(37, Types.NVARCHAR); // "ThirdNameAr"
                        stmt.setNull(38, Types.NVARCHAR); // "FamilyNameAr"
                        stmt.setNull(39, Types.NVARCHAR); // "CivilNo"
                        stmt.setNull(40, Types.DATE); // "DateOfBirth"
                        stmt.setNull(41, Types.TINYINT); // "CSPDVerificationStatusId"
                        stmt.setNull(42, Types.TINYINT); // "GenderId"
                        stmt.setNull(43, Types.TINYINT); // "MaritalStatusId"
                        stmt.setNull(44, Types.TINYINT); // "LifeStatusId"
                        stmt.setNull(45, Types.TINYINT); // "CSPDVerificationTypeId"
                        stmt.setNull(46, Types.NVARCHAR); // "CustomerName"
                        stmt.setNull(47, Types.NVARCHAR); // "CustomerExtraInfo"
                        stmt.setBoolean(48, false); // "IsAutoCustomerProfileCreation"
                        stmt.setNull(49, Types.NVARCHAR); // "SenderNameEn"
                        stmt.setNull(50, Types.NVARCHAR); // "SenderNameAr"
                        stmt.setNull(51, Types.NVARCHAR); // "BeneficiaryNameEn"
                        stmt.setNull(52, Types.NVARCHAR); // "BeneficiaryNameAr"
                        stmt.setNull(53, Types.NVARCHAR); // "OfficialID"
                        stmt.setNull(54, Types.INTEGER); // "OfficialTypeID"
                        stmt.setNull(55, Types.INTEGER); // "NationallityID"
                        stmt.setNull(56, Types.INTEGER); // "BeneficiaryNationallityID"
                        stmt.setNull(57, Types.VARCHAR); // "TransferReason"
                        stmt.setNull(58, Types.INTEGER); // "ReceivingCountryID"
                        stmt.setBigDecimal(59, BigDecimal.ZERO); // "MFEPCustomerFees"
                        stmt.setBigDecimal(60, BigDecimal.ZERO); // "MFEPCustomerFixedFees"
                        stmt.setBigDecimal(61, BigDecimal.ZERO); // "MFEPCustomerPercentageFees"
                        stmt.setBigDecimal(62, BigDecimal.ZERO); // "MFEPBillerFees"
                        stmt.setBigDecimal(63, BigDecimal.ZERO); // "MFEPBillerFixedFees"
                        stmt.setBigDecimal(64, BigDecimal.ZERO); // "MFEPBillerPercentageFees"
                        stmt.setBigDecimal(65, BigDecimal.ZERO); // "CBCustomerFees"
                        stmt.setBigDecimal(66, BigDecimal.ZERO); // "CBCustomerFixedFees"
                        stmt.setBigDecimal(67, BigDecimal.ZERO); // "CBCustomerPercentageFees"
                        stmt.setBigDecimal(68, BigDecimal.ZERO); // "CBBillerFees"
                        stmt.setBigDecimal(69, BigDecimal.ZERO); // "CBBillerFixedFees"
                        stmt.setBigDecimal(70, BigDecimal.ZERO); // "CBBillerPercentageFees"
                        stmt.setNull(71, Types.INTEGER); // "CorridorFeesId"
                        stmt.setQueryTimeout(30000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        result = stmt.getLong("OutValidationCode");
                        ////LOGGER.info("result {}", result);
                        //System.err.println("OutValidationCode = " + result);
                        billerInfo.setValidationCode(result);
                        Statics.getMoreResults(stmt);
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

    public static long insertBillerPrepaidValidationResult(DataBaseClient client, BillerInfo billerInfo) throws SQLException {
        String spCall = "{call dbo.SP_InsertBillerPrepaidInfo (?,?,?,?,?,?,?)}";
        long time = Instant.now().toEpochMilli();
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    ////LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setNull(1, Types.SQLXML); // "XmlMsg"
                        stmt.setString(2, billerInfo.getUuid()); // "GUID"
                        stmt.setInt(3, 0); // "ErrorCode"
                        stmt.setInt(4, 3); // "Status"
                        stmt.setString(5, "Success"); // "Notes"
                        stmt.setNull(6, Types.DECIMAL); // "DueAmount"
                        stmt.setLong(7, billerInfo.getValidationCode()); // "prepaidProcessingDataId"
                        stmt.setQueryTimeout(30000);
                        stmt.setPoolable(true);
                        stmt.executeUpdate();
                        Statics.getMoreResults(stmt);
                        //System.err.println("insertBillerPrepaidValidationResult");
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
        return -1;
    }

    public static long updatePrepaidProcessingData(DataBaseClient client, BillerInfo billerInfo) throws SQLException {
        long result = -1L;
        String spCall = "{call dbo.SP_UpdatePrepaidValidation (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        long time = Instant.now().toEpochMilli();
        try {
            try (Connection conn = client.getConnectionEx()) {
                SQLServerConnection connection = conn.unwrap(com.microsoft.sqlserver.jdbc.SQLServerConnection.class);
                if (connection == null) {
                    ////LOGGER.warn("no connection found", spCall);
                    throw new SQLException("no connection found");
                }
                //connection.setEnablePrepareOnFirstPreparedStatementCall(true);
                try (SQLServerCallableStatement stmt = (SQLServerCallableStatement) connection.prepareCall(spCall)) {
                    try {
                        stmt.setString(1, billerInfo.getUuid()); //"BillerValidationGUID"
                        stmt.setInt(2, 1); //"CurrentStage"
                        stmt.setBigDecimal(3, new BigDecimal("52.0")); //"Amount"
                        stmt.setInt(4, 2); //"BillerServiceTypesFeesTypeID"
                        stmt.setBigDecimal(5, new BigDecimal("0.15")); //"CBJFees"
                        stmt.setBigDecimal(6, new BigDecimal("0.1")); //"MFEPFees"
                        stmt.setInt(7, Statics.CORD_ID); //"CorridorID"
                        stmt.setBigDecimal(8, new BigDecimal("52.25")); //"TotalAmountWithFees"
                        stmt.setInt(9, 0); //"ErrorCode"
                        stmt.setLong(10, billerInfo.getValidationCode()); //"prepaidProcessingDataId"
                        stmt.setNull(11, Types.NVARCHAR); //"CustomerName"
                        stmt.setNull(12, Types.NVARCHAR); //"CustomerExtraInfo"
                        stmt.setNull(13, Types.NVARCHAR); //"SenderNameEn"
                        stmt.setNull(14, Types.NVARCHAR); //"SenderNameAr"
                        stmt.setNull(15, Types.NVARCHAR); //"BeneficiaryNameEn"
                        stmt.setNull(16, Types.NVARCHAR); //"BeneficiaryNameAr"
                        stmt.setNull(17, Types.NVARCHAR); //"OfficialID"
                        stmt.setNull(18, Types.INTEGER); //"OfficialTypeID"
                        stmt.setNull(19, Types.INTEGER); //"NationallityID"
                        stmt.setNull(20, Types.INTEGER); //"BeneficiaryNationallityID"
                        stmt.setNull(21, Types.VARCHAR); //"TransferReason"
                        stmt.setNull(22, Types.INTEGER); //"ReceivingCountryID"
                        stmt.setNull(23, Types.VARCHAR); //"CustomerEmail"
                        stmt.setNull(24, Types.VARCHAR); //"CustomerPhone"
                        stmt.setBigDecimal(25, BigDecimal.ZERO); //"MFEPBillerFees"
                        stmt.setBigDecimal(26, BigDecimal.ZERO); //"MFEPBillerFixedFees"
                        stmt.setBigDecimal(27, BigDecimal.ZERO); //"MFEPBillerPercentageFees"
                        stmt.setBigDecimal(28, BigDecimal.ZERO); //"CBBillerFees"
                        stmt.setBigDecimal(29, BigDecimal.ZERO); //"CBBillerFixedFees"
                        stmt.setBigDecimal(30, BigDecimal.ZERO); //"CBBillerPercentageFees"
                        stmt.setBigDecimal(31, new BigDecimal("0.1")); //"MFEPCustomerFees"
                        stmt.setBigDecimal(32, new BigDecimal("0.1")); //"MFEPCustomerFixedFees"
                        stmt.setBigDecimal(33, BigDecimal.ZERO); //"MFEPCustomerPercentageFees"
                        stmt.setBigDecimal(34, new BigDecimal("0.15")); //"CBCustomerFees"
                        stmt.setBigDecimal(35, new BigDecimal("0.15")); //"CBCustomerFixedFees"
                        stmt.setBigDecimal(36, BigDecimal.ZERO); //"CBCustomerPercentageFees"
                        stmt.setNull(37, Types.INTEGER); //"CorridorFeesID"
                        stmt.setNull(38, Types.SQLXML); //"SubPmts"
                        //LOGGER.trace("ExecuteUpdate stmt for SP_UpdatePrepaidValidation with stmt={} ", stmt);
                        stmt.setQueryTimeout(30000);
                        stmt.setPoolable(true);
                        result = stmt.executeUpdate();
                        Statics.getMoreResults(stmt);
                        //System.err.println("updatePrepaidProcessingData");
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

}
