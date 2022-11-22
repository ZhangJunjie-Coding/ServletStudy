package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发跳转:
 *  request.getRequestDispatcher(url).forward(request,response);
 *
 * 可以让请求从服务端跳转到客户端（或跳转到指定Servlet）
 *
 * 特点：
 *     1.服务端行为
 *     2.地址栏不发生改变
 *     3.从始至终只有一个请求
 *     4.request数据可以共享
 *
 * @author 俊杰
 * @date 11/19/2022 3:27 PM
 */
@WebServlet("/ser04")
public class Servlet04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收客户端请求的参数
        String uname = request.getParameter("uname");
        System.out.println("Servlet04 uname: " + uname);


        // 请求转发跳转到Servlet05
        // request.getRequestDispatcher("ser05").forward(request,response);

        // 请求转发跳转到jsp页面
        // request.getRequestDispatcher("login.jsp").forward(request,response);

        // 请求转发跳转到html页面
        request.getRequestDispatcher("login.html").forward(request,response);

    }
}
