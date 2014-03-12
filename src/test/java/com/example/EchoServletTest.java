package com.example;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;


/**
 * Integration tests - Server should be running:  mvn tomcat7:run
 */
public class EchoServletTest extends TestCase {
	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:8080/ServletFilterExmaple/echo");
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testDoGetBase() throws Exception {
		beginAt("");
		assertTextPresent("http://localhost:8080/ServletFilterExmaple/echo");
	}

	@Test
	public void testDoGetBaseSlash() throws Exception {
		beginAt("/");
		assertTextPresent("http://localhost:8080/ServletFilterExmaple/echo/");
	}

	@Test
	public void testDoGetBaseWithParams() throws Exception {
		beginAt("?foo=pants");
		assertTextPresent("http://localhost:8080/ServletFilterExmaple/echo/?foo=pants");
	}

	@Test
	public void testAddFilterParams() throws Exception {
		beginAt("?foo=pants");
		assertTextPresent("extraParam1 : Added in servlet filter");
	}

	@Test
	public void testOverrideFilterParams() throws Exception {
		beginAt("?extraParam1=SomeInitialValue");
		assertTextPresent("extraParam1 : Added in servlet filter");
	}
}
