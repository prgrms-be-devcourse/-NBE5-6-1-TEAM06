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
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
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
      .total-button {
        text-align: center;
        margin-top: 40px;
      }
      .modal {
        display: none;
        position: fixed;
        z-index: 999;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0,0,0,0.4);
      }
      .modal-content {
        background-color: #fff;
        margin: 10% auto;
        padding: 20px;
        border-radius: 12px;
        width: 90%;
        max-width: 400px;
      }
      .modal-content .form-label {
        font-weight: bold;
      }
      .close {
        color: #aaa;
        float: right;
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
      }
      .close:hover {
        color: black;
      }
      .submit-button {
        width: 100%;
        margin-top: 20px;
        background-color: #6b4f3b;
        color: white;
        padding: 12px;
        border-radius: 8px;
        border: none;
        font-size: 16px;
        cursor: pointer;
      }
    </style>
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>

<main class="container">
    <h2>장바구니</h2>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="userName" value="${cartProduct.userName}"/>
    <input type="hidden" name="orderedAt" value="${cartProduct.orderedAt}"/>
    <input type="hidden" name="expectedDeliveryAt" value="${cartProduct.expectedDeliveryAt}"/>
    <input type="hidden" name="category" value="${cartProduct.category}"/>
    <input type="hidden" name="productName" value="${cartProduct.productName}"/>
    <input type="hidden" name="productPrice" value="${cartProduct.productPrice}"/>
    <input type="hidden" name="productCnt" value="${cartProduct.productCnt}"/>
    <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}"/>

    <c:forEach var="cartProduct" items="${cartList}" varStatus="status">
        <form action="cartList" method="post" class="cart-card">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="cartDetailsId" value="${cartProduct.cartDetailsId}"/>

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
                           style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;"/>

                    <button type="button"
                            class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                        <i class="material-icons">add</i>
                    </button>
                </div>
                <button type="submit" name="action" value="save">저장하기</button>
                <button type="button" class="open-modal"
                        product-details-id="${cartProduct.cartDetailsId}"
                        product-cnt="${cartProduct.productCnt}">
                    구매하기
                </button>
                <button type="submit" formaction="cartList/delete">삭제하기</button>
            </div>
        </form>
    </c:forEach>
</main>

<!-- 모달 창 -->
<div id="orderModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <form id="orderForm" action="order/cartOrderComplete" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input type="hidden" id="cartDetailsId" name="cartDetailsId" value="${cartProduct.cartDetailsId}" />
            <input type="hidden" id="productCnt" name="productCnt" value="${cartProduct.productCnt}" />

            <input type="hidden" name="userName" value="${cartProduct.userName}"/>
            <input type="hidden" name="orderedAt" value="${cartProduct.orderedAt}"/>
            <input type="hidden" name="expectedDeliveryAt" value="${cartProduct.expectedDeliveryAt}"/>
            <input type="hidden" name="category" value="${cartProduct.category}"/>
            <input type="hidden" name="productName" value="${cartProduct.productName}"/>
            <input type="hidden" name="productPrice" value="${cartProduct.productPrice}"/>

            <input type="hidden" name="action" value="cartListOrder"/>

            <div class="mb-3">
                <label for="userName" class="form-label">받는 분</label>
                <input type="text" class="form-control mb-1" id="userName" name="userName" required>
            </div>
            <div class="mb-3">
                <label for="tel" class="form-label">전화번호</label>
                <input type="text" class="form-control mb-1" id="tel" name="tel" required>
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">주소</label>
                <input type="text" class="form-control mb-1" id="address" name="address" required>
            </div>
            <div class="mb-3">
                <label for="postcode" class="form-label">우편번호</label>
                <input type="text" class="form-control" id="postcode" name="postNumber" required>
            </div>

            <button type="submit" class="submit-button">구매 완료</button>
        </form>
    </div>
</div>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

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

  // 모달 열기
  document.querySelectorAll('.open-modal').forEach(button => {
    button.addEventListener('click', function () {
      const cartDetailsId = this.getAttribute('product-details-id');
      const productCnt = this.getAttribute('product-cnt');

      document.getElementById('cartDetailsId').value = cartDetailsId;
      document.getElementById('productCnt').value = productCnt;

      document.getElementById('orderModal').style.display = 'block';
    });
  });

  // 모달 닫기
  document.querySelector('.close').addEventListener('click', function () {
    document.getElementById('orderModal').style.display = 'none';
  });

  // 모달 외부 클릭 시 닫기
  window.addEventListener('click', function (event) {
    const modal = document.getElementById('orderModal');
    if (event.target == modal) {
      modal.style.display = 'none';
    }
  });
</script>

</body>
</html>
