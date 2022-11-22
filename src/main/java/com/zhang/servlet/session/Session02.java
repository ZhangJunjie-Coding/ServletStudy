package com.zhang.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session域对象
 *      setAttribute()   设置域对象
 *      getAttribute()   获取域对象
 *      removeAttribute() 移除域对象
 *
 *      请求转发
 *          一次请求
 *              request作用域有效
 *              session作用域有效
 *      重定向
 *          两次请求
 *              request作用域无效
 *              session作用域有效
 *
 * @author 俊杰
 * @date 11/20/2022 10:22 PM
 */
@WebServlet("/ses02")
public class Session02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* session域对象 */
        // 获取session对象
        HttpSession session = request.getSession();

        // 设置session域对象
        session.setAttribute("uname","admin");
        session.setAttribute("upwd","123456");

        // 移除session域对象
        session.removeAttribute("upwd");

        /* request 域对象 */
        request.setAttribute("name","zhangSan");

        // 请求转发到跳转到jsp页面
        //request.getRequestDispatcher("index.jsp").forward(request,response);

        // 重定向跳转到jsp页面
        response.sendRedirect("index.jsp");
    }
}
