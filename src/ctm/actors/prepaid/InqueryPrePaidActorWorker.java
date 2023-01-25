/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.prepaid;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.Props;
import com.BillerInfo;
import com.Statics;
import ctm.SystemService;
import ctm.actors.masseges.IncomingMsg;
import ctm.actors.masseges.InqMsg;
import ctm.db.InqueryPrePaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class InqueryPrePaidActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    //private static final Logger LOGGER = LoggerFactory.getLogger(InqueryActorWorker.class);
    
    static public Props props(SystemService systemService) {
        return Props.create(InqueryPrePaidActorWorker.class, () -> new InqueryPrePaidActorWorker(systemService));
    }

    public InqueryPrePaidActorWorker(SystemService systemService) {
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
               long result = InqueryPrePaidApiRequest.insertPrepaidProcessingData(systemService.getDbClientPrePaid(), billerInfo);
               InqMsg inqMsg = new InqMsg(result, billerInfo);
               this.systemService.getBillPullPrePaidActorRouter().tell(inqMsg, self());
           } catch (SQLException ex) {
               this.log().error("error {}", ex.getStackTrace());
           }
       }, SystemService.getThreadPoolPrePaid());
    }
    
    
}
