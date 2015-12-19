<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="modal fade" id="deleteUserModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel"><spring:message code="messages.deleteUser"/></h4>
            </div>
            <div class="modal-body">
                <span><spring:message code="messages.deleteConfirmation"/></span>
                <span id="deleteUserIdHidden" hidden="hidden"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="messages.no"/></button>
                <button type="button" class="btn btn-primary" onclick="deleteUser()"> <spring:message code="messages.yes"/></button>
            </div>
        </div>
    </div>
</div>
