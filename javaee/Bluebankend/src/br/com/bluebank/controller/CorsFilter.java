package br.com.bluebank.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
    private static final String LOCALHOST_4200 = "http://localhost:4200";
    private static final String LOCALHOST_4201 = "http://localhost:4201";

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String origin = httpRequest.getHeader("Origin");

        if (LOCALHOST_4201.equals(origin)) {
            httpResponse.setHeader("Access-Control-Allow-Origin", LOCALHOST_4201);
        } else {
            httpResponse.setHeader("Access-Control-Allow-Origin", LOCALHOST_4200);
        }

        httpResponse.setHeader("Access-Control-Allow-Methods", "GET, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept");

        if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
