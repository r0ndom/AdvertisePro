<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form>
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Город</label>
                <input type="text" placeholder="Город" class="form-control" id="city">
            </div>
            <div class="col-sm-4 form-group">
                <label>Район</label>
                <input type="text" placeholder="Район" class="form-control" id="district">
            </div>
            <div class="col-sm-4 form-group">
                <label>Координаты</label>
                <input type="text" placeholder="Координаты" class="form-control" id="coordinates">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-1 form-group">
                <label style="color: #ffffff">1</label>
                <select class="form-control">
                    <option><</option>
                    <option><=</option>
                    <option>></option>
                    <option>>=</option>
                    <option>=</option>
                </select>
            </div>
            <div class="col-sm-3 form-group">
                <label>Цена</label>
                <input type="text" placeholder="Цена размещения" class="form-control" id="price">
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form>