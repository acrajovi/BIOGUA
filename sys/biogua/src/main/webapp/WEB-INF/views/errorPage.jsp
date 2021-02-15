<%-- 
    Document   : errorPage
    Created on : 15-oct-2018, 21:54:31
    Author     : Joss Acosta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body>
        <h1>Se ha producido un error!</h1>
         <h1>${errorMsg}</h1>
    </body>
</html>
