<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<s:url action="showAll" namespace="shop" />">全データ表示</a>

	<br>
	<br>

	<s:form action="/shop/showItemByCategory" theme="simple">
		<select name="categoryCode">
			<c:forEach var="cat" items="${category}">
				<option value="${cat.code}">${cat.name}</option>
			</c:forEach>
		</select>
		<s:submit value="表示" />
	</s:form>

</body>
</html>