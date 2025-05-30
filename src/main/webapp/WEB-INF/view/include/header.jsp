<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<header class="header">
    <nav class="navbar white">
        <div class="nav-wrapper ">
            <a href="/" class="brand-logo grey-text">Grids & Circles Coffee</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
                <sec:authorize access="isAnonymous()">
                    <li><a href="/member/signin" class="grey-text">sign in</a></li>
                    <li><a href="/member/signup" class="grey-text">sign up</a></li>
                    <li>
                        <a href="mobile.html">
                            <i class="material-icons grey-text sidenav-trigger"
                               data-target="slide-out">more_vert</i>
                        </a>
                    </li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <li><a href="/admin/dashboard" class="grey-text">adminpage</a></li>
                    </sec:authorize>

                    <sec:authorize access="!hasRole('ROLE_ADMIN')">
                        <c:choose>
                            <c:when test="${fn:contains(pageContext.request.requestURI, 'member/mypage')}">
                                <li><a href="/cartList" class="grey-text">cart</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="/member/mypage" class="grey-text">mypage</a></li>
                            </c:otherwise>
                        </c:choose>
                    </sec:authorize>

                    <li><a href="#" id="logout" class="grey-text">logout</a></li>
                    <li>
                        <a href="mobile.html">
                            <i class="material-icons grey-text sidenav-trigger"
                               data-target="slide-out">more_vert</i>
                        </a>
                    </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>
</header>
<form:form action="/logout" method="post" id="logoutForm">
</form:form>
<script>
    (() => {

        const logout = document.querySelector('#logout');
        if (!logout) return;

        logout.addEventListener('click', ev => {
            ev.preventDefault();
            logoutForm.submit();
        });

    })();

</script>

