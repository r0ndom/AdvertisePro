<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table">
    <thead>
        <tr>
        <th>Город</th>
        <th>Улица</th>
        <th>Цена</th>
        <th>Тип</th>
        <th>Период</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${places}" var="place">
    <tr>
        <td>${place.city}</td>
        <td>${place.street}</td>
        <td>${place.price}</td>
        <td>${place.serviceType}</td>
        <td>${place.servicePeriod}</td>
        <td>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Действие
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="/admin/updatePlace/${place.id}">Редактировать</a></li>
                    <li><a href="/admin/deletePlace/${place.id}">Удалить</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
    <a href="<c:url value="/admin/addPlace"/>"><button id="addUser" class="btn btn-primary"
            data-toggle="modal" data-target="#createUserModal">
        Добавить место
    </button></a>
</div>