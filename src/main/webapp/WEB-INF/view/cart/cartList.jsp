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
    <form action="cartList" method="post">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />

        <h4>${status.index + 1}</h4>
        <p><b>상품 명</b> : ${cartProduct.productName}</p>
        <strong>상품 수량: </strong>
        <label>
            <input type="number" name="productCnt" value="${cartProduct.productCnt}" min="1" style="width: 35px;"/>
        </label>
        <strong> 팩</strong> <button type="submit">저장하기</button>
        <p><b>상품 가격 (1팩) :</b> ${cartProduct.productPrice} <b>원</b></p>
        <p><b>총 상품 가격 :</b> ${cartProduct.productPrice * cartProduct.productCnt} <b>원</b></p>

        <button type="submit">구매하기</button>

        <p>---------------------------------------</p><br>
    </form>
    </c:forEach>
    <form action="order" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit" style="width: 120px">전체 구매하기</button>
    </form>
</main>
<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>