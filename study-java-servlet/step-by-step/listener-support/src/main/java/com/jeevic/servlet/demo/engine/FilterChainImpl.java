package com.jeevic.servlet.demo.engine;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @className: com.jeevic.servlet.demo.engine -> FilterChainImpl
 * @description:
 * @author: jeevi
 * @createDate: 2023/12/25 20:32
 * @version: 1.0
 */
public class FilterChainImpl implements FilterChain {

    final Filter[] filters;
    final Servlet servlet;
    final int total;
    int index = 0;

    public FilterChainImpl(Filter[] filters, Servlet servlet) {
        this.filters = filters;
        this.servlet = servlet;
        this.total = filters.length;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (index < total) {
            int current = index;
            index++;
            filters[current].doFilter(request, response, this);
        } else {
            servlet.service(request, response);
        }
    }
}
