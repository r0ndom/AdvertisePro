<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
    function submit${param.action}Form() {
        var modal = $("#" + "${param.action}UserModal");
        var form = modal.find('#form');
        $.ajax({
            type: form.attr('method'),
            url: "/admin/${param.action}/",
            dataType : 'json',
            data : form.serialize(),
            success : function(response){
                if (response.status == 'FAIL') {
                    var result = "";
                    for (var i = 0; i < response.errorMessageList.length; i++) {
                        var item = response.errorMessageList[i];
                        result = result + "<br>" + item.message;

                    }
                    modal.find("#errors").html(result);
                } else {
                    window.location.href = "/admin/"
                }
            }
        });
    }
</script>
<div class="modal fade" id="${param.action}UserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">
                    <c:choose>
                        <c:when test="${param.action == 'create'}">
                            <spring:message code="messages.createUser"/>
                        </c:when>
                        <c:when test="${param.action == 'update'}">
                            <spring:message code="messages.updateUser"/>
                        </c:when>
                    </c:choose>
                </h4>
            </div>
            <form:form method="POST" id="form" commandName="user" action="javascript:void(null);" onsubmit="submit${param.action}Form()">
                <div class="modal-body">
                    <div id="errors" style="color: red"></div>
                    <form:hidden path="id"/>
                    <div class="row" <c:if test="${param.action == 'update'}">hidden="hidden"</c:if>>
                        <div class="col-md-3">
                            <label><spring:message code="messages.username"/></label>
                        </div>
                        <div class="col-md-9">
                            <form:input id="username" cssClass="form-control" path="username" required="required"/>
                        </div>
                    </div>
                    <p></p>
                    <jsp:include page="formFields.jsp"/>
                    <p></p>
                </div>
                <div class="modal-footer">
                    <div class="row"><div class="col-md-12">
                        <input class="btn btn-success" style="width: 100%; height: 40px"
                               value="<spring:message code="messages.submit"/>" type="submit"></div></div>
                </div>
            </form:form>
        </div>
    </div>
</div>
