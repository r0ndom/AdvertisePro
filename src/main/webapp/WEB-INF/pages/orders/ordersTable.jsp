<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table class="table">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Тип</th>
        <th>Описание</th>
        <th>Номер счёта</th>
        <th>Статус</th>
        <th>Цена</th>
        <th>Место размещения</th>
        <th>Длительность</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Действие
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="#">Редактировать</a></li>
                    <li><a href="#">Удалить</a></li>
                </ul>
            </div>
        </td>
    </tr>
    </tbody>
</table>