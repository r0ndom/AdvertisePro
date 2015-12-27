<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <title>Информация о клиенте</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Информация о клиенте</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Логин</label>
                                ${client.credentials.login}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Email</label>
                                ${client.contacts.email}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Фамилия</label>
                                ${client.lastName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Имя</label>
                                ${client.firstName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Отчество</label>
                                ${client.middleName}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Город</label>
                                ${client.contacts.city}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Улица</label>
                                ${client.contacts.street}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Номер дома</label>
                                ${client.contacts.house}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Номер квартиры</label>
                                ${client.contacts.flat}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Почтовый индекс</label>
                                ${client.contacts.postCode}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Номер телефона</label>
                                ${client.contacts.phone}
                        </div>
                    </div>
                    <div class="row">
                        <div><a href="<c:url value="/client"/>"><button type="button" class="btn btn-lg btn-success" style="margin-left: 15px">Назад</button></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</tag:layout>