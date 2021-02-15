<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : modulosForm
    Created on : 08/06/2018, 13:29:56
    Author     : BIOST
--%>

<html>
    <head>
        <title><s:message code="modulosForm.titulo" /></title>
    </head>
    <body>

        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="modulosForm.panel" />
                    </h3>
                </div>
                <div class="card-body">
                    <c:url var='guardar' value='/modulos/guardar'></c:url>
                    <form:form method="POST" modelAttribute="modulos"
                               action="${guardar}" >
                        <form:input type="hidden" path="id" />
                        <div class="myrow">
                            <div class="form-group">
                                <div class="row row-center">
                                    <s:message code='modulosForm.Descripcion.placeholder' var='var1' />
                                    <s:message code='sistema.form.completar.tooltip' var='var2' />
                                    <s:message code='modulosForm.faIcon.placeholder' var='var3' />
                                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-2">
                                        <label class="form-tittle label-required" for="descripcion">
                                            <s:message
                                                code="modulosForm.descripcion" /></label>
                                    </div>
                                    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-4">
                                        <form:input  maxlength="100" type="text" path="descripcion" id="descripcion"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var2}"  placeholder="${var1}" required="required" />
                                    </div>
                                    <div class="col-xs-12 col-sm-4 col-md-4 col-lg-2">
                                        <label class="form-tittle label-required" for="faIcon">
                                            <s:message
                                                code="modulosForm.faIcon" /></label>
                                    </div>
                                    <div class="col-xs-12 col-sm-8 col-md-8 col-lg-4">
                                        <form:input  maxlength="100" type="text" path="fa_icon" id="faIcon"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var2}"  placeholder="${var3}" required="required" />
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <input data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm">
                                <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/modulos/lista' />"><button
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
