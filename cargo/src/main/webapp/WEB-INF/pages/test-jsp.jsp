<%--suppress ALL --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>测试JSP</title>
    <link rel="stylesheet" href="/assets/css/common.css">
</head>
<body>
<div class="page-main">
    <div class="content-title">欢迎${name}，JSP测试成功</div>
    <div class="back-link"><a href="<c:url value="/index.html"/>">返回</a></div>
</div>
</body>
</html>
