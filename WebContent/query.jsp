<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>查询商品</title>
<!-- 加载bootstrap.css文件 -->
<link rel="stylesheet" href="/javaweb/css/bootstrap.css" />
</head>
<body>
    <!-- 加载的bootstrap框架之后,所有的body标签里面的元素,需要存储在 div class="container" -->
	<div class="container" style="padding-top: 10px">
		<!-- form-inline:代表内联(文本框与按钮在同一行)表单, -->
		<form action="<%=request.getContextPath()%>/product/queryByName.mvc"
			method="post" class="form-inline">
			<!-- form-group:代表的表单元素组(包括提示文字 + 表单元素) -->
			<div class="form-group">
				<!-- for:定义的名称,要与文本框的id相同 -->
				<label for="word">关键字:</label> <input type="text" name="keyword"
					class="form-control" id="word" placeholder="请输入查询关键字">
			</div>
			<!-- bootstrap采用的 基本样式+个性样式的方式-->
			<button type="submit" class="btn btn-primary">给我搜</button>
		</form>
		<br />

		<!-- 此处只需要显示从后台获取的数据即可(在web中推荐使用jstl标签,因此需要在页面顶部添加标签库)
                          如果在导入标签库时报错,则需要添加两个jar: jstl-1.2.jar standard-1.1.2.jar
     -->
		<!-- bootstrap采用的 基本样式+个性样式的方式:例如table则基本样式名称就称为table -->
		<table class="table table-striped table-hover table-bordered">
			<tr>
				<th>编号</th>
				<th>名称</th>
				<th>价格</th>
				<th>备注</th>
				<th>日期</th>
				<th>所属类别</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${requestScope.proList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.remark}</td>
					<td>${product.date}</td>
					<td>${product.category.name}</td>
					<td>更新|删除</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>