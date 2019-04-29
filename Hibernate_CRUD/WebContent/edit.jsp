<%@page import="VO.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Dao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit || Hibernate</title>
</head>
<body>

<%
	int sid =Integer.parseInt(request.getParameter("id"));
	List list = new ArrayList();
	Dao d = new Dao();
	Student s = new Student();
	s.setSid(sid);
	list = d.displayById(s);
	session.setAttribute("list", list);
	
%>
<form action="update_DB" method="POST">
<c:forEach items="${sessionScope.list}" var="i" >
	

	 <input type="hidden" name="sid" value="${i.sid}" >
	 <input type="text" name="uname" value="${i.username}" placeholder="Enter UserName" >
	 <input type="text" name="email" value="${i.email}" placeholder="Enter Email" >
	 <input type="text" name="phone" value="${i.phone}" placeholder="Enter phone" >
	 <button>Update</button>

	
</c:forEach>

<% session.removeAttribute("list"); %>
</form>
</body>
</html>