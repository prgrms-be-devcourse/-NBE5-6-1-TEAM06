<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage.css">

    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<main class="container">
    <div class="menu-name">
        <strong>${orderList[0].userName}</strong> 님의 주문 목록입니다
    </div>

    <c:forEach var="order" items="${orderList}">
    <div class="<c:choose>
        <c:when test='${!order.activated}'>order-box-cancel</c:when>
        <c:otherwise>order-box</c:otherwise>
    </c:choose>">
            <table class="order-table">
                <colgroup>
                    <col style="width: 15%;">
                    <col style="width: 35%;">
                    <col style="width: 20%;">
                    <col style="width: 15%;">
                    <col style="width: 15%;">
                </colgroup>

                <tr>
                    <th colspan="5" style="text-align: left;">
                        주문번호: ${order.orderId}<br>
                        (주문일시: ${order.orderedAt})<br>
                            <%--                        (배송예정일: ${order.expectDeliveryAt}--%>

                    </th>
                </tr>

                <tr>
                    <th>상품 이미지</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>단가</th>
                    <th>주문 상태</th>
                </tr>

                <c:forEach var="product" items="${order.items}" varStatus="status">
                    <tr>
                        <td><img src="/assets/css" alt="상품 이미지" width="80"></td>
                        <td>${product.productName}</td>
                        <td>${product.orderCnt}</td>
                        <td>₩${product.productPrice}</td>
                        <c:if test="${status.first}">
                            <td rowspan="${fn:length(order.items)+1}" class="order-state">
                                <c:choose>
                                    <c:when test="${order.activated}">
                                        <span class="order-ok">주문 완료</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="order-cancel">주문 취소</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>

                <tr class="total-row">
                    <td colspan="3" class="total-label">총 금액</td>
                    <td class="total-amount">₩${order.totalPrice}</td>
                </tr>
            </table>
            <c:if test="${order.activated}">
                <div style="text-align: right;">
                    <form method="post"
                          action="${pageContext.request.contextPath}/member/order/${order.orderId}/cancel">
                        <input type="hidden" name="_method" value="delete"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="cancel-btn"
                            <%--                            <c:if test="${!order.activated}">--%>
                            <%--                                    disabled--%>
                            <%--                            </c:if>--%>
                        >주문 전체 취소
                        </button>
                    </form>
                </div>
            </c:if>
        </div>
    </c:forEach>
</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>