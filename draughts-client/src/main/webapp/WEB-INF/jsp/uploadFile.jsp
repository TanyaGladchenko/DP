<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../layout/taglib.jsp"%>
<div>
	<form method="POST" enctype="multipart/form-data" action="/processUploadFile">
		<fieldset>
			<input name="file" type="file" />
			<input type="button" value="Choose File"/>
		</fieldset>
	</form>
</div>

