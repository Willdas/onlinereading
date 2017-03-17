<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String ipPath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort();
	String path = request.getContextPath();
	String basePath = ipPath + path + "/";
%>
<!DOCTYPE>
<html>
<body>
<h2>ccc</h2>

<a href="<%=basePath%>jsp/managePage/backstageManagePage.jsp">进入后台</a>

</body>
</html>
