<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="position: absolute">
    <div class="navbar-inner">
        <div class="container-fluid">
            <form action="<c:url value="/j_spring_security_logout"/>" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <button id="submitButton" type="submit" class="navbar-text navbar-right submitButton"
                        style="padding-right: 40px; padding-top: 10px">
                    <b>Выход</b>
                    <img style="height: 34px; width: 34px" src="${pageContext.request.contextPath}/resources/img/exit.png"/>
                </button>
            </form>
        </div>
    </div>
</nav>