<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script>
    $("#submitButton").on('click', function() {
        alert('Услуга добавлена в корзину!');
    });
</script>

<table class="table">
    <thead>
    <tr>
        <th>Тип услуги</th>
        <th>Период услуги</th>
        <th>Цена услуги</th>
        <th>Город</th>
        <th>Улица</th>
        <th>Цена размещения</th>
        <th>Итоговая цена</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${range}" var="r">
        <tr>
            <td>${r.type}</td>
            <td>${r.period}</td>
            <td>${r.servicePrice}</td>
            <td>${r.city}</td>
            <td>${r.street}</td>
            <td>${r.placePrice}</td>
            <td>${r.total}</td>
            <td>
                <a href="<c:url value="/client/order/${r.id}"/>"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Заказать</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>