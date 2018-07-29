<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="deal-detail inner-wrapper">
    <div class="deal-id" data-dealid="${deal.id}" hidden></div>
    <h1 class="deal-title">
        ${deal.dealTitle}
    </h1>
    <div class="deal-content row">
        <div class="col-lg-6">
            <div class="price">
                Price: $${deal.price}
            </div>
            <div class="view-comment">
                219,691 Views | ${deal.comments.size()} Comments
            </div>
            <div class="description">
                ${deal.description}
            </div>
        </div>
        <div class="col-lg-6">
            <div class="image">
                <img class="img-fluid" src="<c:url value="/img/deals/${deal.dealTitle}"></c:url>.jpg" alt="${deal.dealTitle}">
            </div>
            <a class="btn btn-success btn-lg btn-block see-deal-btn" href="<spring:url value="${deal.dealUrl}"/>" target="_blank">See Deal</a>
            <div class="user">
                <img class="profile-image-thumb" src="<c:url value="/img/users/${deal.user.email}"></c:url>.jpg" width="20px">
                <p>${deal.user.firstName} ${deal.user.lastName} posted this deal.</p>
            </div>
        </div>
    </div>
    <div class="comment">
        <div class="comment-send">
            <h3>Comment</h3>
            <p class="let-us-know"><label><spring:message code="comment.question"/></label></p>
            <form id="comment-form">
                <div class="form-group">
                    <label for="title"><spring:message code="comment.title"/></label>
                    <input type="text" class="form-control" id="title" placeholder="Comment title" name="title" />
                    <div class="title-error-message error"></div>
                </div>
                <div class="form-group">
                    <label for="content"><spring:message code="comment.content"/></label>
                    <textarea name="content" class="form-control" id="content" placeholder="Comment content"></textarea>
                    <div class="content-error-message error"></div>
                </div>
                <button type="button" class="btn btn-success comment-btn"><spring:message code="comment.comment"/></button>
            </form>
            <div id="success" class="alert alert-success">
                <spring:message code="comment.success"/>
            </div>
        </div>

        <div class="commented">
            <h3 class="people-think">See what people think</h3>
            <div class="comment-list">
                <c:forEach items="${deal.comments}" var="comment">
                    <div class="comment-item">
                        <div class="comment-title">${comment.title}</div>
                        <div class="comment-time"><fmt:formatDate pattern="MM-dd-yyyy HH:mm:ss" value="${comment.postingTime}" /></div>
                        <div class="comment-content">${comment.content}</div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
