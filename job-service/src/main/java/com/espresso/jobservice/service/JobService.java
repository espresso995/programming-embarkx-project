package com.espresso.jobservice.service;

import com.espresso.jobservice.dto.JobDTO;
import com.espresso.jobservice.exception.EntityNotFoundException;
import com.espresso.jobservice.model.Job;
import com.espresso.jobservice.repository.JobRepository;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
  private final JobRepository repository;

  public List<JobDTO> findAllJobs() {
    List<Job> jobs = this.repository.findAll();
    return jobs.stream().map(this.mapToDTO).collect(Collectors.toList());
  }

  public JobDTO findByJobId(String jobId) {
    Job job =
        this.repository
            .findById(jobId)
            .orElseThrow(() -> new EntityNotFoundException("Job not found for id: " + jobId));
    return this.mapToDTO.apply(job);
  }

  public void createJob(JobDTO jobDTO) {
    Job job =
        Job.builder()
            .title(jobDTO.getTitle())
            .description(jobDTO.getDescription())
            .minSalary(jobDTO.getMinSalary())
            .maxSalary(jobDTO.getMaxSalary())
            .location(jobDTO.getLocation())
            .build();
    this.repository.save(job);
  }

  public void deleteJob(String jobId) {
    Job job =
        this.repository
            .findById(jobId)
            .orElseThrow(() -> new EntityNotFoundException("Job not found for id: " + jobId));
    this.repository.delete(job);
  }

  public void updateJob(String jobId, JobDTO jobDTO) {
    Job job =
        this.repository
            .findById(jobId)
            .orElseThrow(() -> new EntityNotFoundException("Job not found for id: " + jobId));
    job.setTitle(jobDTO.getTitle());
    job.setDescription(jobDTO.getDescription());
    job.setMinSalary(jobDTO.getMinSalary());
    job.setMaxSalary(jobDTO.getMaxSalary());
    job.setLocation(jobDTO.getLocation());
    this.repository.save(job);
  }

  private Function<Job, JobDTO> mapToDTO =
      job ->
          JobDTO.builder()
              .id(job.getId())
              .title(job.getTitle())
              .description(job.getDescription())
              .minSalary(job.getMinSalary())
              .maxSalary(job.getMaxSalary())
              .location(job.getLocation())
              .build();
}
