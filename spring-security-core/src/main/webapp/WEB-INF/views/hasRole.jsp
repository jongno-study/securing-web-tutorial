<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<security:authorize access="hasRole('ROLE_USER')">
    This text is only visible to a user
    <br/>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
    This text is only visible to an admin
    <br/>
</security:authorize>
</body>
</html>