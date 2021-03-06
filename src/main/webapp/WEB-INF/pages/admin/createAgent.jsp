<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>
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

    <script>
        jQuery(function($){
            $("#phone").mask("+99(999)999-99-99");
        });

        $(document).ready(function() {
            $("#postCode").keydown(function (e) {
                e = e || event;
                if (e.ctrlKey || e.altKey || e.metaKey) return;
                var  chr = String.fromCharCode(e.keyCode);
                if (chr == null) return;
                if (e.keyCode != 8 && chr < '0' || chr > '9') return false;
            });
        });
    </script>

    <title>Создание агента</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Создание агента</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form:form method="POST" id="register" action="/admin/agentRegistration">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <label>Логин *</label>
                                <form:input id="login" cssClass="form-control" path="credentials.login" required="required" placeholder="Логин"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <label>Email *</label>
                                <form:input id="email" cssClass="form-control" path="contacts.email" required="required" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <label>Пароль *</label>
                                <form:password id="password" cssClass="form-control" path="credentials.password" required="required" placeholder="Пароль"/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <label>Повторите пароль *</label>
                                <form:password id="secondPassword" cssClass="form-control" path="credentials.secondPassword" required="required" placeholder="Пароль"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Фамилия *</label>
                                <form:input id="lastName" cssClass="form-control" path="lastName" required="required" placeholder="Фамилия"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Имя *</label>
                                <form:input id="firsttName" cssClass="form-control" path="firstName" required="required" placeholder="Имя"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Отчество *</label>
                                <form:input id="middleName" cssClass="form-control" path="middleName" required="required" placeholder="Отчество"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 form-group">
                                <label>Город *</label>
                                <form:input id="city" cssClass="form-control" path="contacts.city" required="required" placeholder="Город"/>
                            </div>
                            <div class="col-sm-6 form-group">
                                <label>Улица *</label>
                                <form:input id="street" cssClass="form-control" path="contacts.street" required="required" placeholder="Улица"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Номер дома *</label>
                                <form:input id="house" cssClass="form-control" path="contacts.house" required="required" placeholder="Номер дома"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Номер квартиры *</label>
                                <form:input id="flat" cssClass="form-control" path="contacts.flat" required="required" placeholder="Номер квартиры"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Почтовый индекс *</label>
                                <form:input id="postCode" cssClass="form-control" path="contacts.postCode" required="required" placeholder="Почтовый индекс"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <label>Номер телефона *</label>
                                <form:input id="phone" cssClass="form-control" path="contacts.phone" required="required" placeholder="+__(___)___-__-__"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-7">
                                <c:if test="${error == false}">
                                    <div class="error">${errorMessage}</div>
                                </c:if>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Создать</button></div>
                            <div class="col-sm-6 form-group"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
                            <div><a href="<c:url value="/admin"/>"><button type="button" class="btn btn-lg btn-danger">Отмена</button></a></div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</tag:layout>
