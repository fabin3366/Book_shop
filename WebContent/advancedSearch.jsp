<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Advanced Search</title>
	<%@ include  file="index.html"%> 
</head>
<body>
	<center>
		<form action='control' method='POST'>
		
		<table>
			</br>			
			</br>
			<h2>Advanced Search</h2>
			</br>
			<tr>
			<td></center><select name="publType"><option value="article" selected="selected">Article</option>
							<option value="inproceedings">Inproceedings</option>
							<option value="proceedings">Proceedings</option>
							<option value="book">Book</option>
							<option value="incollection">Incollection</option>
							<option value="phdthesis">Phdthesis</option>
							<option value="mastersthesis">Mastersthesis</option>
							<option value="www">www</option>
				</select></td>
				<td>Title: <input type="text" name="advtitle" style="width: 150px; height: 25px"></td>
				<td>Author: <input type="text" name="advauthor" style="width: 150px; height: 25px"></td>
			</tr>
			</br>
			</br>
			<tr>
				<td></td>
				<td>Year: <input type="text" name="advyear" style="width: 150px; height: 25px"></td>
				<td>ISBN#:   <input type="text" name="advisbn" style="width: 150px; height: 25px"></td>
			</tr>
			
			
		</table>
		</br>
		</br>
		</br>
		<tr><input type="hidden" name="action" value="addvancedsearch"></tr>
		<tr><button style="width: 80px; height: 40px; background: #4169E1; color: white">Search</button></tr>
		</form>
	</center>
</body>
</html>