<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<%@ include file="/WEB-INF/view/include/page.jsp" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>장바구니</title>--%>
<%--    <%@ include file="/WEB-INF/view/include/static.jsp" %>--%>
<%--</head>--%>
<%--<body>--%>
<%--<%@ include file="/WEB-INF/view/include/header.jsp" %>--%>
<%--<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>--%>
<%--<main class="container">--%>
<%--<h2>장바구니 페이지입니다~~~</h2>--%>

<%--    <c:forEach var="cartProduct" items="${cartList}" varStatus="status">--%>
<%--    <form action="cartList" method="post">--%>

<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--        <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />--%>

<%--        <h4>${status.index + 1}</h4>--%>

<%--        <p><b>상품 명</b> : ${cartProduct.productName}</p>--%>
<%--        <strong>상품 수량: </strong>--%>
<%--        <label>--%>
<%--            <input type="number" name="productCnt" value="${cartProduct.productCnt}" min="1" style="width: 35px;"/>--%>
<%--        </label>--%>
<%--        <strong> 팩</strong> <button type="submit">저장하기</button>--%>
<%--        <p><b>상품 가격 (1팩) :</b> ${cartProduct.productPrice} <b>원</b></p>--%>
<%--        <p><b>총 상품 가격 :</b> ${cartProduct.productPrice * cartProduct.productCnt} <b>원</b></p>--%>

<%--        <button type="submit">구매하기</button>--%>

<%--    </form>--%>

<%--        <form action="cartList/delete" method="post">--%>
<%--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--            <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />--%>
<%--            <button type="submit">상품 삭제하기</button>--%>
<%--        </form>--%>
<%--        <p>---------------------------------------</p><br>--%>
<%--    </c:forEach>--%>

<%--    <form action="order" method="post">--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />--%>
<%--        <button type="submit" style="width: 120px">전체 구매하기</button>--%>
<%--    </form>--%>
<%--</main>--%>
<%--<%@ include file="/WEB-INF/view/include/footer.jsp" %>--%>
<%--</body>--%>

<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
<%--&lt;%&ndash;  function deleteCart(event, cartDetailsId) {&ndash;%&gt;--%>
<%--&lt;%&ndash;    event.preventDefault();&ndash;%&gt;--%>
<%--&lt;%&ndash;    fetch('/cartList', {&ndash;%&gt;--%>
<%--&lt;%&ndash;      method: 'DELETE',&ndash;%&gt;--%>
<%--&lt;%&ndash;      headers: {&ndash;%&gt;--%>
<%--&lt;%&ndash;        'Content-Type': 'application/json',&ndash;%&gt;--%>
<%--&lt;%&ndash;        'X-CSRF-TOKEN': '${_csrf.token}'&ndash;%&gt;--%>
<%--&lt;%&ndash;      },&ndash;%&gt;--%>
<%--&lt;%&ndash;      body: JSON.stringify({ cartDetailsId })&ndash;%&gt;--%>
<%--&lt;%&ndash;    }).then(() => {&ndash;%&gt;--%>
<%--&lt;%&ndash;      location.reload();&ndash;%&gt;--%>
<%--&lt;%&ndash;    });&ndash;%&gt;--%>
<%--&lt;%&ndash;  }&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>
<%--</html>--%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>장바구니</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
    <style>
      body {
        font-family: 'Noto Sans KR', sans-serif;
        background-color: #f8f4f0;
        color: #333;
      }

      h2 {
        text-align: center;
        margin: 40px 0 30px;
        color: #6b4f3b;
      }

      .cart-card {
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 12px;
        padding: 20px;
        margin-bottom: 20px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.05);
      }

      .cart-card h4 {
        color: #8b5e3c;
      }

      .product-info p {
        margin: 6px 0;
      }

      .actions {
        margin-top: 15px;
        display: flex;
        gap: 10px;
      }

      .actions button {
        background-color: #8b5e3c;
        color: white;
        border: none;
        padding: 8px 14px;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.2s ease-in-out;
      }

      .actions button:hover {
        background-color: #a06c4f;
      }

      .actions input[type="number"] {
        width: 50px;
        padding: 4px;
        text-align: center;
      }

      .total-button {
        text-align: center;
        margin-top: 40px;
      }

      .total-button button {
        background-color: #6b4f3b;
        color: white;
        padding: 12px 24px;
        border-radius: 8px;
        font-size: 16px;
        border: none;
        cursor: pointer;
      }

      .total-button button:hover {
        background-color: #85634c;
      }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>

<main class="container">
    <h2>장바구니</h2>

    <c:forEach var="cartProduct" items="${cartList}" varStatus="status">
        <form action="cartList" method="post" class="cart-card">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />

            <h4>${status.index + 1}. ${cartProduct.productName}</h4>

            <div class="product-info">
                <p><b>상품 가격 (1팩):</b> ${cartProduct.productPrice} 원</p>
                <p><b>총 상품 가격:</b> ${cartProduct.productPrice * cartProduct.productCnt} 원</p>
            </div>

            <div class="actions">
                <label>
                    수량:
                    <input type="number" name="productCnt" value="${cartProduct.productCnt}" min="1" />
                </label>
                <button type="submit" name="action" value="save">저장하기</button>
                <button type="submit" name="action" value="buy">구매하기</button>
                <button type="submit" formaction="cartList/delete">삭제하기</button>
            </div>
        </form>
    </c:forEach>

    <div class="total-button">
        <form action="order" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type="submit">전체 구매하기</button>
        </form>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>
