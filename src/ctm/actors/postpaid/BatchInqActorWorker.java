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
import ctm.actors.masseges.FinInqMsg;
import ctm.actors.masseges.UpdateBillMsg;
import ctm.db.InqueryPostPaidApiRequest;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author TareqSaleh
 */
public class BatchInqActorWorker extends AbstractLoggingActor {

    private final SystemService systemService;
    //private static final Logger LOGGER = LoggerFactory.getLogger(BatchInqActorWorker.class);
    
    static public Props props(SystemService systemService) {
        return Props.create(BatchInqActorWorker.class, () -> new BatchInqActorWorker(systemService));
    }

    public BatchInqActorWorker(SystemService systemService) {
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
               long result = InqueryPostPaidApiRequest.insertBatchBill(msg.getMagId(),
                       msg.getBillnqId(),
                       systemService.getDbClient(), billerInfo);
               UpdateBillMsg updateBillMsg = new UpdateBillMsg(msg.getBillnqId(), billerInfo);
               this.systemService.getUpdateBillActorRouter().tell(updateBillMsg, self());
           } catch (SQLException  ex) {
               this.log().error("{}", ex);
           } catch (Exception ex) {
               this.log().error("{}", ex);
           }
       }, SystemService.getThreadPoolPostPaid());
    }
}
