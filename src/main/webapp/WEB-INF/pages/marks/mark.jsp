<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>

    $(window).load(function() {

        $("#submitButton").on('click', function() {
            alert('Услуга добавлена в корзину!');
        });

        (function ($) {

            var RatingBar = function( element, options ) {

                var $me = $( element ).addClass( 'star-ctr' );

                var $bg, $fg, steps, wd, cc, sw, fw, cs, cw, ini;

                $bg = $me.children( 'ul' );
                $fg = $bg.clone().addClass( 'star-fg' ).css( 'width', 0 ).appendTo( $me );
                $bg.addClass( 'star-bg' );

                var starsCount = $me.children('ul').children('li').length / $me.children('ul').length;
                var anyStarSize = Math.round($me.width() / starsCount);

                var rating = $me.attr('data-value');

                $fg.css('width', anyStarSize * rating);
            };

            $.fn.ratingbar = function ( option ) {

                return this.each(function () {

                    var $this   = $( this );
                    var data    = $this.data( 'osb.ratingbar' );
                    var options = typeof option == 'object' && option;

                    if ( !data ) $this.data( 'osb.ratingbar', ( data = new RatingBar( this, options ) ) )

                })
            };

            $.fn.ratingbar.Constructor = RatingBar

        })(jQuery);

        $( '[data-role="ratingbar"]' ).ratingbar();
    });
</script>

<html>
<head>
</head>
<body>
<label>Рекомендуемое Вам: </label>

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
        <th>Оценка</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${marks}" var="mark">
        <tr>
            <td>${mark.type}</td>
            <td>${mark.period}</td>
            <td>${mark.servicePrice}</td>
            <td>${mark.city}</td>
            <td>${mark.street}</td>
            <td>${mark.placePrice}</td>
            <td>${mark.total}</td>
            <td>
                <div class="star-ctr" data-role="ratingbar" data-value="${mark.mark}">
                    <ul>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-star"></span></a></li>
                    </ul>
                </div>
            </td>
            <td>
                <a href="<c:url value="/client/order/${mark.id}"/>"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Заказать</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
