package com.zhang.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie的获取
 * 返回的是cookie数组（不能获取指定的一个cookie,只能获取全部）
 *
 * @author 俊杰
 * @date 11/20/2022 4:35 PM
 */
@WebServlet("/cookie02")
public class Cookie02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取cookie数组
        Cookie[] cookies = request.getCookies();
        // 判断cookie是否为空
        if (cookies != null && cookies.length > 0) {
            // 遍历cookie数组
            for (Cookie cookie : cookies) {
                // 获取cookie的名称和值
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("名称: " + name + ", 值: " + value);
            }
        }
    }
}
