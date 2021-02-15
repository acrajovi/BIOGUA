<!DOCTYPE html>
<html>
    <body>
    <c:if test="${mostrarMensaje}">  
        <c:forEach items="${mensajes}" var="m">
            <c:if test="${m.tipo eq 'error'}">
                 <script>
                    $.growl.error({title: "", size: "large", message: "<strong><c:out value="${m.mensaje}"></c:out></strong>" });
                 </script>
            </c:if>
            <c:if test="${m.tipo eq 'info'}">
                 <script>
                    $.growl.notice({title: "", size: "large", message: "<strong><c:out value="${m.mensaje}"></c:out></strong>" });
                 </script>
            </c:if>
            <c:if test="${m.tipo eq 'warn'}">
                <script>
                    $.growl.warning({title: "", size: "large", message: "<strong><c:out value="${m.mensaje}"></c:out></strong>" });
                 </script>
            </c:if>
            <c:if test="${m.tipo eq 'success'}">
                <script>
                    $.growl({title: "", size: "large", message: "<strong><c:out value="${m.mensaje}"></c:out></strong>" });
                 </script>
            </c:if>
        </c:forEach>
    </c:if>
                 
                 	<c:if test="${param.error != null}">
		<script>
			$.growl
					.error({
						title : "",
						size : "large",
						message : "<h7><strong>Usuario o Contrase\u00f1a incorrectos!</strong></h7>"
					});
		</script>
	</c:if>
	<c:if test="${param.denied != null}">
		<script>
			$.growl
					.error({
						title : "",
						size : "large",
						message : "<h7><strong>Accedo denegado!</strong></h7>"
					});
		</script>
	</c:if>
	<c:if test="${param.logout != null}">
		<script>
			$.growl.notice({
				title : "",
				size : "large",
				message : "<h7><strong>Su sesión ha finalizado!</strong></h7>"
			});
		</script>
	</c:if>
	<c:if test="${param.bienvenido != null}">
		<script>
			$.growl({
				title : "",
				size : "large",
				message : "<h7><strong>Bienvenido!</strong></h7>"
			});
		</script>
	</c:if>
	<c:if test="${param.timeout != null}">
		<script>
			$.growl.warning({
				title : "",
				size : "large",
				message : "<h7><strong>Tiempo de inactividad alcanzado!</strong></h7>"
			});
		</script>
	</c:if>
</body>
</html>