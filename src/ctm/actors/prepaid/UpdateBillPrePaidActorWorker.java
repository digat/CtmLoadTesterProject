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
import ctm.actors.masseges.FinInqMsg;
import ctm.actors.masseges.PrePaidPaymentMsg;
import ctm.db.InqueryPrePaidApiRequest;
import ctm.db.PaymentPrePaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class UpdateBillPrePaidActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    
    static public Props props(SystemService systemService) {
        return Props.create(UpdateBillPrePaidActorWorker.class, () -> new UpdateBillPrePaidActorWorker(systemService));
    }

    public UpdateBillPrePaidActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(FinInqMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(FinInqMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = msg.getBillerInfo() ;
               InqueryPrePaidApiRequest.updatePrepaidProcessingData(systemService.getDbClientPrePaid(), billerInfo);
               PrePaidPaymentMsg pppMsg = new PrePaidPaymentMsg(msg.getBillnqId(), billerInfo);
               this.systemService.getPrePaidPaymentActorRouter().tell(pppMsg, self());
           } catch (SQLException  ex) {
               this.log().error("{}", ex);
           } catch (Exception ex) {
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPrePaid());
    }
}
