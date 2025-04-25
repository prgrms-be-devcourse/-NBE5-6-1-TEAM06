<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>

<html>
<head>
    <title>Grepp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage.css">
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>

<main class="container">
    <div class="menu-name">
        <strong>${member.userId}</strong> 주문 취소 성공 실패 화면
    </div>
    <c:choose>
        <c:when test="${status == 'success'}">
            <h4> 주문 취소 성공</h4>

        </c:when>

        <c:when test="${status == 'fail'}">
            <h2> 취소 실패</h2>
        </c:when>

        <c:otherwise>
            <h1> 오류 발생</h1>
        </c:otherwise>
    </c:choose>

</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>


</body>
</html>