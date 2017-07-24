<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<table
	class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width: 10%">Id</td>
			<td style="width: 30%">Nome</td>
			<td style="width: 20%">Data Vigência</td>
			<td style="width: 20%">Categoria</td>
			<td style="width: 10%">Editar</td>
			<td style="width: 10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cadastro}" var="ingrediente">
			<tr data-id="${cadastro.id}">
				<td>${cadastro.id}</td>
				<td>${cadastro.nome}</td>
				<td>${cadastro.dataVigencia}</td>
				<td>${cadastro.categoria}</td>
				<td><button type="button" class="btn btn-warning btn-editar">Editar</button></td>
				<td><button type="button" class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Campanhas Cadastrados: <span id="quantidade-cadastrados">${cadastrados.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-cadastro">Cadastrar Campanhas</button>
			</td>
		</tr>
	</tfoot>
</table>