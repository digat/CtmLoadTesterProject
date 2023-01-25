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
import ctm.db.PaymentPostPaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class PostPaidPaymentActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    
    static public Props props(SystemService systemService) {
        return Props.create(PostPaidPaymentActorWorker.class, () -> new PostPaidPaymentActorWorker(systemService));
    }

    public PostPaidPaymentActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(PostPaidPaymentMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(PostPaidPaymentMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = msg.getBillerInfo() ;
               PaymentPostPaidApiRequest.handlePaymentMessage(msg.getBillnqId(),
                       systemService.getDbClient(), billerInfo);
           } catch (SQLException  ex) {
               this.log().error("{}", ex);
           } catch (Exception ex) {
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPostPaidPayment());
    }
}
