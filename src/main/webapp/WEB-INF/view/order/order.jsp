<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../../../assets/css/order.css" rel="stylesheet">
</head>

<body class="container-fluid">
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>

<div class="row justify-content-center m-4">
    <h1 class="text-center" onclick="location.href='index.jsp'" style="cursor: pointer;"></h1>
</div>

<div class="card row">
    <!-- Product List -->
    <div class="col s12 m8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
        <h5><b>Product List</b></h5>
        <ul class="list-group products">
            <c:forEach var="product" items="${products}">

                <li class="list-group-item">
                    <div class="col-2">
                        <img class="img-fluid" src="/assets/images/${product.productImgUrl}"
                             alt="">
                    </div>
                    <div class="product-info">
                        <div class="row text-muted product-category">${product.category}</div>
                        <div class="row item-name product-name">${product.productName}</div>
                    </div>
                    <div class="col text-center price">${product.price}원</div>
                    <div class="quantity-control d-flex align-items-center gap-1">
                        <button type="button"
                                class="waves-effect waves-light btn-s btn-brown quantity-decrease">
                            -
                        </button>
                        <input type="number"
                               class="form-control quantity-input"
                               value="0" min="0"
                               data-product-id="${product.productId}"
                               data-name="${product.productName}"
                               style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;"/>
                        <button type="button"
                                class="waves-effect waves-light btn-s btn-brown quantity-increase">
                            +
                        </button>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>

    <!-- Information -->
    <div class="col s12 m4 information p-4">
        <div>
            <h5 class="m-0 p-0"><b>Order Information</b></h5>
            <p class="info-desc">주문정보를 입력해주세요.
            <p>
        </div>
        <hr>

        <ul id="information-list" class="list-unstyled"></ul>

        <form action="/order" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div id="hidden-inputs"></div>

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
                <label for="postNumber" class="form-label">우편번호</label>
                <input type="text" class="form-control" id="postNumber" name="postNumber" required>
            </div>

            <div class="info-desc">당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>


            <div class="row pt-2 pb-2 border-top" style="margin-bottom:0;">
                <h6 class="col">총 수량</h6>
                <h6 class="col text-end total-quantity">0개</h6>
            </div>
            <div class="row pt-2 pb-2 border-top" style="margin-bottom:0;">
                <h6 class="col">총 금액</h6>
                <h6 class="col text-end total-price">0원</h6>
            </div>
            <div class="btn-order">
                <button type="submit" name="action" value="cart"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">shopping_cart</i>장바구니
                </button>
                <button type="submit" name="action" value="order"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">payment</i>결제하기
                </button>
            </div>
        </form>
    </div>
</div>


<script>
  document.addEventListener("DOMContentLoaded", function () {
    const decreaseBtns = document.querySelectorAll(".quantity-decrease");
    const increaseBtns = document.querySelectorAll(".quantity-increase");
    const quantityInputs = document.querySelectorAll(".quantity-input");
    const informationList = document.querySelector("#information-list");

    console.log("Decrease Buttons:", decreaseBtns.length);
    console.log("Increase Buttons:", increaseBtns.length);
    console.log("Quantity Inputs:", quantityInputs.length);
    console.log("information List:", informationList.length);

    function updateInformation() {
      const items = [...document.querySelectorAll('.list-group.products > li')];
      let totalPrice = 0; // 총 금액
      let totalQuantity = 0; // 총 수량

      const hiddenInputs = document.getElementById('hidden-inputs');
      hiddenInputs.innerHTML = ""; // 매번 hidden input 초기화

      const f = items.map(v => {
        const priceText = v.querySelector('.price').textContent.trim(); // "5000원" 형식
        const price = Number(priceText.replace('원', '')); // "원" 제거 후 숫자로 변환
        const itemName = v.querySelector('.item-name').textContent.trim();
        const quantityInput = v.querySelector('.quantity-input');
        const quantity = Number(quantityInput.value);
        const productId = quantityInput.dataset.productId;

        if (quantity > 0) {
          totalPrice += price * quantity; // 총 금액 누적
          totalQuantity += quantity;      // 총 수량 누적

          const productInput = document.createElement('input');
          productInput.type = 'hidden';
          productInput.name = 'productIds';
          productInput.value = productId;

          const quantityInputHidden = document.createElement('input');
          quantityInputHidden.type = 'hidden';
          quantityInputHidden.name = 'quantities';
          quantityInputHidden.value = quantity;

          hiddenInputs.appendChild(productInput);
          hiddenInputs.appendChild(quantityInputHidden);



          return `<li>
                          <div class='li-list'>
                              <h6 class="p-0">\${itemName}</h6>
                              <span class="badge bg-dark">\${quantity}개</span>
                          </div>
                      </li>`;
        }
        return null;
      })
      .filter(v => v !== null)
      .join('');

      console.log(f);
      console.log("Total Price: ", totalPrice); // 콘솔에 총 금액 출력 (디버깅용)

      document.querySelector('#information-list').innerHTML = f;

      // 총금액, 총 수량 UI 업데이트
      const totalQuantityElement = document.querySelector(
          '.total-quantity');
      const totalPriceElement = document.querySelector(
          '.total-price');

      if (totalQuantityElement) {
        totalQuantityElement.textContent = `\${totalQuantity}개`;
      }
      if (totalPriceElement) {
        totalPriceElement.textContent = `\${totalPrice}원`;
      }
    }

    increaseBtns.forEach((btn, idx) => {
      btn.addEventListener("click", () => {
        console.log("Increase button clicked for index:", idx);
        quantityInputs[idx].stepUp();
        updateInformation();
      });
    });

    decreaseBtns.forEach((btn, idx) => {
      btn.addEventListener("click", () => {
        console.log("Decrease button clicked for index:", idx);
        quantityInputs[idx].stepDown();
        updateInformation();
      });
    });

    quantityInputs.forEach(input => {
      input.addEventListener("input", () => {
        console.log("Input changed for:", input.dataset.name);
        updateInformation();
      });
    });

    updateInformation();
  });

</script>

<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>