<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  // Simulate user login check; replace with your real user session attribute
  String username = (String) session.getAttribute("username");
%>
<header style="background-color:#007BFF; color:white; padding:10px 20px; display:flex; align-items:center; justify-content:space-between;">
  <div style="display:flex; align-items:center;">
    <!-- Simple logo placeholder -->
    <img src="${pageContext.request.contextPath}/images/logo.svg" alt="Logo" style="height:40px; margin-right:15px;">
    <nav>
      <a href="${pageContext.request.contextPath}/home" style="color:white; text-decoration:none; margin-right:15px;">Home</a>
      <a href="${pageContext.request.contextPath}/about" style="color:white; text-decoration:none; margin-right:15px;">About</a>
      <a href="${pageContext.request.contextPath}/contact" style="color:white; text-decoration:none;">Contact</a>
    </nav>
  </div>

  <div style="font-weight:bold; font-size:1.1em;">
    <% if (username != null) { %>
    Hello, <%= username %>!
    <% } else { %>
    Welcome, Guest!
    <% } %>
  </div>
</header>
