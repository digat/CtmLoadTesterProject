/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.prepaid;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import com.BillerInfo;
import ctm.SystemService;
import ctm.actors.masseges.PrePaidPaymentMsg;
import ctm.db.PaymentPostPaidApiRequest;
import ctm.db.PaymentPrePaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class PrePaidPaymentActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    
    static public Props props(SystemService systemService) {
        return Props.create(PrePaidPaymentActorWorker.class, () -> new PrePaidPaymentActorWorker(systemService));
    }

    public PrePaidPaymentActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(PrePaidPaymentMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(PrePaidPaymentMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = msg.getBillerInfo() ;
               PaymentPrePaidApiRequest.handlePrepaidTransaction(
                       systemService.getDbClientPrePaid(), billerInfo);
           } catch (SQLException  ex) {
               ex.printStackTrace();
               this.log().error("{}", ex);
           } catch (Exception ex) {
               ex.printStackTrace();
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPrePaidPayment());
    }
}
