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

	<h1>商品一覧</h1>
	<table>
		<tr>
			<td>商品番号</td>
			<td>商品名</td>
			<td>単価</td>
		</tr>

		<c:forEach var="item" items="${items}">
			<tr>
				<td>${item.code}</td>
				<td>${item.name}</td>
				<td>${item.price}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>