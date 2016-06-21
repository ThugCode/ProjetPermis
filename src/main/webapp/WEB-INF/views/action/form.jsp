<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Ajouter une action
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <c:url value="/actions/add" var="_url" />
                    <form class="form-horizontal" id="form" method="post" action="${fn:escapeXml(_url)}">
                        <div class="box-body">
                            <input
	                            type="hidden"
	                            id="inputId"
	                            name="inputId"
	                            value="${action.id}"
                            />
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputName">
                                    Nom
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="inputName"
                                        name="inputName"
                                        placeholder="Nom"
                                        value="${action.name}"
                                    />
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <c:url value="/actions/" var="_url" />
                            <a href="${fn:escapeXml(_url)}" class="btn btn-warning">
                                Annuler
                            </a>
                            <button type="submit" class="btn btn-bitbucket pull-right">
                                ${buttonSubmit}
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>