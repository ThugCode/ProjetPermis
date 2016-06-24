<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Ajouter une action
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <c:url value="/actions/submit" var="_url" />
                    <form:form cssClass="form-horizontal" id="form" method="post" action="${fn:escapeXml(_url)}" modelAttribute="_form">
                        <div class="box-body">
                            <form:input
	                            type="hidden"
	                            id="inputId"
	                            path="id"
                            />
                            <spring:bind path="name">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
	                                <form:label path="name" cssClass="control-label col-sm-2" for="inputName">
	                                    Nom
	                                </form:label>
	                                <div class="col-sm-10">
	                                    <form:input
	                                        type="text"
	                                        path="name"
	                                        class="form-control"
	                                        id="inputName"
	                                    />
	                                    <form:errors cssClass="help-block" path="name" />
	                                </div>
	                            </div>
                            </spring:bind>
                        </div>
                        <div class="box-footer">
                            <c:url value="/actions" var="_url" />
                            <a href="${fn:escapeXml(_url)}" class="btn btn-warning">
                                Annuler
                            </a>
                            <button type="submit" class="btn btn-bitbucket pull-right">
                                ${buttonSubmit}
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>