<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${empty data}">
        <h1>글쓰기</h1>
        <c:set var="iboard" value="0" />
    </c:when>
    <c:otherwise>
        <h1>삭제</h1>
        <c:set var="iboard" value="${data.iboard}" />
    </c:otherwise>
</c:choose>
<form action="writeMod" method="post">
    <input type="hidden" name="iboard" value="${iboard}">
    <div>
        <input type="text" name="title" placeholder="제목" value="${data.title}">
    </div>

    <div>
        <textarea name="ctnt" placeholder="내용">${data.ctnt}</textarea>
    </div>

    <div>
        <input type="submit" value="등록">
        <input type="reset" value="새로작성">
    </div>
</form>