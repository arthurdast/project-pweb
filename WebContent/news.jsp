<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.iesp.banco.DAONews.*"%>
<%@page import="br.edu.iesp.entity.*"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Criação da lista de comentario de acordo com a news e setando na pagina o id da news -->
<% News noticia = (News) getServletContext().getAttribute("news");
   int id = noticia.getId();
   DAOComment daoComment = new DAOComment();
   ArrayList<Comment> listComments = daoComment.listarComments(noticia);
   pageContext.setAttribute("idNews", id);
   pageContext.setAttribute("listComments",listComments);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<!-- Mostra a noticia selecionada na lista de manchetas -->
Noticia&nbsp;&nbsp;&nbsp;<a href="manchetes.jsp">Volta as manchetes</a>
<br>
<br>
	${news.resumo}
<br>
	${news.noticia}
<br>
<br>
<br>
<c:forEach var="comentario" items="${listComments}" >
<!--Botao apra apagar comentario -->
	<form action="ServicoDAOComment" name="login" method="get">
	<input type="hidden" id="idComment" name="idComment" value="${comentario.id}">
	<input type="hidden" id="idNews" name="idNews" value="${idNews}">
	<input type="submit" value="Apagar comentario" class="btn">
</form>
<!-- msotra o comentario -->	
Nome :	${comentario.nome}
E-mail:	${comentario.email}
<br>
<br>
 Comentario: ${comentario.comentario}
<br>
<br>
	</c:forEach>
<br>
<br>
<br>
<!-- Formulario apra a criação da manchete -->
	<form action="ServicoDAOComment" name="InserirComment" method="post">
	Nome:<input type="text" id="nome" name="nome" required></br>
	Email:<input type="text" id="email" name="email" required></br>
	Comentario:<input type="text" id="comentario" name="comentario" required></br>
	<input type="hidden" id="idNews" name="idNews" value="${idNews}">
	<input type="submit" value="Inserir" class="btn">&nbsp;&nbsp;&nbsp;<input type="reset" value="Limpar" class="btn">
</form>

</body>
</html>