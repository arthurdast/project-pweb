<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noticiario</title>
</head>
<body>
<!-- Formulario que envia o login e senha para servinews via post-->
<form action="ServicoLogin" name="login" method="post">
	login:<input type="text" id="name" name="name" required></br>
	senha:<input type="text" id="name" name="name" required></br>
	<input type="submit" value="Cadastrar" class="btn">&nbsp;&nbsp;&nbsp;  <input type="reset" value="Limpar" class="btn">
</form>

</body>
</html>