/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.adoweb01.Produto;
import com.mycompany.adoweb01.ProdutoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vitor
 */
@WebServlet(name = "ConsultarProduto", urlPatterns = {"/consultar-produto"})
public class ConsultarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Produto> listaProduto;
        HttpSession sessao = request.getSession();
        request.setAttribute("usuario", sessao.getAttribute("usuario"));
        

        if (sessao == null || sessao.getAttribute("usuario") == null) {
            request.setAttribute("mensagemErro", "Você precisa logar ! ");
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }

        try {

            String nome = request.getParameter("nome");

            listaProduto = ProdutoDAO.procurarProduto(nome);
            request.setAttribute("listaProduto", listaProduto);

            if (nome == null || nome.equals("")) {
                listaProduto = ProdutoDAO.listarProduto();
                request.setAttribute("listaProduto", listaProduto);
            }

            
            sessao.setAttribute("listaProduto", listaProduto);
            response.sendRedirect(request.getContextPath() + "/consultarProduto.jsp");
            
            //this.getServletContext().getRequestDispatcher("/consultarProduto.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath() + "/consultarProduto.jsp");

            //RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
            //dispatcher.forward(request, response);
        } catch (Exception e) {
        }

        
        
    }

}
