<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.grepp.spring.app.model.order.dto.OrderDto" %>

<html>
<head>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>주문 완료</title>
</head>
<body class="container">

<div class="center-align" style="margin-top: 30px;">
    <i class="material-icons large green-text">check_circle</i>
    <h4 class="green-text">주문이 완료되었습니다!</h4>
</div>

<div class="card-panel">
    <p>주문일자:
        <fmt:formatDate value="${order.orderedAt}" pattern="yyyy-MM-dd (E) HH시 mm분 ss초" />
    </p>
    <p>주문상태: 결제완료</p>
    <p>${order.userId}님 주문이 완료되었습니다!</p>
    <p>주문상태 : ${order.orderStatus.label}</p>
    <p>예상 배송일: <fmt:formatDate value="${order.expectDeliveryAt}" pattern="yyyy-MM-dd (E)"/></p>
</div>

<h5>주문 내역</h5>
<table class="striped">
    <thead>
    <tr>
        <th>상품코드</th>
        <th>카테고리</th>
        <th>상품명</th>
        <th>단가</th>
        <th>수량</th>
        <th>총금액</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${order.items}">
        <tr>
            <td>${item.productCode}</td>
            <td>${item.category}</td>
            <td>${item.productName}</td>
            <td><fmt:formatNumber value="${item.unitPrice}" type="currency" /></td>
            <td>${item.quantity}</td>
            <td><fmt:formatNumber value="${item.totalPrice}" type="currency" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="right-align" style="margin-top: 20px;">
    <strong>총 결제금액:
        <fmt:formatNumber value="${order.totalPrice}" type="currency"/>
    </strong>
</div>

<div class="center-align" style="margin-top: 30px;">
    <a href="/" class="btn waves-effect brown lighten-1">메인으로 돌아가기</a>
</div>

</body>
</html>