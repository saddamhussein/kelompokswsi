<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<%
		String customerId = request.getParameter("customerId");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String birth_date = request.getParameter("birth_date");
	%>

	<form action="save" method="post">
		<table>
			<tr>
				<td>Masukkan ID yang diubah :</td>
				<td><input type="text" name="customerId"
					value="<%=(customerId)%>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Nama Depan :</td>
				<td><input type="text" name="first_name"
					value="<%=(first_name)%>"></td>
			</tr>
			<tr>
				<td>Nama Belakang :</td>
				<td><input type="text" name="last_name"
					value="<%=(last_name)%>"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Tempat tanggal Lahir:</td>
				<td><input type="text" name="birth_date" value="<%=(birth_date)%>"></td>
			</tr>
			<tr>
				<td>Nomor HP :</td>
				<td><input type="text" name="mobile_phone"></td>
			</tr>
			<tr>
				<td>Nomor Telepon Rumah :</td>
				<td><input type="text" name="home_phone"></td>
			</tr>
			<tr>
				<td>email :</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Kota Tempat Tinggal :</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>Jalan Tmpt Tinggal :</td>
				<td><input type="text" name="street"></td>
			</tr>
			<tr>
				<td>Kode Pos :</td>
				<td><input type="text" name="postal_code"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Tambahkan</button></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="update" />
	</form>
</body>
</html>