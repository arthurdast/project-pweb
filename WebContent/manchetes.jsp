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

		<br> <br> <br> <br>
		<form action="ServicoManchetes" name="botaopesquisa" method="post">
			<input type="text" id="pesquisa" name="pesquisa" required> <input
				type="submit" value="Pesquisa" class="btn">
		</form>
		<c:if test="${sempesquisa}">
			<h4>Noticia não encontrada</h4>
		</c:if>
		<div class="row">
			<!-- Lista as manchetes -->
			<c:forEach var="news" items="${listnews}">

				<div class="col-md-4">
					<h2>
						<a href="ServicoManchetes?id=${news.id}">${news.manchete}</a>
					</h2>
					Categoria da noticia:
					<c:choose>
						<c:when test="${news.categoria eq 'Arte'}">
							<img alt="" src="Imagem/arte.png">
						</c:when>
						<c:when test="${news.categoria eq  'Acidente'}">
							<img alt="" src="Imagem/acidente.png">
						</c:when>
						<c:when test="${news.categoria eq 'Ciência'}">
							<img alt="" src="Imagem/ciencia.png">
						</c:when>
						<c:when test="${news.categoria eq 'Clima'}">
							<img alt="" src="Imagem/clima.png">
						</c:when>
						<c:when test="${news.categoria eq 'Cultura'}">
							<img alt="" src="Imagem/cultura.png">
						</c:when>
						<c:when test="${news.categoria eq 'Desastre'}">
							<img alt="" src="Imagem/desastre.png">
						</c:when>
						<c:when test="${news.categoria eq 'Entretenimento'}">
							<img alt="" src="Imagem/entretenimento.png">
						</c:when>
						<c:when test="${news.categoria eq 'Esporte'}">
							<img alt="" src="Imagem/esporte.png">
						</c:when>
						<c:when test="${news.categoria eq 'Negócio'}">
							<img alt="" src="Imagem/negocio.png">
						</c:when>
						<c:when test="${news.categoria eq 'Policial'}">
							<img alt="" src="Imagem/policial.png">
						</c:when>
						<c:when test="${news.categoria eq 'Religião'}">
							<img alt="" src="Imagem/religiao.png">
						</c:when>
						<c:when test="${news.categoria eq 'Saúde'}">
							<img alt="" src="Imagem/saude.png">
						</c:when>
						<c:when test="${news.categoria eq 'Tecnologia'}">
							<img alt="" src="Imagem/tecnologia.png">
						</c:when>
						<c:otherwise>
				Sem categoria
			</c:otherwise>
					</c:choose>
					${news.categoria}
					<p>postado em ${news.data}</p>
					<br>
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
		<br>
		<br>
		<c:if test="${not empty userlogado}">

			<form action="ServicoDAOManchetes" name="InserirNoticias"
				method="post">
				<div class="form-group">
					<label for="exampleInputEmail1">Manchete</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="manchete"
						required placeholder="Manchete">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Resumo</label> <input
						type="text" class="form-control" id="resumo" name="resumo"
						required placeholder="Resumo">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Noticias</label>
					<textarea name="noticia" class="form-control" required rows=""
						cols="" placeholder="Notícia"></textarea>
				</div>

				<b>Categoria</b><br> <select name="categoria">
					<option value="Arte">Arte</option>
					<option value="Acidente">Acidente</option>
					<option value="Cultura">Cultura</option>
					<option value="Ciência">Ciência</option>
					<option value="Clima">Clima</option>
					<option value="Desastre">Desastre</option>
					<option value="Entretenimento">Entretenimento</option>
					<option value="Esporte">Esporte</option>
					<option value="Negócio">Negócio</option>
					<option value="Policial">Policial</option>
					<option value="Religião">Religião</option>
					<option value="Saude">Saúde</option>
					<option value="Tecnologia">Tecnologia</option>
				</select> <br>
				<br> <input type="submit" value="Inserir"
					class="btn btn-success">&nbsp;&nbsp;&nbsp;<input
					type="reset" value="Limpar" class="btn">
			</form>

		</c:if>

	</div>
</body>
</html>