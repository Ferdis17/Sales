<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="title"><spring:message code="postdeal.title" /></h1>
<p>Help others save money by finding the lowest price, best deals, and hot coupons.</p>
<form:form modelAttribute="deal" enctype="multipart/form-data">
    <div class="form-group">
        <label for="dealUrl"><spring:message code="label.dealUrl" /></label>
        <form:input class="form-control" placeholder="Deal URL" path="dealUrl" />
        <div class="error"><form:errors path="dealUrl" /></div>
    </div>
    <div class="form-group">
        <label for="dealTitle"><spring:message code="label.dealTitle" /></label>
        <form:input class="form-control" placeholder="Deal Title" path="dealTitle" />
        <div class="error"><form:errors path="dealTitle" /></div>
    </div>
    <div class="form-group">
        <label for="price"><spring:message code="label.price" /></label>
        <form:input class="form-control" placeholder="Price" path="price" />
        <div class="error"><form:errors path="price" /></div>
    </div>
    <div class="form-group">
        <label for="description"><spring:message code="label.description" /></label>
        <form:textarea path="description" class="form-control"></form:textarea>
        <div class="error"><form:errors path="description" /></div>
    </div>
    <div class="form-group">
        <label for="category"><spring:message code="label.category" /></label>
        <form:select class="form-control" id="category" path="dealCategory.id" >
            <form:option value="0"><spring:message code="label.selectCategory" /></form:option>
            <form:options items="${categories}" itemLabel="name" itemValue="id" />
        </form:select>
        <div class="error"><form:errors path="dealCategory" /></div>
    </div>
    <div class="form-group">
        <label for="store"><spring:message code="label.store" /></label>
        <form:select class="form-control" id="store" path="store.id" >
            <form:option value="0"><spring:message code="label.selectStore" /></form:option>
            <form:options items="${stores}" itemLabel="name" itemValue="id" />
        </form:select>
        <div class="error"><form:errors path="store" /></div>
    </div>
    <div class="form-group">
        <label for="dealImage"><spring:message code="label.dealImage" /></label>
        <form:input type="file" class="form-control" id="dealImage" path="dealImage" />
        <div class="error"><form:errors path="dealImage" /></div>
    </div>
    <div class="form-row">
        <div class="form-check">
            <label class="form-check-label">
                <form:checkbox class="form-check-input" path="isFeature" />
                Feature deal
            </label>
        </div>&nbsp;
        <div class="form-check">
            <label class="form-check-label">
                <form:checkbox class="form-check-input" path="isFrontPage" />
                Frontpage deal
            </label>
        </div>
    </div>
    <button type="submit" class="btn btn-success"><spring:message code="button.post" /></button>
</form:form>