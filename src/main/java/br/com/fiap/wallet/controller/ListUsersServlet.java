package br.com.fiap.wallet.controller;
import br.com.fiap.wallet.dao.AccountDao;
import br.com.fiap.wallet.model.user.Account;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listausuarios")
public class ListUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            AccountDao accountDao = new AccountDao();
            List<Account> listausers = accountDao.getAllUsers();


            request.setAttribute("listausuarios", listausers);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao acessar valores: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}