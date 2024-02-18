package com.espresso.jobservice.controller;

import com.espresso.jobservice.dto.JobDTO;
import com.espresso.jobservice.service.JobService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
  private final JobService service;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<JobDTO> findAllJobs() {
    return this.service.findAllJobs();
  }

  @GetMapping("/{job-id}")
  @ResponseStatus(HttpStatus.OK)
  public JobDTO findJobById(@PathVariable("job-id") String jobId) {
    return this.service.findByJobId(jobId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createJob(@RequestBody JobDTO jobDTO) {
    this.service.createJob(jobDTO);
  }

  @DeleteMapping("/{job-id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteJob(@PathVariable("job-id") String jobId) {
    this.service.deleteJob(jobId);
  }

  @PutMapping("/{job-id}")
  @ResponseStatus(HttpStatus.OK)
  public void updateJob(@PathVariable("job-id") String jobId, @RequestBody JobDTO jobDTO) {
    this.service.updateJob(jobId, jobDTO);
  }
}
