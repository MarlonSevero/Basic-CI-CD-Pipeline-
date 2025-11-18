<div class="table-responsive">
         <table class="table table-striped table-sm" id="cryptoTable" name="cryptoTable">
           <thead>
             <tr>
               <th>#</th>
               <th>Moeda Fiduciaria</th>
               <th>Preco Atual</th>
               <th>Crypto</th>
               <th>Ultima Atualizacao</th>
             </tr>
           </thead>
           <tbody>
                  <c:forEach var="coin" items="${listacrypto}" varStatus="status">
                          <tr>
                            <td>${status.index + 1}</td>
                            <td>${(coin.currencyBase)}</td>
                            <td>${coin.currencyPair}</td>
                            <td>${coin.coinPrice}</td>
                            <td>hora atual</td>
                          </tr>
                        </c:forEach>
           </tbody>
         </table>
       <c:if test="${empty listacrypto}">
         <p>Nenhuma moeda carregada. Verifique se o cache retornou dados válidos.</p>
       </c:if>
  </div>