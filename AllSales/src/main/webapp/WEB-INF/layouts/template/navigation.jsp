<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top">
        <a class="navbar-brand" href="<spring:url value="/" />">
            <img class="logo" src="<c:url value="/img/logo.png"></c:url>" alt="All Deals">
            all<span class="high-light">deals</span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a href="<spring:url value="/sales/categories/0"/>" class="nav-link">Sales</a>
                </li>
                <li class="nav-item">
                    <a href="<spring:url value="/stores/1"/>" class="nav-link">Store</a>
                </li>
                <li class="nav-item">
                    <a href="<spring:url value="/blog/categories/0"/>" class="nav-link">Blog</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <sec:authorize access="isAnonymous()">
                    <li class="nav-item">
                        <a href="<spring:url value="/login"/>" class="nav-link">Login</a>
                    </li>
                    <li class="nav-item">
                        <a href="<spring:url value="/register"/>" class="nav-link">Register</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item post-deal">
                        <a href="<spring:url value="/sales/post"/>" class="nav-link btn btn-outline-success post-a-deal">Post a Sale</a>
                    </li>
                    <li class="nav-item">
                        <a href="<spring:url value="/blog/post"/>" class="nav-link btn btn-outline-success post-a-deal">Post a Blog</a>
                    </li>
                    <li class="nav-item">
                        <a href="<spring:url value="/logout"/>" class="nav-link">Logout</a>
                    </li>
                </sec:authorize>
                <li class="nav-item">
                    <a href="?language=en" class="nav-link">EN</a>
                </li>
                <li class="nav-item">
                    <a href="?language=vn" class="nav-link">VN</a>
                </li>
                <li class="nav-item">
                    <a href="?language=fr" class="nav-link">FR</a>
                </li>
            </ul>
        </div>
    </nav>
</header>