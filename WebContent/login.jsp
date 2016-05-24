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
<p align="right"> <a href="manchetes.jsp"><button>Manchetes</button></a> </p>
<!-- Formulario que envia o login e senha para servinews via post-->
<form action="ServicoLogin" name="login" method="post">
	login:<input type="text" id="login" name="login" required></br>
	senha:<input type="text" id="senha" name="senha" required></br>
	<input type="submit" value="Logar" class="btn">&nbsp;&nbsp;&nbsp;  <input type="reset" value="Limpar" class="btn">
</form>

<c:if test="${aviso}">
<h3>Login errado.</h3>
<h4>login ou senha errado</h4>

</c:if>
<br>
<br>
<br>
<br>

<form action="ServicoCadastroLogin" name="botaocadastro" method="get">
	<input type="submit" value="Cadastro" class="btn">
</form>

<c:if test="${cadastro}">
<!-- Formulario para cadastrar usuario-->
<form action="ServicoCadastroLogin" name="formcadastro" method="post">
    Nome:<input type="text" id="nome" name="nome" required></br>
	Login:<input type="text" id="login" name="login" required></br>
	Senha:<input type="text" id="senha" name="senha" required></br>
	<input type="submit" value="Cadastar Login" class="btn">&nbsp;&nbsp;&nbsp;  <input type="reset" value="Limpar" class="btn">
</form>
</c:if>

<c:if test="${cadastrado}">
<h3>Login cadastrado.</h3>
</c:if>


</body>
</html>