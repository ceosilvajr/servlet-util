package com.ceosilvajr.servletutil.dto;

import com.ceosilvajr.servletutil.HttpResponseCodes;

/**
 * Created date 20/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class SuccessResponse {

  private Success success;

  public SuccessResponse() {
    // Intended to be empty
  }

  public SuccessResponse(final Builder builder) {
    this.success = builder.success;
  }

  public Success getSuccess() {
    return success;
  }

  public String getMessage() {
    return success.getMessage();
  }

  public static class Success {

    private int code;
    private String message;

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
  }

  public static class Builder {

    private final Success success;

    public Builder(final HttpResponseCodes httpResponseCodes, final String message) {
      final Success success = new Success();
      success.setCode(httpResponseCodes.getCode());
      success.setMessage(message);
      this.success = success;
    }

    public SuccessResponse build() {
      return new SuccessResponse(this);
    }
  }
}
