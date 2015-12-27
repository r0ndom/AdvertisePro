<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
    <script>
        $(document).ready(function() {
            jQuery(function($){
                $("#accountNumber").mask("9999-9999-9999-9999");
            });

            $("#accountNumber").keydown(function (e) {
                e = e || event;
                if (e.ctrlKey || e.altKey || e.metaKey) return;
                var  chr = String.fromCharCode(e.keyCode);
                if (chr == null) return;
                if (e.keyCode != 8 && chr < '0' || chr > '9') return false;
            });
        });
    </script>

    <title>Оформление заказа</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Оформление заказа</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form:form method="POST" id="register" action="/client/order/${range.id}">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Фамилия *</label>
                                <input id="lastName" placeholder="${client.lastName}" class="form-control" disabled/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Имя *</label>
                                <input id="firstName" placeholder="${client.firstName}" class="form-control" disabled/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Отчество *</label>
                                <input id="middleName" placeholder="${client.middleName}" class="form-control" disabled/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <label>Тип услуги *</label>
                                <input id="serviceType" placeholder="${range.type}" class="form-control" disabled/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <label>Период услуги *</label>
                                <input id="servicePeriod" placeholder="${range.period}" class="form-control" disabled/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Город *</label>
                                <input id="city" placeholder="${range.city}" class="form-control" disabled/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Улица *</label>
                                <input id="street" placeholder="${range.street}" class="form-control" disabled/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Итоговая цена *</label>
                                <form:input id="total" cssClass="form-control" path="total" placeholder="${range.total}" disabled="true"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <label>Описание *</label>
                                <form:textarea id="description" cssClass="form-control" required="required" rows="5" path="description" maxlength="255" cssStyle="resize: vertical" placeholder="Описание"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Номер счёта *</label>
                                <form:input id="accountNumber" cssClass="form-control" required="required" path="accountNumber" maxlength="12" placeholder="____-____-____-____"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Добавить</button></div>
                            <div class="col-sm-6 form-group"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
                            <div><a href="<c:url value="/client"/>"><button type="button" class="btn btn-lg btn-danger">Отмена</button></a></div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>

</tag:layout>
