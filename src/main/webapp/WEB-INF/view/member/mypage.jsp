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

<main class="container">
    <div class="menu-name">
        <strong>${member.userId}</strong> 님의 주문 목록입니다
    </div>

    <c:forEach var="order" items="${orderList}">
        <div class="order-box">
            <table class="order-table">
                <colgroup>
                    <col style="width: 15%;">
                    <col style="width: 45%;">
                    <col style="width: 20%;">
                    <col style="width: 20%;">
                </colgroup>

                <tr>
                    <th colspan="4" style="text-align: left;">
                        주문일시: 2025-05-05 13:00:00<br>
                        (주문번호: ${order.orderId})
                    </th>
                </tr>

                <tr>
                    <th>상품 이미지</th>
                    <th>상품명</th>
                    <th>수량</th>
                    <th>단가</th>
                </tr>

                <c:forEach var="product" items="${order.orderDetails}">
                    <tr>
                        <td><img src="/assets/css" alt="상품 이미지" width="80"></td>
                        <td>${product.productName}</td>
                        <td>${product.orderCnt}</td>
                        <td>${product.productPrice}원</td>
                    </tr>
                </c:forEach>

                <tr class="total-row">
                    <td colspan="3" class="total-label">총 금액</td>
                    <td class="total-amount">${order.totalPrice}원</td>
                </tr>
            </table>

            <div style="text-align: right;">
                <button type="submit" class="cancel-btn">주문 전체 취소</button>
            </div>
        </div>
    </c:forEach>
</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>