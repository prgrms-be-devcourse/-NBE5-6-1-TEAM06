<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<c:if test="${not empty param.error}">
    <div class="card-panel red lighten-2 text-white">${param.error}</div>
</c:if>
<h4>메인 페이지 : 커피콩 판매 합니다~~~  </h4>
    <div class="row">
        <div class="col s6 m3">
            <div class="card">
                <div class="card-image">
                    <img src="/assets/images/${product.productImgUrl}" style="width: 247px; height: 160px;">
                    <span class="card-title">Card Title</span>
                </div>
                <div class="card-content">
                    <p>상품명</p><hr>
                    <p>상품 설명</p>
                </div>
            </div>
        </div>
        <div class="col s6 m3">
            <div class="card">
                <div class="card-image">
                    <img src="/assets/images/${product.productImgUrl}" style="width: 247px; height: 160px;">
                    <span class="card-title">Card Title</span>
                </div>
                <div class="card-content">
                    <p>상품명</p><hr>
                    <p>상품 설명</p>
                </div>
            </div>
        </div>
        <div class="col s6 m3">
            <div class="card">
                <div class="card-image">
                    <img src="/assets/images/${product.productImgUrl}" style="width: 247px; height: 160px;">
                    <span class="card-title">Card Title</span>
                </div>
                <div class="card-content">
                    <p>상품명</p><hr>
                    <p>상품 설명</p>
                </div>
            </div>
        </div>
        <div class="col s6 m3">
            <div class="card">
                <div class="card-image">
                    <img src="/assets/images/${product.productImgUrl}" style="width: 247px; height: 160px;">
                    <span class="card-title">Card Title</span>
                </div>
                <div class="card-content">
                    <p>상품명</p><hr>
                    <p>상품 설명</p>
                </div>
            </div>
        </div>
    </div>

    <div style="display: flex; justify-content: center; align-items: center; height: 10vh;">
        <button>구매하기</button>
    </div>



</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>