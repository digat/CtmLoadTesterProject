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
public class FinInqMsg {
        private final long billnqId;
        private final long magId;
        private final BillerInfo billerInfo;

    public FinInqMsg(long billnqId, long magId, BillerInfo billerInfo){
        this.billnqId = billnqId;
        this.magId = magId;
        this.billerInfo = billerInfo;
    }

    public long getBillnqId() {
        return billnqId;
    }

    public long getMagId() {
        return magId;
    }
        public BillerInfo getBillerInfo() {
        return billerInfo;
    }
}
