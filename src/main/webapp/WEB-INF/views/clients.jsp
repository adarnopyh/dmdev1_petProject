<%--<%@ taglib prefix="c" uri="https://jakarta.ee/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="c" uri="http://jakarta.apache.org/taglibs/core" %>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client List</title>
</head>
<body>
<h1>Client List</h1>
<table style="border: 1px solid green">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Is Legal</th>
        <th>Is VAT Payer</th>
        <th>Reg Number</th>
        <th>VAT Number</th>
        <th>IBAN</th>
        <th>Price Level</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td>${client.id}</td>
            <td>${client.name}</td>
            <td>${client.isLegal}</td>
            <td>${client.isVatPayer}</td>
            <td>${client.regNumber}</td>
            <td>${client.vatNumber}</td>
            <td>${client.bankAccount.iban}</td>
            <td>${client.priceLevel.code}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
