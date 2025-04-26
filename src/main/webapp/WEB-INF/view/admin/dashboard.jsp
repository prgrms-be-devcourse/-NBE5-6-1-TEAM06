<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>

<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>

<main class="container">
    <h4>모든 고객의 주문 내역</h4>

    <table class="striped">
        <thead>
        <tr>
            <th>주문번호</th>
            <th>이메일</th>
            <th>주문상세</th>
            <th>총 가격</th>
            <th>총 수량</th>
            <th>주문일</th>
            <th>주문취소</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.userId}</td>
                <td>
                    <c:forEach var="item" items="${order.items}">
                        ${item.productName} (${item.quantity})<br/>
                    </c:forEach>
                </td>
                <td>${order.totalPrice}</td>
                <td>${order.orderItems}</td>
                <td>${order.orderDate}</td>
                <td>
                    <form method="post" action="/admin/deleteOrder" onsubmit="return confirm('정말 삭제하시겠습니까?');">
                        <input type="hidden" name="_method" value="delete"/>
                        <input type="hidden" name="orderId" value="${order.orderId}"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn red">주문취소</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>
