<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : pantallasForm
    Created on : 12/07/2018, 14:56:56 
    Author     : BIOST
--%>

<html>
    <head>
        <title><s:message code="pantallasForm.titulo" /></title>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="pantallasForm.panel" />
                    </h3>
                </div>
                <div class="card-body">
                    <c:url var='guardar' value='/pantallas/guardar'></c:url>
                    <form:form method="POST" modelAttribute="pantallas"
                               action="${guardar}" >
                        <form:input type="hidden" path="id" />
                        <div class="myrow">
                            <div class="form-group">
                                <div class="row row-center">
                                    <s:message code='pantallasForm.Descripcion.placeholder' var='var1' />
                                    <s:message code='pantallasForm.link.placeholder' var='var2' />

                                    <s:message code='sistema.form.completar.tooltip' var='var3' />
                                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-2">
                                        <label class="form-tittle label-required" for="descripcion">
                                            <s:message
                                                code="pantallasForm.descripcion" /></label>
                                    </div>
                                    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-4">
                                        <form:input  maxlength="100" type="text" path="descripcion" id="descripcion"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var3}"  placeholder="${var1}" required="required" />
                                    </div>
                                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-2">
                                        <label class="form-tittle label-required" for="link">
                                            <s:message
                                                code="pantallasForm.link" /></label>
                                    </div>
                                    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-4">
                                        <form:input  maxlength="100" type="unknow" path="link" id="link"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var3}"  placeholder="${var2}" required="required" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <input data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm">
                                <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/pantallas/lista' />"><button
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
