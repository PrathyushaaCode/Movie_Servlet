<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int a=7;
System.out.println(a);
%>

<%!int b=8;%>
<%
System.out.println(a);
%>
<%=a %>

</body>
</html>