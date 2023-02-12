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
									<td width="400"><input type="password" name="pwd"></td>
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
	<div text-align="center">
	<form action="${contextPath}/update.do" method="post">
		<table border="1" align="center">
			<tr>
				<td width="100">글 번호</td><td width="200"><input type="hidden" name="no" value="${board.no}">${board.no}</td>
			</tr>
			<tr>
				<td width="100">작성자</td><td width="200"><input type="hidden" name="id" value="${board.id}">${board.id}</td>
			</tr>
			<tr>
				<td width="100">제 목</td><td width="200"><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td width="100">본 문</td><td width="200"><textarea cols="60" rows="10" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td width="100">작성일</td><td width="200">${board.wdate}</td>
			</tr>
			<tr>
				<td width="100">조회수</td><td width="200">${board.views}</td>
			</tr>
			<tr>
				<td><input type="submit" value="완료"></td><td><input type="button" onclick="location.href='${contextPath}/list.do}'" value="취소"></td>
			</tr>
		</table>
		</form>
			<h1><a type="button" href="${contextPath}/list.do">게시판 목록으로</a></h1>
	</div>
</body>
</html>