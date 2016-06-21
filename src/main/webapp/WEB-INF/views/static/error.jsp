<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<t:layout>
    <jsp:attribute name="_page_title">Erreur</jsp:attribute>
    <jsp:body>
        <div class="error-page">
            <h2 class="headline text-red">500</h2>
            <div class="error-content">
                <h3>
                    <i class="fa fa-warning text-red"></i>
                    Oups! Une erreur est survenue.
                </h3>
                <p>${customMessage}</p>
                <p>${errorMessage}</p>
                <p style="text-align: justify;">
                    Nous n'avons pas pu générer la page que vous recherchez.
                    Vous pouvez <a href="/permis/">retourner au tableau de bord</a> ou utiliser le champ de recherche.
                </p>
                <form class="search-form">
                    <div class="input-group">
                        <input type="text" name="search" class="form-control" placeholder="Search">
                        <div class="input-group-btn">
                            <button type="submit" name="submit" class="btn btn-danger btn-flat">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
                <%--
                <c:if test="${not empty stackTrace && fn:length(stackTrace) gt 0}">
                 <ol>
                     <c:forEach items="${stackTrace}" var="item">
                         <li>
                             <strong>${item.fileName}</strong> à la ligne <strong>${item.lineNumber}</strong><br/>
                             <code>${item.className}.${item.methodName}()</code>
                         </li>
                     </c:forEach>
                 </ol>
             </c:if>
             --%>
            </div>
        </div>
    </jsp:body>
</t:layout>