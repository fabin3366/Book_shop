<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="servlet.*"  import="java.util.*" import="util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//String xmlPath = getServletConfig().getServletContext().getRealPath("/") + "dblp.xml";
	randGeneration randGeneration = new randGeneration();
	ArrayList<publication> randResults = randGeneration.generateRandResult();
	//HttpSession ses = request.getSession();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Random ten publications</title>
</head>
<body>
	
	<center>
	<table align="center" style="text-align: center;" width="80%" border="0">
			<tr>
				<td><h3>Author</h3></td>
				<td><h3>Title</h3></td>
				<td><h3>Publication Year</h3></td>
			</tr>
			</br>
			<%
				int i = 0;
				for (i = 0; i < randResults.size(); i++) {
					publication publ = randResults.get(i);
					int number = i;
			%>
			<tr>
				
				<td><%if (publ.getAuthor() == null){%>--<%}else{%><%=publ.getAuthor()%><%} %></td>
				<td><%if (publ.getTitle() == null){%>--<%}else{%><a href="control?itemid=<%=publ.getItemId()%>&action=moredetails"><%=publ.getTitle()%><%} %></td>
				<td><%if (publ.getYear() == null){%>--<%}else{%>
				
					<%=publ.getYear()%><%} %></td>

			</tr>
			<%
				}
			%>
		</table>
		</center>
</body>
</html>