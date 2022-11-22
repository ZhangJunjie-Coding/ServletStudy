package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 俊杰
 * @date 11/19/2022 3:56 PM
 */
@WebServlet("/ser07")
public class Servlet07 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet07......");
        // 获取域对象内容
        String name = (String) request.getAttribute("name");
        System.out.println("name: " + name);
        Integer age = (Integer) request.getAttribute("age");
        System.out.println("age: " + age);
        List<String> list = (List<String>) request.getAttribute("list");
        System.out.println(list.get(0));
    }
}
