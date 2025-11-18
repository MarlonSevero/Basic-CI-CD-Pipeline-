package br.com.fiap.wallet.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.fiap.wallet.dao.AccountDao;
import br.com.fiap.wallet.dao.*;
import br.com.fiap.wallet.dao.AddressDao;
import br.com.fiap.wallet.model.user.Account;
import br.com.fiap.wallet.model.user.Address;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Configura charset para evitar problema com acentuação
        request.setCharacterEncoding("UTF-8");

        try {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            AccountDao accountDao = new AccountDao();
            AddressDao addressDao = new AddressDao();

            // Recebe os parâmetros do formulário

            String cidade = request.getParameter("cidade");
            String bairro = request.getParameter("bairro");
            String rua = request.getParameter("rua");
            String numero = request.getParameter("numero");
            String complemento = request.getParameter("complemento");
            Address address = new Address();

            //Criar e salvar endereço
            address.setCidade(cidade);
            address.setBairro(bairro);
            address.setRua(rua);
            address.setNumero(numero);
            address.setComplemento(complemento);
            int idAddress = addressDao.save(address); // <- Obtém ID gerado

            String nome = request.getParameter("name_user");
            LocalDate dataNascimento = LocalDate.parse(request.getParameter("dt_nascimento"), formatter);
            double renda = Double.parseDouble(request.getParameter("renda"));
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String senha = request.getParameter("passwd");

            Account account = new Account(); //cria Conta JavaBin
            account.setName(nome);
            account.setDt_birth(dataNascimento);
            account.setRenda(renda);
            account.setCpf(cpf);
            account.setEmail(email);
            account.setPassword(senha);
            account.setId_address(idAddress);
            accountDao.create(account); //registra item no banco
            response.sendRedirect("login.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao cadastrar usuário: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}