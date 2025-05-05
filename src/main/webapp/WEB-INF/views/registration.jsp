<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/registration" method="post">
    <label for="username">Username:
      <input type="text" name="username" id="username">
    </label><br>
    <label for="birthday">Birthday:
      <input type="date" name="birthday" id="birthday">
    </label><br>
    <label for="email">Email:
      <input type="text" name="email" id="email">
    </label><br>
    <label for="password">Email:
      <input type="password" name="password" id="password">
    </label><br>
    <button type="submit">Submit</button>
  </form>
</body>
</html>
