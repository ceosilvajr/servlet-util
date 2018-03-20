package com.ceosilvajr.servletutil;

/**
 * Created date 19/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public enum HttpResponseCodes {

  /**
   * Status code (200) indicating the request succeeded normally.
   */
  RC_OK(200),

  /**
   * Status code (201) indicating the request succeeded and created a new resource on the server.
   */
  RC_CREATED(201),

  /**
   * Status code (400) indicating the request sent by the client was syntactically incorrect.
   */
  RC_BAD_REQUEST(400),

  /**
   * Status code (401) indicating that the request requires HTTP authentication.
   */
  RC_UNAUTHORIZED(401),

  /**
   * Status code (404) indicating that the requested resource is not available.
   */
  RC_NOT_FOUND(404),

  /**
   * Status code (409) indicating that the request could not be completed due to a conflict with the current state of
   * the resource.
   */
  RC_CONFLICT(409),

  /**
   * Status code (500) indicating an error inside the HTTP server which prevented it from fulfilling the request.
   */
  RC_INTERNAL_SERVER_ERROR(500),

  /**
   * Status code (501) indicating the HTTP server does not support the functionality needed to fulfill the request.
   */
  RC_NOT_IMPLEMENTED(501);

  private final int code;

  HttpResponseCodes(final int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

}