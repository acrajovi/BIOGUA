<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/menuDinamico.jsp"%>
<%-- 
    Document   : usuariosForm
    Created on : 31/05/2018, 09:24:56 AM
    Author     : BIOST
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset= UTF-8">
        <title><s:message code="usuariosForm.titulo" /></title>
    </head>
    <body>

        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h3 class="card-title">
                        <s:message code="usuariosForm.panel" />
                    </h3>
                </div>

                <div class="card-body">
                    <c:url var='guardar' value='/usuarios/guardar'></c:url>
                     <c:url var='path' value='/usuarios'></c:url>         
                    <form:form method="POST" modelAttribute="usuarios" action="${guardar}" >                       
                        <div class="myrow">
                            <div class="form-group">
                                <div class="myrow">
                                    <s:message code='usuariosForm.usuario.placeholder' var='var1' />
                                    <s:message code='usuariosForm.ci.placeholder' var='var2' />
                                    <s:message code='usuariosForm.nombre.placeholder' var='var3' />
                                    <s:message code='usuariosForm.apellido.placeholder' var='var4' />
                                    <s:message code='sistema.form.completar.tooltip' var='var5' />

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <label class="form-tittle label-required" for="usuario">
                                            <s:message code="usuariosForm.usuario" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                                        <form:input  readonly="${!nuevo}" maxlength="50" 
                                                     type="text" path="usuario" id="usuario"
                                                     class="form-control input-sm" autofocus="autofocus"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var5}" placeholder="${var1}" required="required" />
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <label class="form-tittle label-required" for="ci">
                                            <s:message code="usuariosForm.ci" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-4">
                                        <form:input  readonly="${!nuevo}" onkeyup="format(this);" onchange="format(this);" maxlength="10" 
                                                     type="text" path="ci" id="ci"
                                                     class="form-control input-sm" autofocus="autofocus"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var5}"  placeholder="${var2}" required="required" />
                                    </div>

                                </div>
                                <div class="myrow">             
                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                        <label class="form-tittle label-required" for="nombre">
                                            <s:message code="usuariosForm.nombre" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                        <form:input  maxlength="100" 
                                                     type="text" path="nombre" id="nombre"
                                                     class="form-control input-sm" autofocus="autofocus"
                                                     data-toggle="tooltip" data-placement="bottom" title="${var5}"  placeholder="${var3}" required="required" />
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                        <label class="form-tittle label-required" for="apellido">
                                            <s:message code="usuariosForm.apellido" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                        <form:input   maxlength="100" 
                                                      type="text" path="apellido" id="apellido"
                                                      class="form-control input-sm" autofocus="autofocus"
                                                      data-toggle="tooltip" data-placement="bottom" title="${var5}"   placeholder="${var4}" required="required" />
                                    </div>
                                </div>
                                <div class="myrow">
                                    <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                        <label class="form-tittle label-required" for="comboSucursales">
                                            <s:message code="usuariosForm.sucursal" /></label>
                                    </div>
                                    <div  class=" col-xs-12 col-sm-12 col-md-4 col-lg-4">
                                        <form:select path="sucursales.id" id="comboSucursales"
                                                     class="selectpicker" data-live-search="true"
                                                     data-size="5" required="required">
                                            <option value="">
                                                <s:message code="sistema.form.combos.placeholder" /></option>

                                            <c:forEach items="${sucursales}" var="s">
                                                <c:choose>
                                                    <c:when test="${s.id eq usuarios.sucursales.id}">
                                                        <option value="${s.id}" selected="selected">${s.descripcion}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${s.id}">${s.descripcion}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <c:if test = "${!nuevo}">
                                        <div class="col-xs-12 col-sm-12 col-md-2 col-lg-2">
                                            <label class="form-tittle label-required" for="comboEstadosPersonas">
                                                <s:message code="usuariosForm.estado" /></label>
                                        </div>
                                        <div class=" col-xs-12 col-sm-12 col-md-4 col-lg-4" >
                                            <form:select path="estadosPersonas.id" id="comboEstadosPersonas"
                                                         class="selectpicker" data-live-search="true"
                                                         data-size="5" required="required">
                                                <option value="">
                                                    <s:message code="sistema.form.combos.placeholder" /></option>

                                                <c:forEach items="${estadosPersonas}" var="e">
                                                    <c:choose>
                                                        <c:when test="${e.id eq usuarios.estadosPersonas.id}">
                                                            <option value="${e.id}" selected="selected">${e.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${e.id}">${e.descripcion}</option>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </form:select>
                                        </div>
                                    </c:if>
                                </div>


                            </div>

                        </div>
                        <c:if test = "${!nuevo}">
                            <div class="card-footer">
                                <div class="myrow">
                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <label class="form-tittle" for="fechaAlta">
                                            <s:message code="usuariosForm.fechaAlta" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <form:input  readonly="true" 
                                                     type="text" path="fecha_alta" id="fechaAlta"
                                                     class="form-control input-sm" />
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <label class="form-tittle" for="fechaCambioPass">
                                            <s:message code="usuariosForm.fechaCambioEstado" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <form:input  readonly="true" 
                                                     type="text" path="fecha_cambio_estado" id="fechaCambioEstado"
                                                     class="form-control input-sm" />
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <label class="form-tittle" for="fechaCaducaPass">
                                            <s:message code="usuariosForm.fechaCaducaPass" /></label>
                                    </div>

                                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-2">
                                        <form:input  readonly="true" 
                                                     type="text" path="fecha_caduca" id="fechaCaducaPass"
                                                     class="form-control input-sm" />
                                    </div>
                                </div>  
                            </div>

<!--                            <div class="float-left">
                                <div class="col-xs-12 col-sm-16 col-md-12 col-lg-12">
                                    <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="usuariosForm.btn.resetpass.tooltip" />">
                                        <button onclick="confirmarReicioPass('${path}/reiniciar/${usuarios.usuario}', '${usuarios.usuario}')" type="button" class="btn btn-danger btn-sm">
                                            <s:message code='usuariosForm.btn.resetpass' />
                                        </button>
                                    </a>
                                </div>
                            </div>-->
                        </c:if>


                        <div class="myrow float-right">
                            <div class="col-xs-12 col-sm-16 col-md-12 col-lg-12">
                                <input data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnGuardar.tooltip" />" type="submit" value="<s:message code='sistema.form.btnGuardar' />" class="btn btn-info btn-sm ">
                                <a data-toggle="tooltip" data-placement="bottom" title="<s:message code="sistema.btnCancelar.tooltip" />" href="<c:url value='/usuarios/lista' />"><button
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
