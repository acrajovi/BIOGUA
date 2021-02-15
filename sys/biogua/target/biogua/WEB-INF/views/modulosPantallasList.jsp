<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : modulosPantallasList
    Created on : 15/07/2018, 19:19:12
    Author     : jacosta
--%>
<html>
    <head>
        <title><s:message code="modulosPantallasList.titulo" /></title>
    </head>

    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="modulosPantallasList.panel"/>
                        ${modulos.descripcion}
                    </h3>
                </div>
                <div class="card-body">    
                    <div class="myrow" >
                        <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                            <a data-toggle="tooltip" data-placement="left" title="<s:message code="sistema.btnNuevo.tooltip"/>" class="btn btn-info margin-btn"
                               href="<c:url value='/modulosPantallas/nuevo/${modulos.id}'/>">
                                <span  class="fa fa-plus-square"></span>
                                <s:message code="sistema.form.btnNuevo" />
                            </a>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8" >
                            <c:url var='path' value='/modulosPantallas'></c:url>                              
                            <form:form method="POST" modelAttribute="filtros"
                                       action="${path}/buscar" class="input-group">

                                <form:input type="hidden" path="criterio" value="${modulos.id}" />

                                <s:message code='sistema.form.busqueda.placeholder' var='variable' />
                                <s:message code='sistema.form.completar.tooltip' var='var2' />

                                <form:input type="text" path="filtro" autofocus="autofocus"
                                            class="form-control" data-toggle="tooltip" data-placement="bottom" title="${var2}" placeholder="${variable}" />
                                <span data-toggle="tooltip" data-placement="right" title="<s:message code="sistema.btnBuscar.tooltip" />" class="input-group-btn">
                                    <button class="btn btn-default" type="submit" value="buscar">
                                        <span class="fa fa-search"></span> <s:message code="sistema.form.btnBuscar" />
                                    </button>
                                </span>    
                            </form:form>
                        </div>
                        <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                            <a data-toggle="tooltip" data-placement="left" title="<s:message code="sistema.btnVolver.tooltip"/>" class="float-right btn btn-secondary margin-btn"
                               href="<c:url value='/modulos/lista'/>">
                                <span  class="fa fa-reply"></span>
                                <s:message code="sistema.form.btnVolver" />
                            </a>
                        </div>
                    </div>
                    <div class="myrow scrollHorizontal" >
                        <table border='1' cellpadding='1' cellspacing='1'
                               class="w3-table w3-striped w3-border w3-bordered w3-hoverable w3-table-all" >
                            <tr class="w3-light-grey">
                                <th><s:message code="pantallasList.grilla.descripcion" /></th>
                                <th><s:message code="pantallasList.grilla.link" /></th>
                                <th><s:message code="sistema.grilla.opcion.eliminar" /></th>
                            </tr>
                            <c:forEach items="${pantallas}" var="l">
                                <tr >
                                    <td><c:out value="${l.descripcion}" /></td>
                                    <td><c:out value="${l.link}" /></td>
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
