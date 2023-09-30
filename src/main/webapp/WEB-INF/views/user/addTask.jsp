<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../../css/allcss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body>
<c:if test ="${empty user }">
<c:redirect url="login"></c:redirect>
</c:if>
	<%@ include file="../../componant/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card ">
					<div class="card-header">
						<p class="text-center fs-3">Add Task</p>
						<c:if test="${not empty msg }">
							<p class="text-center text-dark fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="user/saveTask" method="post">
							<div class="mb-3">
								<label>Title:</label> <input type="text" name="title"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Description:</label> <input type="text"
									name="description" class="form-control">
							</div>
							<div class="mb-3">
								<label>Due Date:</label> <input type="date" name="dueDate"
									class="form-control">
							</div>
							<div class="mb-3">
								<input type="hidden" name="status" value="false"
									class="form-control">
							</div>
							<div class="mb-3">
							<%String id = request.getParameter("userId"); %>
								<label for="assignedUser">Assign to:</label> <br> <select
									id="assignedUser" name="assignedUser" class="form-control">
									<option value="<%=id %>">Self</option>
									<option value="2">Other User</option>
								</select><br>
								<br>
							</div>
							<button class="btn btn-dark col-md-12">Add</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>