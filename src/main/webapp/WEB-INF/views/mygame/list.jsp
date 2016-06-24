<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<t:layout>
    <jsp:attribute name="_page_title">
        Mes formations
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <c:forEach items="${games}" var="item" varStatus="loop">
                <c:url value="/mygames/${item.id}" var="_url" />
                <a href="${fn:escapeXml(_url)}">
                    <div class="col-md-3 col-sm-6 col-xs-12">
                        <div class="info-box">
                            <span class="info-box-icon bg-navy">
                                <i class="fa fa-graduation-cap"></i>
                            </span>
                            <div class="info-box-content">
                                  <span class="info-box-text">
                                    ${fn:escapeXml(item.name)}
                                  </span>
                                  <span class="info-box-number">
                                    ${fn:length(item.missions)}
                                    <c:choose>
                                        <c:when test="${fn:length(item.missions) gt 1}">
                                            missions
                                        </c:when>
                                        <c:otherwise>
                                            mission
                                        </c:otherwise>
                                    </c:choose>
                                  </span>
                            </div>
                          </div>
                    </div>
                </a>
                <c:if test="${loop.index > 0 && loop.index % 2 == 1}">
                    <div class="clearfix visible-sm-block"></div>
                </c:if>
            </c:forEach>
        </div>
    </jsp:body>
</t:layout>