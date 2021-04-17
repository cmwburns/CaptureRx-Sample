package com.cmwburns.capturerxsample.Services;

import com.cmwburns.capturerxsample.Data.Job;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class Consumer {

  @KafkaListener(topics = "Jobs", groupId = "group_id")
  public void consume(Job job) {
    log.info(String.format("Consumed job -> %s", job));
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
