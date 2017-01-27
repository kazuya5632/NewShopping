<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>商品一覧</h3>
	<table border="1" style="font-size: 15px;">
		<thead>
			<tr>
				<th>商品番号 <a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=code&sort_pattern=asc">▲</a>
					<a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=code&sort_pattern=desc">▼</a>
				</th>
				<th>商品名 <a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=name&sort_pattern=asc">▲</a>
					<a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=name&sort_pattern=desc">▼</a>
				</th>
				<th>価格 <a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=price&sort_pattern=asc">▲</a>
					<a
					href="/NewShopping/shop?action=sortShow&category_code=${sortCode}&sort=price&sort_pattern=desc">▼</a>
				</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.code}</td>
					<td>${item.name}</td>
					<td>${item.price}</td>


					<td><s:form action="/cart/addCart">
							<s:textfield key="quantity" />
							<input type="hidden" name="code" value="${item.code}" />
							<s:submit value="カートに入れる" />
						</s:form></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>