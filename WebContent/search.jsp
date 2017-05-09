<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="bean.*" import="servlet.*"  import="java.util.*" import="util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	ArrayList<publication> resultsList = (ArrayList<publication>) request.getAttribute("results");
	//HttpSession ses = request.getSession();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Searching Bar</title>
	<%@ include  file="index.html"%> 
</head>
<body>

	<form action='control' method='POST'>
		<center>
			</br>
			</br>
			<table width=50%>
			<tr> </tr><tr></tr>
				<tr>
					<td><input type="text" name="searchContent" placeholder="   Typing  here.."
						style="width: 450px; height: 25px"></td>
					<td><select name="searchType"><option value="all" selected="selected">All</option>
							<option value="author">Author</option>
							<option value="title">Title</option>
							<option value="year">Year</option></select></td>
					
					<td><input type="submit" value="Search"
						style="width: 80px; height: 40px; background: #4169E1; color: white"></td>
<!-- 						<td><a href="advancedSearch.jsp">advanced search</td> -->
					<td><input type="hidden" name="action" value="search" /></td>
				</tr>
				<tr> </tr>
				<tr> </tr>
			<jsp:include  page="randShowing.jsp"/>
				
			</table>

		</center>
	</form>
</body>
</html>