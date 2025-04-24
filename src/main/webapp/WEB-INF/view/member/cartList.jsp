<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>장바구니</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
<h2>장바구니 페이지입니다~~~</h2>

    <c:forEach var="cartProduct" items="${cartList}" varStatus="status">
        <h4>${status.index + 1}</h4>
        <p>장바구니 번호 : ${cartProduct.cartId}</p>
        <p>상품 명 : ${cartProduct.productName}</p>
        <p>상품 수량 : ${cartProduct.productCnt} 팩</p>
        <p>상품 가격(1팩) : ${cartProduct.productPrice} 원</p>
        <p>총 상품 가격 : ${cartProduct.productPrice * cartProduct.productCnt} 원</p>

        <p>---------------------------------------</p><br>

    </c:forEach>
</main>
<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>