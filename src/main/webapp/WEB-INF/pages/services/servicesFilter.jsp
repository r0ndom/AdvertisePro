<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script>
    $(document).ready(function() {
        $("#price").keydown(function (e) {
            e = e || event;
            if (e.ctrlKey || e.altKey || e.metaKey) return;
            var  chr = String.fromCharCode(e.keyCode);
            if (chr == null) return;
            if (e.keyCode != 8 && chr < '0' || chr > '9') return false;
        });
    });
</script>

<form:form method="POST" action="/servicesTable">
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Тип</label>
                <form:select path="type" cssClass="form-control" id="type">
                    <form:option value="${null}" label="Выберите тип" disabled="true"/>
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
                <label>Период</label>
                <form:select path="period" cssClass="form-control" id="period">
                    <form:option value="${null}" label="Выберите период" disabled="true"/>
                    <form:option value="День" label="День"/>
                    <form:option value="Неделя" label="Неделя"/>
                    <form:option value="Месяц" label="Месяц"/>
                    <form:option value="Квартал" label="Квартал"/>
                    <form:option value="Полгода" label="Полгода"/>
                    <form:option value="Год" label="Год"/>
                </form:select>
            </div>
            <div class="col-sm-4 form-group">
                <label>Цена</label>
                <form:input id="price" cssClass="form-control" path="price"  placeholder="Цена"/>
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form:form>