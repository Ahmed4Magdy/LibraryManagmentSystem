package com.example.demo.Service;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulePrice {

    Logger log = LoggerFactory.getLogger(SchedulePrice.class);

    //    @Scheduled(fixedDelay = 2000)
//    @Scheduled(fixedDelayString = "${price-interval}")
    @SchedulerLock(name = "myscheduledTask")
    @Scheduled(cron = "${interval.in.cron}")
    @Async
    public void computepric() throws InterruptedException {

        Thread.sleep(4000);
        log.info("compute price>>" + LocalDateTime.now());

    }


    @SchedulerLock(name = "BookDiscount")
    @Scheduled(cron = "${interval.in.cron}")
    @Async
    public void ComputeDiscount() throws InterruptedException {

        Thread.sleep(4000);
        log.info("compute price>>" + LocalDateTime.now());

    }

}
