/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import ctm.actors.postpaid.BatchInqActorRouter;
import ctm.actors.postpaid.BillPullActorRouter;
import ctm.actors.postpaid.InqueryActorRouter;
import ctm.actors.postpaid.PostPaidPaymentActorRouter;
import ctm.actors.postpaid.UpdateBillActorRouter;
import ctm.actors.masseges.IncomingMsg;
import ctm.actors.prepaid.BillPullPrePaidActorRouter;
import ctm.actors.prepaid.InqueryPrePaidActorRouter;
import ctm.actors.prepaid.PrePaidPaymentActorRouter;
import ctm.actors.prepaid.UpdateBillPrePaidActorRouter;
import ctm.db.DataBaseClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author TareqSaleh
 */
public class SystemService {

    private final ActorSystem actorSystem;
    private static final ExecutorService THREAD_POOL_POST_PAID = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2 * 1) - 1, r -> {
        Thread t = new Thread(r);
        //t.setDaemon(true); // must be not daemon
        return t;
    });

    public static ExecutorService getThreadPoolPostPaid() {
        return THREAD_POOL_POST_PAID;
    }
    private static final ExecutorService THREAD_POOL_PAYMENT_POST_PAID = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2 * 1) - 1, r -> {
        Thread t = new Thread(r);
        //t.setDaemon(true); // must be not daemon
        return t;
    });

    public static ExecutorService getThreadPoolPostPaidPayment() {
        return THREAD_POOL_PAYMENT_POST_PAID;
    }
    private static final ExecutorService THREAD_POOL_PRE_PAID = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2 * 1) - 1, r -> {
        Thread t = new Thread(r);
        //t.setDaemon(true); // must be not daemon
        return t;
    });
    private static final ExecutorService THREAD_POOL_PAYMENT_PRE_PAID = Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors() * 2 * 1) - 1, r -> {
        Thread t = new Thread(r);
        //t.setDaemon(true); // must be not daemon
        return t;
    });

    public static ExecutorService getThreadPoolPrePaidPayment() {
        return THREAD_POOL_PAYMENT_PRE_PAID;
    }

    public static ExecutorService getThreadPoolPrePaid() {
        return THREAD_POOL_POST_PAID;
    }

    private final DataBaseClient dbClient;
    private final DataBaseClient dbClientPrePaid;
    private final ActorRef inqueryActorRouter;
    private final ActorRef billPullActorRouter;
    private final ActorRef batchInqActorRouter;
    private final ActorRef updateBillActorRouter;
    private final ActorRef postPaidPaymentActorRouter;
    private final ActorRef inqueryPrePaidActorRouter;
    private final ActorRef billPullPrePaidActorRouter;
    private final ActorRef updateBillPrePaidActorRouter;
    private final ActorRef prePaidPaymentActorRouter;

    public SystemService(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
        dbClient = new DataBaseClient();
        dbClientPrePaid = new DataBaseClient();
        inqueryActorRouter = actorSystem.actorOf(InqueryActorRouter.props(0, this));
        billPullActorRouter = actorSystem.actorOf(BillPullActorRouter.props(1, this));
        batchInqActorRouter = actorSystem.actorOf(BatchInqActorRouter.props(2, this));
        updateBillActorRouter = actorSystem.actorOf(UpdateBillActorRouter.props(3, this));
        postPaidPaymentActorRouter = actorSystem.actorOf(PostPaidPaymentActorRouter.props(4, this));
        inqueryPrePaidActorRouter = actorSystem.actorOf(InqueryPrePaidActorRouter.props(5, this));
        billPullPrePaidActorRouter = actorSystem.actorOf(BillPullPrePaidActorRouter.props(6, this));
        updateBillPrePaidActorRouter = actorSystem.actorOf(UpdateBillPrePaidActorRouter.props(7, this));
        prePaidPaymentActorRouter = actorSystem.actorOf(PrePaidPaymentActorRouter.props(8, this));
    }

    public ActorRef getInqueryActorRouter() {
        return inqueryActorRouter;
    }

    public void startDb() {
        dbClient.openDb();
        dbClientPrePaid.openDb();
    }

    public void doTest() {
        for (int i = 0; i < 2000; i++) {
//            this.inqueryActorRouter.tell(new IncomingMsg("ok", 30623L), null);
//            this.inqueryActorRouter.tell(new IncomingMsg("ok", 32092L), null);
//            this.inqueryActorRouter.tell(new IncomingMsg("ok", 32192L), null);
//            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 30656L), null);
//            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 31944L), null);
//            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 31960L), null);
            
            this.inqueryActorRouter.tell(new IncomingMsg("ok", 30667L), null);
            this.inqueryActorRouter.tell(new IncomingMsg("ok", 30629L), null);
            this.inqueryActorRouter.tell(new IncomingMsg("ok", 32192L), null);
            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 31486L), null);
            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 30670L), null);
            this.inqueryPrePaidActorRouter.tell(new IncomingMsg("ok", 30825L), null);
        }
       /*
        mapBillers.put(30667L, BillerInfo.create(PaymentType.Postpaid, "Internet", 14, 30667L));
        mapBillers.put(30629L, BillerInfo.create(PaymentType.Postpaid, "Mobile", 16, 30629L));
        mapBillers.put(32192L, BillerInfo.create(PaymentType.Postpaid, "Help_Feed_10_Monthly_Po", 45, 32192L));
        //prepaid]
        mapBillers.put(31486L, BillerInfo.create(PaymentType.Prepaid, "Dhabehah", 45, 31486L, 31, 139));
        mapBillers.put(30670L, BillerInfo.create(PaymentType.Prepaid, "PrepaidEvo", 14, 30670L, 24, 43));
        mapBillers.put(30825L, BillerInfo.create(PaymentType.Prepaid, "MIX_Vouchers", 16, 30825L, 226, 227));
        */
    }

    public ActorSystem getActorSystem() {
        return actorSystem;
    }

    public DataBaseClient getDbClient() {
        return dbClient;
    }

    public DataBaseClient getDbClientPrePaid() {
        return dbClientPrePaid;
    }

    public ActorRef getBillPullActorRouter() {
        return billPullActorRouter;
    }

    public ActorRef getBatchInqActorRouter() {
        return batchInqActorRouter;
    }

    public ActorRef getUpdateBillActorRouter() {
        return updateBillActorRouter;
    }

    public ActorRef getPostPaidPaymentActorRouter() {
        return postPaidPaymentActorRouter;
    }

    public ActorRef getInqueryPrePaidActorRouter() {
        return inqueryPrePaidActorRouter;
    }

    public ActorRef getBillPullPrePaidActorRouter() {
        return billPullPrePaidActorRouter;
    }

    public ActorRef getUpdateBillPrePaidActorRouter() {
        return updateBillPrePaidActorRouter;
    }

    public ActorRef getPrePaidPaymentActorRouter() {
        return prePaidPaymentActorRouter;
    }

}
