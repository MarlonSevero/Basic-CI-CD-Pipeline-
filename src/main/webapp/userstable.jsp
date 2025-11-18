<div class="table-responsive">
         <table class="table table-striped table-sm" id="cryptoTable" name="cryptoTable">
           <thead>
             <tr>
               <th>#</th>
               <th>Nome</th>
               <th>Data Nascimento</th>
               <th>CPF</th>
               <th>Renda</th>
               <th>IdEndereco</th>
               <th>Email</th>
             </tr>
           </thead>
           <tbody>
                  <c:forEach var="user" items="${listausuarios}" varStatus="status">
                          <tr>
                            <td>${status.index + 1}</td>
                            <td>${user.name}</td>
                            <td>${user.dt_birth}</td>
                            <td>${user.cpf}</td>
                            <td>${user.renda}</td>
                            <td>${user.id_address}</td>
                            <td>${user.email}</td>
                          </tr>
                        </c:forEach>
           </tbody>
         </table>
  </div>
