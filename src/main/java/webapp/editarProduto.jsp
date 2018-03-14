
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>ekoob</title>
        <link rel="stylesheet" href="css/homecss.css"/>
        <link rel="stylesheet" href="css/crudcss.css"/>

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
                <li><a class="active" href="home.jsp">Home</a></li>

                <c:if test = "${sessionScope.usuario.getFuncao().equals('vendedor')
                                ||sessionScope.usuario.getFuncao().equals('estoquista') 
                                || sessionScope.usuario.getFuncao().equals('gerente')}">
                      <li class="active"><a id ="produto" href = "cadastrarProduto.jsp">Produto</a></li>
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
        <c:if test="${not empty mensagem}">
        <alert><c:out value="${mensagem}" /></alert>
        </c:if> 
    <div  id="pagina" class="container">
        <div class="row">
            <div class="col-xs-12">
                <ul class="nav nav-pills nav-justified">
                    <li class="active"><a class="abranc" href="cadastrarProduto.jsp">Cadastro Produto</a></li>
                    <li><a class="abranc" href="consultarProduto.jsp">Consultar Produto</a></li>

                </ul>

            </div>

        </div>

    </div>
    <section>
        <div id="box" class="container-fluid">
            <div class="container">
                <div class="formBox">

                    <form id="registerform" name="registerform" action="${pageContext.request.contextPath}/editar-produto" method="post">
                        <div class="row">
                            <div class="col-sm-12">
                                <h1>Cadastrar Produto</h1>
                            </div>
                            <div class="row">
                                <div class="col-sm-6">
                                    <input type="hidden" maxlength="50" size="50" name="idProduto" class="input required" id="fnome" value = "${idProduto}">

                                    <div class="inputBox">
                                        <div class="inputText">Nome</div>
                                        <input type="text" maxlength="50" size="50" name="nome" class="input required" id="fnome" value = "${nome}">

                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Autor</div>
                                        <input type="text" maxlength="30" size="30" name="autor" class="input required" value = "${autor}">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Editora</div>
                                        <input type="text" maxlength="30" size="30" name="editora" class="input required" value = "${editora}">
                                    </div>

                                </div>
                                <div class="col-sm-6">
                                    <div class="inputBox">
                                        <div class="inputText">Ano</div>
                                        <input type="number" maxlength="4" size="4" name="ano" class="input required " value = "${ano}">
                                    </div>

                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="inputBox">
                                    <div class="inputText">Estoque</div>
                                    <input type="number" maxlength="10" size="10" name="estoque" class="input required " value = "${estoque}">
                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="inputBox">
                                    <div class="inputText">Preço</div>
                                   
                                    <input type="number" maxlength="10" size="10" name="preco" class="input required " value = "${preco}">
                                </div>

                            </div>



                            <div class="col-sm-12">
                                <input type="submit" name="" value="Salvar" class="button">
                            </div>
                        </div>
                    </form>
                </div>


            </div>
        </div>

    </div>
</section>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<script type="text/javascript">
    $(".input").focus(function () {
        $(this).parent().addClass("focus");
    }).blur(function () {
        if ($(this).val() === '') {
            $(this).parent().removeClass("focus");
        }
    });</script>
<script>
    $(document).ready(function () {
        $("#registerform").validate({

        });
    });
</script>
</html>