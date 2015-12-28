<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <title>Информация о агенте</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Информация о агенте</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Логин</label>
                                ${agent.credentials.login}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Email</label>
                                ${agent.contacts.email}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Фамилия</label>
                                ${agent.lastName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Имя</label>
                                ${agent.firstName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Отчество</label>
                                ${agent.middleName}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Город</label>
                                ${agent.contacts.city}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Улица</label>
                                ${agent.contacts.street}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Номер дома</label>
                                ${agent.contacts.house}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Номер квартиры</label>
                                ${agent.contacts.flat}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Почтовый индекс</label>
                                ${agent.contacts.postCode}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Номер телефона</label>
                                ${agent.contacts.phone}
                        </div>
                    </div>
                    <div class="row">
                        <div><a href="<c:url value="/agent"/>"><button type="button" class="btn btn-lg btn-success" style="margin-left: 15px">Назад</button></a></div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</tag:layout>
