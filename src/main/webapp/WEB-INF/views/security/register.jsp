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
            [Nom du site]
            &raquo; Inscription
        </title>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" media="screen" />
        <c:url value="/assets/css/admin-lte.min.css" var="_url" />
        <link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" media="screen" />
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/iCheck/1.0.2/skins/square/blue.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/register.css"/>
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition register-page">
    	<div class="register-box">
	    	<div class="register-logo">
	    		<c:url value="/login" var="_url" />
	    		<a href="${_url}">
	    			<b>Aéroport</b> de Nice
	    		</a>
	    	</div>
	    	<div class="register-box-body">
	    		<p class="login-box-msg">
	    			<b>Demandez</b> votre compte pour parcourir la plateforme. Vous recevrez un mail de confirmation lorsqu'il sera disponible.
	    		</p>
	    		<c:url value="/register" var="_url" />
	    		<form method="post" action="${_url}">
	    			<div class="form-group has-feedback">
				        <input type="text" class="form-control" placeholder="NOM Prénom">
			        	<span class="glyphicon glyphicon-user form-control-feedback"></span>
			      	</div>
			      	<div class="form-group has-feedback">
				        <input type="email" class="form-control" placeholder="Email">
				        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			    	</div>
				    <div class="form-group has-feedback">
				        <input type="password" class="form-control" placeholder="Mot de passe">
				        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
				    </div>
				    <div class="form-group has-feedback">
				        <input type="password" class="form-control" placeholder="Vérification mot de passe">
				        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
				    </div>
				    <div class="row">
				        <div class="col-xs-8">
				          	<div class="checkbox icheck">
				            	<label>
				              		<input type="checkbox"/> 
				              		<span class="text-checkbox">
				              			J'accepte la <a href="#">charte de l'aéroport de Nice</a>
				              		</span>
			            		</label>
				          	</div>
			        	</div>
				        <!-- /.col -->
				        <div class="col-xs-4">
				          	<button id="register-btn" type="submit" class="btn btn-primary btn-block btn-flat">Valider</button>
				        </div>
				        <!-- /.col -->
				    </div>
				    <div class="row all-width">
				    	Vous avez déjà un compte ? 
				    	<c:url value="/login" var="_url" />
						<a href="${_url}">
							Se connecter
						</a>
				    </div>
	    		</form>
	    		
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