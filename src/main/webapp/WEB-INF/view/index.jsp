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

    <h4 style="text-align: center;">“We sell fresh coffee beans.”</h4>
    <div class="row">

        <c:forEach var="product" items="${products}">
            <div class="col s4 m3">
                <div class="card" style="text-align: center;">
                    <div class="card-image" style="text-align: center;">
                        <img src="/assets/images/${product.productImgUrl}"
                             style="width: 247px; height: 160px;">
                    </div>
                    <div class="card-content" style="text-align: center;">
                        <p>${product.productName}</p>
                        <hr>
                        <p>${product.category}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div style="display: flex; justify-content: center; align-items: center; height: 10vh;">

        <a href="/order"><button class="waves-effect waves-light btn-brown">구매하기</button></a>
    </div>


</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>