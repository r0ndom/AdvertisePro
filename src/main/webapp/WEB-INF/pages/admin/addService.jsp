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
        $(document).ready(function() {
            $("#price").keydown(function (e) {
                e = e || event;
                if (e.ctrlKey || e.altKey || e.metaKey) return;
                var  chr = String.fromCharCode(e.keyCode);
                if (chr == null) return;
                var price = $("#price").val();
                if (e.keyCode == 190 && !(price.indexOf(".") > -1) && price.length > 0) return true;
                if (e.keyCode != 8 && chr < '0' || chr > '9') return false;
            });
        });
    </script>

    <title>Добавление услуги</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Добавление услуги</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form:form method="POST" id="register" action="/admin/addService">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Тип *</label>
                                <form:select path="type" cssClass="form-control" id="type" required="required">
                                    <form:option value="${null}" label="Выберите тип"/>
                                    <form:option value="Билборд" label="Билборд"/>
                                    <form:option value="Растяжка" label="Растяжка"/>
                                    <form:option value="В транспорте" label="В транспорте"/>
                                    <form:option value="На транспорте" label="На транспорте"/>
                                    <form:option value="Метро" label="Метро"/>
                                    <form:option value="Интернет баннеры" label="Интернет баннеры"/>
                                    <form:option value="Печатные СМИ" label="Печатные СМИ"/>
                                    <form:option value="Телевидение - бегущая строка" label="Телевидение - бегущая строка"/>
                                    <form:option value="Телевидение - видеоролик" label="Телевидение - видеоролик"/>
                                    <form:option value="Радио" label="Радио"/>
                                </form:select>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Период *</label>
                                <form:select path="period" cssClass="form-control" id="period" required="required">
                                    <form:option value="${null}" label="Выберите период"/>
                                    <form:option value="День" label="День"/>
                                    <form:option value="Неделя" label="Неделя"/>
                                    <form:option value="Месяц" label="Месяц"/>
                                    <form:option value="Квартал" label="Квартал"/>
                                    <form:option value="Полгода" label="Полгода"/>
                                    <form:option value="Год" label="Год"/>
                                </form:select>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Цена *</label>
                                <form:input id="price" cssClass="form-control" path="price" required="required" placeholder="Цена"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-7">
                                <c:if test="${error == false}">
                                    <div class="error">Услуга с указанным типом и периодом уже существует!</div>
                                </c:if>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Добавить</button></div>
                            <div class="col-sm-6 form-group"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
                            <div><a href="<c:url value="/admin"/>"><button type="button" class="btn btn-lg btn-danger">Отмена</button></a></div>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</tag:layout>
