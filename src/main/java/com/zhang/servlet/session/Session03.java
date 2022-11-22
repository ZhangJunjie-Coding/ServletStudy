package com.zhang.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session对象的销毁
 *
 *      1.默认到期时间
 *          Tomcat中session默认的存活时间为30min,即你不操作页面的时间,一旦有操作,session就会重新计时
 *          可以在Tomcat中的conf目录下的web.xml文件中进行修改
 *              session 默认的最大不活动时间. 单位: 分钟
 *              <session-config>
 *                  <session-timeout>30</session-timeout>
 *              </session-config>
 *
 *      2. 手动设置到期时间
 *          可以在程序中自己设定session的生命周期
 *          通过 session.setMaxInactiveInterval(int) 来设定 session的最大不活动时间,单位为秒。
 *          通过 session.getMaxInactiveInterval(int) 来获取 session对象的最大不活动时间,单位为秒。
 *
 *      3. 立即销毁
 *          可以通过 session.invalidate() 方法让 session 立刻失效
 *
 *      4. 关闭浏览器
 *          session底层依赖cookie,cookie对象默认只在浏览器内存中存活,关闭浏览器即失效
 *
 *      5. 关闭服务器
 *          当关闭服务器时,session 销毁。
 *
 * @author 俊杰
 * @date 11/20/2022 10:22 PM
 */
@WebServlet("/ses03")
public class Session03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 获取session的最大不活动时间
        // int time = session.getMaxInactiveInterval();
        // System.out.println("session的最大不活动时间: "+ time);

        // 修改最大不活动时间
        // session.setMaxInactiveInterval(15);  // 15秒失效


        // 立刻销毁 ,可以通过 session.invalidate() 方法让 session 立刻失效
//        session.invalidate();

    }
}
