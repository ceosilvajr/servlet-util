package com.ceosilvajr.servletutil;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created date 19/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public final class ServletRequestUtility {

  private final HttpServletRequest httpServletRequest;

  public static ServletRequestUtility instanceOf(final HttpServletRequest httpServletRequest) {
    if (httpServletRequest == null) {
      throw new IllegalArgumentException("HttpServletRequest should not be null.");
    }
    return new ServletRequestUtility(httpServletRequest);
  }

  private ServletRequestUtility(final HttpServletRequest httpServletRequest) {
    this.httpServletRequest = httpServletRequest;
  }

  public <T> T toRequestClass(final Class<T> classOfT) throws IOException {
    return new Gson().fromJson(httpServletRequest.getReader(), classOfT);
  }
}
