<%-- 
    Document   : home
    Created on : 02/12/2017, 06:41:03
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>koob</title>
        <link rel="stylesheet" href="css/homecss.css"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <nav>

        <div class="full-width navbar">
            <a class="navbar-brand" href="home.jsp"><img class="logo" src="logo.png" /></a> 
            <ul>
                <li class="active"><a href="home.jsp">Home</a></li>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                ||sessionScope.usuario.getFuncao().equals('estoquista') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li><a id ="produto" href = "cadastrarProduto.jsp">Produto</a></li>
                      </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                || sessionScope.usuario.getFuncao().equals('gerente')}">

                      <li><a id ="cliente" href="cadastrarCliente.jsp">Cliente</a></li>

                </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('ti') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">

                      <li><a id ="usuario"href="cadastrarUsuario.jsp">Usuário</a></li>

                </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')

                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li><a id ="venda"href="venda.jsp">Venda</a></li>
                      </c:if>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('gerente')}">
                    <li><a id = "relatorio" href="relatorio.jsp">Relatório</a></li>
                    </c:if>

                <li class="active"><a href="Logout">Logout</a></li>







            </ul>
            <div style="clear: both"></div>
        </div>
    </nav>
    <body>
        <c:if test="${not empty mensagemErro}">
        <alert><c:out value="${mensagemErro}" /></alert>
        </c:if> 
</body>
</html>
