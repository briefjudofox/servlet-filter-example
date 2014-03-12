package com.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="echoServletFilter", urlPatterns="/echo/*")
public class EchoServletFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		EchoServletFilteredRequest filteredRequest = new EchoServletFilteredRequest(httpRequest);

		//Add or Override Request Parameters Here
		filteredRequest.addParameter("extraParam1","Added in servlet filter");
		filteredRequest.addParameter("extraParam2","Also added in servlet filter");

		//Passed the FilteredRequest Along the Chain:
		chain.doFilter(filteredRequest, response);
	}

	@Override
	public void destroy() {

	}
}
