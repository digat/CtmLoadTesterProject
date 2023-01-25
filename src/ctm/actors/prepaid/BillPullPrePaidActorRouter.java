/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.actors.prepaid;

import akka.actor.AbstractActor;
import akka.actor.AbstractLoggingActor;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import static akka.actor.SupervisorStrategy.resume;
import akka.japi.pf.DeciderBuilder;
import akka.routing.RandomPool;
import scala.concurrent.duration.Duration;
import akka.actor.Props;
import ctm.SystemService;
import ctm.actors.masseges.InqMsg;
/**
 *
 * @author TareqSaleh
 */
public class BillPullPrePaidActorRouter extends AbstractLoggingActor {

    private ActorRef router;
    private final SystemService systemService;

    public BillPullPrePaidActorRouter(SystemService systemService) {
        this.systemService = systemService;
    }

    private static final SupervisorStrategy STRATGY = new OneForOneStrategy(10, Duration.create("1 second"),
            DeciderBuilder.match(Exception.class, ex -> {
                ex.printStackTrace();
                return resume();
            }).build());

    static public Props props(long topicKey, SystemService systemService) {
        return Props.create(BillPullPrePaidActorRouter.class, () -> new BillPullPrePaidActorRouter(systemService));
    }

    @Override
    public void preStart() {
        log().info("BillPullPrePaidActorWorker topicKey [{}] started");
        router = getContext().actorOf(new RandomPool(10000).props(Props.create(BillPullPrePaidActorWorker.class, () -> new BillPullPrePaidActorWorker(systemService))),
                "BillPullPrePaidActorWorker" + 1);
    }

    @Override
    public void postStop() {
        log().warning("BillPullPrePaidActorWorker topicKey [{}] stopped", 1);
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return STRATGY;
    }

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(InqMsg.class, msg -> {
                    router.tell(msg, this.getSelf());
                })
                .build();
    }

}