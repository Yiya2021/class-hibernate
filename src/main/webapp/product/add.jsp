<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 20468
  Date: 2023/3/27
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="add.do">
    产品名称:<input type="text" name="productName"><br>
    生产日期:<input type="text" name="productDate"><br>
    产品单价:<input type="text" name="productPrice"><br>
    库存数量:<input type="text" name="productStock"><br>
    包装类型:<input type="text" name="productPacking"><br>
    包装尺寸:<input type="text" name="productSize"><br>
    销售区域:
    <c:forEach var="area" items="${areaList}">
        <input type="checkbox" name="areaId" value="${area.ANo}">${area.AName}
    </c:forEach><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
