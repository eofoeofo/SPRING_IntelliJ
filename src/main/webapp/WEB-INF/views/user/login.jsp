<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>로그인</h1>
<div>${requestScope.errMsg}</div>
<form action="login" method="post">
    <div><input type="text" name="uid" placeholder="id" value="zzzz"></div>
    <div><input type="password" name="upw" placeholder="password" value="123"></div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>