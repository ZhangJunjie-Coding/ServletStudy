package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向:
 *     服务端指导的客户端行为，
 *     存在两次请求
 *     地址栏会发生变化
 *     request对象不共享
 */
@WebServlet("/ser11")
public class Servlet11 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet11......");

        // 重定向跳转到ser12
        response.sendRedirect("ser12");
    }
}
