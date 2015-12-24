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
        //        $(document).ready(function() {
        //            $("#submitButton").click(function() {
        //
        //            });
        //        });
    </script>

    <title>Добавление места</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">

    <div class="container">
        <h1 class="well">Добавление места</h1>
        <div class="col-lg-12 well">
            <div class="row">
                <form:form method="POST" id="register" action="/admin/addPlace">
                    <div class="col-sm-12">
                        <div class="row">
                            <div class="col-sm-4 form-group">
                                <label>Город *</label>
                                <form:input id="city" cssClass="form-control" path="city" required="required" placeholder="Город"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Улица *</label>
                                <form:input id="street" cssClass="form-control" path="street" required="required" placeholder="Улица"/>
                            </div>
                            <div class="col-sm-4 form-group">
                                <label>Цена *</label>
                                <form:input id="price" cssClass="form-control" path="price" required="required" placeholder="Цена"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 form-group">
                                <label>Тип-Период *</label>
                                <form:select path="serviceType" cssClass="form-control" id="serviceType">
                                    <c:forEach items="${services}" var="service">
                                        <form:option value="${service.type} - ${service.period}" label="${service.type} - ${service.period}"/>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-7">
                                <c:if test="${error == false}">
                                    <div class="error">Место с указанным городом, улицей, типом и периодом уже существует!</div>
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
