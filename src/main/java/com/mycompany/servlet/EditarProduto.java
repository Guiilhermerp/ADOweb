/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.adoweb01.Produto;
import com.mycompany.adoweb01.ProdutoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author guilherme.gcosta6
 */
@WebServlet(name = "EditarProduto", urlPatterns = {"/editar-produto"})
public class EditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
        double preco_compra = Double.parseDouble(request.getParameter("preco_compra"));
        double preco_venda = Double.parseDouble(request.getParameter("preco_venda"));

        Produto cliente = new Produto(quantidade, nome, descricao, 0, 0, 0, dt_cadastro);
        

        //String erro = ValidadorCliente.validarCliente(cliente);
        String erro = "";
        if (!erro.equals("")) {
            request.setAttribute("mensagem", erro);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultarProduto.jsp");
            dispatcher.forward(request, response);

        } else {

            try {

                ProdutoDAO.atualizarProduto(cliente);

            } catch (Exception e) {
                e.printStackTrace();
            }

            //cria ou recupera uma sessão ja existente
            sessao = request.getSession();

            request.setAttribute("mensagem", "Produto editado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/consultarProduto.jsp");
            dispatcher.forward(request, response);

        }

    }

}
