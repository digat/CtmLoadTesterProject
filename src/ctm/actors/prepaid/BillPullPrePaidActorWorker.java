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
import ctm.actors.masseges.InqMsg;
import ctm.db.InqueryPrePaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class BillPullPrePaidActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    //private static final Logger LOGGER = LoggerFactory.getLogger(BillPullActorWorker.class);
    
    static public Props props(SystemService systemService) {
        return Props.create(BillPullPrePaidActorWorker.class, () -> new BillPullPrePaidActorWorker(systemService));
    }

    public BillPullPrePaidActorWorker(SystemService systemService) {
        super();
        this.systemService = systemService;
    }
    
    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(InqMsg.class, msg -> {
                    handelIncomingMsg(msg);
                })
                .build();
    }

    private void handelIncomingMsg(InqMsg msg) {
       //insertBillInquiry
       CompletableFuture.runAsync(()->{
           try {
               final BillerInfo billerInfo = msg.getBillerInfo() ;
               long result = InqueryPrePaidApiRequest.insertBillerPrepaidValidationResult(systemService.getDbClientPrePaid(), billerInfo);
               FinInqMsg finInqMsg = new FinInqMsg(msg.getBillnqId(), result, billerInfo);
               this.systemService.getUpdateBillPrePaidActorRouter().tell(finInqMsg, self());
           } catch (SQLException ex) {
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPrePaid());
    }
}
