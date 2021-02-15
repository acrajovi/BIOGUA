<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : estadosForm
    Created on : 31/05/2018, 09:24:56 AM
    Author     : BIOST
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><s:message code="parametrosGeneralesForm.titulo" /></title>
    </head>
    <body>

        <div class="container">
            <div class="card">

                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="parametrosGeneralesForm.panel" />
                    </h3>
                </div>

                <div class="card-body">
                    <c:url var='guardar' value='/parametrosGenerales/guardar'></c:url>
                    <form:form method="POST" modelAttribute="parametrosGenerales"
                               action="${guardar}" >

                        <div class="myrow">
                            <div class="form-group">
                                <div class="myrow">
                                    <s:message code='parametrosGeneralesForm.parametro.placeholder' var='var1' />
                                    <s:message code='parametrosGeneralesForm.valor.placeholder' var='var2' />
                                    <s:message code='parametrosGeneralesForm.descripcion.placeholder' var='var3' />
                                    <s:message code='sistema.form.completar.tooltip' var='var4' />

                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                        <label class="form-tittle" for="parametro">
                                            <s:message code="parametrosGeneralesForm.parametro" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                        <form:input  readonly="true" maxlength="100" type="text" path="parametro" id="parametro"
                                                     class="form-control input-sm"
                                                     placeholder="${var1}" required="required" />
                                    </div>


                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                        <label class="form-tittle label-required" for="valor">
                                            <s:message code="parametrosGeneralesForm.valor" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                        <form:input  maxlength="100" type="text" path="valor" id="valor"
                                                     autofocus="autofocus" class="form-control input-sm"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var4}"
                                                     placeholder="${var2}" required="required" />
                                    </div>
                                </div>
                                <div class="myrow">
                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-22">
                                        <label class="form-tittle" for="descripcion">
                                            <s:message code="parametrosGeneralesForm.descripcion" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-112 col-md-10 col-lg-10">
                                        <form:input readonly="true" maxlength="100" type="text" path="descripcion" id="descripcion"
                                                    class="form-control input-sm"
                                                    placeholder="${var3}" required="required" />
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                <input title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm ">
                                <a title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/parametrosGenerales/lista' />"><button
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
