<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="bean.publication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//ArrayList<publication> resultsList = (ArrayList<publication>) request.getAttribute("results");
	publication publChosen = (publication) request.getAttribute("publChosen");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Detailed Information</title>
	<%@ include  file="index.html"%> 
</head>
<body>
	<center>
		</br>
		</br>
		<h2>Detailed Information</h2>
		</br>
		<table align="center" style="text-align: center;" width="50%" border="0">
			<tr>
				<td>
					<%
						if (publChosen.getAuthor() != null) {
					%> <h3>Author</h3>
				</td>
				<td></td>
				<td><%=publChosen.getAuthor()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getEditor() != null) {
					%> <h3>Editor</h3>
				</td>
				<td></td>
				<td><%=publChosen.getEditor()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getTitle() != null) {
					%> <h3>Title</h3>
				</td>
				<td></td>
				<td><%=publChosen.getTitle()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getPages() != null) {
					%> <h3>Pages</h3>
				</td>
				<td></td>
				<td><%=publChosen.getPages()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getYear() != null) {
					%> <h3>Publication Year</h3>
				</td>
				<td></td>
				<td><%=publChosen.getYear()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getAddress() != null) {
					%> <h3>Address</h3>
				</td>
				<td></td>
				<td><%=publChosen.getAddress()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getVolume() != null) {
					%> <h3>Volume</h3>
				</td>
				<td></td>
				<td><%=publChosen.getVolume()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getJournal() != null) {
					%> <h3>Journal</h3>
				</td>
				<td></td>
				<td><%=publChosen.getJournal()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getNumber() != null) {
					%> <h3>Number</h3>
				</td>
				<td></td>
				<td><%=publChosen.getNumber()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getMonth() != null) {
					%> <h3>Month</h3>
				</td>
				<td></td>
				<td><%=publChosen.getMonth()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getEe() != null) {
					%> <h3>EE</h3>
				</td>
				<td></td>
				<td><%=publChosen.getEe()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getUrl() != null) {
					%> <h3>Url</h3>
				</td>
				<td></td>
				<td><%=publChosen.getUrl()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getBooktitle() != null) {
					%> <h3>Booktitle</h3>
				</td>
				<td></td>
				<td><%=publChosen.getBooktitle()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getCrossref() != null) {
					%> <h3>Crossref</h3>
				</td>
				<td></td>
				<td><%=publChosen.getCrossref()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getCdrom() != null) {
					%> <h3>Cdrom</h3>
				</td>
				<td></td>
				<td><%=publChosen.getCdrom()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getCite() != null) {
					%> <h3>Cite</h3>
				</td>
				<td></td>
				<td><%=publChosen.getCite()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getPublisher() != null) {
					%> <h3>Publisher</h3>
				</td>
				<td></td>
				<td><%=publChosen.getPublisher()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getNote() != null) {
					%> <h3>Note</h3>
				</td>
				<td></td>
				<td><%=publChosen.getNote()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getIsbn() != null) {
					%> <h3>ISBN</h3>
				</td>
				<td></td>
				<td><%=publChosen.getIsbn()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getSeries() != null) {
					%> <h3>Series</h3>
				</td>
				<td></td>
				<td><%=publChosen.getSeries()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getSchool() != null) {
					%> <h3>School</h3>
				</td>
				<td></td>
				<td><%=publChosen.getSchool()%></td>
				<%
					}
				%>
			</tr>
			<tr>
				<td>
					<%
						if (publChosen.getChapter() != null) {
					%> <h3>Chapter</h3>
				</td>
				<td></td>
				<td><%=publChosen.getChapter()%></td>
				<%
					}
				%>
			</tr>
			
			
			
		</table>
		</br>
		<table>
			<td>
			<form action='control' method='POST'>
				<input type="hidden" name="action" value="addtocart">
				<input type="hidden" name="itemid" value=<%=publChosen.getItemId() %>>
				<button style="width: 80px; height: 35px; background: #4169E1; color: white">Add to Cart</button></td>
				
			</form>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><FORM ACTION='search.jsp' METHOD='POST'>
<!-- 				<INPUT TYPE='submit' VALUE='Search Again'> -->
				<button style="width: 80px; height: 35px; background: #4169E1; color: white">Search Again</button></td>
			</FORM>
			</table>
			</br>
			</br>
			</br>
	</center>

</body>
</html>