<%@ page import="java.util.List"%>
<%@ page import="id.co.skyforce.basicjsf.domain.Customer"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="id.co.skyforce.basicjsf.HibernateUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%-- <%@ page import="java.io.IOException"%> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Daftar Customer</title>
</head>
<body>
	<%
	List<Customer> listCustomer = (List<Customer>) request
				.getAttribute("listCustomer");
	SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy");
	
		if (listCustomer == null) {
			out.println("Tidak Ada Data Customer Untuk Ditampilkan");
		} else {
	%>
	<h2>Customer Management</h2>
		<table border="1">

			<%
				for (Customer cust : listCustomer) {
			%>
			<tr>
				<td>
					<%
						out.println(cust.getId());
					%>
				</td>
				<td>
					<%
						out.println(cust.getFirstName()+" "+cust.getLastName());
					%>
				</td>
				<td>
					<%
						out.println(cust.getEmail());
					%>
				</td>
				<td>
					<%
					
					
					//try {
						String birth_date = formatter.format(cust.getBirthDate());
					/* } catch (ParseException e) {
						e.printStackTrace();
					} */
					
					
						out.println(birth_date);
					%>
				</td>


				<td>
					<form action="update.jsp" method="post">
						<input type="hidden" name="customerId" value="<%=cust.getId()%>">
						<input type="hidden" name="first_name"
							value="<%=cust.getFirstName()%>"> <input type="hidden"
							name="last_name" value="<%=cust.getLastName()%>"> <input
							type="hidden" name="email" value="<%=cust.getEmail()%>">
						<input type="hidden" name="birth_date"
							value="<%=cust.getBirthDate()%>"> <input type="hidden"
							name="action" value="update" />
							<a href="" onclick="document.forms[0].submit();return false;"> Update </a>
<!-- 						<button type="submit" value="Update">Update</button> -->
					</form>
				</td>
				<td>
					<form action="" method="post">
						<input type="hidden" name="customerId" value="<%=cust.getId()%>">
						<input type="hidden" name="action" value="delete" />
<!-- 						//<button type="submit">Delete</button> -->
						<a href="" onclick="document.forms[1].submit();return false;">
						 Delete </a>
					</form>
				</td>
			</tr>

			<%
				}
			%>

		</table>
		<br>
	<a href="form.jsp">New Customer</a>
	<%
		}
	%>

</body>
</html>