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
    <h4>메인 페이지 : 커피콩 판매 합니다~~~ </h4>
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col s6 m3">
                <div class="card">
                    <div class="card-image">
                        <img src="/assets/coffee.PNG" style="width: 200px; height: 160px;">
                        <span class="card-title"></span>
                    </div>
                    <div class="card-content">
                        <p>${product.productName}</p>
                        <hr>
                        <p>${product.info}</p>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div style="display: flex; justify-content: center; align-items: center; height: 10vh;">
        <a href="/order">
            <button>구매하기</button>
        </a>
    </div>


</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>