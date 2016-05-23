<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp"%>
<spring:message code="user.label.firstName" var="firstname"/>
<spring:message code="user.label.middleName" var="middlename"/>
<spring:message code="user.label.lastName" var="lastname"/>
<spring:message code="user.label.birthday" var="birthday"/>
<spring:message code="user.label.email" var="email"/>
<spring:message code="user.label.login" var="login"/>

<div>
	<form method="GET" modelAttribute="user">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="user_first_name">${firstname}</label></th>
					<td>"${user.firstName}"</td>
				</tr>
				<tr>
					<th><label for="user_middle_name">${middlename}</label></th>
					<td>"${user.middleName}"</td>
				</tr>
				<tr>
					<th><label for="user_last_name">${lastname}</label></th>
					<td>"${user.lastName}"</td>
				</tr>
				<tr>
					<th><label for="user_birthday">${birthday}</label></th>
					<td>"${user.birthday}"</td>
				</tr>
				<tr>
					<th><label for="user_email">${email}</label></th>
					<td>"${user.email}"</td>
					<errors path="email" />
				</tr>
				<tr>
					<th><label for="user_login">${login}</label></th>
					<td>"${user.login}"</td>
				</tr>

			</table>
		</fieldset>
	</form>
</div>