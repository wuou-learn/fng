package com.upup.fng.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/12/7 下午5:29
 */
public abstract class BaseFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        //例外的请求路径直接进入过滤器链的下一个任务
        ArrayList<String> list = new ArrayList<String>();
        list.add("/imp/user");
        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }


    public abstract void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException;
}
