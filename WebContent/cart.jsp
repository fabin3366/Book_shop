<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="servlet.*" import="java.util.*"
	import="util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	ArrayList<publication> publInCart = (ArrayList<publication>) session.getAttribute("cart");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Carts</title>
	<%@ include  file="index.html"%> 
</head>
<body>
	<center>
		</br>
		</br>
		<h2>Shopping Cart</h2>
		</br>


			<%
				if (publInCart == null || publInCart.size() == 0) {
			%>
			<h1>Shopping Cart is Empty!</h1>
			<%
				} else {
			%>
		<table align="center" style="text-align: center;" width="70%"
			border="0">
			<tr>
				<td></td>
				<td><h3>Number</h3></td>
				<td><h3>Author</h3></td>
				<td><h3>Title</h3></td>
				<td><h3>Publication Year</h3></td>
			</tr>
			</br>

			<%
				int i = 0;
					for (i = 0; i < publInCart.size(); i++) {
						publication publ = publInCart.get(i);
						int number = i + 1;
			%>

			<tr><td>
				<form action='control' method='POST'>
					<input type="checkbox" name="cartoperation"
						value=<%=publ.getItemId()%>>
				
				</td>
				<td><%=number %></td>
				<td>
					<%
						if (publ.getAuthor() != null) {
					%><%=publ.getAuthor()%> <%
 	}
 %>
				</td>
				<td>
					<%
						if (publ.getTitle() != null) {
					%><%=publ.getTitle()%> <%
 	}
 %>
				</td>
				<td>
					<%
						if (publ.getYear() != null) {
					%><%=publ.getYear()%> <%
 	}
 %>
				</td>

			</tr>
			<%
				}
				}
			%>
		</table>
		</br>
		</br>
		</br>
		<table>	
		<td>	
				<input type="hidden" name="action" value="removefromcart">
				<button style="width: 80px; height: 35px; background: #4169E1; color: white">Remove from Cart</button></td>
		</form>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td>
		<FORM ACTION='search.jsp' METHOD='POST'>
			<!-- 				<INPUT TYPE='submit' VALUE='Search Again'> -->
			<button
				style="width: 80px; height: 35px; background: #4169E1; color: white">Search
				Again</button>
			</td>
		</FORM>
		</table>
	</center>
</body>
</html>