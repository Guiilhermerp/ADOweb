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
@WebServlet(name = "CadastroProduto", urlPatterns = {"/cadastro-produto"})
public class CadastroProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino;

        HttpSession sessao = request.getSession();

        if (sessao.getAttribute("produto") != null) {

            request.setAttribute("mensagem", "Produto cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/CadastroProduto.jsp");
            dispatcher.forward(request, response);

            destino = "CadastrarProduto.jsp";

        } else {

            destino = "CadastroProduto.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               dispatcher.forward(request, response);

        }

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        int quantidade = -1;
        double preco_venda = -1;
        
        try {
            quantidade = Integer.parseInt(request.getParameter("quantidade"));
            preco_venda = Double.parseDouble(request.getParameter("preco_venda"));
        } catch (Exception e) {

        }

        Produto produto = new Produto(quantidade, nome, descricao, preco_venda, preco_venda, quantidade);

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco_compra(preco_venda);
        produto.setQuantidade(quantidade);
        produto.setPreco_venda(preco_venda);
        String erro = "";
        
        if (erro.equals("")) {
            try {
                ProdutoDAO.inserirProduto(produto);
            } catch (Exception e) {
                e.printStackTrace();
            }

             request.setAttribute("mensagem", "Produto cadastrado ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastrarProduto.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensagem", erro);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/cadastrarProduto.jsp");
            dispatcher.forward(request, response);
        }

    }
}
