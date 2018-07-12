<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="loginUrl" value="/login" />
<h1 class="title"><spring:message code="login.title" /></h1>
<form action="${loginUrl}" method="post" class="loggin-form">
    <c:if test="${param.error != null}">
        <div class="alert alert-danger">
            <p>Invalid username and password.</p>
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            <p>You have been logged out successfully.</p>
        </div>
    </c:if>
    <c:if test="${param.accessDenied !=null}">
        <div class="alert alert-danger">
            <p>Access Denied: You are not authorised!</p>
        </div>
    </c:if>
    <div class="form-group">
        <label for="email"><spring:message code="label.email" /></label>
        <input class="form-control" id="email" placeholder="Enter email" name="email" />
    </div>
    <div class="form-group">
        <label for="password"><spring:message code="label.password" /></label>
        <input class="form-control" id="password" placeholder="Password" name="password" type="password"/>
    </div>
    <div class="form-check">
        <label>
            <input type="checkbox" name="remember-me"/> Remember Me?
        </label>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-success"><spring:message code="button.signin" /></button>
</form>