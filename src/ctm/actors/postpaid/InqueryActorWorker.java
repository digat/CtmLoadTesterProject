/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.postpaid;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import com.BillerInfo;
import com.Statics;
import ctm.SystemService;
import ctm.actors.masseges.IncomingMsg;
import ctm.actors.masseges.InqMsg;
import ctm.db.InqueryPostPaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class InqueryActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    //private static final Logger LOGGER = LoggerFactory.getLogger(InqueryActorWorker.class);
    
    static public Props props(SystemService systemService) {
        return Props.create(InqueryActorWorker.class, () -> new InqueryActorWorker(systemService));
    }

    public InqueryActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(IncomingMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(IncomingMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = Statics.getBillerInfo().get(msg.getServiceId()) ;
               long result = InqueryPostPaidApiRequest.insertBillInquiry(systemService.getDbClient(), billerInfo);
               InqMsg inqMsg = new InqMsg(result, billerInfo);
               this.systemService.getBillPullActorRouter().tell(inqMsg, self());
           } catch (SQLException ex) {
               this.log().error("error {}", ex.getStackTrace());
           }
       }, SystemService.getThreadPoolPostPaid());
    }
}
