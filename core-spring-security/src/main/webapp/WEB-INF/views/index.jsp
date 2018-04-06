<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
				<title>인덱스 페이지</title>
</head>
<body>

<ul>
				<sec:authorize access="isAuthenticated()">
								<li>authenticated as <sec:authentication property="principal.username" /></li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_MEMBER')">
								<li>This text is only visible to a member</li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_ADMIN')">
								<li>This text is only visible to an admin</li>
				</sec:authorize>
				
				<sec:authorize access="! isAuthenticated()">
								<li><a href="<c:url value='/login' />">로그인</a></li>
				</sec:authorize>
				
				<sec:authorize access="isAuthenticated()">
								<form:form action="/logout" method="POST">
												<input type="submit" value="Logout" />
								</form:form>
				</sec:authorize>
</ul>

</body>
</html>
