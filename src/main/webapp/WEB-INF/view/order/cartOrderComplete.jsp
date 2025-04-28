<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <p class="green-text">${cartProduct.userName}님 주문이 완료되었습니다!</p>
</div>

<div class="card-panel">
    <p>주문 일자: ${cartProduct.orderedAt}</p>
<%--    <p>주문 상태: ${order.orderStatus.label}</p>--%>
    <p>예상 배송일자: ${cartProduct.expectedDeliveryAt}</p>
</div>

<h5>주문 내역</h5>
<table class="striped">
    <thead>
    <tr>
<%--        <th>카테고리</th>--%>
        <th>상품명</th>
        <th>단가</th>
        <th>수량</th>
<%--        <th>합계</th>--%>
    </tr>
    </thead>
    <tbody>
<%--    <c:forEach var="item" items="${order.items}">--%>
        <tr>
<%--            <td>${cartProduct.category}</td>--%>
            <td>${cartProduct.productName}</td>
            <td><fmt:formatNumber value="${cartProduct.productPrice}" type="currency" /></td>
            <td>${cartProduct.productCnt}</td>
<%--            <td><fmt:formatNumber value="${cartProduct.unitPrice}" type="currency" /></td>--%>
        </tr>
<%--    </c:forEach>--%>
    </tbody>
</table>

<div class="right-align" style="margin-top: 20px;">
    <strong>총 결제금액:
        <fmt:formatNumber value="${cartProduct.productPrice * cartProduct.productCnt}" type="currency"/>
    </strong>
</div>

<div class="center-align" style="margin-top: 30px;">
    <a href="/" class="btn waves-effect brown lighten-1">메인으로 돌아가기</a>
</div>

</body>
</html>