<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Layout da Pagina" %>

<%@ attribute name="titulo" required="true" description="Titulo da Pagina" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="url" value="<%=request.getContextPath()%>" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ProjetoPOO | ${titulo}</title>
		
		<link rel="stylesheet" href="${url}/css/bootstrap.css" type="text/css" />
	</head>
	
	<body>
	
		<div class="container">
			<jsp:doBody />
		</div>
	
	</body>
</html>