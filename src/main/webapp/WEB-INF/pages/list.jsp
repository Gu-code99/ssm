<%--
  Created by IntelliJ IDEA.
  User: GuYuBo
  Date: 2020/6/25
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>查询所有账户信息</h3>

    <c:forEach items="${list}" var="account">
        ${account.name}
    </c:forEach>

</body>
</html>
