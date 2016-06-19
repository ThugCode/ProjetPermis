<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>
            AdN Formations - Connexion
        </title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/skins/square/blue.css" media="screen" />
        <c:url value="/assets/css/login.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${_url}"/>
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition login-page">
    	<div class="login-box">
	    	<div class="login-logo">
    			<b>Aéroport</b> de Nice
	    	</div>
	    	<div class="login-box-body">
	    		<p class="login-box-msg">
	    			<b>Connectez-vous</b> pour démarrer votre session
	    		</p>
	    		<c:url value="/login" var="_url" />
	    		<form method="post" action="${_url}">
	    			<div class="form-group has-feedback<c:if test="${not empty _error_email}"> has-error</c:if>">
				        <input
					        type="email"
					        name="email"
					        class="form-control"
					        placeholder="Adresse email"
					        <c:if test="${not empty _last_email}">
					        	value="${fn:escapeXml(_last_email)}"
					        </c:if>
				        />
				        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				        <c:if test="${not empty _error_email}">
				            <span class="help-block">${_error_email}</span>
				        </c:if>
				    </div>
				    <div class="form-group has-feedback<c:if test="${not empty _error_password}"> has-error</c:if>">
				        <input
					        type="password"
					        name="password"
					        class="form-control"
					        placeholder="Mot de passe"
					        name=""
				        />
				        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        <c:if test="${not empty _error_password}">
                            <span class="help-block">${_error_password}</span>
                        </c:if>
				    </div>
				    <c:if test="${not empty _error}">
					    <p class="text-red text-justify">
	                        ${_error}
	                    </p>
				    </c:if>
				    <div class="row">
				        <div class="col-xs-8">
				          	<div class="checkbox icheck">
				            	<label>
				              		<input
				              		type="checkbox"
				              		name="remember_me"
				              		<c:if test="${not empty _remember_me && _remember_me}">
				              		    checked="checked"
				              		</c:if>
				              		/> 
				              		Se souvenir de moi
					            </label>
				          	</div>
				        </div>
				        <!-- /.col -->
				        <div class="col-xs-4">
				          	<button type="submit" class="btn btn-primary btn-block btn-flat">Connexion</button>
				        </div>
				        <!-- /.col -->
				    </div>
	    		</form>
	    		<c:url value="/register" var="_url" />
	    		<br/>
	    		Vous n'avez pas de compte ?
				<a class="text-center" href="${_url}">
					Demander un compte
				</a>
	    	</div>
    	</div>
    	
    	<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/icheck.min.js"></script>
        <script type="text/javascript">
        	$(function() {
        		$("input").iCheck({
       		      	checkboxClass: "icheckbox_square-blue",
       		      	radioClass: "iradio_square-blue",
       		      	increaseArea: "20%"
       		    });
        	});
        </script>
    </body>
   </html>