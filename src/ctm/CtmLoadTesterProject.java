/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ctm;

import akka.actor.ActorSystem;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author TareqSaleh
 */
public class CtmLoadTesterProject {
    private static final Logger LOGGER = LoggerFactory.getLogger(CtmLoadTesterProject.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, SQLException {
        String version = "[TP] version 3.03 /NoAppache/NoSMS";
        System.err.println(version);
        LOGGER.info(version);
        ActorSystem actorSystem = ActorSystem.create("TP-ActorsTobology");
        LOGGER.error("Starting.... ");
        SystemService systemService = new SystemService(actorSystem);
        System.err.println("start db");
        systemService.startDb();
        
        
        Thread.sleep(2000);
        System.err.println("do inq");
        systemService.doTest();
    }
    
}
