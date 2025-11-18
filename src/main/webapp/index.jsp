<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
		<html lang="pt-BR"> 
		<head>
	<%@ include file="head.jsp" %>			
    </head>
<body>
	<%@ include file="navbar.jsp" %>
	            <section>
                <div class="container-grid">
                    <div class="row align-items-center">
                        <div class="col-lg-6 col-md-6 col-12 text-center m-0 p-0">
						<img src="${pageContext.request.contextPath}/static/gallery/1af48695a71e068d9f880bbde3f2f385.jpg" class="img-fluid" alt="Imagem ilustrativa de uma carteira de criptomoedas" />                        </div>
                        <div class="col-lg-6 col-md-6 col-12 text-center text-md-start intro">
                            <h2 class="title-default-style">Minha Crypto Wallet</h2> 
                            <p>Gerencie suas criptomoedas com total segurança e facilidade.</p> 
                            <a href="#services">
                                <button type="button" class="btn btn-secondary btn-lg">Ver Funcionalidades</button>
                            </a>
                        </div>
                    </div>
                </div>
            </section>

    <%@ include file="mainContent.jsp" %>
  	<%@ include file="footer.jsp" %>
  	<%@ include file="footerconf.jsp" %>
</html>