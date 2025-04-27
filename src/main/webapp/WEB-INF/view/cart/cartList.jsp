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
        <form method="post" class="cart-card">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" name="userName" value="${cartProduct.userName}" />
            <input type="hidden" name="orderedAt" value="${cartProduct.orderedAt}" />
            <input type="hidden" name="expectedDeliveryAt" value="${cartProduct.expectedDeliveryAt}" />
            <input type="hidden" name="category" value="${cartProduct.category}" />
            <input type="hidden" name="productName" value="${cartProduct.productName}" />
            <input type="hidden" name="productPrice" value="${cartProduct.productPrice}" />
            <input type="hidden" name="productCnt" value="${cartProduct.productCnt}" />
            <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />

            <h4>${status.index + 1}. ${cartProduct.productName}</h4>

            <div class="product-info">
                <p><b>상품 가격 (1팩):</b> ${cartProduct.productPrice} 원</p>
                <p><b>총 상품 가격:</b> ${cartProduct.productPrice * cartProduct.productCnt} 원</p>
            </div>

            <div class="actions">
                <div>
                    <b>수량</b>
                    <button type="button"
                            class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                        <i class="material-icons">remove</i>
                    </button>

                    <input type="number"
                           name="productCnt"
                           class="form-control quantity-input"
                           value="${cartProduct.productCnt}" min="1"
                           style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;" />

                    <button type="button"
                            class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                        <i class="material-icons">add</i>
                    </button>
                </div>

<%--                <label>--%>
<%--                    수량:--%>
<%--                    <input type="number" name="productCnt" value="${cartProduct.productCnt}" min="1" />--%>
<%--                </label>--%>
                <button type="submit" name="action" value="save" formaction="cartList">저장하기</button>
                <button type="submit" name="action" value="cartListOrder" formaction="order/cartOrderComplete">구매하기</button>
                <button type="submit" formaction="cartList/delete">삭제하기</button>
            </div>
        </form>
    </c:forEach>

    <div class="total-button">
        <form action="order" method="post">
<c:forEach var="cartProductAll" items="${cartProductAll}" varStatus="status">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" name="productCnt" value="${cartProductAll.productId}" />
            <input type="hidden" name="cartDetailsId" value="${cartProductAll.cartDetailsId}" />
            <input type="hidden" name="productName" value="${cartProductAll.productName}" />
            <input type="hidden" name="productCnt" value="${cartProductAll.productCnt}" />
            <input type="hidden" name="category" value="${cartProductAll.category}" />
            <input type="hidden" name="productPrice" value="${cartProductAll.productPrice}" />
            <button type="submit" name="action" value="cartListOrderAll">전체 구매하기</button>
</c:forEach>
        </form>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const qtyControls = document.querySelectorAll(".actions"); // actions로 수정

    qtyControls.forEach(control => {
      const minusBtn = control.querySelector(".quantity-decrease");
      const plusBtn = control.querySelector(".quantity-increase");
      const input = control.querySelector(".quantity-input");

      minusBtn.addEventListener("click", () => {
        let val = parseInt(input.value);
        if (val > 1) {
          input.value = val - 1;
        }
      });

      plusBtn.addEventListener("click", () => {
        let val = parseInt(input.value);
        input.value = val + 1;
      });
    });
  });

</script>
</html>
