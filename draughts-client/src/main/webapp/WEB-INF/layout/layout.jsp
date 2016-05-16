<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="taglib.jsp"%>
<html>
<head>
<title> title fghjhgfghjk
<%-- <spring:message code="header.message" /> --%>
</title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script> -->
<%-- <link href="<spring:url value="/resources/css/style.css"/>" --%>
<!-- 	rel="stylesheet" type="text/css"> -->
<!-- <script type="text/javascript" -->
<%-- 	src="<c:url value="/resources/js/dropdowns-enhancement.js" />"></script> --%>
</head>
<body>
	<div id="divider">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="body">
		<tiles:insertAttribute name="navbar" />
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>
