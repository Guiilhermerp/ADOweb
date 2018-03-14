<%-- 
    Document   : index
    Created on : 02/12/2017, 03:00:42
    Author     : Vitor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"/>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device">
        <link rel="stylesheet" href="css/indexcss.css"/>
        <title>koob</title>
    </head>
    <body>
        <div class="loginBox">
            <div class="glass">
                <img src="logo.png" class="user"/>
                <h3></h3>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="inputBox">
                        <input type="text" name="username" placeholder="Usuário"/>
                        <span><i class="fa fa-user" aria-hidden="true"></i></span>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="senha" placeholder="Senha"/>
                        <span><i class="fa fa-lock" aria-hidden="true"></i></span>
                    </div>
                    <input type="submit" name="" value="Login">
                </form>
            </div>
        </div>
    
</body>
</html>
