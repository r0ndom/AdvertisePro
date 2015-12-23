<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                        <li><a href="#">Редактировать</a></li>
                        <li><a href="#">Удалить</a></li>
                    </ul>
                </div>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
    <button id="addUser" class="btn btn-primary"
            data-toggle="modal" data-target="">
        Создать агента
    </button>
</div>