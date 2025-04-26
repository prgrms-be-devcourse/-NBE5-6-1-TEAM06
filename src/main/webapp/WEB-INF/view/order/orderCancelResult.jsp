<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>

<main class="container">
    </div>
    <c:choose>
        <c:when test="${status == 'success'}">
            <div class="center-align" style="margin-top: 30px;">
                <i class="material-icons large green-text">check_circle</i>
                <h4 class="green-text"><strong>${order.userId}</strong>님, 주문이 성공적으로 취소되었습니다!</h4>
            </div>
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
                            주문번호: ${order.orderId}<br>
                            (주문일시: ${order.orderedAt}<br>
                                <%--                        (배송예정일: ${order.expectDeliveryAt}--%>

                        </th>
                    </tr>

                    <tr>
                        <th>상품 이미지</th>
                        <th>상품명</th>
                        <th>수량</th>
                        <th>단가</th>
                    </tr>

                    <c:forEach var="product" items="${order.items}">
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
            </div>

            </div>
        </c:when>

        <c:when test="${status == 'fail'}">
            <div class="center-align" style="margin-top: 30px;">
                <i class="material-icons large red-text">cancel</i>
                <h4 class="black-text"><strong>${order.userId}</strong>님, </h4>
                <h4 class="red-text">주문 취소에 실패했습니다.</h4>
                <h4 class="red-text">주문 취소 가능 기간을 확인해 주세요.</h4>
            </div>
        </c:when>

        <c:otherwise>
            <h1> 오류 발생</h1>
        </c:otherwise>
    </c:choose>

</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>


</body>
</html>