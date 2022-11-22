package com.zhang.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie的注意点：
 * 1.Cookie只在当前浏览器中有效（不夸浏览器和电脑）
 * 2.Cookie不能存中文
 *      如果一定要存中文，则需要通过URLEncoder.encoder()方法进行编码，获取时通过URLDecoder.decode()方法进行解码
 * 3.如果出现同名的Cookie对象，则会覆盖
 * 4.Cookie的存储数量是有上限的，不同浏览器的上限不同。Cookie存储的大小是有限的，在4kb左右
 */
@WebServlet("/cookie04")
public class Cookie04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*Cookie存中文*/
        String name = "俊杰";
        String value = "张";

        // 将中文通过URLEncoder进行编码
        name = URLEncoder.encode(name);
        value = URLEncoder.encode(value);

        // 创建Cookie对象
        Cookie cookie = new Cookie(name, value);
        // 响应Cookie
        response.addCookie(cookie);

        // 获取Cookie时，通过URLDecoder进行解码
        Cookie[] cookies = request.getCookies();
        //判断非空
        if (cookies != null && cookies.length > 0) {
            // 遍历
            for (Cookie cookie1 : cookies) {
                // 解码
                System.out.println(URLDecoder.decode(cookie1.getName()));
                System.out.println(URLDecoder.decode(cookie1.getValue()));
            }
        }

        // 将原来已有的Cookie对象重新设置
        Cookie cookie2 = new Cookie("name","zhangSan");
        response.addCookie(cookie2);


    }
}
