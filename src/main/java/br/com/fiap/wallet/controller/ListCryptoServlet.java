package br.com.fiap.wallet.controller;

import br.com.fiap.wallet.cache.CryptoPriceCache;
import br.com.fiap.wallet.model.coins.CoinCrypto;
import br.com.fiap.wallet.model.coins.CurrencyPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/listacrypto")
public class ListCryptoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            final CoinCrypto coinCrypto = new CoinCrypto();
            // Cria a lista para armazenar as moedas
        List<CoinCrypto> listacrypto = coinCrypto.getAllPair();

        request.setAttribute("listacrypto", listacrypto);
        request.getRequestDispatcher("crypto.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Erro ao acessar valores: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}