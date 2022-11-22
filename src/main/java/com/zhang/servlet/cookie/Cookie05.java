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
 * Cookie路径问题
 *      1.当前服务器下任何项目的任意资源都可获取Cookie对象
 *          设置路径为 "/",表示在当前服务器下任何项目都可访问到Cookie对象
 *
 *      2.当前项目下的资源可获取Cookie对象(默认不设置Cookie的path)
 *         默认不设置Cookie的path 或者 设置为当前站点名
 *
 *      3.指定项目下的资源可获取Cookie对象
 *      4.指定目录下的资源可获取Cookie对象
 *
 *      总结：只有访问的路径中包含Cookie对象的path值，才可以获取到该cookie对象
 */
@WebServlet("/cookie05")
public class Cookie05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*当前服务器下任何项目的任意资源都可获取Cookie对象*/
        Cookie cookie01 = new Cookie("cookie01", "cookie01");
        // 设置路径为 "/",表示在当前服务器下任何项目都可访问到Cookie对象
        cookie01.setPath("/");
        response.addCookie(cookie01);


        /* 当前项目下的资源可获取Cookie对象(默认不设置Cookie的path) */
        Cookie cookie02 = new Cookie("cookie02", "cookie02");
        // 默认不设置Cookie的path 或者 设置为当前站点名
        cookie02.setPath("/sc04");
        response.addCookie(cookie02);

        /* 指定项目下的资源可获取Cookie对象 */
        Cookie cookie03 = new Cookie("cookie03", "cookie03");
        // 设置指定项目的站点名
        cookie03.setPath("/sc03");
        response.addCookie(cookie03);

        /* 指定目录下的资源可获取Cookie对象 */
        Cookie cookie04 = new Cookie("cookie04", "cookie04");
        // 设置指定项目的站点名
        cookie04.setPath("/sc04/cookie02");
        response.addCookie(cookie04);


    }
}
