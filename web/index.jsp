<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
</head>
<body>
<h2>获取域对象</h2>
<%

    // 获取Session对象
    HttpSession session1 = request.getSession();
    String uname = (String) session1.getAttribute("uname");
    String upwd = (String) session1.getAttribute("upwd");

    // 获取request对象
    String name = (String) request.getAttribute("name");

    out.print("uname: " + uname + ", upwd: " + upwd + ",name: " + name);

%>
</body>
</html>