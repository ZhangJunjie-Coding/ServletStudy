package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符流响应数据
 *
 * 乱码原因：
 *      对于getWriter()获取到的字符流，响应中文必定出现乱码，由于服务器端在进行编码时默认会使用ISO-8859-1格式的编码，该编码方式默认不支持中文
 * 乱码解决：
 *   1. 设置服务端编码格式
 *      response.setCharacterEncoding("UTF-8");
 *   2. 设置客户端的编码
 *      response.setHeader("content-type","text/html;charset=UTF-8");
 *
 *   总结：设置客户端和服务端的编码都支持中文，且保持一致
 *
 *
 *   同时设置客户端和服务端的编码格式
 *     response.setContentType("text/html;charset=UTF-8");
 *
 * @author 俊杰
 * @date 11/20/2022 3:18 PM
 */
@WebServlet("/ser09")
public class Servlet09 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置服务端的编码格式
//        response.setCharacterEncoding("UTF-8");

        // 设置客户端的编码格式和响应的MIME类型
//        response.setHeader("content-type","text/html;charset=UTF-8");

        // 同时设置客户端和服务端的编码格式
        response.setContentType("text/html;charset=UTF-8");
        /**
         * getWriter() 字符输出流 （输出字符串）
         */
//         获取字符输出流
        PrintWriter writer = response.getWriter();
//         输出数据
        writer.write("你好");
        writer.write("<h2>你好</h2>");
    }
}
