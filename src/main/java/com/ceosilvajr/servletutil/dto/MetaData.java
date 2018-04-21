/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.servletutil.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created date 14/03/2018
 *
 * @author ceosilvajr@gmail.com.
 **/
public class MetaData {

  public static final int SINGLE_RESULT_COUNT = 1;

  private String status;
  private String message;
  private String next;
  private int resultCount;

  public MetaData() {
    super();
  }

  public MetaData(final Builder builder) {
    this.status = builder.status;
    this.message = builder.message;
    this.next = builder.next;
    this.resultCount = builder.resultCount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public int getResultCount() {
    return resultCount;
  }

  public void setResultCount(int resultCount) {
    this.resultCount = resultCount;
  }

  @Override public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }

  public static class Builder {

    private String status;
    private String message;
    private String next;
    private int resultCount;

    public Builder() {
      this.status = StringUtils.EMPTY;
      this.message = StringUtils.EMPTY;
      this.next = StringUtils.EMPTY;
      this.resultCount = 0;
    }

    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public Builder setMessage(String message) {
      this.message = message;
      return this;
    }

    public Builder setNext(String next) {
      this.next = next;
      return this;
    }

    public Builder setResultCount(int resultCount) {
      this.resultCount = resultCount;
      return this;
    }

    public MetaData build() {
      return new MetaData(this);
    }
  }
}
