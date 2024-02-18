package com.espresso.jobservice.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "jobs")
public class Job {
  @Id private String id;
  private String title;
  private String description;
  private BigDecimal minSalary;
  private BigDecimal maxSalary;
  private String location;
}
