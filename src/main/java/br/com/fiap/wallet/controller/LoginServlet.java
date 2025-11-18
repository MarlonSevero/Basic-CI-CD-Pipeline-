package br.com.fiap.wallet.controller;

import br.com.fiap.wallet.dao.AccountDao;
import br.com.fiap.wallet.dao.AddressDao;
import br.com.fiap.wallet.model.user.Account;
import br.com.fiap.wallet.model.user.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            AccountDao accountDao = new AccountDao();
            String email = request.getParameter("email");
            String passwd = request.getParameter("passwd");
            Account account = accountDao.login(email, passwd);
            request.setAttribute("conta", account);
            request.getSession().setAttribute("usuarioLogado", account);
            response.sendRedirect("sucesso.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao acessar valores: " + e.getMessage());
            response.sendRedirect("error.jsp");
            //request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}