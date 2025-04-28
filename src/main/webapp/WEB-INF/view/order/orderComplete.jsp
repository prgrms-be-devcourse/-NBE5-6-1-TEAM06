<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order Complete</title>

    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../../../assets/css/order.css" rel="stylesheet">
</head>

<body class="container-fluid">
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>

<!-- 주문 완료 아이콘과 문구 -->
<div class="center-align" style="margin-top: 30px;">
    <i class="material-icons large green-text">check_circle</i>
    <p class="green-text">
        ${order.userName != null ? order.userName : '고객'}님 주문이 완료되었습니다!
    </p>
</div>

<!-- Order Summary (기본 정보) -->
<div class="center-align" style="margin-top: 30px;">

    <table class="striped centered" style="width: 50%; margin: 20px auto;">
        <tbody>
        <tr>
            <th>주문 번호</th>
            <td>${order.orderId}</td>
        </tr>
        <tr>
            <th>주문 일자</th>
            <td>${order.orderedAtStr}</td>
        </tr>
        <tr>
            <th>주문 상태</th>
            <td>${order.orderStatus}</td>
        </tr>
        <tr>
            <th>예상 배송일</th>
            <td>${order.expectedDeliveryDateStr}</td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Order Summary (상품 정보) -->
<div class="center-align" style="margin-top: 30px;">
    <h5><b>Order Summary</b></h5> <!-- 여기도 Order Summary로 통일 -->

    <table class="striped centered" style="width: 70%; margin: 20px auto;">
        <thead>
        <tr>
            <th>카테고리</th>
            <th>상품명</th>
            <th>단가</th>
            <th>수량</th>
            <th>상품 합계</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${order.items}">
            <tr>
                <td>${item.category}</td>
                <td>${item.productName}</td>
                <td><fmt:formatNumber value="${item.productPrice}" type="currency"/></td>
                <td>${item.quantity != null ? item.quantity : 0}</td>
                <td>
                    <fmt:formatNumber
                            value="${item.productPrice * (item.quantity != null ? item.quantity : 0)}"
                            type="currency"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- 총 결제금액 (오른쪽 정렬) -->
<div class="right-align" style="margin-right: 15%; margin-top: 20px;">
    <strong>총 결제금액:
        <fmt:formatNumber value="${order.totalPrice}" type="currency"/>
    </strong>
</div>

<!-- 메인으로 돌아가기 버튼 -->
<div class="center-align" style="margin-top: 30px;">
    <a href="/" class="btn waves-effect brown lighten-1">메인으로 돌아가기</a>
</div>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>