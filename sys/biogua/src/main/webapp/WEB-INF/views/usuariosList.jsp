<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : usuariosList
    Created on : 29/05/2018, 11:02:16 AM
    Author     : jacosta
--%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
        <title><s:message code="usuariosList.titulo" /></title>
    </head>

    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="usuariosList.panel"/>
                    </h3>
                </div>
                <div class="card-body">    
                    <div class="myrow" >
                        <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                            <a data-toggle="tooltip" data-placement="left" title="<s:message code="sistema.btnNuevo.tooltip"/>" class="btn btn-info margin-btn"
                               href="<c:url value='/usuarios/nuevo'/>">
                                <span  class="fa fa-plus-square"></span>
                                <s:message code="sistema.form.btnNuevo" />
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8" >
                            <c:url var='path' value='/usuarios'></c:url>                              
                            <form:form method="POST" modelAttribute="filtros"
                                       action="${path}/buscar" class="input-group">

                                <form:input type="hidden" path="criterio" value="--" />

                                <s:message code='sistema.form.busqueda.placeholder' var='variable' />
                                <s:message code='sistema.form.completar.tooltip' var='var2' />

                                <form:input type="text" onkeyup="toUpper(this)" path="filtro" autofocus="autofocus"
                                            class="form-control"  data-toggle="tooltip" data-placement="bottom" title="${var2}" placeholder="${variable}" />
                                <span data-toggle="tooltip" data-placement="right" title="<s:message code="sistema.btnBuscar.tooltip" />" class="input-group-btn">
                                    <button class="btn btn-default" type="submit" value="buscar">
                                        <span class="fa fa-search"></span> <s:message code="sistema.form.btnBuscar" />
                                    </button>
                                </span>
                            </form:form>
                        </div>
                    </div>
                    <div class="myrow scrollHorizontal" >
                        <table border='1' cellpadding='1' cellspacing='1'
                               class="w3-table w3-striped w3-border w3-bordered w3-hoverable w3-table-all" >
                            <tr class="w3-light-grey">
                                <th><s:message code="usuariosList.grilla.usuario" /></th>
                                <th><s:message code="usuariosList.grilla.ci" /></th>
                                <th><s:message code="usuariosList.grilla.nombre" /></th>
                                <th><s:message code="usuariosList.grilla.apellido" /></th>
                                <th><s:message code="usuariosList.grilla.sucursal" /></th>
                                <th><s:message code="usuariosList.grilla.estado" /></th>
                                <th><s:message code="usuariosList.grilla.resetPasss" /></th>
                                <th><s:message code="usuariosList.grilla.roles" /></th>
                                <th><s:message code="sistema.grilla.opcion.modificar" /></th>
                                <th><s:message code="sistema.grilla.opcion.eliminar" /></th>
                            </tr>
                            <c:forEach items="${lista}" var="l">
                                <tr >
                                    <td><c:out value="${l.usuario}" /></td>
                                    <td><c:out value="${l.ci}" /></td>
                                    <td><c:out value="${l.nombre}" /></td>
                                    <td><c:out value="${l.apellido}" /></td>
                                    <td><c:out value="${l.sucursales.descripcion}" /></td>
                                    <td><c:out value="${l.estadosPersonas.descripcion}" /></td>
                                    <td class="td-center">
                                        <a onclick="confirmarReicioPass('${path}/restablecerPass/${l.usuario}', '${l.usuario}')"  href="#">
                                            <i  style="color: red" class="fa fa-history fa-lg " aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="usuariosForm.btn.resetpass.tooltip" />">
                                            </i>
                                        </a>
                                    </td>
                                    <td class="td-center">
                                        <a href="${path}/rolesUsuarios/${l.usuario}">
                                            <i  style="color: orangered" class="fa fa fa-cogs fa-lg " aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="usuariosForm.btn.roles.tooltip" />">
                                            </i>
                                        </a>
                                    </td>
                                    <td class="td-center">
                                        <a href="${path}/editar/${l.usuario}">
                                            <i class="fa fa-edit fa-lg " aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnModificar.tooltip" />">
                                            </i>
                                        </a>
                                    </td>
                                    <td class="td-center">
                                        <a onclick="confirmarEliminacion('${path}/eliminar/${l.usuario}', '${l.usuario}');" href="#">
                                            <i class="fa fa-trash fa-lg" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnEliminar.tooltip" />" ></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
