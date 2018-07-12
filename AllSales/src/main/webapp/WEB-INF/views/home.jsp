<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<main role="main">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <c:forEach items="${featureSales}" var="featureSale" varStatus="status">
                <li data-target="#myCarousel" data-slide-to="${status.index}" class="<c:if test="${status.first}">active</c:if>"></li>
            </c:forEach>
        </ol>
        <div class="carousel-inner">
            <c:forEach items="${featureSales}" var="featureSale" varStatus="status">
                <div class="carousel-item <c:if test="${status.first}">active</c:if>">
                    <img class="first-slide img-fluid" src="<c:url value="/img/deals/${featureSale.saleTitle}"></c:url>.jpg" alt="${featureSale.dealTitle}">
                    <div class="container">
                        <div class="carousel-caption text-left">
                            <h1>${featureSale.saleTitle}</h1>
                            <p>${fn:substring(featureSale.description, 0, 100)}</p>
                            <p><a class="btn btn-lg btn-success" href="<spring:url value="/deals/detail/${featureSale.id}"/>" role="button">Sale detail</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="container frontpage-deals">
        <h1>Frontpage sales</h1>
        <div class="row">
            <c:forEach items="${frontpageSales}" var="sale" varStatus="status">
                <div class="col-lg-3">
                    <div class="deal">
                        <a href="<spring:url value="/deals/detail/${sale.id}"/>">
                            <div class="image">
                                <img class="img-fluid" src="<c:url value="/img/deals/${sale.dealTitle}"></c:url>.jpg" alt="${sale.saleTitle}">
                            </div>
                            <div class="store">${sale.store.name}</div>
                            <div class="deal-title">${sale.dealTitle}</div>
                            <div class="price-user">
                                <div class="price">
                                    $${sale.price}
                                </div>
                                <div class="user">
                                    <img class="rounded-circle" src="<c:url value="/img/users/${sale.user.email}"></c:url>.jpg" width="20px" height="20px">
                                </div>
                            </div>
                            <div class="comment"><i class="fa fa-commenting-o" aria-hidden="true"></i> ${sale.comments.size()}</div>
                        </a>
                    </div>
                </div><!-- /.col-lg-4 -->
            </c:forEach>
        </div><!-- /.row -->
    </div>
</main>
