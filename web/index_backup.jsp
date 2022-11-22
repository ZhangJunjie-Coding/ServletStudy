<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 俊杰
  Date: 11/19/2022
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
</head>
<body>
<h2>index页面</h2>
<%--如果要在Jsp中写Java代码，需要写在脚本段中--%>
<%
    // 获取域对象内容
    String name = (String) request.getAttribute("name");
    System.out.println("name: " + name);
    Integer age = (Integer) request.getAttribute("age");
    System.out.println("age: " + age);
    List<String> list = (List<String>) request.getAttribute("list");
//    System.out.println(list.get(0));
%>
</body>
</html>