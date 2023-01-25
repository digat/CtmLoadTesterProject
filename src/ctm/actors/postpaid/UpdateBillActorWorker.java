/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.postpaid;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import com.BillerInfo;
import ctm.SystemService;
import ctm.actors.masseges.PostPaidPaymentMsg;
import ctm.actors.masseges.UpdateBillMsg;
import ctm.db.InqueryPostPaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class UpdateBillActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    
    static public Props props(SystemService systemService) {
        return Props.create(UpdateBillActorWorker.class, () -> new UpdateBillActorWorker(systemService));
    }

    public UpdateBillActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(UpdateBillMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(UpdateBillMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = msg.getBillerInfo() ;
               InqueryPostPaidApiRequest.updateBillInquiryResponseMessage(msg.getBillnqId(),
                       systemService.getDbClient());
               PostPaidPaymentMsg pppMsg = new PostPaidPaymentMsg(msg.getBillnqId(), billerInfo);
               this.systemService.getPostPaidPaymentActorRouter().tell(pppMsg, self());
           } catch (SQLException  ex) {
               this.log().error("{}", ex);
           } catch (Exception ex) {
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPostPaid());
    }
}
