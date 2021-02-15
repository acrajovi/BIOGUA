<%@include file="/WEB-INF/includes/include.jsp"%>
<%@include file="/WEB-INF/includes/includeMessages.jsp"%>
<%@include file="/WEB-INF/includes/footer.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title><s:message code="form.logIn.titulo" /></title>
    </head>
    <body class="login-page">
        <div class="container">
            <div class="card card-container">
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <img id="profile-img" class="profile-img-card" src="/biogua/static/imagenes/logoTr.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <c:url var="loginUrl" value="/login" />
                <form class="form-signin" action="${loginUrl}" method="post"    >
                    <p>
                        <input type="text"  autofocus="autofocus" id="usuario" name="usuario" Placeholder="Usario" class="form-control" required>
                    </p> 
                    <p>
                        <input type="password" id="pass" name="pass" Placeholder="Constraseña" class="form-control" required>
                    </p> 
                    <input type="submit" class="btn btn-lg btn-primary btn-block btn-signin" value="Ingresar">
                    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                    <!--</fieldset>-->

                </form><!-- /form -->
                <a  href="http://www.bio.com.py" class="forgot-password">
                    BIO Soluciones Tecnológicas
                </a>                   
            </div><!-- /card-container -->
        </div><!-- /container -->

    </body>
</html>