<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <ul>
        <c:choose>
            <c:when test="${empty sessionScope.loginUser}">
                <li>
                    <a href="/user/login">LOGIN</a>
                </li>

                <li>
                    <a href="/user/join">SIGNUP</a>
                </li>
            </c:when>

            <c:otherwise>
                <li>
                    <a href="/user/logout">LOGOUT</a>
                </li>

                <li>
                    <a href="/board/favList">LIKE</a>
                </li>
            </c:otherwise>
        </c:choose>
        <li>
            <a href="/">HOME</a>
        </li>

        <li>
            <a href="/board/list">LIST</a>
        </li>

        <c:if test="${not empty sessionScope.loginUser}">
            <li>
                <a href="/board/writeMod">WRITE</a>
            </li>

            <li>
                <a href="/user/profile">PROFILE</a>
            </li>
        </c:if>
    </ul>
</header>
