<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="url" value="<%=request.getContextPath()%>" />

<layout:pagina titulo="Autorizar Solicitação">

	<jsp:attribute name="cabecalhoExtra">
	
		<script type="text/javascript">
		
			$(document).ready(function() {
				$("#autorizarSolicitacao").addClass('active');
			});
			
			function recusar(id) {
				
				if (confirm("Recusar a solicitação " + id + " ?")) {
					
					$.post("${url}/solicitacao/recusar", { 'id': id }, function(resposta) {
						
						if (resposta == 'sucesso') {
							
							window.location.reload(true);
						}
					});
				}
			}
		
		</script>
	
	</jsp:attribute>
	
	<jsp:body>
	
		<div class="page-header">
			<h3>Autorizar Solicitação</h3>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>#</th>
					<th>Empregado</th>
					<th>Data Início</th>
					<th>Data Fim</th>
					<th>Motivo</th>
					<th>Opções</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="acao" items="${acoesList}">
					<tr>
						<td>${acao.id}</td>
						<td>${acao.empregado.nome}</td>
						<td><fmt:formatDate value="${acao.dataInicio}" pattern="dd-MM-yyyy HH:mm:ss" /></td>
						<td><fmt:formatDate value="${acao.dataFim}" pattern="dd-MM-yyyy HH:mm:ss" /></td>
						<td>${acao.descricao}</td>
						<td>
							<div class="btn-group">
								<button type="button" onclick="recusar(${acao.id});" class="btn btn-danger">Recusar</button>
								<button type="button" class="btn btn-success">Aprovar</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	
	</jsp:body>

</layout:pagina>