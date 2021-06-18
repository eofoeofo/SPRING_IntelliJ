<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <form action="list" id="frm">
        <input type="hidden" name="page" value="${param.page == null ? 1 : param.page}">
        <select name="recordCnt">
            <c:forEach begin="5" end="20" step="5" var="cnt">
                <c:choose>
                    <c:when test="${cnt eq param.recordCnt}">
                        <option selected>${cnt}</option>
                    </c:when>
                    <c:otherwise>
                        <option>${cnt}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </form>
</div>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일시</th>
        <form name="frmChk" onsubmit="return checkForm(this)">
            <input type="checkbox" name="spring" name="SEASON[]" value="1">봄
            <input type="checkbox" name="summer" name="SEASON[]" value="2">여름
            <input type="checkbox" name="fall" name="SEASON[]" value="3">가을
            <input type="checkbox" name="winter" name="SEASON[]" value="4">겨울
            <input type="submit" value="전송">
        </form>
        <th><button>삭제</button></th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr class="record" onclick="moveToDetail(${item.iboard});">
            <td>${item.iboard}</td>
            <td>
                <c:choose>
                    <c:when test="${param.searchType eq 1 || param.searchType eq 2}">
                        ${item.title.replace(param.searchText, '<mark>' += param.searchText += '</mark>')}
                    </c:when>
                    <c:otherwise>
                        ${item.title}
                    </c:otherwise>
                </c:choose>
                <c:if test="${not empty sessionScope.loginUser && item.isFav eq 1}">
                    <i class="fas fa-kiss-wink-heart"></i>
                </c:if>
            </td>
            <c:choose>
                <c:when test="${empty item.profileImg}">
                    <c:set var="img" value="/res/img/no_profile.jpg"/>
                </c:when>

                <c:otherwise>
                    <c:set var="img" value="/img/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}" />
                </c:otherwise>
            </c:choose>
            <td>
                <c:choose>
                    <c:when test="${param.searchType eq 4}">
                        ${item.writerNm.replace(param.searchText, '<mark>' += param.searchText += '</mark>' )}
                    </c:when>
                    <c:otherwise>
                        ${item.writerNm}
                    </c:otherwise>
                </c:choose>
                <img src="${img}" class="profileImg">
            </td>
            <td>${item.regdt}</td>
        </tr>
    </c:forEach>
</table>
<div>
    <c:forEach begin="1" end="${pagingCnt}" var="page">
        <c:choose>
            <c:when test="${page eq param.page || (empty param.page && page eq 1)}">
                <span class="colorRed">${page}</span>
            </c:when>
            <c:otherwise>
                <span><a href="list?page=${page}&recordCnt=${param.recordCnt == null ? 5 : param.recordCnt}&searchType=${param.searchType == null ? 1 : param.searchType}&searchText=${param.searchText == null ? '' : param.searchText}">${page}</a></span>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<div>
    <form action="list" method="get">
        <div>
            <select name="searchType">
                <option value="1" ${param.searchType == 1 ? 'selected' : '' }>제목+내용</option>
                <option value="2" ${param.searchType == 2 ? 'selected' : '' }>제목</option>
                <option value="3" ${param.searchType == 3 ? 'selected' : '' }>내용</option>
                <option value="4" ${param.searchType == 4 ? 'selected' : '' }>글쓴이</option>
            </select>
            <input type="search" name="searchText" value="${param.searchText}">
            <input type="submit" value="검색">
        </div>
    </form>
</div>