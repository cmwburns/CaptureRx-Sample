package com.cmwburns.capturerxsample.Services;

import com.cmwburns.capturerxsample.Data.Job;
import com.cmwburns.capturerxsample.Data.JobRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Data
@Service
public class JobService {
  private final JobRepository jobRepository;
  private final Producer kafkaProducer;

  public Job getJob(long id) {
    return jobRepository.findById(id);
  }

  public void save(long id) throws IllegalArgumentException {
    if (id != 0) {
      Job job = new Job(id, "IN PROGRESS");
      jobRepository.save(job);
      kafkaProducer.sendMessage(job);
    } else {
      throw new IllegalArgumentException();
    }
  }

  public void save(Job job) {
    jobRepository.delete(job);
    job.setJob_status("DONE");
    jobRepository.save(job);
  }

  public List<Job> getAllJobs() {
    return jobRepository.findAll();
  }
}
