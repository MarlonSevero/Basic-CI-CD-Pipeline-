<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <%@ include file="head.jsp"%>
</head>
<body>
    <%@ include file="navbar.jsp"%>

    <div class="full-height-10vmin">
        <div id="formCarousel" class="carousel slide" data-bs-interval="false">
        <form action="cadastroServlet" method="post" onsubmit="validarFormulario">
            <div class="carousel-inner">
                <!-- Tela 1 -->
                <div class="carousel-item active">
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center">
                            <div class="box p-4">
                                <h2 class="display-6">Email Pessoal</h2>
                                <p>meuemail@email.com.br</p>

                                <h2 class="display-6">Data de Nascimento Válida</h2>
                                <p>Informe as informações reais de pessoa física.</p>

                                <h2 class="display-6">Renda Exata</h2>
                                <p>Dê a informação correta para melhor análise.</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box p-4">
                                <label for="name_user" class="form-label">Nome Completo</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="name_user" name="name_user" placeholder="Seu nome">

                                <label for="dt_nascimento" class="form-label">Data de Nascimento</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="dt_nascimento" name="dt_nascimento">

                                <label for="renda" class="form-label">Renda Mensal</label>
                                <input type="number" class="form-control form-control-lg" id="renda" name="renda" placeholder="Sua renda">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box p-4">
                                <label for="email" class="form-label">Email</label>
                                <input type="mail" class="form-control form-control-lg mb-3" id="email" name="email" placeholder="Seu Email">

                                <label for="passwd" class="form-label">Senha</label>
                                <input type="password" class="form-control form-control-lg" id="passwd" name="passwd" placeholder="Sua Senha">

                                <label for="conf_passwd" class="form-label">Confirme sua senha</label>
                                <input type="password" class="form-control form-control-lg mb-4" id="conf_passwd" name="conf_passwd" placeholder="Ex: Suasenha123x">
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-end mt-3 me-4">
                        <button class="btn btn-lg btn-primary" data-bs-target="#formCarousel" data-bs-slide="next">Próximo</button>
                    </div>
                </div>

                <!-- Tela 2 -->
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-4 d-flex align-items-center">
                            <div class="box p-4">
                                <h2 class="display-6">Endereço</h2>
                                <p>Informe os dados reais para garantir a veracidade do cadastro.</p>

                                <h2 class="display-6">Localização Correta</h2>
                                <p>Certifique-se de que as informações estão atualizadas.</p>

                                <h2 class="display-6">Complemento</h2>
                                <p>Se houver bloco, apartamento ou outra informação relevante.</p>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box p-4">
                                <label for="cidade" class="form-label">Cidade</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="cidade" name="cidade" placeholder="Ex: São Paulo">

                                <label for="bairro" class="form-label">Bairro</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="bairro" name="bairro" placeholder="Ex: Centro">

                                <label for="rua" class="form-label">Rua</label>
                                <input type="text" class="form-control form-control-lg" id="rua" name="rua" placeholder="Ex: Av. Paulista">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="box p-4">
                                <label for="numero" class="form-label">Número</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="numero" name="numero" placeholder="Ex: 123">

                                <label for="complemento" class="form-label">Complemento</label>
                                <input type="text" class="form-control form-control-lg mb-4" id="complemento" name="complemento" placeholder="Ex: Apto 45, Bloco B">

                                <label for="cpf" class="form-label">CPF</label>
                                <input type="text" class="form-control form-control-lg mb-3" id="cpf" name="cpf" placeholder="Seu CPF">

                                <div class="d-flex justify-content-between">
                                    <button class="btn btn-lg btn-secondary" data-bs-target="#formCarousel" data-bs-slide="prev">Voltar</button>
                                    <button type="submit" class="btn btn-lg btn-success" id="btn_submit">Enviar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        </div>
    </div>

    <%@ include file="footerconf.jsp"%>
</script>
</body>
</html>