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
	    			<b>ABC</b>DEF
	    		</a>
	    	</div>
	    	<div class="register-box-body">
	    		<p class="login-box-msg">
	    			Création d'un nouveau compte
	    		</p>
	    		<c:url value="/register" var="_url" />
	    		<form method="post" action="${_url}">
	    			<div class="form-group has-feedback">
				        <input type="text" class="form-control" placeholder="Full name">
			        	<span class="glyphicon glyphicon-user form-control-feedback"></span>
			      	</div>
			      	<div class="form-group has-feedback">
				        <input type="email" class="form-control" placeholder="Email">
				        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			    	</div>
				    <div class="form-group has-feedback">
				        <input type="password" class="form-control" placeholder="Password">
				        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
				    </div>
				    <div class="form-group has-feedback">
				        <input type="password" class="form-control" placeholder="Retype password">
				        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
				    </div>
				    <div class="row">
				        <div class="col-xs-8">
				          	<div class="checkbox icheck">
				            	<label>
				              		<input type="checkbox"> I agree to the <a href="#">terms</a>
			            		</label>
				          	</div>
			        	</div>
				        <!-- /.col -->
				        <div class="col-xs-4">
				          	<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
				        </div>
				        <!-- /.col -->
				    </div>
	    		</form>
	    		<c:url value="/login" var="_url" />
				<a class="text-center" href="${_url}">
					Je suis déjà inscrit
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