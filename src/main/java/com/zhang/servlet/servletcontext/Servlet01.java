package com.zhang.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取ServletContext对象
 * 1.通过request对象获取
 * 2.通过session对象获取
 * 3.通过ServletConfig对象获取
 * 4.直接获取
 *
 * 常用方法
 *    1.获取当前服务器的版本信息
 *    2.获取项目的真实路径
 *
 * @author 俊杰
 * @date 11/22/2022 3:09 PM
 */
@WebServlet("/src01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request对象获取
        ServletContext context = request.getServletContext();

        // 通过session对象获取
        ServletContext context1 = request.getSession().getServletContext();

        // 通过ServletConfig对象获取
        ServletContext context2 = getServletConfig().getServletContext();

        // 直接获取
        ServletContext context3 = getServletContext();


        // 常用方法
        // 1.获取当前服务器的版本信息
        String serverInfo = request.getServletContext().getServerInfo();
        System.out.println("获取当前服务器的版本信息: " + serverInfo);

        // 2.获取项目的真实路径
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("获取项目的真实路径: " + realPath);
    }
}
