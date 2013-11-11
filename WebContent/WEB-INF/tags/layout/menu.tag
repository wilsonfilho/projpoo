<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Tag Menu" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="url" value="<%=request.getContextPath()%>" />

<nav class="navbar navbar-inverse">
	<ul class="nav navbar-nav">
	    <li id="solicitarAbono"><a href="${url}">Solicitar Abono</a></li>
	    <li id="autorizarSolicitacao"><a href="${url}/autorizarsolicitacao">Autorizar Solicitação</a></li>
	    <li id="avaliarSolicitacao"><a href="${url}/avaliarsolicitacao">Avaliar Solicitação</a></li>
	</ul>
</nav>