<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>测试Tomcat</title>
    <link rel="stylesheet" href="<c:url value="/assets/css/common.css"/>">
</head>
<body>
<div class="page-main">
    <div class="title">测试JSP</div>
    <c:if test="${not empty name }">
        <div>${name} is got</div>
    </c:if>
    <div class="back-link">
        <a href="<c:url value="/index.html"/>">返回主页</a>
    </div>
</div>
</body>
</html>