<%@ page import="Sourse.Field" %>
<%@ page import="Sourse.Figure" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintStream"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <style>
        <%@include file="/WEB-INF/static/index.css"%>
    </style>
    <title>X\O</title>
</head>
<body>
<%
    List<Figure> data= new ArrayList<>();
%>
<table>
    <tr>
        <td onclick="window.location='/logic?click=0'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(0).getFigure() %>
        </td>
        <td onclick="window.location='/logic?click=1'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(1).getFigure() %></td>
        <td onclick="window.location='/logic?click=2'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(2).getFigure() %></td></td>
    </tr>
    <tr>
        <td onclick="window.location='/logic?click=3'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(3).getFigure() %></td></td>
        <td onclick="window.location='/logic?click=4'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(4).getFigure() %></td></td>
        <td onclick="window.location='/logic?click=5'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(5).getFigure() %></td></td>
    </tr>
    <tr>
        <td onclick="window.location='/logic?click=6'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(6).getFigure() %></td></td>
        <td onclick="window.location='/logic?click=7'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(7).getFigure() %></td></td>
        <td onclick="window.location='/logic?click=8'"><%
            data = (List<Figure>) request.getSession().getAttribute("data");%>
            <%= data.get(8).getFigure() %></td></td>
    </tr>
</table>
<button id="reset-button" onclick="window.location ='/main?pos=1'">Заново</button>
<button id="reset-button" class="bt btToMain" onclick="window.location ='/main'">На главную</button>
</body>
</html>
