<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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


</body>
</html>