package org.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
public class TaskApp {

    public static void main(String[] args) {
        SpringApplication.run(TaskApp.class);
    }


    /**
     * java的 Timer 类可以实现简单定时任务
     */
//    public static void main(String[] args) {
//        System.out.println("Hello World!");
//
//        Timer timer = new Timer();
//
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("timer task run...");
//            }
//        };
//        timer.schedule(task, 0, 2000);
//    }
}
