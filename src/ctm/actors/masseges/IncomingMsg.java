/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.masseges;

/**
 *
 * @author TareqSaleh
 */
public class IncomingMsg {
    private final String msg;

    public long getServiceId() {
        return serviceId;
    }
    private final long serviceId;

    public IncomingMsg(String msg, long serviceId){
        this.msg = msg;
        this.serviceId = serviceId;
    }

    public String getMsg() {
        return msg;
    }
    
}