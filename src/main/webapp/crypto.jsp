<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("usuarioLogado") == null) {
        response.sendRedirect("loginrequired.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="pt-BR"> 
<head>
    <%@ include file="headcrypto.jsp" %>
</head>
<body>

      <%@ include file="sidebar.jsp" %>
       <!--<main> abre dentro da jsp-->
      <%@ include file="cryptotable.jsp" %>
       </main>
</div>

      <%@ include file="footerconfcrypto.jsp" %>
</body>
</html>