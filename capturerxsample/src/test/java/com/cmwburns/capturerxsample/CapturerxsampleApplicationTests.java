package com.cmwburns.capturerxsample;

import com.cmwburns.capturerxsample.Data.Job;
import com.cmwburns.capturerxsample.Services.JobService;
import com.cmwburns.capturerxsample.Services.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@EmbeddedKafka(
    partitions = 1,
    brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class CapturerxsampleApplicationTests {

  private final JobService jobService;
  private final Producer producer;

  @Autowired
  public CapturerxsampleApplicationTests(JobService jobService, Producer producer) {
    this.jobService = jobService;
    this.producer = producer;
  }

  @Test
  public void test() throws InterruptedException {
    long idList[] = {1, 2, 3, 4, 5};

    for (int i = 0; i < idList.length; i++) {
      Thread.sleep(5000);
      jobService.save(idList[i]);
      assertNotNull(jobService.getJob(idList[i]));
      Job job = jobService.getJob(idList[i]);
      assertEquals(idList[i], job.getId());
      assertEquals("IN PROGRESS", job.getJob_status());
    }
    Thread.sleep(5000);

    List<Job> jobList = jobService.getAllJobs();
    assertEquals(jobList.size(), idList.length);
    for (int i = 0; i < idList.length; i++) {
      Job job = jobList.get(i);
      assertNotNull(job);
      assertEquals(idList[i], job.getId());
      assertEquals("DONE", job.getJob_status());
    }
  }
}
