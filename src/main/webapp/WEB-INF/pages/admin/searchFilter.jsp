<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form>
    <div class="col-sm-12">
        <div class="row">
            <div class="col-sm-12 form-group">
                <label>Логин</label>
                <input type="text" placeholder="Логин" class="form-control" id="login">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 form-group">
                <label>Email</label>
                <input type="text" placeholder="Email" class="form-control" id="email">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Фамилия</label>
                <input type="text" placeholder="Фамилия" class="form-control" id="lastName">
            </div>
            <div class="col-sm-4 form-group">
                <label>Имя</label>
                <input type="text" placeholder="Имя" class="form-control" id="firstName">
            </div>
            <div class="col-sm-4 form-group">
                <label>Отчество</label>
                <input type="text" placeholder="Отчество" class="form-control" id="middleName">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Город</label>
                <input type="text" placeholder="Город" class="form-control" id="city">
            </div>
            <div class="col-sm-6 form-group">
                <label>Улица</label>
                <input type="text" placeholder="Улица" class="form-control" id="street">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4 form-group">
                <label>Номер дома</label>
                <input type="text" placeholder="Номер дома" class="form-control" id="house">
            </div>
            <div class="col-sm-4 form-group">
                <label>Номер квартиры</label>
                <input type="text" placeholder="Еомер квартиры" class="form-control" id="flat">
            </div>
            <div class="col-sm-4 form-group">
                <label>Почтовый индекс</label>
                <input type="text" placeholder="Почтовый идекс" class="form-control" id="zip">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6 form-group">
                <label>Номер телефона</label>
                <input type="text" placeholder="Номер телефона" class="form-control" id="phone">
            </div>
            <div class="col-sm-6 form-group">
                <label>Роль</label>
                <select class="form-control">
                    <option>Администратор</option>
                    <option>Агент</option>
                    <option>Клиент</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div style="float: left" class="col-sm-4 form-group"><button type="submit" class="btn btn-lg btn-success">Поиск</button></div>
            <div style="float: right"><button type="reset" class="btn btn-lg btn-warning">Очистить</button></div>
        </div>
    </div>
</form>