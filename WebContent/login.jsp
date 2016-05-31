<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticiario</title>
</head>
<body>
<%@ include file="top.jsp"%>
<br>
<br>
<div class="container">

<br>
<br>


<p align="right"> <a href="manchetes.jsp" class="btn btn-info">Manchetes</a> </p>

<c:if test="${aviso}">
		
	<div class="alert alert-danger" role="alert">Dados inválidos!</div>
	
</c:if>

<!-- Formulario que envia o login e senha para servinews via post-->
<form action="ServicoLogin" name="login" method="post">

	<div class="form-group">
		<label for="login">Login</label> <input type="text"
		class="form-control" id="login" name="login"
		required placeholder="Login">
	</div>
	
	
	<div class="form-group">
		<label for="senha">Senha</label> <input type="text"
		class="form-control" id="senha" name="senha"
		required placeholder="Senha">
	</div>
	<div class="text-center">
		<input type="submit" value="Logar" class="btn">
	</div>
	
</form>
<br>
<div class="text-center"> 
	<form action="ServicoCadastroLogin" name="botaocadastro" method="get">
		<input type="submit" value="Cadastro" class="btn btn-success">
	</form>
</div>

	



<c:if test="${cadastro}">
	<!-- Formulario para cadastrar usuario-->
	<form action="ServicoCadastroLogin" name="formcadastro" method="post">
	
	<div class="form-group">
		<label for="nome">Nome</label> <input type="text"
		class="form-control" id="nome" name="nomes"
		required placeholder="Nome">
	</div>
	
	<div class="form-group">
		<label for="login">Login</label> <input type="text"
		class="form-control" id="login" name="login"
		required placeholder="Login">
	</div>
	
	
	<div class="form-group">
		<label for="senha">Senha</label> <input type="text"
		class="form-control" id="senha" name="senha"
		required placeholder="Senha">
	</div>
	
		<input type="submit" value="Cadastar Login" class="btn">&nbsp;&nbsp;&nbsp;  <input type="reset" value="Limpar" class="btn">
	</form>
</c:if>

<c:if test="${cadastrado}">
<h3>Login cadastrado.</h3>
</c:if>
</div>

</body>
</html>