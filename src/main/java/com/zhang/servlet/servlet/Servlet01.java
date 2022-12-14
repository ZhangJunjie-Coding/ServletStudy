package com.zhang.servlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 俊杰
 * @date 11/19/2022 1:03 PM
 */
@WebServlet("/ser01")
public class Servlet01 extends HttpServlet {

    /**
     * 就绪/服务方法（处理请求数据）
     * 系统方法，服务器自动调用
     * 当有请求到达Servlet时，就会调用该方法
     * 方法可以被多次调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet被调用了.....");
    }

    /**
     * 销毁方法
     * 系统方法，服务器自动调用
     * 当服务器关闭或应用程序停止时，调用该方法
     * 方法只会执行一次
     */
    @Override
    public void destroy() {
        System.out.println("Servlet被销毁了.....");
    }

    /**
     * 初始化方法
     * 系统方法，服务器自动调用
     * 当请求到达Servlet容器时，Servlet容器会判断该Servlet对象是否存在，如果不存在，则创建实例并初始化
     * 方法只会执行一次
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet被创建了.....");
    }
}
