<%@include file="/WEB-INF/includes/includeMessages.jsp"%>
<%@include file="/WEB-INF/includes/footer.jsp"%>

<script type="text/javascript">
    setTimeout(sessionTimeOut, (${SessionTime} * 1000) - 10000);
//    setTimeout(sessionTimeOut, 1);
</script>

<nav class="navbar navbar-azul">

    <!--    <div class="float-right">
            <a class="float-left"
               href="<c:url value='/menuPrincipal'></c:url>"> <img
                    class="logotipoMenu" src="<c:url value='/static/imagenes/logoTr.png'></c:url>"
                    alt="BIO Soluciones TecnolÃ³gicas">
            </a>
        </div>-->
    <!--<strong>BIOGUA</strong>-->

    <!--</div>-->
    <!--<div class="">-->


    <!--<div class="float-right">-->
    <!--<div class="col-lg">-->
    <span class="titulo-sistema d-none d-sm-block">
        <strong>BIOGUA</strong>
    </span> 
    <div class="col-xs-8-offset-2 col-sm-8 col-md-8 col-lg-9"> 
        <button  id="btnMenuOpen" class="fas fa-bars btn-menu " onclick="w3_open()">
        </button>
    </div>
    <div class="d-none d-md-block d-lg-block d-xl-block">
        <a
           href="<c:url value='/menuPrincipal'></c:url>"> <img
                class="logotipo" src="<c:url value='/static/imagenes/logoTr.png'></c:url>"
                alt="BIO Soluciones Tecnolóicas">
        </a>
    </div>
    <!--</div>-->

</nav>
<!--<button  class="fas fa-bars btn float-right " onclick="w3_open()"></button>-->

<!--<div class="w3-sidebar w3-bar-block w3-dark-grey w3-animate-left " style="display:none;" id="mySidebar">-->
<div class="w3-sidebar w3-animate-zoom w3-overlay w3-dark-grey" style="display:none;" id="mySidebar">
    <div class="content">
        <nav>
            <div id="menu" class="menu">
                <button class="fas fa-times btn-menu-close" onclick="w3_close()"></button>  
                <div class="menu-header">
                    <!--<s:message code="form.menuPrincipal.navBar.principal" />-->
                    <ul class="menu-cabecera">
                        <!--<li>-->
                        <li >
                            <a href="<c:url value='/menuPrincipal'></c:url>">
                                <i class="fa fa-home"></i> 
                                <s:message code="form.menuPrincipal.navBar.principal" />
                            </a>
                        </li>
                    </ul>


                </div>
                <ul>
                    <!--<li class="active"><a href="<c:url value='/menuPrincipal'></c:url>"><i class="fa fa-home"></i> Home</a></li>-->

                    <li><a href="#"><i class="fa fa-th"> </i>
                            <s:message code="form.menuPrincipal.modulo.administracion" />
                        </a>
                        <ul class="submenu">
                            <li><a href="<c:url value='/estados/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.estados" /></a></li>
                        </ul>
                        <ul class="submenu">
                            <li><a href="<c:url value='/estadosPersonas/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.estadosPersonas" /></a></li>
                        </ul>
                        <ul class="submenu">
                            <li><a href="<c:url value='/sucursales/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.sucursales" /></a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="fa fa-lock"> </i>
                            <s:message code="form.menuPrincipal.modulo.seguridad" />
                        </a>
                        <ul class="submenu">
                            <!--<li><a href="#"> Web Design </a>-->
                            <!--<ul class="submenu">-->
                            <li><a href="<c:url value='/usuarios/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.usuarios" /></a></li>
                            <!--<li><a href="#"> Joomla</a></li>-->
                            <!--</ul>-->
                            <!--</li>-->
                            <!--<li><a href="#"> Hosting</a></li>-->
                            <!--<li><a href="#"> Design </a></li>-->
                        </ul>
                    </li>

                    <li><a href="#"><i class="fa fa-cog"> </i>
                            <s:message code="form.menuPrincipal.modulo.configuracion" />
                        </a>
                        <ul class="submenu">

                            <li><a href="<c:url value='/parametrosGenerales/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.parametrosGenerales" /></a></li>
                            <li><a href="<c:url value='/modulos/lista'></c:url>"> Módulos</a></li>
                            <li><a href="<c:url value='/pantallas/lista'></c:url>"> Pantallas</a></li>
                            <li><a href="<c:url value='/roles/lista'></c:url>"> <s:message code="form.menuPrincipal.menu.roles" /></a></li>
                        </ul>
                    </li>
                    <!--<li><a href="#"><i class="fa fa-newspaper-o"> </i>News<span class="menu-label"> 8 </span></a></li>-->
                    <!--                    <li><a href="#"><i class="fa fa-user"> </i> About</a></li>-->
                    <li class="text-right"><a href="<c:url value='/usuarios/cambioPass'></c:url>"><i class="fa fa-user"> </i> Cambiar Contraseña</a></li>
                    <li class="text-right" style="font-weight: bold;"><a href="<c:url value='/logout'></c:url>"><i style="color: orangered" class="fa fa-window-close"> </i> <s:message code="form.menuPrincipal.navBar.cerrarSesion" /> </a></li>

                </ul>
                <!--<div class="menu-footer"> BIO </div>-->
                <div class="menu-footer"> 
                    <strong style="font-size: 10px;">${usersysNameApe}</strong> 
                    <br>
                    <span class="fa fa-copyright"></span>
                    <strong style="font-size: 10px;"><s:message code="sistema.desarrollador" /></strong> 
                    <!--<strong style="font-size: 10px; color: trasnparent"></strong>--> 
                </div>
                <div class="menu-footer"> </div>
                <!--<h1 id="sessionTime">${SessionTime}</h1>-->
                <!--<div id="SessionTime" class="menu-footer"> <strong style="font-size: 10px;">${SessionTime}</strong> </div>-->
            </div>
        </nav>
    </div>
</div>


<!--icono subir-->
<a class="ir-arriba"  href="#" title="Volver arriba">
    <span class="fa-stack">
        <i class="fa fa-circle fa-stack-2x"></i>
        <i class="fa fa-arrow-up fa-stack-1x fa-inverse"></i>
    </span>
</a>


