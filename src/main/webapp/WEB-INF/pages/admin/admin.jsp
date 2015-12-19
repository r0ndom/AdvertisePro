<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sidebar.css">

    <div id="mainPage">

        <jsp:include page="../commons/header.jsp"/>
        <div>
            <div id="wrapper" class="active">
                <jsp:include page="menuAdmin.jsp"/>
                <div id="page-content-wrapper">
                    <div class="page-content inset">
                        <div class="row">
                            <div class="col-md-12">
                                <br>
                                <jsp:include page="searchFilter.jsp"/>
                                <jsp:include page="table.jsp"/>
                                <div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
                                    <button id="addUser" class="btn btn-primary"
                                            data-toggle="modal" data-target="#createUserModal">
                                        Создать пользователя
                                    </button>
                                </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</tag:layout>