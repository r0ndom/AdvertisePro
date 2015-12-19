<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form>
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Тип</label>
                <input type="text" placeholder="Тип" class="form-control" id="type">
            </div>
            <div class="col-sm-4 form-group">
                <label>Цена</label>
                <input type="text" placeholder="Цена" class="form-control" id="price">
            </div>
            <div class="col-sm-4 form-group">
                <label>Период</label>
                <input type="text" placeholder="Период" class="form-control" id="age">
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form>