package com.cmwburns.capturerxsample.Services;

import com.cmwburns.capturerxsample.Data.Job;
import com.cmwburns.capturerxsample.Data.JobRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Data
@Service
public class JobService {
  private JobRepository jobRepository;

  public Job getJob(int id) {
    return jobRepository.findById(id);
  }

  public void save(int id) {
    Job job = new Job(id, "PENDING");
    jobRepository.save(job);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    job.setJob_status("DONE");
    jobRepository.save(job);
  }
}
