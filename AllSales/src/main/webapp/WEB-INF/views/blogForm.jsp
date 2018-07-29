<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="title"><spring:message code="postblog.title" /></h1>
<form:form modelAttribute="blog" enctype="multipart/form-data">
    <div class="form-group">
        <label for="title"><spring:message code="title" /></label>
        <form:input class="form-control" placeholder="Blog Title" path="title" />
        <div class="error"><form:errors path="title" /></div>
    </div>
    <div class="form-group">
        <label for="content"><spring:message code="content" /></label>
        <form:textarea path="content" class="form-control" ></form:textarea>
        <div class="error"><form:errors path="content" /></div>
    </div>
    <div class="form-group">
        <label for="category"><spring:message code="label.category" /></label>
        <form:select class="form-control" id="category" path="blogCategory.id" >
            <form:option value="0"><spring:message code="label.selectCategory" /></form:option>
            <form:options items="${categories}" itemLabel="name" itemValue="id" />
        </form:select>
        <div class="error"><form:errors path="blogCategory" /></div>
    </div>
    <div class="form-group">
        <label for="image"><spring:message code="label.image" /></label>
        <form:input type="file" class="form-control" id="image" path="image" />
        <div class="error"><form:errors path="image" /></div>
    </div>
    <button type="submit" class="btn btn-success"><spring:message code="button.post" /></button>
</form:form>