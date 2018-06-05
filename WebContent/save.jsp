<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<!-- 加载bootstrap.css文件 -->
<link rel="stylesheet" href="/javaweb/css/bootstrap.css" />
<title>添加商品</title>
</head>
<body>
	<div class="container" style="padding-top: 10px">
		<!-- action:就是配置提交到后台的地址,请注意在web项目中,所有的请求都需要添加工程名 -->
		<!-- *.mvc是在web.xml中已经配置,只有mvc后缀的请求才会交给spring mvc处理 -->
		<!-- request.getContextPath() 动态获取当前项目的工程名 -->
		<form action="<%=request.getContextPath()%>/product/save.mvc" method="get" class="form-horizontal">
			<!-- form-group:代表的表单元素组(包括提示文字 + 表单元素) -->
			<div class="form-group">
			    <!-- lable:代表提示文字 
			         class="col-sm-2 代表所占的列宽(总共有12列)
			         placeholder:文本框的提示
			     -->
				<label for="pname" class="col-sm-2 control-label">商品名称:</label>
				<div class="col-sm-6">
					<input type="text" name="name" class="form-control" id="pname"
						placeholder="商品名称">
					<span class="inline-block">如果有错误,此处将会显示错误消息</span>
				</div>
			</div>
			
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">商品价格:</label>
				<div class="col-sm-6">
					<input type="text" name="price" class="form-control" id="price"
						placeholder="商品价格">
				</div>
			</div>
			<!-- 商品备注,采用文本域 -->
			<div class="form-group">
				<label for="remark" class="col-sm-2 control-label">商品备注:</label>
				<div class="col-sm-8">
					<textarea class="form-control" name="remark" rows="3" id="remark"></textarea>
				</div>
			</div>
			
			<!-- 商品备注,采用文本域 -->
			<div class="form-group">
				<label for="cid" class="col-sm-2 control-label">所属类别:</label>
				<div class="col-sm-8">
					<select class="form-control" name="category.id" id="cid">
					   <!-- 
					    <option value="1">数码产品</option>
					    <option value="2">服饰</option>
					    -->
					    <c:forEach items="${applicationScope.categoryList}" var="category">
					         <option value="${category.id}">${category.name}</option>
					    </c:forEach>
					</select>
				</div>
			</div>
			
			
			<!-- 设置要偏移的列数: col-sm-offset-2 -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">添加商品</button>
				</div>
			</div>
		</form>
















	</div>

</body>
</html>