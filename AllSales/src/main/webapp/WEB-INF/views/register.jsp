<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="title"><spring:message code="register.title" /></h1>
<form:form modelAttribute="user" method="POST" enctype="multipart/form-data">
    <div class="form-group">
        <label for="email"><spring:message code="label.email" /></label>
        <form:input class="form-control" id="email" placeholder="Enter email" path="email" />
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        <div class="error"><form:errors path="email" /></div>
    </div>
    <div class="form-group">
        <label for="password"><spring:message code="label.password" /></label>
        <form:password class="form-control" id="password" placeholder="Password" path="password" />
        <div class="error"><form:errors path="password" /></div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="first-name"><spring:message code="label.firstname" /></label>
            <form:input class="form-control" id="first-name" placeholder="First name" path="firstName" />
            <div class="error"><form:errors path="firstName" /></div>
        </div>
        <div class="form-group col-md-6">
            <label for="last-name"><spring:message code="label.lastname" /></label>
            <form:input class="form-control" id="last-name" placeholder="Last name" path="lastName" />
            <div class="error"><form:errors path="lastName" /></div>
        </div>
    </div>
    <div class="form-group">
        <label for="address"><spring:message code="label.address" /></label>
        <form:input type="text" class="form-control" id="address"
                    placeholder="Apartment, studio, or floor" path="address.street" />
        <div class="error"><form:errors path="address.street" /></div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="city"><spring:message code="label.city" /></label>
            <form:input type="text" class="form-control" id="city" placeholder="City" path="address.city" />
            <div class="error"><form:errors path="address.city" /></div>
        </div>
        <div class="form-group col-md-4">
            <label for="state"><spring:message code="label.state" /></label>
            <form:input type="text" class="form-control" id="state" placeholder="State" path="address.state" />
            <div class="error"><form:errors path="address.state" /></div>
        </div>
        <div class="form-group col-md-2">
            <label for="zip"><spring:message code="label.zip" /></label>
            <form:input type="text" class="form-control" id="zip" placeholder="52556" path="address.zip" />
            <div class="error"><form:errors path="address.zip" /></div>
        </div>
    </div>
    <div class="form-group">
        <label for="profile-picture"><spring:message code="label.profile-picture" /></label>
        <form:input type="file" class="form-control" id="profile-picture" path="profilePicture" />
        <div class="error"><form:errors path="profilePicture" /></div>
    </div>
    <button type="submit" class="btn btn-success"><spring:message code="button.signup" /></button>
</form:form>