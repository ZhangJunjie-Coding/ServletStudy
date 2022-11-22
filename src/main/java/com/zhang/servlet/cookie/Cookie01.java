package com.zhang.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * cookie的创建和发送
 *
 * @author 俊杰
 * @date 11/20/2022 4:35 PM
 */
@WebServlet("/cookie01")
public class Cookie01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie = new Cookie("uname", "zhang");
        // 发送（响应）Cookie对象
        response.addCookie(cookie);

    }
}
