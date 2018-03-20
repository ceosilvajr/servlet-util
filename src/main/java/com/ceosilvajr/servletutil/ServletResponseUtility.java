package com.ceosilvajr.servletutil;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
 * Created date 19/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public final class ServletResponseUtility {

  private final HttpServletResponse httpServletResponse;
  private final Object object;

  public static ServletResponseUtility instanceOf(final HttpServletResponse httpServletResponse, final Object object) {
    if (httpServletResponse == null) {
      throw new IllegalArgumentException("httpServletResponse should not be null.");
    } else if (object == null) {
      throw new IllegalArgumentException("Object should not be null.");
    } else {
      return new ServletResponseUtility(httpServletResponse, object);
    }
  }

  private ServletResponseUtility(final HttpServletResponse httpServletResponse, final Object object) {
    this.httpServletResponse = httpServletResponse;
    this.object = object;
  }

  public void toJson() throws IOException {
    toJson(HttpResponseCodes.RC_OK, new HashMap<>());
  }

  public void toJson(final Map<String, String> headers) throws IOException {
    toJson(HttpResponseCodes.RC_OK, headers);
  }

  public void toJson(final HttpResponseCodes responseCode) throws IOException {
    toJson(responseCode, new HashMap<>());
  }

  public void toJson(final HttpResponseCodes responseCode, final Map<String, String> headers) throws IOException {
    if (responseCode == null) {
      throw new IllegalArgumentException("HttpResponseCodes should not be null.");
    } else {
      setHeaders(headers);
      final String json = new Gson().toJson(object);
      httpServletResponse.setStatus(responseCode.getCode());
      httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
      httpServletResponse.setContentType("application/json");
      close(httpServletResponse, json);
    }
  }

  private void setHeaders(final Map<String, String> headers) {
    if (headers != null) {
      for (final Map.Entry<String, String> next : headers.entrySet()) {
        httpServletResponse.setHeader(next.getKey(), next.getValue());
      }
    }
  }

  private void close(final HttpServletResponse resp, final String json) throws IOException {
    final PrintWriter out = resp.getWriter();
    out.print(json);
    out.flush();
  }
}
