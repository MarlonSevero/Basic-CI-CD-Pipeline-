package br.com.fiap.wallet.controller;

import br.com.fiap.wallet.dao.AddressDao;
import br.com.fiap.wallet.model.user.Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/listaenderecos")
public class ListAddressServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            AddressDao addressDao = new AddressDao();
            List<Address> listaEnderecos = addressDao.getAllAddress();


            request.setAttribute("listaenderecos", listaEnderecos);
            request.getRequestDispatcher("address.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao acessar valores: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}