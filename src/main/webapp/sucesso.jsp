<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/static/css/styleload.css" media="all">
    <%@ include file="head.jsp" %>
    <meta http-equiv="refresh" content="3;url=crypto.jsp">
    <title>Processando...</title>
</head>
<body>

    <div class="mensagem">
        ✅ Operação realizada com sucesso!<br>
        Você será redirecionado em instantes...
    </div>

    <div class="spinner-border text-success" role="status">
        <span class="visually-hidden">Carregando...</span>
    </div>

    <%@ include file="footerconf.jsp" %>
</body>
</html>