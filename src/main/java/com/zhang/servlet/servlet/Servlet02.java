package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 俊杰
 * @date 11/19/2022 1:29 PM
 */
@WebServlet("/ser02")
public class Servlet02 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 常用方法
         */
        // 获取请求时的完整路径（从http开始,到"?"前面结束）
        String url = request.getRequestURL() + "";
        System.out.println("获取请求时的完整路径: " + url);

        // 获取请求时的部分路径 （从项目的站点名开始,到 "?" 前面结束）
        String uri = request.getRequestURI();
        System.out.println("获取请求时的部分路径: " + uri);

        // 获取请求时的参数字符串 （从"?"后面开始,到最后的字符串）
        String queryString = request.getQueryString();
        System.out.println("获取请求时的参数字符串: " + queryString);

        // 获取请求方法 (GET和POST)
        String method = request.getMethod();
        System.out.println("获取请求方式: " + method);

        // 获取当前协议版本 (HTTP/1.1)
        String protocol = request.getProtocol();
        System.out.println("获取当前协议版本: " + protocol);

        // 获取项目的站点名 (项目对外访问路径)
        String webapp = request.getContextPath(); // 上下文路径
        System.out.println("获取项目的站点名: " + webapp);


        /**
         * 获取请求的参数
         */
        // 获取指定名称的参数值,返回字符串
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        System.out.println("uname: " + uname + ", upwd: " + upwd);

        // 获取指定名称的参数的所有参数值,返回字符串数组 （用于复选框传值）
        String[] hobbys = request.getParameterValues("hobby");
        if (hobbys != null && hobbys.length > 0) {
            for (String hobby : hobbys) {
                System.out.println("爱好: " + hobby);
            }
        }
    }
}
