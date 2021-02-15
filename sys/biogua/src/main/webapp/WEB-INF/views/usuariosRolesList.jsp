<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : estadosList
    Created on : 29/05/2018, 11:02:16 AM
    Author     : jacosta
--%>
<html>
    <head>
        <title><s:message code="usuariosRolesList.titulo" /></title>
    </head>

    <body>
        <div class="container col-xs-12 col-sm-12 col-md-12 col-lg-12"  style="height:100%; width:65%; "    >
            <div class="card col-xs-12 col-sm-4 col-md-4 col-lg-6" style="float: left;">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="usuariosRolesListOK.panel"/>
                    </h3>
                </div>
                <div class="card-body">    
                    <div class="myrow scrollHorizontal" >
                        <table border='1' cellpadding='1' cellspacing='1'
                               class="w3-table w3-striped w3-border w3-bordered w3-hoverable w3-table-all" >
                            <tr class="w3-light-grey">
                                <th><s:message code="estadosList.grilla.descripcion" /></th>
                                <th><s:message code="sistema.grilla.opcion.quitar" /></th>
                            </tr>
                            <c:forEach items="${lista}" var="l">
                                <tr >
                                    <td><c:out value="${l.descripcion}" /></td>
                                    <td class="td-center">
                                        <a href="${path}/editar/${l.id}">
                                            <i class="fa fa-edit fa-lg " aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnModificar.tooltip" />">
                                            </i>
                                        </a>
                                    </td>
                                    <td class="td-center">
                                        <a onclick="confirmarEliminacion('${path}/eliminar/${l.id}', '${l.descripcion}');" href="#">
                                            <i class="fa fa-trash fa-lg" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnEliminar.tooltip" />" ></i>
                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <div class="card col-xs-12 col-sm-4 col-md-4 col-lg-6" style="float: right;">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="usuariosRolesListNO.panel"/>
                    </h3>
                </div>
                <div class="card-body">    
                    <div class="myrow scrollHorizontal" >
                        <table border='1' cellpadding='1' cellspacing='1'
                               class="w3-table w3-striped w3-border w3-bordered w3-hoverable w3-table-all" >
                            <tr class="w3-light-grey">
                                <th><s:message code="estadosList.grilla.descripcion" /></th>
                                <th><s:message code="sistema.grilla.opcion.agregar" /></th>
                            </tr>
                            <c:forEach items="${lista}" var="l">
                                <tr >
                                    <td><c:out value="${l.descripcion}" /></td>
                                    <td class="td-center">
                                        <a href="${path}/editar/${l.id}">
                                            <i class="fa fa-edit fa-lg " aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnModificar.tooltip" />">
                                            </i>
                                        </a>
                                    </td>
                                    <td class="td-center">
                                        <a onclick="confirmarEliminacion('${path}/eliminar/${l.id}', '${l.descripcion}');" href="#">
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
