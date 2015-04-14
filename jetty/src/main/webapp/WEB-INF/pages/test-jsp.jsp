<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>测试JSP</title>
    <link rel="stylesheet" href="common/css/common.css">
</head>
<body>
<div class="page-main">
    <div class="content-title">JSP测试成功</div>
    <c:if test="${not empty name}">
        The value of name is: <c:out value="${name}"/>
    </c:if>
    <div class="back-link"><a href="index.html">返回</a></div>
</div>
</body>
</html>
