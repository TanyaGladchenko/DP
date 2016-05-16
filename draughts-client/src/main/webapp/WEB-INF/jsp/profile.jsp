<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp"%>
<div>
	<form method="GET" modelAttribute="user">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="user_first_name">First Name:</label></th>
					<td>"${user.firstName}"</td>
				</tr>
				<tr>
					<th><label for="user_middle_name">Middle Name:</th>
					<td>"${user.middleName}"</td>
				</tr>
				<tr>
					<th><label for="user_last_name">Last Name:</label></th>
					<td>"${user.lastName}"</td>
				</tr>
				<tr>
					<th><label for="user_birthday">Birthday:</th>
					<td>"${user.birthday}"</td>
				</tr>
				<tr>
					<th><label for="user_email">Email:</label></th>
					<td>"${user.email}"</td>
					<errors path="email" />
				</tr>
				<tr>
					<th><label for="user_login">Login:</th>
					<td>"${user.login}"</td>
				</tr>

			</table>
		</fieldset>
	</form>
</div>