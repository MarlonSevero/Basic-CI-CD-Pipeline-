<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pt-BR">
<head>
<%
    if (session.getAttribute("usuarioLogado") != null) {
        response.sendRedirect("crypto.jsp");
        return;
    }
%>
    <%@ include file="head.jsp"%>

</head>
<body>
<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">
        <div class="px-5 ms-xl-4">
          <i class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4" style="color: #709085;"></i>
          <span class="h1 fw-bold mb-0">My Crypto Wallet</span>
        </div>
        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
          <form style="width: 23rem;" action="login" method="post">
            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>
            <div data-mdb-input-init class="form-outline mb-4">
              <input type="email" id="email" name="email" class="form-control form-control-lg" />
              <label class="form-label" for="email">Email address</label>
            </div>
            <div data-mdb-input-init class="form-outline mb-4">
              <input type="password" id="passwd" name="passwd" class="form-control form-control-lg" />
              <label class="form-label" for="passwd">Senha</label>
            </div>
            <div class="pt-1 mb-4">
              <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-info btn-lg btn-block" type="button">Login</button>
            </div>
            <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Esqueceu a senha?</a></p>
            <p>Nao tem uma conta? <a href="cadastro.jsp" class="link-info">Registrar aqui</a></p>
            <p><a href="index.jsp" class="link-info">Inicio</a></p>
          </form>
        </div>
      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
    </div>
      </section>
    </body>
</html>