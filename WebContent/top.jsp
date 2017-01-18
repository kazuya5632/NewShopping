<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/NewShopping/shop?action=showAll">全データ表示</a>
	<BR>

	<form action="/NewShopping/shop" method="post">
		<input type="hidden" name="action" value="showItemByCategory">

		<select name="category">
			<c:forEach var="cat" items="${category}">
				<option value="${cat.code}">${cat.name}</option>
			</c:forEach>
		</select> <BR>
		<input type="submit" value="表示">
	</form>
</body>
</html>