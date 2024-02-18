package com.espresso.jobservice.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {
  private String id;
  private String title;
  private String description;
  private BigDecimal minSalary;
  private BigDecimal maxSalary;
  private String location;
}
