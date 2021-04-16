package com.cmwburns.capturerxsample.Controllers;

import com.cmwburns.capturerxsample.Data.Job;
import com.cmwburns.capturerxsample.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/get")
@AllArgsConstructor
public class GetController {

  private final JobService jobService;

  @CrossOrigin
  @RequestMapping(
      value = {"/{jobId}"},
      method = RequestMethod.GET)
  public Job getTransactions(@PathVariable int jobId) {
    return jobService.getJob(jobId);
  }
}
