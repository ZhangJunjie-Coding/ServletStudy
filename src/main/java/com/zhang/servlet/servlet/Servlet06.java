package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * request作用域
 * 通过该对象可以在一个请求中传递数据，所用范围：在一次请求中有效，即服务器跳转有效。（请求转发跳转时有效）
 * <p>
 * 1. 设置域对象内容
 * request.setAttribute(String name,Object value);
 * <p>
 * 2. 获取域对象内容
 * request.getAttribute(String name)
 * <p>
 * 3. 删除域对象内容
 * request.removeAttribute(String name)
 *
 * @author 俊杰
 * @date 11/19/2022 3:47 PM
 */
@WebServlet("/ser06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet 06....");

        // 设置域对象内容
        request.setAttribute("name", "admin");
        request.setAttribute("age", 18);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        request.setAttribute("list", list);

        // 请求转发跳转到Servlet
        // request.getRequestDispatcher("ser07").forward(request,response);

        // 请求转发跳转到jsp,并通过域对象传递数据
        request.getRequestDispatcher("index.jsp").forward(request,response);


    }
}
