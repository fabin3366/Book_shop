<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="bean.publication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	ArrayList<publication> resultsList = (ArrayList<publication>) session.getAttribute("results");
	int pageCount = 0;
	int curPage = 0;
	int size = resultsList.size();
	if (size % 10 != 0)
		pageCount = size / 10 + 1;
	else
		pageCount = size / 10;
	String temp = request.getParameter("curPage");
	if (temp==null)
		temp = "1";
	curPage = Integer.parseInt(temp);


%>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DBLP search results</title>
	<%@ include  file="index.html"%> 
</head>
<body>

	<form action='control' method='POST'>
		<center>
			</br>
			</br>
			</br>
			<table align="center" style="text-align: center;" width="50%" border="0">
				<tr>
				</tr>
				<tr></tr>
				<tr>
					<td><input type="text" name="searchContent" placeholder="   Typing  here.."
						style="width: 450px; height: 25px"></td>
					<td><select name="searchType"><option value="all"
								selected="selected">All</option>
							<option value="author">Author</option>
							<option value="title">Title</option>
							<option value="year">Year</option></select></td>

					<td><input type="submit" value="Search"
						style="width: 80px; height: 35px; background: #4169E1; color: white"></td>
					<td><input type="hidden" name="action" value="search" /></td>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				</table>
				</br>
				<table align="center" style="text-align: center;" width="70%"
					border="0">
					<h2>Search Results</h2>
					<tr>
						<td><h3>Author</h3></td>
						<td><h3>Title</h3></td>
						<td><h3>Publication year</h3></td>
					</tr>
					<%
						
					for (int i = (curPage - 1) * 10; i < Math.min(size, curPage * 10); i++) {
							publication publ = resultsList.get(i);
							int number = i;
					%>
					<tr>						
						<td><%if (publ.getAuthor() == null){%>--<%}else{%><%=publ.getAuthor()%><%} %></td>
						<td><%if (publ.getTitle() == null){%>--<%}else{%><a href="control?itemid=<%=publ.getItemId()%>&action=moredetails"><%=publ.getTitle()%><%} %></td>
						<td><%if (publ.getYear() == null){%>--<%}else{%><%=publ.getYear()%><%} %></td>


					</tr>
					<%
						}
					%>
				</table>
				<br/>
				<br/>
				
				<table>
			
			<tr>
				<%if (curPage > 1) {%>
					
					<a href = "result.jsp?curPage=<%=curPage-1%>">Previous Page</a>
				<%}%>
			</tr>
			<tr>
			<span style="font-size:12px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			</tr>
			<tr>
				<%if (curPage < pageCount) {%>
				<a href = "result.jsp?curPage=<%=curPage+1%>">Next Page</a>
				<%}%>
			</tr>

		</table>
				</center>
				</form>
</body>
</html>