<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="inner-wrapper store">
    <div class="row">
        <div class="col-lg-3">
            <div class="filters">
                <div class="filter">
                    <h3 class="filter-title">
                        Related Stores
                    </h3>
                    <ul class="category-filter">
                        <c:forEach items="${stores}" var="store">
                            <li><a href="<spring:url value="/stores/${store.id}"/>">${store.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="store-detail">
                    <h3 class="store-name">
                        <img class="img-fluid" src="<c:url value="/img/stores/${store.name}"></c:url>.png" alt="${store.name}">
                    </h3>
                    <div class="store-description">
                        ${store.description}
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9">
            <div class="row">
                <c:forEach items="${deals}" var="deal">
                    <div class="col-lg-12">
                        <a class="store-deal-link" href="<spring:url value="/deals/detail/${deal.id}"/>">
                            <div class="store-deal row">
                                <div class="price col-lg-2">
                                    $${deal.price}
                                </div>
                                <div class="main-deal col-lg-7">
                                    <div class="deal-cat">${deal.dealCategory.name}</div>
                                    <div class="deal-title">${deal.dealTitle}</div>
                                    <div class="deal-description">${fn:substring(deal.description, 0, 100)}</div>
                                </div>
                                <div class="big-button col-lg-3">
                                    <button class="btn btn-success">Get Offer</button>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
