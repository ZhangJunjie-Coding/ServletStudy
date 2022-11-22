package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 乱码原因：
 * 由于在解析过程中默认使用的编码方式为 ISO-8859-1（此编码不支持中文）,所以解析时一定会出现乱码
 * 请求乱码问题 tomcat8.0一下版本才有的问题
 *
 * Tomcat8以上的版本：
 * Get请求是不会乱码的,不需要处理
 *
 * POST请求会乱码，通过设置服务器解析编码的格式 request.setCharacterEncoding("UTF-8")
 *
 * 乱码情况:
 *      POST请求: 无论什么版本的服务器，post请求中文都会乱码. (解决: request.setCharacterEncoding("UTF-8"))
 *
 *  注:
 *      1.request.setCharacterEncoding("UTF-8") 只针对 POST请求乱码
 *      2.new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8"); 针对任何请求方式。
 *      但是如果数据本身不乱码，还依然使用 new String方法转换，则会乱码
 * @author 俊杰
 * @date 11/19/2022 2:02 PM
 */
@WebServlet("/ser03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求的编码格式
        request.setCharacterEncoding("UTF-8");

        // 获取客户端传递的参数
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        System.out.println("姓名: " + uname);
        System.out.println("密码: " + upwd);
    }
}
