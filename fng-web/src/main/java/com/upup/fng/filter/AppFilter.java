package com.upup.fng.filter;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2020/12/7 下午6:43
 */

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AppFilter extends BaseFilter {


    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进来了");
    }
}
