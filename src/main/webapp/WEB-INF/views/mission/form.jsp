<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:layout>
    <jsp:attribute name="_page_title">Ajouter une mission</jsp:attribute>
    <jsp:attribute name="_page_scripts">
        <c:url value="/assets/js/mission/form.js" var="_url" />
        <script type="text/javascript" src="${fn:escapeXml(_url)}"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="col-md-12 col-lg-8 col-lg-offset-2">
                <div class="box box-primary">
                    <c:url value="/missions/submit" var="_url" />
                    <form class="form-horizontal" id="form" method="post" action="${fn:escapeXml(_url)}">
                        <div class="box-body">
                            <input
	                            type="hidden"
	                            id="inputId"
	                            name="inputId"
	                            value="${mission.id}"
                            />
                            <input
	                            type="hidden"
	                            id="inputGoals"
	                            name="inputGoals"
                            />
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="inputTitle">
                                    Titre
                                </label>
                                <div class="col-sm-10">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="inputTitle"
                                        name="inputTitle"
                                        placeholder="Titre"
                                        value="${mission.title}"
                                    />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">
                                    Objectif(s) requis
                                </label>
                                <div class="col-sm-10">
	                                <div class="panel panel-default">
	                                    <div id="panelCards" class="panel-body">
	                                        <c:if test="${empty mission.goals}">
	                                            Aucun objectif pour le moment
	                                        </c:if>
	                                        <c:forEach items="${mission.goals}" var="item">
	                                            <div class="col-md-3 card" data-id="${item.id}">
	                                                <div class="box box-warning">
	                                                    <div class="box-header with-border">
	                                                        <h3 class="box-title">${item.name}</h3>
	                                                        <div class="box-tools pull-right">
	                                                            <button type="button" class="btn btn-box-tool" data-widget="remove">
	                                                                <i class="fa fa-times"></i>
	                                                            </button>
	                                                        </div>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </c:forEach>
	                                    </div>
	                                    <div class="panel-footer text-center">
	                                        <button id="addGoal" type="button" class="btn btn-bitbucket" data-toggle="modal" data-target="#goalModal">
	                                            <i class="fa fa-plus"></i>
	                                            Ajouter un objectif
	                                        </button>
	                                    </div>
	                                </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <c:url value="/missions" var="_url" />
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
        
        <div class="modal modal-default fade" id="goalModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                        <h4 class="modal-title">Ajouter des objectifs</h4>
                    </div>
                    <div class="modal-body">
                        <table class="table table-bordered">
                            <tbody>
                                <c:forEach items="${goals}" var="item">
                                    <tr>
                                        <td style="width: 40px" class="text-center">
                                            <input
                                                type="checkbox"
                                                id="objective-${item.id}"
                                                value="${item.id}"
                                            />
                                        </td>
                                        <td>
                                            <label for="objective-${item.id}" class="boldless">
                                                ${item.name}
                                            </label>
                                        </td>
                                    </tr>
                                </c:forEach>
                              </tbody>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary pull-left" data-dismiss="modal">Annuler</button>
                        <button id="saveGoals" type="button" class="btn btn-primary">Sauvegarder</button>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:layout>