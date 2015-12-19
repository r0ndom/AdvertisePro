<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.email"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="email" cssClass="form-control" path="email" required="required"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.password"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="password" cssClass="form-control" path="password" required="required"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.name"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="name" cssClass="form-control" path="name" required="required"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.surname"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="surname" cssClass="form-control" path="surname" required="required"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.phone"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="number" cssClass="form-control" path="number" required="required" pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$"/>
        <span>
            <p><spring:message code="messages.example"/></p>
            <spring:message code="messages.numbers"/>
        </span>
    </div>
</div>
<p></p>

<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.address"/></label>
    </div>
    <div class="col-md-9">
        <form:input id="address" cssClass="form-control" path="address" required="required"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.gender"/></label>
    </div>
    <div class="col-md-9">
        <form:select id="gender" cssClass="form-control" path="gender" required="required" items="${genders}" itemLabel="viewName"/>
    </div>
</div>
<p></p>
<div class="row">
    <div class="col-md-3">
        <label><spring:message code="messages.role"/></label>
    </div>
    <div class="col-md-9">
        <form:select id="authorities" cssClass="form-control" path="authorities" required="required" items="${roles}" itemLabel="roleViewName"/>
    </div>
</div>
<p></p>