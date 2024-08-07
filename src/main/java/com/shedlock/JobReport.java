package com.shedlock;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobReport {

  @Scheduled(cron = "0 0 12 * * *")
  @SchedulerLock(name = "jobReport", lockAtMostFor = "30m")
  public void report() {
    // report revenue based on e.g. orders in database
    System.out.println("Reporting revenue");
  }

  @Scheduled(cron = "0 * * * * *")
  @SchedulerLock(name = "shortRunningTask", lockAtMostFor = "50s", lockAtLeastFor = "30s")
  public void shortRunningTask() {
    System.out.println("Start short running task");
  }
}
