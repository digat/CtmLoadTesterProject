/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import com.google.common.collect.Maps;
import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import ctm.types.PaymentType;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author TareqSaleh
 */
public class Statics {
    public static final String PROCESS_DATE = "2023-01-13T23:44:14";
    public static final String ISSUE_DATE = "2023-01-13T23:44:14";
    public static final String DUE_DATE = "2023-01-13T23:44:14";
    private static final Map<Long, BillerInfo> mapBillers = Maps.newHashMap();
    private static final Random random = new Random();
//    public static final int CORD_ID = 1575;
//    public static final int CORD_FEES_ID = 3340;
    public static final int CORD_ID = 3338;
    public static final int CORD_FEES_ID = 4072;
    static {
        //postpaid
        mapBillers.put(30667L, BillerInfo.create(PaymentType.Postpaid, "Internet", 14, 30667L));
        mapBillers.put(30629L, BillerInfo.create(PaymentType.Postpaid, "Mobile", 16, 30629L));
        mapBillers.put(32192L, BillerInfo.create(PaymentType.Postpaid, "Help_Feed_10_Monthly_Po", 45, 32192L));
        //prepaid]
        mapBillers.put(31486L, BillerInfo.create(PaymentType.Prepaid, "Dhabehah", 45, 31486L, 31, 139));
        mapBillers.put(30670L, BillerInfo.create(PaymentType.Prepaid, "PrepaidEvo", 14, 30670L, 24, 43));
        mapBillers.put(30825L, BillerInfo.create(PaymentType.Prepaid, "MIX_Vouchers", 16, 30825L, 226, 227));
    }
    
    public static Map<Long, BillerInfo> getBillerInfo(){
        return mapBillers;
    }
    
    public static int getReandomNumber(){
        return random.nextInt(999);
    }
    public static void getMoreResults(SQLServerCallableStatement stmt) throws SQLServerException {
    while (stmt.getMoreResults()){}
}
}
