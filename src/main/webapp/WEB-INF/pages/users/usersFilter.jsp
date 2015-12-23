<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form:form method="POST" action="/userTable">
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Логин</label>
                <form:input id="login" cssClass="form-control" path="login"  placeholder="Логин"/>
            </div>
            <div class="col-sm-6 form-group">
                <label>Email</label>
                <form:input id="email" cssClass="form-control" path="email"  placeholder="Email"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Фамилия</label>
                <form:input id="lastName" cssClass="form-control" path="lastName"  placeholder="Фамилия"/>
            </div>
            <div class="col-sm-4 form-group">
                <label>Имя</label>
                <form:input id="firsttName" cssClass="form-control" path="firstName"  placeholder="Имя"/>
            </div>
            <div class="col-sm-4 form-group">
                <label>Отчество</label>
                <form:input id="middleName" cssClass="form-control" path="middleName"  placeholder="Отчество"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Город</label>
                <form:input id="city" cssClass="form-control" path="city"  placeholder="Город"/>
            </div>
            <div class="col-sm-6 form-group">
                <label>Улица</label>
                <form:input id="street" cssClass="form-control" path="street"  placeholder="Улица"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Номер дома</label>
                <form:input id="house" cssClass="form-control" path="house"  placeholder="Номер дома"/>
            </div>
            <div class="col-sm-4 form-group">
                <label>Номер квартиры</label>
                <form:input id="flat" cssClass="form-control" path="flat"  placeholder="Номер квартиры"/>
            </div>
            <div class="col-sm-4 form-group">
                <label>Почтовый индекс</label>
                <form:input id="postCode" cssClass="form-control" path="postCode"  placeholder="Почтовый индекс"/>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Номер телефона</label>
                <form:input id="phone" cssClass="form-control" path="phone"  placeholder="Номер телефона"/>
            </div>
            <div class="col-sm-6 form-group">
                <label>Роль</label>
                <form:select path="role" cssClass="form-control" id="role">
                    <form:option value="${null}" label="Выберите роль"/>
                    <form:option value="ROLE_ADMIN" label="Администратор"/>
                    <form:option value="ROLE_AGENT" label="Агент"/>
                    <form:option value="ROLE_CLIENT" label="Клиент"/>
                </form:select>
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success" id="search">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form:form>