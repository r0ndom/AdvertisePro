<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <title>Администратор</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.js"/>"></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</head>

<body>

<div id="wrapper">

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/admin"/>">Администратор</a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${adminLogin} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a
                                href="<c:url value="/admin/info"/>"
                                ><i class="fa fa-fw fa-user"></i> Профиль</a>
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
                <li id="li0">
                    <a href="<c:url value="/admin/0"/>"> Пользователи</a>
                </li>
                <li id="li1">
                    <a href="<c:url value="/admin/1"/>"> Услуги</a>
                </li>
                <li id="li2">
                    <a href="<c:url value="/admin/2"/>"> Места</a>
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

<script type="text/javascript">
    var pageContent = $("#pageContent");
    var tableContent = $("#tableContent");

    $(document).ready(function() {
        $('#menu').find('li').click(function() {
            var activeLiIndex = $(this).index();
            switch (activeLiIndex) {
                case 0:
                    pageContent.load("/userFilter");
                    tableContent.load("/userTable");
                    break;
                case 1:
                    pageContent.load("/servicesFilter");
                    tableContent.load("/servicesTable");
                    break;
                case 2:
                    pageContent.load("/priceListFilter");
                    tableContent.load("/priceListTable");
                    break;
            }
        });

        switch (${index}) {
            case 0:
                pageContent.load("/userFilter");
                tableContent.load("/userTable");
                break;
            case 1:
                pageContent.load("/servicesFilter");
                tableContent.load("/servicesTable");
                break;
            case 2:
                pageContent.load("/priceListFilter");
                tableContent.load("/priceListTable");
                break;
        }

        $("#li" + ${index}).addClass("active");
    });
</script>

</body>

</html>