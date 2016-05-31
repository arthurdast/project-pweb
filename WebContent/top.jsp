<%@page import="br.edu.iesp.banco.Conexao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.iesp.banco.DAONews.*"%>
<%@page import="br.edu.iesp.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="assets/css/bootstrap.min	.css" />"
	rel="stylesheet">

<nav class="navbar navbar-inverse navbar-fixed-top">
<div class="container">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">Manchetes PWEB, Olá
			${userlogado.nome} </a>
	</div>
	<div id="navbar" class="navbar-collapse collapse">
		<c:if test="${empty userlogado}">

			<form class="navbar-form navbar-right"
				action='<c:url value="login.jsp"/>' name="botaologat">
				<input type="submit" value="Logar"
					class="btn btn-info">
			</form>

		</c:if>
		<c:if test="${not empty userlogado}">

			<form class="navbar-form navbar-right"
				action='<c:url value="login.jsp"/>' name="botaocadastro">
				<input type="submit" value="Cadastrar Adiministrador"
					class="btn btn-info">
			</form>
			<form class="navbar-form navbar-right" action="ServicoLogin"
				name="botaodeslogar" method="get">
				<input type="submit" value="Deslogar" class="btn btn-info">
			</form>

		</c:if>
	</div>
	<!--/.navbar-collapse -->
</div>
</nav>



