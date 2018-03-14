/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet;

import com.mycompany.adoweb01.ProdutoDAO;
import com.mycompany.adoweb01.Produto;
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
@WebServlet(name = "AdicionarProduto", urlPatterns = {"/AdicionarProduto"})
public class AdicionarProduto extends HttpServlet {

    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Integer id = Integer.parseInt(request.getParameter("idProduto"));

        Produto produto = ProdutoDAO.obterProduto(id);

        sessao.setAttribute("nome", produto);
        sessao.setAttribute("idProduto", produto.getId());
        sessao.setAttribute("nomeProduto", produto.getNome());
  
    }

}
catch (Exception e) {
        }
    }

    //@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
