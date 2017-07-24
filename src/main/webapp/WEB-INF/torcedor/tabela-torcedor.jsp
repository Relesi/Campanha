<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<fmt:setLocale value="pt_BR"/>
<table class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 10%">#</td>
			<td style="width: 30%">Nome</td>
			<td style="width: 30%">E-mail</td>
			<td style="width: 10%">Data Nascimento</td>
			<td style="width: 10%">Time</td>
			<td style="width: 10%">Categoria</td>
			<td style="width:  5%">Editar</td>
			<td style="width:  5%">Remover</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${torcedor}" var="torcedor">
			<tr data-id="${torcedor.id}">
				<td>${torcedor.id}</td>
				<td>${torcedor.nome}</td>
				<td>
					<fmt:formatNumber value="${torcedor.data}" type="currency"/>
				</td>
				<td>${torcedor.categoria}</td>
				<td>
					<c:forEach items="${torcedor.cadastro}" var="cadastro">
						${cadastro.nome}
					</c:forEach>
				</td>
				<td>
					<button type="button" class="btn btn-warning btn-editar">
						<spring:message code="views.torcedor.tabela.colunas.editar"/>
					</button>
				</td>
				<td>
					<button type="button" class="btn btn-danger btn-deletar">
						<spring:message code="views.torcedor.tabela.colunas.remover"/>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="8">Torcedores Cadastrados: <span id="quantidade-torcedores">${torcedor.size()}</span></td>
		</tr>
		<tr>
			<td colspan="8">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-torcedor">Cadastrar Torcedor</button>
			</td>
		</tr>
	</tfoot>
</table>