package com.ceosilvajr.servletutil.dto;

import com.ceosilvajr.servletutil.HttpResponseCodes;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created date 20/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class ErrorResponse {

  private Error error;

  public ErrorResponse() {
    // Intended to be empty
  }

  public ErrorResponse(final Builder builder) {
    this.error = builder.error;
  }

  public Error getError() {
    return error;
  }

  public String getMessage() {
    return error.getMessage();
  }

  public String getReason() {
    return error.getErrors().get(0).getReason();
  }

  public static class Error {

    private List<Errors> errors;
    private int code;
    private String message;

    public List<Errors> getErrors() {
      return errors;
    }

    public void setErrors(final List<Errors> errors) {
      this.errors = errors;
    }

    public int getCode() {
      return code;
    }

    public void setCode(final int code) {
      this.code = code;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(final String message) {
      this.message = message;
    }

    @Override public String toString() {
      return new ToStringBuilder(this)
          .append("errors", errors)
          .append("message", message)
          .append("code", code)
          .toString();
    }
  }

  public static class Errors {

    private String reason;
    private String message;

    public String getReason() {
      return reason;
    }

    public void setReason(final String reason) {
      this.reason = reason;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(final String message) {
      this.message = message;
    }

    @Override public String toString() {
      return new ToStringBuilder(this)
          .append("reason", reason)
          .append("message", message)
          .toString();
    }
  }

  public static class Builder {

    private final Error error;

    public Builder(final HttpResponseCodes httpResponseCodes, final String reason, final String message) {
      this.error = getError(httpResponseCodes, reason, message);
    }

    private Error getError(final HttpResponseCodes httpResponseCodes, final String reason, final String message) {
      final Error error = new Error();
      final Errors errors = new Errors();
      final List<Errors> errorsList = new ArrayList<>();
      errorsList.add(errors);
      error.setCode(httpResponseCodes.getCode());
      error.setMessage(message);
      errors.setReason(reason);
      error.setErrors(errorsList);
      return error;
    }

    public ErrorResponse build() {
      return new ErrorResponse(this);
    }
  }

  @Override public String toString() {
    return new ToStringBuilder(this)
        .append("error", error)
        .toString();
  }
}
