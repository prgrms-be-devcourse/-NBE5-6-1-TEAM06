<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>주문 페이지</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
<h4>주문 페이지 입니다!!!</h4>

    <form action="" method="post" class="form-example">
        <div class="form-example">
            <label for="name">Enter your name: </label>
            <input type="text" name="name" id="name" required />
        </div>

        <div class="form-example">
            <input type="submit" value="장바구니에 담기" />
        </div>
        <div class="form-example">
            <input type="submit" value="결제하기" />
        </div>
    </form>

</main>
<%@ include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>