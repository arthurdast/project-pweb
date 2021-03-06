<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.iesp.banco.DAONews.*"%>
<%@page import="br.edu.iesp.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Cria��o da lista de comentario de acordo com a news e setando na pagina o id da news -->
<%
	News noticia = (News) getServletContext().getAttribute("news");
	int id = noticia.getId();
	DAOComment daoComment = new DAOComment();
	ArrayList<Comment> listComments = daoComment.listarComments(noticia);
	pageContext.setAttribute("idNews", id);
	pageContext.setAttribute("listComments", listComments);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="top.jsp"%>
<br>
<br>
<br>
<br>
	<div class="container">
		
		<div class="row">
	
			<div class="col-md-12">
			<p align="right">postado em ${news.data}</p>
				<h2>
					${news.resumo} 
				</h2>
				<p>${news.noticia}</p>					
			</div>
	
		</div>

		<br> <br>  <br>  <br>
		<br> <br>
		<c:forEach var="comentario" items="${listComments}">
			<!--Botao apra apagar comentario -->
			<c:if test="${not empty userlogado}">
				<form action="ServicoDAOComment" name="login" method="get">
					<input type="hidden" id="idComment" name="idComment"
						value="${comentario.id}"> <input type="hidden" id="idNews"
						name="idNews" value="${idNews}"> <input type="submit"
						value="Apagar comentario" class="btn">
			</c:if>
			</form>
			<!-- msotra o comentario -->	
Nome :	${comentario.nome}
E-mail:	${comentario.email}
<br>
Comentado em: ${comentario.data}
			<br>
 Comentario: ${comentario.comentario}
<br>
			<br>
		</c:forEach>
		<br> <br> <br>
		<!-- Formulario apra a cria��o da manchete -->
		<form action="ServicoDAOComment" name="InserirComment" method="post">
			
			<div class="form-group">
				<label for="nome">Nome</label> <input type="text"
				class="form-control" id="nome" name="nome"
				required placeholder="Nome">
			</div>
			
			<div class="form-group">
				<label for="email">Email</label> <input type="text"
				class="form-control" id="email" name="email"
				required placeholder="Email">
			</div>
			
			<div class="form-group">
				<label for="comentario">Comentario</label>
				<textarea name="comentario" class="form-control" required rows="4"
					cols="4" placeholder="Comentario"></textarea>
			</div>
						
			
			<input type="hidden" id="idNews" name="idNews"
				value="${idNews}"> <input type="submit" value="Inserir"
				class="btn">&nbsp;&nbsp;&nbsp;<input type="reset"
				value="Limpar" class="btn">
		</form>
	</div>
	
</body>
</html>