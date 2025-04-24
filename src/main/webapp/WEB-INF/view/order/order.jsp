<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">

    <!-- Materialize CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css"
          rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


    <link href="../../../assets/css/order.css" rel="stylesheet">
    <title>Order</title>
</head>
<body class="container-fluid">
<div class="row justify-content-center m-4">
    <h1 class="text-center">Grids & Circle</h1>
</div>
<div class="card">
    <div class="row">
        <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
            <h5 class="flex-grow-0"><b>Product List</b></h5>
            <ul class="list-group products">
                <li class="list-group-item d-flex mt-3">
                    <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg"
                                            alt=""></div>
                    <div class="col">
                        <div class="row text-muted">커피콩</div>
                        <div class="row">Columbia Nariñó</div>
                    </div>
                    <div class="col text-center price">5000원</div>
                    <div class="quantity-control d-flex align-items-center gap-1">
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                            <i class="material-icons">remove</i>
                        </button>
                        <input type="number"
                               class="form-control quantity-input"
                               value="1" min="0"
                               style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;" />
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </li>
                <li class="list-group-item d-flex mt-2">
                    <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg"
                                            alt=""></div>
                    <div class="col">
                        <div class="row text-muted">커피콩</div>
                        <div class="row">Brazil Serra Do Caparaó</div>
                    </div>
                    <div class="col text-center price">5000원</div>
                    <div class="quantity-control d-flex align-items-center gap-1">
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                            <i class="material-icons">remove</i>
                        </button>
                        <input type="number"
                               class="form-control quantity-input"
                               value="1" min="0"
                               style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;" />
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </li>
                <li class="list-group-item d-flex mt-2">
                    <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg"
                                            alt=""></div>
                    <div class="col">
                        <div class="row text-muted">커피콩</div>
                        <div class="row">Columbia Quindío</div>
                    </div>
                    <div class="col text-center price">5000원</div>
                    <div class="quantity-control d-flex align-items-center gap-1">
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                            <i class="material-icons">remove</i>
                        </button>
                        <input type="number"
                               class="form-control quantity-input"
                               value="1" min="0"
                               style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;" />
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </li>
                <li class="list-group-item d-flex mt-2">
                    <div class="col-2"><img class="img-fluid" src="https://i.imgur.com/HKOFQYa.jpeg"
                                            alt=""></div>
                    <div class="col">
                        <div class="row text-muted">커피콩</div>
                        <div class="row">Ethiopia Sidamo</div>
                    </div>
                    <div class="col text-center price">5000원</div>
                    <div class="quantity-control d-flex align-items-center gap-1">
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-decrease">
                            <i class="material-icons">remove</i>
                        </button>
                        <input type="number"
                               class="form-control quantity-input"
                               value="1" min="0"
                               style="width: 2rem; text-align: center; height: 1.5rem; font-size: 0.8rem;" />
                        <button type="button"
                                class="waves-effect waves-light btn-small btn-brown btn-xs quantity-increase">
                            <i class="material-icons">add</i>
                        </button>
                    </div>
                </li>
            </ul>
        </div>
        <div class="col-md-4 summary p-4">
            <div>
                <h5 class="m-0 p-0"><b>Summary</b></h5>
            </div>
            <hr>
            <div class="row">
                <h6 class="p-0">Columbia Nariñó <span class="badge bg-dark text-">2개</span></h6>
            </div>
            <div class="row">
                <h6 class="p-0">Brazil Serra Do Caparaó <span class="badge bg-dark">2개</span></h6>
            </div>
            <div class="row">
                <h6 class="p-0">Columbia Quindío <span class="badge bg-dark">2개</span></h6>
            </div>
            <div class="row">
                <h6 class="p-0">Ethiopia Sidamo <span class="badge bg-dark">2개</span></h6>
            </div>


            <form action="/order" method="post">
                <div class="mb-3">
                    <label for="email" class="form-label">이메일</label>
                    <input type="email" class="form-control mb-1" id="email">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">주소</label>
                    <input type="text" class="form-control mb-1" id="address">
                </div>
                <div class="mb-3">
                    <label for="postcode" class="form-label">우편번호</label>
                    <input type="text" class="form-control" id="postcode">
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>

                <div class="row pt-2 pb-2 border-top">
                    <h5 class="col">총금액</h5>
                    <h5 class="col text-end">15000원</h5>
                </div>
                <button type="submit" name="action" value="cart"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">shopping_cart</i>
                    장바구니
                </button>
                <button type="submit" name="action" value="order"
                        class="waves-effect waves-light btn-l hover">
                    <i class="material-icons left">payment</i>
                    결제하기
                </button>
            </form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/view/include/footer.jsp" %>
<script>
  document.addEventListener("DOMContentLoaded", function () {
    const qtyControls = document.querySelectorAll(".quantity-control");

    qtyControls.forEach(control => {
      const minusBtn = control.querySelector(".quantity-decrease");
      const plusBtn = control.querySelector(".quantity-increase");
      const input = control.querySelector(".quantity-input");

      minusBtn.addEventListener("click", () => {
        let val = parseInt(input.value);
        if (val > 0) input.value = val - 1;
      });

      plusBtn.addEventListener("click", () => {
        let val = parseInt(input.value);
        input.value = val + 1;
      });
    });
  });

</script>
</body>
</html>