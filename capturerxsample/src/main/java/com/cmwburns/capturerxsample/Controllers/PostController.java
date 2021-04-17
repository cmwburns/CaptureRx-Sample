package com.cmwburns.capturerxsample.Controllers;

import com.cmwburns.capturerxsample.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
@CrossOrigin
public class PostController {

  private final JobService jobService;

  @RequestMapping(
      value = {"/addjob/{jobId}"},
      method = RequestMethod.POST)
  public void addJob(@PathVariable int jobId) {
    jobService.save(jobId);
  }
}
