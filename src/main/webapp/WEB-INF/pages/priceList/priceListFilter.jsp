<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form:form>
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Город</label>
                <input type="text" placeholder="Город" class="form-control" id="city">
            </div>
            <div class="col-sm-4 form-group">
                <label>Улица</label>
                <input type="text" placeholder="Улица" class="form-control" id="district">
            </div>
            <div class="col-sm-4 form-group">
                <label>Тип</label>
                <%--<form:input id="type" cssClass="form-control" path="type"  placeholder="Тип"/>--%>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Цена</label>
                <%--<form:input id="type" cssClass="form-control" path="price"  placeholder="Цена" required="required"/>--%>
            </div>
            <div class="col-sm-4 form-group">
                <label>Период</label>
                <%--<form:select path="period" cssClass="form-control" id="period">--%>
                    <%--<form:option value="${null}" label="Выберите период" disabled="true"/>--%>
                    <%--<form:option value="День" label="День"/>--%>
                    <%--<form:option value="Неделя" label="Неделя"/>--%>
                    <%--<form:option value="Месяц" label="Месяц"/>--%>
                    <%--<form:option value="Квартал" label="Квартал"/>--%>
                    <%--<form:option value="Полгода" label="Полгода"/>--%>
                    <%--<form:option value="Год" label="Год"/>--%>
                <%--</form:select>--%>
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form:form>