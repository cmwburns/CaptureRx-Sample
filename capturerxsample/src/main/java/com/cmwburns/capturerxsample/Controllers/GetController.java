package com.cmwburns.capturerxsample.Controllers;

import com.cmwburns.capturerxsample.Data.Job;
import com.cmwburns.capturerxsample.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/get")
@AllArgsConstructor
@CrossOrigin
public class GetController {

  private final JobService jobService;

  @RequestMapping(
      value = {"/job/{jobId}"},
      method = RequestMethod.GET)
  public Job getJob(@PathVariable int jobId) {
    return jobService.getJob(jobId);
  }

  @RequestMapping(
          value = {"/alljobs"},
          method = RequestMethod.GET)
  public List<Job> getAllJobs() {
    return jobService.getAllJobs();
  }
}
