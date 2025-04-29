<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <h4>상품별 재고 현황</h4>
    <table class="striped">
        <thead>
        <tr>
            <th>상품명</th>
            <th>재고</th>
            <th>재고 수정</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productName}</td> <!-- 상품명 수정 -->
                <td>${product.stock}</td>
                <td>
                    <form method="post" action="/admin/updateStock" style="display: flex; align-items: center;">
                        <input type="hidden" name="productId" value="${product.productId}" /> <!-- 상품 ID 수정 -->

                        <button type="button" onclick="decreaseStock(this)" class="btn" style="background-color: #8B4513; color: white;">-</button>

                        <input type="number" name="stock" value="${product.stock}" min="0" style="width: 60px; text-align: center; margin: 0 5px;" />
                        <button type="button" onclick="increaseStock(this)" class="btn" style="background-color: #8B4513; color: white;">+</button>

                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

                        <button type="submit" class="btn" style="background-color: #6F4E37; color: white; margin-left: 10px;"
                                onclick="return confirmUpdateStock();">재고 수정</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h4>모든 고객의 주문 내역</h4>
    <table class="striped">
        <thead>
        <tr>
            <th>주문번호</th>
            <th>이메일</th>
            <th>주문 상세</th>
            <th>총 가격</th>
            <th>총 수량</th>
            <th>주문일</th>
            <th>주문상태</th>
            <th>주문취소</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orderDetails}">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.userId}</td>
                <td>${order.productName}</td>


<%--                <td>--%>
<%--                    <c:forEach var="item" items="${order.items}">--%>
<%--                        ${order.productName} (${item.quantity})<br/>--%>
<%--                    </c:forEach>--%>
<%--                </td>--%>

                <td>₩<c:out value="${order.totalPrice}"/></td>
                <td>₩<c:out value="${order.quantity}"/></td>
<%--                <td>${order.orderCnt}</td> <!-- 총 수량 수정 -->--%>

                <td>
                    <c:if test="${not empty order.orderedAt}">
                        ${fn:replace(order.orderedAt, 'T', ' ')}
                    </c:if>
                </td> <!-- 주문일 수정 -->

                <td>
                    <c:choose>
                        <c:when test="${order.activated}">
                            결제완료
                        </c:when>
                        <c:otherwise>
                            주문취소
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>
                    <c:choose>
                        <c:when test="${order.activated}">
                            <form method="post" action="/admin/deleteOrder" onsubmit="return confirm('정말 취소하시겠습니까?');">
                                <input type="hidden" name="_method" value="delete"/>
                                <input type="hidden" name="orderId" value="${order.orderId}"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn red">주문 취소</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            취소완료
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>

<script>
  function decreaseStock(button) {
    const input = button.nextElementSibling;
    if (parseInt(input.value) > 0) {
      input.value = parseInt(input.value) - 1;
    }
  }

  function increaseStock(button) {
    const input = button.previousElementSibling;
    input.value = parseInt(input.value) + 1;
  }

  function confirmUpdateStock() {
    const confirmed = confirm('재고를 수정하시겠습니까?');
    if (confirmed) {
      setTimeout(function() {
        alert('재고 수정이 완료되었습니다!');
      }, 100);
      return true;
    }
    return false;
  }
</script>

</body>
</html>