<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title></title>
</head>
<body>
<form method="post">
  <div style="width: 600px;">
    <label>name:</label>
    <input type="text" name="name" style="width: 100%;" value="${user.name}">
  </div>
  <div style="width: 600px;">
    <label>birthday:</label>
    <input type="text" name="birthday" style="width: 100%;" value="${user.birthday}">
    <form:input path="user.birthday"/>
    <spring:eval expression="user.birthday"></spring:eval>
  </div>
  <div style="width: 600px;">
    <input type="submit" value="submit">
  </div>
</form>
</body>
</html>
