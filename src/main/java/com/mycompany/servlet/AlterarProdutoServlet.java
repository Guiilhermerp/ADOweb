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
@WebServlet(name = "AlterarProdutoServlet", urlPatterns = {"/alterar-produto"})
public class AlterarProdutoServlet extends HttpServlet {

  
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
        

        Produto produto = new Produto(nome, descricao, preco_compra, preco_venda, 0, d);

        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setQuantidade(0);
        produto.setPreco_compra(0);
        produto.setPreco_venda(0);

        try {
            ProdutoDAO.atualizarProduto(produto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/consultarProduto.jsp");

    }
}
