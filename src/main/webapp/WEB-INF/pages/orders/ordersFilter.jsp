<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form>
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Цена</label>
                <input type="text" placeholder="Цена" class="form-control" id="price">
            </div>
            <div class="col-sm-6 form-group">
                <label>Номер счёта</label>
                <input type="text" placeholder="Номер счёта`" class="form-control" id="bill">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Статус</label>
                <input type="text" placeholder="Статус" class="form-control" id="state">
            </div>
            <div class="col-sm-6 form-group">
                <label>Длительность</label>
                <input type="text" placeholder="Длительность" class="form-control" id="last">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 form-group">
                <label>Описание</label>
                <input type="text" placeholder="Описание" class="form-control" id="description">
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form>