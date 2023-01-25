/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import ctm.types.PaymentType;
import java.util.UUID;

/**
 *
 * @author TareqSaleh
 */
public class BillerInfo {

    private final PaymentType payment;
    private final String serviceType;
    private final int billerCode;
    private final String uuid = UUID.randomUUID().toString();
    private long validationCode;
    private int serviceTypeId;
    private Integer prepaidCategoryId;

    public long getServiceId() {
        return serviceId;
    }
    private final long serviceId;

    public static BillerInfo create(PaymentType payment, String serviceType, int billerCode,long serviceId) {
        return new BillerInfo(payment, serviceType, billerCode, serviceId, -1, -1);
    }
    public static BillerInfo create(PaymentType payment, String serviceType, int billerCode,long serviceId,int serviceTypeId,
            Integer prepaidCategoryId) {
        return new BillerInfo(payment, serviceType, billerCode, serviceId, serviceTypeId, prepaidCategoryId);
    }
    public BillerInfo(PaymentType payment, String serviceType, int billerCode, long serviceId, int serviceTypeId,
            Integer prepaidCategoryId) {
        this.payment = payment;
        this.serviceType = serviceType;
        this.billerCode = billerCode;
        this.serviceId = serviceId;
        this.serviceTypeId= serviceTypeId;
        this.prepaidCategoryId = prepaidCategoryId;
    }

    public PaymentType getPayment() {
        return payment;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getBillerCode() {
        return billerCode;
    }

    public String getUuid() {
        return uuid;
    }

    public long getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(long validationCode) {
        this.validationCode = validationCode;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Integer getPrepaidCategoryId() {
        return prepaidCategoryId;
    }

    public void setPrepaidCategoryId(Integer prepaidCategoryId) {
        this.prepaidCategoryId = prepaidCategoryId;
    }
    
    

}
