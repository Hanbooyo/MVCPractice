<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<c:set var="result" value="${param.result}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
<style type="text/css">
	.sel_page {
		color : red;
	}
	a {
		text-decoration: none;
		color : black;
	}
</style>
<script>
	function fn_articleForm(isLogOn, articleForm, loginForm) {
		if(isLogOn != '' && isLogOn != 'false') {
			location.href=articleForm;
		}else {
			alert('로그인 후 글쓰기가 가능합니다.');
			location.href=loginForm + '?action=/articleForm.do';
		}
	}
</script>
<c:choose>
	<c:when test="${result=='loginFailed'}">
		<script>
			window.onload = function () {
				alert('아이디 혹은 비밀번호를 확인해주세요.')
			}
		</script>
	</c:when>
</c:choose>
</head>
<body>
	<header>
		<table width="100%">
		<tr>
			<td>
				<h1 align="center"><a href="${contextPath}/main.do">
					H O M E
				</a></h1>
			</td>
			<td>
				<h1 align="center">로그인 게시판 TEST</h1>
			</td>
			<td align="center">
				<c:choose>
					<c:when test="${isLogOn == true && member != null }">
						<h3>환영 합니다. ${member.id} 님</h3>
						<a href="${contextPath}/logout.do">로그아웃</a>
					</c:when>
					<c:otherwise>
						<form action="${contextPath}/login.do" method="post">
							<h3 align="center">로그인 창</h2>
							<table align="center">
								<tr>
									<td width="200"><p align="right">아이디</p></td>
									<td width="400"><input type="text" name="id"></td>
								</tr>
								<tr>
									<td width="200"><p align="right">비밀번호</p></td>
									<td width="400"><input type="text" name="pwd"></td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="로그인">
										<input type="reset" value="다시입력">
									</td>
								</tr>
							</table>
						</form>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
	</header>
		<h1><a href="${contextPath}/list.do">게시판 목록으로</a></h1>
</body>
</html>