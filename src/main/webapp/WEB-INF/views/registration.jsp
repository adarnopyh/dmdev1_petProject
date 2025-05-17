
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>
  <form action="/registration" method="post">
    <label for="username">Username:
      <input type="text" name="username" id="username">
    </label><br>
    <label class="custom-select" for="role">Role:
      <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.roles}">
        <option value="${role}">${role}</option>
        </c:forEach>
      </select>
    </label><br>
    <label for="email">Email:
      <input type="text" name="email" id="email">
    </label><br>
    <label for="password">Password:
      <input type="password" name="password" id="password">
    </label><br>
    <button type="submit">Submit</button>
  </form>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
