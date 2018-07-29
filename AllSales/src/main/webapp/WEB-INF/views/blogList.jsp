<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="inner-wrapper deal-list">
    <div class="row">
        <div class="col-lg-3">
            <div class="filters">
                <div class="filter">
                    <h3 class="filter-title">
                        Category
                    </h3>
                    <ul class="category-filter">
                        <c:forEach items="${categories}" var="cat">
                            <li><a href="<spring:url value="/blog/categories/${cat.id}"/>">${cat.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="row">
                <c:forEach items="${blogs}" var="blog">
                    <div class="col-lg-4">
                        <div class="deal">
                            <a href="<spring:url value="/blog/detail/${blog.id}"/>">
                                <div class="image">
                                    <img class="img-fluid" src="<c:url value="/img/blogs/${blog.title}"></c:url>.jpg" alt="${blog.title}">
                                </div>
                                <div class="deal-title">${blog.title}</div>
                                <div class="price-user">
                                    <div class="user">
                                        <img class="rounded-circle" src="<c:url value="/img/users/${blog.user.email}"></c:url>.jpg" width="20px" height="20px">
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
