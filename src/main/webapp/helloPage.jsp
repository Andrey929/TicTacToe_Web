<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrey
  Date: 08.11.2023
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <%@include file="WEB-INF/static/main.css"%>
    </style>
    <title>Hello</title>
</head>
<body>
<img src="WEB-INF/Pictures/firstP.png" alt="">
<h2>В какой режим поиграем ?</h2>
<button id="buttonWithPC" type="button" class="btn b1" onclick="window.location = '/main?pos=1'"> 1vsPC </button>
<button id="buttonWithPlayer" type="button" class="btn b2" onclick="window.location = '/main?pos=2'"> 1vs1 </button>
</body>
</html>
