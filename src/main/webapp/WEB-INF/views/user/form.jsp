<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
    <jsp:attribute name="_page_title">
        Ajouter un utilisateur
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <form class="form-horizontal" method="post" action="#">
                        <div class="box-body">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputName">
                                    Nom
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="inputName"
                                        placeholder="Nom"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputSurname">
                                    Prénom
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="inputSurname"
                                        placeholder="Prénom"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputEmail">
                                    Adresse email
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="email"
                                        class="form-control"
                                        id="inputEmail"
                                        placeholder="Adresse email"
                                    />
                                </div>
                            </div>
                            <%-- @todo Hide if current user isn't an administrator --%>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <div class="checkbox">
                                        <label>
                                            <input
                                            type="checkbox"
                                            id="cbAdmin"
                                            />
                                            Est administrateur ?
                                        </label>
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
                    </form>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>