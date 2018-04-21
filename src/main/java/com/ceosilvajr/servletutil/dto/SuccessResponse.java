/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.servletutil.dto;

import com.ceosilvajr.servletutil.HttpResponseCodes;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created date 20/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public final class SuccessResponse {

  private Success success;

  public SuccessResponse() {
    super();
  }

  public SuccessResponse(final Builder builder) {
    this.success = builder.success;
  }

  public static SuccessResponse defaultOk() {
    return new SuccessResponse(new Builder(HttpResponseCodes.RC_OK, "Success"));
  }

  public Success getSuccess() {
    return success;
  }

  public String getMessage() {
    return success.getMessage();
  }

  @Override public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
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
