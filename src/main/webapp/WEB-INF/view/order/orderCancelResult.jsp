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
    </div>
    <c:choose>
    <c:when test="${status == 'success'}">
        <div class="menu-name">
        <strong>${member.userId}</strong>님, 주문이 성공적으로 취소되었습니다.
        </div>
        </c:when>

        <c:when test="${status == 'fail'}">
        <h2> ${member.userId}님, 주문 취소가 실패되었습니다.</h2>
        </c:when>

        <c:otherwise>
        <h1> 오류 발생</h1>
        </c:otherwise>
        </c:choose>

</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>


</body>
</html>