package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 响应数据:
 * getWriter()                 字符输出流 （输出字符串）
 * getOutputStream()           字节输出流 （输出一切数据）
 *
 * 两种流不可同时使用。如果同时使用会报错: 	java.lang.IllegalStateException: getWriter() has already been called for this response
 * 		at org.apache.catalina.connector.Response.getOutputStream(Response.java:550)
 * 		at org.apache.catalina.connector.ResponseFacade.getOutputStream(ResponseFacade.java:210)
 *
 * @author 俊杰
 * @date 11/19/2022 4:39 PM
 */
@WebServlet("/ser08")
public class Servlet08 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * getWriter() 字符输出流 （输出字符串）
         */
        // 获取字符输出流
//        PrintWriter writer = response.getWriter();
        // 输出数据
//        writer.write("Hello");
//        writer.write("<h2>hello</h2>");

        /**
         * getOutputStream() 字节输出流 （输出一切数据）
         */
        // 得到字节输出流
        ServletOutputStream out = response.getOutputStream();
        // 输出数据
        out.write("Hi".getBytes());
        out.write("<h2>hello</h2>".getBytes());
    }
}
