<%@page import="br.edu.iesp.banco.Conexao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.iesp.banco.DAONews.*"%>
<%@page import="br.edu.iesp.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% DAONews daoNews = new DAONews();
ArrayList<News> listnews = daoNews.listarNews();
pageContext.setAttribute("listnews", listnews);  
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
Manchetes                                                                 <a href="login.jsp">Login</a>                        
<br>
<br>
<!-- Lista as manchetes -->
	<c:forEach var="news" items="${listnews}" >
<!--Botao apra apagar a noticia -->
	<form action="ServicoDAOManchetes" name="login" method="get">
	<input type="hidden" id="news" name="news" value="${news.id}"></br>
	<input type="submit" value="Apagar noticia" class="btn">
</form>
<!-- msotra manchete  e o resumo -->	
	<a href="ServicoManchetes?id=${news.id}">${news.manchete}</a>
<br>
	${news.resumo}
<br>
<br>
<br>
	</c:forEach>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>	
<!-- Formulario apra a criação da manchete -->
	<form action="ServicoDAOManchetes" name="InserirNoticias" method="post">
	Manchetes:<input type="text" id="manchete" name="manchete" required></br>
	Resumo:<input type="text" id="resumo" name="resumo" required></br>
	Noticias:<input type="text" id="noticia" name="noticia" required></br>
	<input type="submit" value="Inserir" class="btn">&nbsp;&nbsp;&nbsp;<input type="reset" value="Limpar" class="btn">
</form>

</body>
</html>