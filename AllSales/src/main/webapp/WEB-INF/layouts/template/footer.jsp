<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- FOOTER -->
<footer class="fluid-container row">
    <div class="copyright col-lg-6"><i class="fa fa-copyright"></i> 2018 allSales, Inc. | <a href="#">Privacy</a> | <a href="#">Terms</a></div>
    <div class="col-lg-6">
        <ul>
            <li class="nav-item active">
                <a href="<spring:url value="/sales/categories/0"/>" class="nav-link">Sales</a>
            </li>
            <li class="nav-item">
                <a href="<spring:url value="/stores/1"/>" class="nav-link">Store</a>
            </li>
            <li class="nav-item">
                <a href="<spring:url value="/blog/categories/0"/>" class="nav-link">Blog</a>
            </li>
        </ul>
    </div>
</footer>