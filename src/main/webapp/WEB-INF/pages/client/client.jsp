<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <title>Клиент</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.js"/>"></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</head>

<body>

<div>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/client"/>">Клиент</a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${clientLogin}<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a
                                href="<c:url value="/client/info"/>"
                                ><i class="fa fa-fw fa-user"></i> Профиль</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="<c:url value="/login"/>"><i class="fa fa-fw fa-power-off"></i> Выйти</a>
                    </li>
                </ul>
            </li>
        </ul>

    </nav>

    <div id="page-wrapper">

        <div class="container-fluid">

            <div id="pageContent">
                <jsp:include page="/rangeFilter"/>
            </div>

            <div id="tableContent">
                <jsp:include page="/rangeTable"/>
            </div>

        </div>

    </div>

</div>

</body>

</html>