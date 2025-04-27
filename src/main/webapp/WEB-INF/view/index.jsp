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
                    <p>콜롬비아 나리뇨 (Colombia Nariño)</p><hr>
                    <p>콜롬비아 남서부, 에콰도르와 인접한 고산 지대에 위치한 나리뇨는 해발 1,800m 이상의 고도에서 커피가 재배됩니다.
                        이 지역은 낮과 밤의 기온 차가 커 체리의 숙성이 천천히 이루어지며, 그 결과 복합적인 향미와 뛰어난 단맛, 밝은 산미를 지닌 커피가 생산됩니다.
                        나리뇨 커피는 꿀처럼 부드러운 단맛과 감귤류, 플로럴한 향이 어우러진 뛰어난 균형감을 자랑합니다. 카투라(Caturra), 카스티요(Castillo) 등의 품종이 주로 재배됩니다.</p>
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
        <a href="/order"><button >구매하기</button></a>
    </div>



</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>