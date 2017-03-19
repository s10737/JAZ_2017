<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<body>
<table>
<c:forEach items="${users}" var="user">
    <tr>
        <td>User name: <c:out value="${user.userName}"/></td>
        <td>Role: <c:out value="${user.role}"/></td>
    </tr>
</c:forEach>
</table>
<p>Zarzadzanie uprawnieniami</p>
<form action="users" method="post">
<select name="userName">
<c:forEach items="${users}" var="user">
        <option><c:out value="${user.userName}"/></option>
</c:forEach>
</select>
<select name="role">
        <option>normal</option>
        <option>premium</option>
        <option>admin</option>
</select>
<input type="submit" value="Submit"/>
</form>
</body>
</html>