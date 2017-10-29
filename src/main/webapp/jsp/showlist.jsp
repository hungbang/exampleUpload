<%--
  Created by IntelliJ IDEA.
  User: KAI
  Date: 10/28/17
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
this is show list
<c:if test="${not empty images}">
    <c:forEach var="image" items="${images}">
        <img src='<c:out value="${image.path}"/>' />
    </c:forEach>
    </c:if>
</body>
</html>
