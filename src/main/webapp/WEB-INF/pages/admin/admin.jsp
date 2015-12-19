<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <title>Страница администратора</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">

</head>

<body>

<div id="wrapper">

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

    <ul class="nav navbar-right top-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Логин <b class="caret"></b></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="#"><i class="fa fa-fw fa-user"></i> Профиль</a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="<c:url value="/login"/>"><i class="fa fa-fw fa-power-off"></i> Выйти</a>
                </li>
            </ul>
        </li>
    </ul>

    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav" id="menu">
            <li>
                <a href="#"> Пользователи</a>
            </li>
            <li>
                <a href="#"> Реклама</a>
            </li>
        </ul>
    </div>

</nav>

<div id="page-wrapper">

    <div class="container-fluid">

        <div id="pageContent">

        </div>

        <div id="tableContent">

        </div>

    </div>

</div>

</div>

<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#menu').find('li').click(function() {
            var activeLiIndex = $(this).index();
            switch (activeLiIndex) {
                case 0:
                    $("#pageContent").load("/adminFilter");
                    $("#tableContent").load("/adminTable");
                    break;
                case 1:
                    break;
            }
        });

        $("#pageContent").load("/adminFilter");
        $("#tableContent").load("/adminTable");
    });
</script>

</body>

</html>