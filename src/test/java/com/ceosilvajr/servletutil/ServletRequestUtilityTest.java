/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.servletutil;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

/**
 * Created date 19/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class ServletRequestUtilityTest {

  private static final String EXCEPTION_MESSAGE = "Expected exception not thrown.";

  @InjectMocks private ServletRequestUtility servletRequestUtility;
  @Mock private HttpServletRequest httpServletRequest;
  @Mock private BufferedReader bufferedReader;

  @BeforeMethod
  public void beforeMethod() {
    MockitoAnnotations.initMocks(this);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void given_null_request_throw_IllegalArgumentException() throws IOException {
    // given
    this.servletRequestUtility = ServletRequestUtility.instanceOf(null);
    // when
    Object toRequestClass = servletRequestUtility.toRequestClass(Object.class);
    // then
    fail(EXCEPTION_MESSAGE);
  }
}
