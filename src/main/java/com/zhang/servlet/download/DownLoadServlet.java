package com.zhang.servlet.download;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 俊杰
 * @date 11/22/2022 4:43 PM
 */
@WebServlet("/downloadServlet")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("文件下载.......");
        // 设置请求的编码
        request.setCharacterEncoding("UTF-8");

        // 获取文件下载路径
        String path = getServletContext().getRealPath("/download/");
        System.out.println("文件下载的路径: " + path);

        // 获取要下载的文件名
        String name = request.getParameter("fileName");

        if (name == null || "".equals(name.trim())) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("请输入要下载的文件名!");
            response.getWriter().close();
            return;
        }

        // 通过路径得到file对象
        File file = new File(path + name);

        // 判断file对象是否存在,且是否是一个标准文件
        if (file.exists() && file.isFile()) {

            // 设置响应类型（浏览器无法使用某种方式或激活某个程序来处理的类型）
            response.setContentType("application/x-msdownload");

            // 设置头信息
            response.setHeader("Content-Disposition", "attachment;filename=" + name);

            // 得到输入流
            InputStream is = new FileInputStream(file);

            // 得到输出流
            ServletOutputStream os = response.getOutputStream();

            // 定义byte数组
            byte[] car = new byte[1024];

            // 定义长度
            int len = 0;
            while ((len = is.read(car)) != -1) {
                os.write(car, 0, len);
            }
            // 关闭流，释放资源
            os.close();
            is.close();
        } else {
            System.out.println("文件不存在,下载失败!");
        }
    }
}
