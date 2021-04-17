package com.cmwburns.capturerxsample.Services;

import com.cmwburns.capturerxsample.Data.Job;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class Producer {

  private static final String TOPIC = "Jobs";
  private final KafkaTemplate<Object, Job> kafkaTemplate;

  public void sendMessage(Job job) {
    log.info(String.format("Job created -> %s", job));
    kafkaTemplate.send(TOPIC, job);
  }
}
