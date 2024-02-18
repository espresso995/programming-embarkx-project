package com.espresso.jobservice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
class ApiError {
  private HttpStatus status;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;

  private String message;
  private String debugMessage;

  private ApiError() {
    this.timestamp = LocalDateTime.now();
  }

  ApiError(HttpStatus status) {
    this();
    this.status = status;
  }

  ApiError(HttpStatus status, Throwable cause) {
    this();
    this.status = status;
    this.message = "Unexpected error occurs";
    this.debugMessage = cause.getLocalizedMessage();
  }

  ApiError(HttpStatus status, String message, Throwable cause) {
    this();
    this.status = status;
    this.message = message;
    this.debugMessage = cause.getLocalizedMessage();
  }
}
