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
            <th>Логин</th>
            <th>Email</th>
            <th>Имя</th>
            <th>Адрес</th>
            <th>Номер телефона</th>
            <th>Роль</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.credentials.login}</td>
            <td>${user.contacts.email}</td>
            <td>${user.lastName} ${user.firstName} ${user.middleName}</td>
            <td>${user.contacts.postCode}, г. ${user.contacts.city}, ул. ${user.contacts.street}, д. ${user.contacts.house}, кв. ${user.contacts.flat}</td>
            <td>${user.contacts.phone}</td>
            <td>
                <c:if test="${user.role == 'ROLE_ADMIN'}">
                    <c:out value="Администратор"/>
                </c:if>
                <c:if test="${user.role == 'ROLE_AGENT'}">
                    <c:out value="Агент"/>
                </c:if>
                <c:if test="${user.role == 'ROLE_CLIENT'}">
                    <c:out value="Клиент"/>
                </c:if>
            </td>
            <td>
                <div class="dropdown">
                    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        Действие
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li><a href="/admin/updateUser/${user.id}">Редактировать</a></li>
                        <c:if test="${user.role != 'ROLE_ADMIN'}">
                            <li><a href="/admin/deleteUser/${user.id}">Удалить</a></li>
                        </c:if>
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
            <div class="error">Данного пользователя нельзя удалить, т.к. он сделал заказы на размещение рекламы!</div>
        </c:if>
    </div>
</div>

<div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
    <a href="<c:url value="/admin/agentRegistration"/>"><button id="addUser" class="btn btn-primary"
            data-toggle="modal">
        Создать агента
    </button></a>
</div>