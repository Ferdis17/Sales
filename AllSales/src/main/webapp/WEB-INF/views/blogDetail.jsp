<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="blog-detail inner-wrapper">
    <div class="blog-title">
        <h3>${blog.title}</h3>
        <p><fmt:formatDate pattern="MM-dd-yyyy HH:mm:ss" value="${blog.postDate}" /></p>
    </div>
    <div class="blog-content row">
        <div class="col-lg-12">
            <img class="blog-image img-fluid" src="<c:url value="/img/blogs/${blog.title}"></c:url>.jpg">
            <div class="blog-content">
                ${blog.content}
            </div>
        </div>
    </div>
</div>
