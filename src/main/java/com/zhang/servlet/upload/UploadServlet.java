package com.zhang.servlet.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * 使用注解@MultipartConfig将一个Servlet标识为支持文件上传。
 * Servlet将multipart/form-data的POST请求封装成Part，通过Part对上传文件进行操作。
 *
 * @author 俊杰
 * @date 11/22/2022 3:39 PM
 */
@WebServlet("/uploadServlet")
@MultipartConfig // 如果是文件上传表单，一定要加这个注解
public class UploadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件上传......");

        // 设置请求的编码格式
        request.setCharacterEncoding("UTF-8");

        // 获取普通表单项 (文本框)
        String uname = request.getParameter("uname"); // "uname" 代表的是文本框的name属性值
        System.out.println("uname: " + uname);

        // 通过 getPart(name) 方法获取Part对象 (name代表的是页面表单中file文件域的name属性值)
        Part part = request.getPart("myfile");

        // 通过Part对象,获取上传的文件名
        String fileName = part.getSubmittedFileName();
        System.out.println("上传文件名: " + fileName);

        // 获取上传文件需要存放的路径 (得到项目存放的真实路径)
        String realPath = request.getServletContext().getRealPath("/");
        System.out.println("文件存放的路径: " + realPath);

        // 将文件上传到指定位置
        part.write(realPath + fileName);
    }
}
