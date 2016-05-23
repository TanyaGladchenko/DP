<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layout/taglib.jsp"%>
<spring:message code="user.label.firstName" var="firstname"/>
<spring:message code="user.label.middleName" var="middlename"/>
<spring:message code="user.label.lastName" var="lastname"/>
<spring:message code="user.label.birthday" var="birthday"/>
<spring:message code="user.label.email" var="email"/>
<spring:message code="user.label.login" var="login"/>
<spring:message code="user.label.password" var="password"/>
<spring:message code="user.label.registration" var="title"/>
<spring:message code="user.button.signUp" var="reg"/>

<div>
	<form method="POST" modelAttribute="user">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="user_first_name">${firstname}</label></th>
					<td><input path="firstName" size="20" id="user_first_name" /></td>
					<errors path="firstName" />
				</tr>
				<tr>
					<th><label for="user_middle_name">${middlename}</label></th>
					<td><input path="middleName" size="30" id="user_middle_name" /></td>
				</tr>
				<tr>
					<th><label for="user_last_name">${lastname}</label></th>
					<td><input path="firstName" size="30" id="user_last_name" /></td>
					<errors path="lastName" />
				</tr>
				<tr>
					<th><label for="user_birthday">${birthday}</label></th>
					<fmt:formatDate value="$user.birthday}" var "dateString" pattern="dd/MM/yyyy"/>
					<td><input path="birthday" id="user_birthday" value="${dateString}"/></td>
					<errors path="birthday" />
				</tr>
				<tr>
					<th><label for="user_email">${email}</label></th>
					<td><input path="email" size="30" id="user_email" /></td>
					<errors path="email" />
				</tr>
				<tr>
					<th><label for="user_login">${login}</label></th>
					<td><input path="login" size="15" id="user_login" /></td>
					<errors path="login" />
				</tr>
				<tr>
					<th><label for="user_password">${password}</label></th>
					<td><password path="password" size="15" id="user_password" /></td>
					<errors path="password" />
				</tr>
				<th />
				<td><input type="button" name="${reg}"/></td>
				<tr>
				</tr>
			</table>
		</fieldset>
	</form>
</div>