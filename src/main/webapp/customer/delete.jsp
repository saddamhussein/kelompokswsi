<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">
		<table>
			<tr>
				<td>ID Customer Dihapus :</td>
				<td><input type="text" name="customerId"><br></td>
			</tr>
			<tr>
				<td><input type="hidden" name="action" value="delete" /></td>
				<td><button type="submit">Hapus</button></td>
			</tr>
		</table>
		
		
	</form>
</body>
</html>