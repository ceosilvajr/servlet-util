[![Build Status](https://travis-ci.org/ceosilvajr/servlet-util.svg?branch=master)](https://travis-ci.org/ceosilvajr/servlet-util)
[![](https://jitpack.io/v/ceosilvajr/servlet-util.svg)](https://jitpack.io/#ceosilvajr/servlet-util)

servlet-utils
=======
General utilities for servlet

Download 
-------
1. Add the JitPack repository to your build file
```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
```
2. Add the dependency
```
dependencies {
	  compile 'com.github.ceosilvajr:servlet-util:+'
	}
```

How to use
-------
- Return json response using `ServletResponseUtility`
``` java
public class CronSymbolsServlet extends HttpServlet {

  private static final long serialVersionUID = -5487788660925224417L;

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletResponseUtility.instanceOf(resp, new Object()).toJson();
  }
}
```
- Convert request body to object using `ServletRequestUtility`
``` java
public class CronSymbolsServlet extends HttpServlet {

  private static final long serialVersionUID = -5487788660925224417L;

  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
      ServletRequestUtility.instanceOf(req).toRequestClass(Object.class);
  }
}
```
- Object response dto `ErrorResponse` and `SuccessResponse`

License
-------

MIT License

Copyright (c) 2018 Ariel Silva Jr

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.