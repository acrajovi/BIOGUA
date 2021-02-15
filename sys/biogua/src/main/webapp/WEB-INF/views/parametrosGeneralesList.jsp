<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : estadosList
    Created on : 29/05/2018, 11:02:16 AM
    Author     : jacosta
--%>
<html>
    <head>
        <title><s:message code="parametrosGeneralesList.titulo" /></title>
    </head>

    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="parametrosGeneralesList.panel"/>
                    </h3>
                </div>

                <div class="card-body"> 
                    <div class="row row-center">
                        <div class="form-group">
                            <c:url var='path' value='/parametrosGenerales'></c:url>
                                <div class=" row-center col-xs-10 col-sm-12 col-md-8 col-lg-6">
                                <form:form method="POST" modelAttribute="filtros"
                                           action="${path}/buscar" class="input-group">

                                    <form:input type="hidden" path="criterio" value="--" />

                                    <s:message code='sistema.form.busqueda.placeholder' var='variable' />
                                    <s:message code='sistema.form.completar.tooltip' var='var2' />

                                    <form:input type="text" path="filtro" autofocus="autofocus"
                                                class="form-control" data-toggle="tooltip" data-placement="bottom" title="${var2}" placeholder="${variable}" />

                                    <span data-toggle="tooltip" data-placement="right" title="<s:message code="sistema.btnBuscar.tooltip" />" class="input-group-btn">
                                        <button class="btn btn-default" type="submit" value="buscar">
                                            <span class="fa fa-search"></span> <s:message code="sistema.form.btnBuscar" />
                                        </button>
                                    </span>
                                </div>
                            </form:form>
                        </div>
                    </div>

                    <div class="row scrollHorizontal">
                        <table border='1' cellpadding='1' cellspacing='1'
                               class="w3-table w3-striped w3-border w3-bordered w3-hoverable w3-table-all">

                            <tr class="w3-light-grey">
                                <th><s:message code="parametrosGeneralesList.grilla.parametro" /></th>
                                <th><s:message code="parametrosGeneralesList.grilla.valor" /></th>
                                <th><s:message code="parametrosGeneralesList.grilla.descripcion" /></th>
                                <th style="width: 50px;"><s:message code="sistema.grilla.opcion.modificar" /></th>

                            </tr>

                            <c:forEach items="${lista}" var="l">

                                <tr>
                                    <td><c:out value="${l.parametro}" /></td>
                                    <td class="td-center"><c:out value="${l.valor}" /></td>
                                    <td><c:out value="${l.descripcion}" /></td>
                                    <td class="td-center">
                                        <a href="${path}/editar/${l.parametro}">
                                            <i class="fa fa-edit fa-lg" aria-hidden="true" data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnModificar.tooltip" />">
                                            </i>
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
