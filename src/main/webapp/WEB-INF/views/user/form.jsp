<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Ajouter un utilisateur
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <c:url value="/users/submit" var="_url" />
                    <form:form cssClass="form-horizontal" id="form" method="post" action="${fn:escapeXml(_url)}" modelAttribute="_form">
                        <div class="box-body">
	                        <form:input
                                type="hidden"
                                path="id"
                            />
                            <spring:bind path="lastname">
	                            <div class="form-group ${status.error ? 'has-error' : ''}">
	                                <form:label path="lastname" cssClass="control-label col-sm-2" for="inputLastName">
	                                    Nom
	                                </form:label>
	                                <div class="col-sm-10">
	                                    <form:input
	                                        type="text"
	                                        path="lastname"
	                                        cssClass="form-control"
	                                        id="inputLastName"
	                                    />
	                                    <form:errors cssClass="help-block" path="lastname" />
	                                </div>
	                            </div>
                            </spring:bind>
                            <spring:bind path="firstname">
	                            <div class="form-group ${status.error ? 'has-error' : ''}">
	                                <form:label path="firstname" cssClass="control-label col-sm-2" for="inputFirstName">
	                                    Prénom
	                                </form:label>
	                                <div class="col-sm-10">
	                                    <form:input
	                                        type="text"
	                                        path="firstname"
	                                        class="form-control"
	                                        id="inputFirstName"
	                                    />
	                                    <form:errors cssClass="help-block" path="firstname" />
	                                </div>
	                            </div>
                            </spring:bind>
                            <spring:bind path="password">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:label path="password" cssClass="control-label col-sm-2" for="inputPassword">
                                        Mot de passe
                                    </form:label>
                                    <div class="col-sm-10">
                                        <form:input
                                            type="password"
                                            path="password"
                                            class="form-control"
                                            id="inputPassword"
                                        />
                                        <form:errors cssClass="help-block" path="password" />
                                    </div>
                                </div>
                            </spring:bind>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputPasswordConfirmation">
                                    Confirmation du mot de passe
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="password"
                                        name="passwordConfirmation"
                                        class="form-control"
                                        id="inputPasswordConfirmation"
                                    />
                                </div>
                            </div>
                            <spring:bind path="mail">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
	                                <form:label path="mail" cssClass="control-label col-sm-2" for="inputEmail">
	                                    Adresse email
	                                </form:label>
	                                <div class="col-sm-10">
	                                    <form:input
	                                        type="email"
	                                        path="mail"
	                                        class="form-control"
	                                        id="inputEmail"
	                                    />
	                                    <form:errors cssClass="help-block" path="mail" />
	                                </div>
	                            </div>
                            </spring:bind>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <form:label path="isAdmin" for="inputIsAdmin">
                                            <form:checkbox
	                                            path="isAdmin"
	                                            id="inputIsAdmin"
                                            />
                                            Est administrateur ?
                                        </form:label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <form:label path="isEnabled" for="inputIsEnabled">
                                            <form:checkbox
	                                            path="isEnabled"
	                                            id="inputIsEnabled"
                                            />
                                            Compte activé ?
                                        </form:label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <c:url value="/users" var="_url" />
                            <a href="${fn:escapeXml(_url)}" class="btn btn-warning">
                                Annuler
                            </a>
                            <button type="submit" class="btn btn-bitbucket pull-right">
                                Créer
                            </button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>