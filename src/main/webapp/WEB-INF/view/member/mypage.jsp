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
    <h4>구매한 상품 정보 보여주기</h4>
    <h4>${member.userId}</h4>
    <h4>${member.username}</h4>
</main>

<%@include file="/WEB-INF/view/include/footer.jsp" %>
</body>
</html>