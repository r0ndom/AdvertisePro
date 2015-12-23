<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <title>Информация об администраторе</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Информация об администраторе</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Логин</label>
                            ${admin.credentials.login}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Email</label>
                            ${admin.contacts.email}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Фамилия</label>
                            ${admin.lastName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Имя</label>
                            ${admin.firstName}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Отчество</label>
                            ${admin.middleName}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Город</label>
                            ${admin.contacts.city}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Улица</label>
                            ${admin.contacts.street}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Номер дома</label>
                            ${admin.contacts.house}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Номер квартиры</label>
                            ${admin.contacts.flat}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Почтовый индекс</label>
                            ${admin.contacts.postCode}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Номер телефона</label>
                            ${admin.contacts.phone}
                        </div>
                    </div>
                    <div class="row">
                        <div><a href="<c:url value="/admin"/>"><button type="button" class="btn btn-lg btn-success" style="margin-left: 15px">Назад</button></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</tag:layout>