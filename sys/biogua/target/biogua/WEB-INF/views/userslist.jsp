<%@include file="/WEB-INF/includes/include.jsp"%>
 
<!DOCTYPE html>
<html>
    <head>
        <title><s:message code="usuariosList.titulo" /></title>
    </head>

    <body>
                  <%@include file="/WEB-INF/includes/menuDinamico.jsp"%>	
        <div class="container">

            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">
                        <s:message code="usuariosList.titulo" />
                    </span></div>
                    
                    
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Email</th>
                            <th>ID</th>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                <th width="100"></th>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th width="100"></th>
                                </sec:authorize>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.email}</td>
                                <td>${user.ssoId}</td>
                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                    <td><a href="<c:url value='/usuarios/editar-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <td><a href="<c:url value='/usuarios/eliminar-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>