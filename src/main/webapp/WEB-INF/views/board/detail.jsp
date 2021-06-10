<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/
libs/font-awesome/5.15.3/css/all.min.css"
integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<c:if test="${sessionScope.loginUser.iuser == data.iuser}">
    <div>
        <a href="delete?iboard=${data.iboard}">삭제</a>
        <a href="writeMod?iboard=${param.iboard}">수정</a>
    </div>
</c:if>
<div>
    <a href="#" onclick="goBack();">돌아가기</a>
</div>
<h1>${data.title}</h1>
<div>
    글번호 : ${data.iboard} | <i id="favIcon" class="far fa-kiss-wink-heart pointer"></i>
</div>
<div>
    작성자 : ${data.writerNm} | 작성일 : ${data.regdt}
</div>
<div>
    <c:out value="${data.ctnt}"/>
</div>

<c:if test="${not empty sessionScope.loginUser}">
    <div>
        <form id="cmtFrm" onsubmit="return false;">
            <input type="text" id="cmt" placeholder="댓글" onkeyup="enterKey();">
            <input type="button" value="댓글달기" onclick="regCmt();">
        </form>
    </div>
</c:if>
<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>

<div id="modal" class="displayNone">
    <div class="modal_content">
        <form id="cmtUpdFrm" onsubmit="return false;">
            <input type="hidden" id="icmt">
            <input type="text" id="cmt">
        </form>
        <input type="button" value="댓글 수정" onclick="updAjax();">
        <input type="button" value="취소" onclick="closeUpdModal();">
    </div>
</div>
