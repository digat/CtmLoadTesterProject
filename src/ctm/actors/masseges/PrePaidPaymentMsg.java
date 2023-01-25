/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.masseges;

import com.BillerInfo;

/**
 *
 * @author TareqSaleh
 */
public class PrePaidPaymentMsg {
        private final long billnqId;
        private final BillerInfo billerInfo;

    public PrePaidPaymentMsg(long billnqId, BillerInfo billerInfo){
        this.billnqId = billnqId;
        this.billerInfo = billerInfo;
    }

    public long getBillnqId() {
        return billnqId;
    }
    public BillerInfo getBillerInfo() {
        return billerInfo;
    }
}