package com.cmwburns.capturerxsample.Controllers;

import com.cmwburns.capturerxsample.Services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
@CrossOrigin
public class PostController {

  private final JobService jobService;

  @RequestMapping(
      value = {"/addjob/{jobId}"},
      method = RequestMethod.POST)
  public void addJob(@PathVariable int jobId, HttpServletResponse response) {
    try {
      jobService.save(jobId);
      response.setStatus(202);
    } catch (IllegalArgumentException e) {
      response.setStatus(400);
    }
  }
}
