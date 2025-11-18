<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="table-responsive">
         <table class="table table-striped table-sm" id="cryptoTable" name="cryptoTable">
            <thead>
              <tr>
                <th>#</th>
                <th>Cidade</th>
                <th>Rua</th>
                <th>Bairro</th>
                <th>Número</th>
                <th>Complemento</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="addr" items="${listaenderecos}" varStatus="status">
                <tr>
                  <td>${status.count}</td>
                  <td>${addr.cidade}</td>
                  <td>${addr.rua}</td>
                  <td>${addr.bairro}</td>
                  <td>${addr.numero}</td>
                  <td>${addr.complemento}</td>
                </tr>
              </c:forEach>
            </tbody>
  </div>
