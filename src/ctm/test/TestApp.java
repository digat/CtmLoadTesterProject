/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ctm.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author TareqSaleh
 */
public class TestApp {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.parse("16:20:59.849", DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        LocalTime endTime = LocalTime.parse("16:35:01.947", DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
        long finalTime = (endTime.toNanoOfDay() - startTime.toNanoOfDay())/1000000;
        System.out.println(finalTime/1000);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]"); 
        LocalDateTime dateTime = LocalDateTime.parse("2023-01-09T12:00:23", formatter);

        Timestamp time = Timestamp.valueOf(dateTime);
        System.out.println(time);
    }
}
