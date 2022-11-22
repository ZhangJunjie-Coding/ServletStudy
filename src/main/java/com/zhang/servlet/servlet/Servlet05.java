package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 俊杰
 * @date 11/19/2022 3:29 PM
 */
@WebServlet("/ser05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收客户端请求的参数
        String uname = request.getParameter("uname");
        System.out.println("Servlet05 uname: " + uname);

    }
}
