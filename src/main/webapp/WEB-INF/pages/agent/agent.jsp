<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <title>Агент</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">

    <script src="<c:url value="/resources/js/jquery.js"/>"></script>

    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</head>

<body>

<div>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/agent"/>">Агент</a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${agentLogin}<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a
                                href="<c:url value="/agent/info"/>"
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

            <h1>Необработанных заказов - ${ordersCount}</h1>

            <c:if test="${orders.size() > 0}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Описание</th>
                        <th>Номер счёта</th>
                        <th>Статус заказа</th>
                        <th>Цена</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td><a href="/agent/orderInfo/${order.id}">${order.description}</a></td>
                            <td>${order.accountNumber}</td>
                            <td>
                                <c:if test="${order.status == 'Processed'}">
                                    <span class="label label-warning"><c:out value="Обрабатывается"/></span>
                                </c:if>
                                <c:if test="${order.status == 'Rejected'}">
                                    <span class="label label-danger"><c:out value="Отменен"/></span>
                                </c:if>
                                <c:if test="${order.status == 'Done'}">
                                    <span class="label label-success"><c:out value="Завершен"/></span>
                                </c:if>
                            </td>
                            <td>${order.total}</td>
                            <td>
                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        Действие
                                        <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                        <a href="/agent/submit/${order.id}"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Выполнить</button></a>
                                        <c:if test="${order.status == 'Processed'}">
                                            <a href="/agent/delete/${order.id}"><button type="submit" class="btn btn-lg btn-danger" id="rejectButton">Отменить</button></a>
                                        </c:if>
                                    </ul>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

        </div>

    </div>

</div>