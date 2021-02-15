<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : rolesPantallasForm
    Created on : 27/07/2018, 20:13:50 
    Author     : BIOST
--%>

<html>
    <head>
        <title><s:message code="rolesPantallas.titulo" /></title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="rolesPantallas.panel" />
                        ${roles.descripcion}
                    </h3>
                </div>
                <div class="card-body">
                    <c:url var='guardar' value='/rolesPantallas/guardar'></c:url>
                    <form:form method="POST" modelAttribute="rolesPantallas"
                               action="${guardar}" >
                        <form:input type="hidden" path="id" />
                        <form:input type="hidden" path="roles.id" value="${roles.id}"/>
                        <div class="myrow">
                            <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                <label class="form-tittle label-required" for="comboPantallas">
                                    <s:message code="rolesPantallas.pantallas" /></label>
                            </div>
                            <div class=" col-xs-12 col-sm-12 col-md-6 col-lg-6" >
                                <form:select path="pantallas.id" id="comboPantallas"
                                             autofocus="autofocus" class="selectpicker" data-live-search="true"
                                             data-size="5" required="required">
                                    <option value="">
                                        <s:message code="sistema.form.combos.placeholder" /></option>
                                        <c:forEach items="${pantallas}" var="p">
                                            <c:choose>
                                                <c:when test="${p.id eq rolesPantallas.pantallas.id}">
                                                <option value="${p.id}" selected="selected">${p.descripcion}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${p.id}">${p.descripcion}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>      

                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <input data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm">
                                <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/rolesPantallas/pantallasDelRol/${roles.id}' />"><button
                                        type="button" class="btn btn-info btn-sm">
                                        <s:message code='sistema.form.btnCancelar' />
                                    </button></a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
