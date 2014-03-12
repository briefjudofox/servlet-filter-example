package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@WebServlet (value={"/echo","/echo/"}, name="echoServlet")
public class EchoServlet  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder(req.getRequestURL());
		if(req.getQueryString() != null) sb.append("?").append(req.getQueryString());
		sb.append("\n");
		for (Map.Entry<String,String[]> entry : req.getParameterMap().entrySet()) {
			sb.append("\n");
			sb.append(entry.getKey());
			sb.append(" : ");
			sb.append(entry.getValue()[0]);
		}
		resp.getWriter().println(sb.toString());
	}
}

