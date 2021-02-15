<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : rolesForm
    Created on : 25/07/2018, 19:04:01 
    Author     : BIOST
--%>

<html>
    <head>
        <title><s:message code="rolesForm.titulo" /></title>
    </head>
    <body>

        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="rolesForm.panel" />
                    </h3>
                </div>
                <div class="card-body">
                    <c:url var='guardar' value='/roles/guardar'></c:url>
                    <form:form method="POST" modelAttribute="roles"
                               action="${guardar}" >
                        <form:input type="hidden" path="id" />
                        <div class="myrow">
                            <div class="form-group">
                                <div class="row row-center">
                                    <s:message code='rolesForm.Descripcion.placeholder' var='var1' />
                                    <s:message code='sistema.form.completar.tooltip' var='var2' />
                                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-3">
                                        <label class="form-tittle label-required" for="descripcion">
                                            <s:message
                                                code="rolesForm.descripcion" /></label>
                                    </div>
                                    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-6">
                                        <form:input  maxlength="100" type="text" path="descripcion" id="descripcion"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                   data-toggle="tooltip" data-placement="bottom" title="${var2}"  placeholder="${var1}" required="required" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <input data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm">
                                <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/roles/lista' />"><button
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
