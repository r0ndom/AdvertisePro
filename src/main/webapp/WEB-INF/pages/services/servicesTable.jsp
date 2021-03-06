<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    .error {
        padding: 15px;
        margin-bottom: 20px;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #a94442;
        background-color: #f2dede;
        border-color: #ebccd1;
    }
</style>

<table class="table">
    <thead>
    <tr>
        <th>Тип</th>
        <th>Цена</th>
        <th>Период</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${services}" var="service">
    <tr>
        <td>${service.type}</td>
        <td>${service.price}</td>
        <td>${service.period}</td>
        <td>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Действие
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="/admin/updateService/${service.id}">Редактировать</a></li>
                    <li><a href="/admin/deleteService/${service.id}">Удалить</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-md-7">
        <c:if test="${error == false}">
            <div class="error">Данную запись нельзя удалить, т.к. она имеет связь с таблицой "Места"!</div>
        </c:if>
    </div>
</div>

<div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
    <a href="<c:url value="/admin/addService"/>"><button id="addUser" class="btn btn-primary"
            data-toggle="modal">
        Добавить услугу
    </button></a>
</div>