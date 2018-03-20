package com.ceosilvajr.servletutil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.given;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * Created date 19/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class ServletResponseUtilityTest {

  private static final String EXCEPTION_MESSAGE = "Expected exception not thrown.";

  @InjectMocks private ServletResponseUtility servletResponseUtility;
  @Mock private HttpServletResponse httpServletResponse;
  @Mock private PrintWriter printWriter;

  @BeforeMethod
  public void beforeMethod() {
    MockitoAnnotations.initMocks(this);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void given_null_httpResponse_Throw_IllegalArgumentException() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(null, null);
    // when
    servletResponseUtility.toJson(null, null);
    // then
    fail(EXCEPTION_MESSAGE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void given_null_object_Throw_IllegalArgumentException() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(httpServletResponse, null);
    // when
    servletResponseUtility.toJson(null, null);
    // then
    fail(EXCEPTION_MESSAGE);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void given_null_httpResponseCode_Throw_IllegalArgumentException() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(httpServletResponse, new Object());
    // when
    servletResponseUtility.toJson(null, null);
    // then
    fail(EXCEPTION_MESSAGE);
  }

  @Test
  public void integration() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(httpServletResponse, new Object());
    given(httpServletResponse.getWriter()).willReturn(printWriter);
    // when
    servletResponseUtility.toJson(HttpResponseCodes.RC_OK, new HashMap<>());
    // then
    assertTrue(httpServletResponse.getHeaderNames().isEmpty());
  }

  @Test
  public void integration_OK() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(httpServletResponse, new Object());
    given(httpServletResponse.getWriter()).willReturn(printWriter);
    // when
    servletResponseUtility.toJson(new HashMap<>());
    // then
    assertTrue(httpServletResponse.getHeaderNames().isEmpty());
  }

  @Test
  public void integration_default() throws IOException {
    // given
    this.servletResponseUtility = ServletResponseUtility.instanceOf(httpServletResponse, new Object());
    given(httpServletResponse.getWriter()).willReturn(printWriter);
    // when
    servletResponseUtility.toJson();
    // then
    assertTrue(httpServletResponse.getHeaderNames().isEmpty());
  }
}
