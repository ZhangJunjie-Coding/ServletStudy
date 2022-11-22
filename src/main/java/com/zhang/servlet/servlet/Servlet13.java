package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向与请求转发的区别:
 *      1. 请求转发的地址栏不会发生改变，重定向的地址栏会发生改变
 *      2. 请求转发只有一次请求，重定向有两次请求
 *      3. 请求转发时 request 对象可共享，重定向时 request对象不可共享
 *      4. 请求转发是服务端行为，重定向时客户端行为
 *      5. 请求转发时的地址只能是当前站点下（当前项目）的资源，重定向时地址可以是任何地址
 */
@WebServlet("/ser13")
public class Servlet13 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet06....");

        // 接收参数
        String uname = request.getParameter("uname");
        System.out.println(uname);

        // 设置request域对象
        request.setAttribute("upwd","123456");

        // 请求转发
         // request.getRequestDispatcher("index.jsp").forward(request,response);

        // 重定向
//        response.sendRedirect("index.jsp");

        // 重定向到百度
//        response.sendRedirect("http://www.baidu.com");

        // 转发到百度
        request.getRequestDispatcher("http://www.baidu.com").forward(request,response);
    }
}
