package com.lightwing.tookit;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class StringFilter extends HttpServlet implements Filter {
    private FilterConfig filterConfig;

    // Handle the passed-in FilterConfig
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    // Process the request/response pair
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) {
        try {
            System.out.println(((HttpServletRequest) request).getRequestURI());
            if (!((HttpServletRequest) request).getRequestURI().contains("BooksPageAction"))
                request.setCharacterEncoding("GBK");
            filterChain.doFilter(request, response);
        } catch (ServletException sx) {
            filterConfig.getServletContext().log(sx.getMessage());
        } catch (IOException iox) {
            filterConfig.getServletContext().log(iox.getMessage());
        }
    }

    // Clean up resources
    public void destroy() {
    }
}
