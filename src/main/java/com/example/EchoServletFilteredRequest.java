package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * An example HttpServletRequestWrapper that allows you to modify or add request parameters
 * before being processed by the servlet.
 */
public class EchoServletFilteredRequest extends HttpServletRequestWrapper {

	private Map<String, String[]> filteredParameters;

	public EchoServletFilteredRequest(HttpServletRequest request) {
		super(request);
		filteredParameters = new HashMap<String, String[]>();
		filteredParameters.putAll(request.getParameterMap());
	}

	@Override
	public String getParameter(String name) {
		String[] values = filteredParameters.get(name);
		if(values != null && values.length > 0) return values[0];
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return Collections.unmodifiableMap(filteredParameters);
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(filteredParameters.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return filteredParameters.get(name);
	}


	public void addParameter(String key, String[] valueArray){
		this.filteredParameters.put(key,valueArray);
	}

	public void addParameter(String key, String value){
		this.filteredParameters.put(key, new String[]{value});
	}

}
