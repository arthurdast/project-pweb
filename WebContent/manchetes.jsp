<%@page import="sun.print.resources.serviceui_zh_CN"%>
<%@page import="br.edu.iesp.banco.Conexao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.iesp.banco.DAONews.*"%>
<%@page import="br.edu.iesp.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	DAONews daoNews = new DAONews();
	ArrayList<News> listnews = daoNews.listarNews();
	pageContext.setAttribute("listnews", listnews);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menchetes</title>
</head>

<body>

	<%@ include file="top.jsp"%>

	<div class="container">

		<!-- Lista as manchetes -->
		<form action="ServicoManchetes" name="botaopesquisa" method="post">
			<input type="text" id="pesquisa" name="pesquisa" required> <input
				type="submit" value="Pesquisa" class="btn">
		</form>
		<c:if test="${sempesquisa}">
			<h4>Noticia não encontrada</h4>
		</c:if>
		<div class="row">
			<c:forEach var="news" items="${listnews}">

				<div class="col-md-4">
					<h2>
						<a href="ServicoManchetes?id=${news.id}">${news.manchete}</a>
					</h2>
					<p>${news.resumo}</p>
					<p>						

						<c:if test="${not empty userlogado}">
							<form action="ServicoDAOManchetes" name="login" method="get">
								<input type="hidden" id="news" name="news" value="${news.id}">
								<input type="submit" value="Apagar noticia"
									class="btn btn-danger">
							</form>
						</c:if>
					</p>
				</div>

			</c:forEach>

		</div>
	
	<!-- Formulario apra a criação da manchete -->
	<c:if test="${not empty userlogado}">
		
		<form action="ServicoDAOManchetes" name="InserirNoticias" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Manchete</label>
		    <input type="text" class="form-control" id="exampleInputEmail1" name="manchete" required placeholder="Manchete">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Resumo</label>
		    <input type="text" class="form-control" id="resumo" name="resumo" required>
		  </div>		  
		  <div class="form-group">
		    <label for="exampleInputPassword1">Noticias</label>
		    <textarea name="noticia" class="form-control" required rows="" cols=""></textarea>
		  </div>
		  
		  <input type="submit" value="Inserir" class="btn btn-success">&nbsp;&nbsp;&nbsp;<input
				type="reset" value="Limpar" class="btn">
		</form>

	</c:if>
	
	</div>
</body>
</html>