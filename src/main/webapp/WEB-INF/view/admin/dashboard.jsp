<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<<<<<<< HEAD

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>

=======
<%@include file="/WEB-INF/view/include/page.jsp" %>
>>>>>>> origin/kdy
<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<<<<<<< HEAD

<main class="container">
    <h4>모든 고객의 주문 내역</h4>

    <table class="striped">
        <thead>
        <tr>
            <th>주문번호</th>
            <th>고객이름</th>
            <th>상품명</th>
            <th>수량</th>
            <th>총 가격</th>
            <th>주문일</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.userName}</td>
                <td>${order.productName}</td>
                <td>${order.productCnt}</td>
                <td>${order.totalPrice}</td>
                <td>${order.createdAt}</td>
                <td>
                    <form method="post" action="/admin/orderList" onsubmit="return confirm('삭제하시겠습니까?');">
                        <input type="hidden" name="_method" value="delete"/>
                        <input type="hidden" name="orderId" value="${order.orderId}"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button class="btn red">삭제</button>
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

=======
<main class="container">
<h4> 모든 고객의 주문 내역을 볼 수 있는 페이지 - 이메일별로 나열</h4>
</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
>>>>>>> origin/kdy
