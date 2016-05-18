<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>
			[Nom du site]
			<c:if test="${not empty _page_title}">
				&raquo; ${fn:escapeXml(_page_title)}
			</c:if>
		</title>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" media="screen" />
		<c:url value="/assets/css/general.css" var="_url" />
		<link rel="stylesheet" type="text/css" href="${fn:escapeXml(_url)}" />
		<c:if test="${not empty _page_stylesheets}">
			${_page_stylesheets}
		</c:if>
		<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
	</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Afficher / Cacher la navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <c:url value="/" var="_url" />
                    <a class="navbar-brand" href="${fn:escapeXml(_url)}">
                        [Nom du site]
                    </a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                	<ul class="nav navbar-nav">
                	</ul>
                	<ul class="nav navbar-nav navbar-right">
                	</ul>
            	</div>
        	</div>
        </nav>
        <div class="container">
        	<c:if test="${not empty _page_body}">
        		${_page_body}
        	</c:if>
        </div>
	
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
        <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <c:if test="${not empty _page_scripts}">
            ${_page_scripts}
        </c:if>
	</body>
</html>