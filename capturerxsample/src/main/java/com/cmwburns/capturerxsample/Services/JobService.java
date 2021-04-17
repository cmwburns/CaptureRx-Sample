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

  public Job getJob(int id) {
    return jobRepository.findById(id);
  }

  public void save(int id) {
    Job job = new Job(id, "IN PROGRESS");
    jobRepository.save(job);
    kafkaProducer.sendMessage(job);
    job.setJob_status("DONE");
    jobRepository.save(job);
  }

  public List<Job> getAllJobs() {
    return jobRepository.findAll();
  }
}
