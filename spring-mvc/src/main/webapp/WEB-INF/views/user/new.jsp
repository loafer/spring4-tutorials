<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title></title>
  </head>
  <body>
    <form method="post" action="/conversion/user">
      <div style="width: 600px;">
        <label>name:</label>
        <input type="text" name="name" style="width: 100%;" value="${user.name}">
      </div>
      <div style="width: 600px;">
        <label>birthday:</label>
        <input type="text" name="birthday" style="width: 100%;" value="${user.birthday}">
      </div>
      <div style="width: 600px;">
        <input type="submit" value="submit">
      </div>
    </form>
  </body>
</html>
