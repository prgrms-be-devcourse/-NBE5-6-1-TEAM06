<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="../../../assets/css/order.css" rel="stylesheet">
</head>
<body class="container-fluid">

<div class="row justify-content-center m-4">
    <h1 class="text-center" onclick="location.href='index.jsp'" style="cursor: pointer;">Grids &
        Circle</h1>
</div>

<div class="card">
    <div class="row">
        <!-- Product List -->
        <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
            <h5><b>Product List</b></h5>
            <ul class="list-group products">
                <c:forEach var="product" items="${products}">
                    <li class="list-group-item d-flex mt-2">
                        <div class="col-2">
                            <img class="img-fluid" src="/assets/images/${product.productImgUrl}" alt="">
                        </div>
                        <div class="col">
                            <div class="row text-muted">${product.category}</div>
                            <div class="row item-name">${product.productName}</div>
                        </div>
                        <div class="col text-center price">${product.price}원</div>
                        <div class="quantity-control d-flex align-items-center gap-1">
                            <button type="button"
                                    class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                                <i class="material-icons">remove</i>
                            </button>
<%--                            // 수정--%>
                            <input type="number" class="form-control quantity-input" value="0" min="0"
                                   data-name="${product.productName}"
                                   style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;"/>
                            <button type="button"
                                    class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                                <i class="material-icons">add</i>
                            </button>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <!-- Summary -->
        <div class="col-md-4 summary p-4">
            <div>
                <h5 class="m-0 p-0"><b>Summary</b></h5>
            </div>
            <hr>
            <ul id="summary-list" class="list-unstyled"></ul>

            <form action="/order" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="productIds" value="${item.productId}">
                <input type="hidden" name="quantities" value="${item.quantity}">

                <div class="mb-3">
                    <label for="userName" class="form-label">받는 분</label>
                    <input type="email" class="form-control mb-1" id="userName" name="userName">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">전화번호</label>
                    <input type="text" class="form-control mb-1" id="tel" name="tel">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">주소</label>
                    <input type="text" class="form-control mb-1" id="address" name="address">
                </div>
                <div class="mb-3">
                    <label for="postcode" class="form-label">우편번호</label>
                    <input type="text" class="form-control" id="postcode" name="postNumber">
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>
                <div class="row pt-2 pb-2 border-top">
                    <h5 class="col">총금액</h5>
                    <h5 class="col text-end">0원</h5>
                </div>
                <button type="submit" name="action" value="cart"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">shopping_cart</i>장바구니
                </button>
                <button type="submit" name="action" value="order"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">payment</i>결제하기
                </button>
            </form>
        </div>
    </div>
</div>

<script>
  document.addEventListener("DOMContentLoaded", function () {
    const decreaseBtns = document.querySelectorAll(".quantity-decrease");
    const increaseBtns = document.querySelectorAll(".quantity-increase");
    const quantityInputs = document.querySelectorAll(".quantity-input");
    const summaryList = document.querySelector("#summary-list");

    console.log("Decrease Buttons:", decreaseBtns.length);
    console.log("Increase Buttons:", increaseBtns.length);
    console.log("Quantity Inputs:", quantityInputs.length);

    function updateSummary() {
      const items = [...document.querySelectorAll('.list-group.products > li')];
      let totalPrice = 0; // 총 금액을 저장할 변수

      const f = items
      .map(v => {
        const priceText = v.querySelector('.price').textContent.trim(); // "5000원" 형식
        const price = Number(priceText.replace('원', '')); // "원" 제거 후 숫자로 변환
        const itemName = v.querySelector('.item-name').textContent.trim();
        const quantity = Number(v.querySelector('.quantity-input').value);

        if (quantity >= 1) {
          totalPrice += price * quantity; // 총 금액 누적 계산
          return `<li>
                          <div class='row'>
                              <h6 class="p-0">\${itemName}
                                  <span class="badge bg-dark">\${quantity}개</span>
                              </h6>
                          </div>
                      </li>`;
        }
        return null;
      })
      .filter(v => v !== null)
      .join('');

      console.log(f);
      console.log("Total Price: ", totalPrice); // 콘솔에 총 금액 출력 (디버깅용)

      summaryList.innerHTML = f;

      // 총금액 UI 업데이트
      const totalPriceElement = document.querySelector('.summary .row.border-top h5.text-end');
      if (totalPriceElement) {
        totalPriceElement.textContent = `\${totalPrice}원`;
      }
    }

    increaseBtns.forEach((btn, idx) => {
      btn.addEventListener("click", () => {
        console.log("Increase button clicked for index:", idx);
        quantityInputs[idx].stepUp();
        updateSummary();
      });
    });

    decreaseBtns.forEach((btn, idx) => {
      btn.addEventListener("click", () => {
        console.log("Decrease button clicked for index:", idx);
        quantityInputs[idx].stepDown();
        updateSummary();
      });
    });

    quantityInputs.forEach(input => {
      input.addEventListener("input", () => {
        console.log("Input changed for:", input.dataset.name);
        updateSummary();
      });
    });

    updateSummary();
  });

</script>

</body>
</html>