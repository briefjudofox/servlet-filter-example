# Modify request parameters using a servlet filter

The `EchoServlet` writes the URL and request parameters on the response.  The `EchoServletFilter` intercepts requests to `/echo/*` and wraps the original request in a `EchoServletFilteredRequest` which allows you to add or update parameters by calling `addParameter()`.  As an example the `EchoServletFilter` adds 2 additional parameters ('extraParam1' and 'extraParam1').     

### Installing
#### Clone the repository
```git clone https://github.com/briefjudofox/servlet-filter-example.git```

#### Install with Maven
```cd servlet-filter-example```
```mvn install```

#### Run with embedded Tomcat
```mvn tomcat7:run```

#### Open a new command line and run tests
```mvn test```

#### Run from cmd or browser
```curl http://localhost:8080/ServletFilterExmaple/echo/```
```curl http://localhost:8080/ServletFilterExmaple/echo/?extraParam1=SomeInitialValue```
```curl http://localhost:8080/ServletFilterExmaple/echo/?extraParam1=SomeInitialValue&foo=pants```
