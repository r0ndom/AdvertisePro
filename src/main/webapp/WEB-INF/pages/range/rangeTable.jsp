<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/resources/css/rating.css"/>" rel="stylesheet">

<style>
    .hidden {

    }
</style>

<script>

    $(window).load(function() {

        $('.hidden').hide();

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

                function initialize() {

                    ini = true;

                    // How many rating elements
                    cc = $bg.children().length;

                    steps = Math.floor( +( $me.attr( 'data-steps' ) || 0 ) );

                    // Total width of the bar
                    wd = $bg.width();

                }

                $me.on( 'click', function( e ) {

                    if ( !ini ) initialize();

                    var $li, dt, nm, nw, ns, ow, vl;

                    // Where is the mouse relative to the left
                    // side of the bar?
                    ow = dt = e.pageX - $me.offset().left;
                    vl = Math.round( ow / wd * cc * 10 ) / 10;

                    // steps == 0 means continous mode, so no need to
                    // waste time finding a snapping point
                    if ( steps > 0 ) {

                        $li = $( e.target ).closest( 'li' );
                        if ( !$li.length ) return;

                        // Find the per element step
                        vl = nm = $li.index();
                        ow = nw = $li.position().left;
                        cw = $li.outerWidth( true ) / steps;

                        // Now find any sub-step within an element
                        // when the number of steps is larger
                        // than the number of elements
                        ns = Math.round( ( dt - nw ) / cw );
                        ow = nw + ns * cw;

                        // The fractional part of the rating
                        vl += Math.round( ( ns / steps ) * 10 ) / 10;

                    }

                    $me.attr( 'data-value', vl );
                    var mark;
                    if (ow <= anyStarSize) {
                        mark = 1;
                        ow = anyStarSize * mark;
                    } else if (ow <= (anyStarSize * 2)) {
                        mark = 2;
                        ow = anyStarSize * mark;
                    } else if (ow <= (anyStarSize * 3)) {
                        mark = 3;
                        ow = anyStarSize * mark;
                    } else if (ow <= (anyStarSize * 4)) {
                        mark = 4;
                        ow = anyStarSize * mark;
                    }
                    else {
                        mark = 5;
                        ow = anyStarSize * mark;
                    }
                    $fg.css( 'width', Math.round( ow )+'px' );

                    var placeId = $(this).parent().siblings(':first').text();
                    $.post('/mark', {
                        placeId: placeId,
                        mark: mark
                    });

                    alert('Рейтинг услуги в выбранном Вами месте скоро обновится!');
                    alert('Перезагрузите страницу для просмотра рекомендуемых Вам товаров!');
                });
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

<table class="table">
    <thead>
    <tr>
        <th class="hidden"></th>
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
    <c:forEach items="${range}" var="r">
        <tr>
            <td class="hidden">${r.id}</td>
            <td>${r.type}</td>
            <td>${r.period}</td>
            <td>${r.servicePrice}</td>
            <td>${r.city}</td>
            <td>${r.street}</td>
            <td>${r.placePrice}</td>
            <td>${r.total}</td>
            <td>
                <div class="star-ctr" data-role="ratingbar" data-value="${r.mark}">
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
                <a href="<c:url value="/client/order/${r.id}"/>"><button type="submit" class="btn btn-lg btn-success" id="submitButton">Заказать</button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>