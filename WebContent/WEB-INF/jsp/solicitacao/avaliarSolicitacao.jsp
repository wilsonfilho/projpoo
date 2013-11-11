<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="url" value="<%=request.getContextPath()%>" />

<layout:pagina titulo="Avaliar Solicitação">

	<jsp:attribute name="cabecalhoExtra">
	
		<script type="text/javascript">
		
			$(document).ready(function() {
				$("#avaliarSolicitacao").addClass('active');
				
				$("#dialogObservacao").dialog({
					autoOpen: false,
					modal: true,
					resizable: false,
					minHeight: 300,
					minWidth: 500,
					draggable: false
				});
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
			
        	function aprovar(id) {
				
				if (confirm("Aprovar a solicitação " + id + " ?")) {
					
					$.post("${url}/solicitacao/aprovar", { 'id': id }, function(resposta) {
						
						if (resposta == 'sucesso') {
							
							window.location.reload(true);
						}
					});
				}
			}
        	
        	function retornar(id) {
        		
        		$("#acaoId").val(id);
        		
        		$("#dialogObservacao").dialog('open');
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
								<button type="button" onclick="retornar(${acao.id});" class="btn btn-warning">Retornar</button>
								<button type="button" onclick="aprovar(${acao.id});" class="btn btn-success">Aprovar</button>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div id="dialogObservacao" title="Observação">
			<form action="${url}/solicitacao/retornar" method="post">
				<input type="hidden" id="acaoId" name="id" />
			
				<div class="input-group">
					<span class="input-group-addon">Observação:</span>
					<textarea style="height: 200px; resize: none" class="form-control" name="observacao"></textarea>
				</div>
				
				<br />
				
				<div class="btn-group pull-right">
					<button type="reset" class="btn btn-danger" onclick="$('#dialogObservacao').dialog('close');">Cancelar</button>
					<button type="submit" class="btn btn-warning">Confirmar Retorno</button>
				</div>
			</form>
		</div>
	
	</jsp:body>

</layout:pagina>