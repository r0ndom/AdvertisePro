<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>

    <title>Информация о заказе</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Информация о заказе</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <div class="col-sm-12">
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
                        <div class="col-sm-6 form-group">
                            <label>Тип услуги</label>
                                ${place.serviceType}
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Период услуги</label>
                                ${place.servicePeriod}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4 form-group">
                            <label>Город</label>
                                ${place.city}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Улица</label>
                                ${place.street}
                        </div>
                        <div class="col-sm-4 form-group">
                            <label>Итоговая цена</label>
                                ${order.total}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12 form-group">
                            <label>Описание</label>
                                ${order.description}
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <label>Номер счёта</label>
                                ${order.accountNumber}
                        </div>
                        <div class="col-sm-6 form-group">
                            <label>Дата</label>
                                ${order.date}
                        </div>
                    </div>
                    <div class="row">
                        <div style="margin-left: 15px"><a href="<c:url value="/agent"/>"><button type="button" class="btn btn-lg btn-danger">Назад</button></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</tag:layout>

