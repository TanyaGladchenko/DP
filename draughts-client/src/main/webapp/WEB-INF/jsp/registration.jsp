<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp"%>
<div>
	<form method="POST" modelAttribute="user">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="user_first_name">First Name:</label></th>
					<td><input path="firstName" size="20" id="user_first_name" /></td>
					<errors path="firstName" />
				</tr>
				<tr>
					<th><label for="user_middle_name">Middle Name:</th>
					<td><input path="middleName" size="30" id="user_middle_name" /></td>
				</tr>
				<tr>
					<th><label for="user_last_name">Last Name:</label></th>
					<td><input path="firstName" size="30" id="user_last_name" /></td>
					<errors path="lastName" />
				</tr>
				<tr>
					<th><label for="user_birthday">Birthday:</th>
					<td><date path="birthday" min="01-01-1930" id="user_birthday" /></td>
					<errors path="birthday" />
				</tr>
				<tr>
					<th><label for="user_email">Email:</label></th>
					<td><input path="email" size="30" id="user_email" /></td>
					<errors path="email" />
				</tr>
				<tr>
					<th><label for="user_login">Login:</th>
					<td><input path="login" size="15" id="user_login" /></td>
					<errors path="login" />
				</tr>
				<tr>
					<th><label for="user_password">Login:</th>
					<td><password path="password" size="15" id="user_password" /></td>
					<errors path="password" />
				</tr>
				<th />
				<td><input type="button" name="reg" value="Registration" /></td>
				<tr>
				</tr>
			</table>
		</fieldset>
	</form>
</div>