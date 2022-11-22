package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字节流响应数据
 *  乱码问题：
 *      对于getOutputStream()方式获取到的字节流，响应中文时，由于本身就是传输的字节，所以此时可能出现乱码，也可能正确显示。
 *      当服务器端给的字节恰好和客户端使用的编码方式一致时则文本正确显示，否则出现乱码。无论如何我们都应该准确掌握服务器和客户端
 *      使用的是那种编码格式，以确保数据正确显示。
 *
 *   乱码解决：
 *      1. 设置服务端的编码格式
 *       response.setCharacterEncoding("UTF-8");
 *      2. 设置客户端的编码
 *       response.setHeader("content-type","text/html;charset=UTF-8")
 *   总结：设置客户端和服务端的编码都支持中文，且保持一致。
 *
 *
 *   同时设置客户端和服务端的编码格式
 *     response.setContentType("text/html;charset=UTF-8");
 *
 * @author 俊杰
 * @date 11/20/2022 3:18 PM
 */
@WebServlet("/ser10")
public class Servlet10 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        /**
         * getOutputStream() 字节输出流 （输出一切数据）
         */
        // 得到字节输出流
        ServletOutputStream out = response.getOutputStream();
        // 输出数据
        out.write("你好".getBytes("UTF-8"));
        out.write("<h2>你好</h2>".getBytes("UTF-8"));
    }
}
