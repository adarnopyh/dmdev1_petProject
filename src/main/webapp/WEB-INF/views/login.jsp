<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>

<form action="${pageContext.request.contextPath}/login" method="post">
  <label for="username">Username:
    <input type="text" name="username" id="username" required>
  </label><br>

  <label for="password">Password:
    <input type="password" name="password" id="password" required>
  </label><br>

  <button type="submit">Login</button>
</form>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
