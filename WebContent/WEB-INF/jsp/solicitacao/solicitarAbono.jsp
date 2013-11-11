<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib tagdir="/WEB-INF/tags/layout" prefix="layout" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="url" value="<%=request.getContextPath()%>" />

<layout:pagina titulo="Solicitar Abono">

	<jsp:attribute name="cabecalhoExtra">
	
		<script type="text/javascript">
		
			$(document).ready(function() {
				$("#solicitarAbono").addClass('active');
			});
			
			$('#formulario').submit(function() {
				
				$("#errmsg2").html("Solicitação cadastrada com Sucesso!");
				$("#errmsg2").show();
				
			});
		
		</script>
		
	</jsp:attribute>

	<jsp:body>
	
	<style type="text/css">
	
	#errmsg2 {
	color: red;
	display: none;
             }
	
	
	
    </style>
	
		<div class="page-header">
			<h3>Solicitação de Abono</h3>
		</div>
		
		<form class="formulario" action="${url}/solicitacao/salvar" method="post">
			<div class="input-group">
				<span class="input-group-addon">Empregado:</span>
				<select class="form-control" name="empregado.id">
					<c:forEach var="empregado" items="${empregadoList}">
						<option value="${empregado.id}">${empregado.nome}</option>
					</c:forEach>	
				</select>
			</div>
			
			<br />
			
			<div class="input-group">
				<span class="input-group-addon">Data Início:</span>
				<input type="text" class="form-control" name="dataInicio">
			</div>
			
			<br />
			
			<div class="input-group">
				<span class="input-group-addon">Data Fim:</span>
				<input type="text" class="form-control" name="dataFim">
			</div>
			
			<br />
			
			<div class="input-group">
				<span class="input-group-addon">Motivo:</span>
				<textarea class="form-control" name="acao.descricao"></textarea>
			</div>
			
			<br />
			
			<div class="btn-group pull-right">
				<button type="reset" class="btn btn-danger">Cancelar</button>
				<button type="submit" class="btn btn-success">Enviar</button>
			</div>
			
			 <span id="errmsg2"></span>
			
		</form>	
	
	</jsp:body>

</layout:pagina>