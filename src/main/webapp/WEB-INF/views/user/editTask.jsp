<%@page import="com.project.taskmanager.service.TaskService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.project.taskmanager.model.Task"%>
<%@ page
	import="org.springframework.web.context.WebApplicationContext,
    org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.project.taskmanager.service.TaskService"%>



<!DOCTYPE html>
<html>
<head>
<title>Edit Task</title>
<%@include file="../../../css/allcss.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="/WEB-INF/componant/navbar.jsp"%>
	<c:if test="${empty user }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<div class="container">
		<h1 class="text-center">Edit Task</h1>


		<form action="user/updateTask" method="post">${task.id }
			<input type="hidden" name="id" value="${task.id }">

			<div class="mb-3">
				<label for="task_title">Task Title</label> <input type="text"
					class="form-control" id="title" name="title" value="${task.title}">
			</div>

			<div class="mb-3">
				<label for="task_description">Task Description</label>
				<textarea class="form-control" id="description" name="description">${task.description}</textarea>
			</div>

			<div class="mb-3">
				<label for="task_due_date">Due Date</label> <input type="date"
					class="form-control" id="dueDate" name="dueDate"
					value="<fmt:formatDate value='${task.dueDate}' pattern='yyyy-MM-dd' />">
			</div>
			<div class="mb-3">
				<label for="status" class="form-label">Status</label> <select
					class="form-select" id="status" name="status">
					<option value="true" ${task.status ? 'selected' : ''}>Completed</option>
					<option value="false" ${!task.status ? 'selected' : ''}>In
						Progress</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="assignedUser" class="form-label">Assigned To</label> <select
					class="form-select" id="assignedUser" name="assignedUser">
					<c:forEach var="user" items="${users}">
						<option value="${user.id}"
							${user.id == task.assignedUser.id ? 'selected' : ''}>${user.name}</option>
					</c:forEach>
				</select>
			</div>



			<button type="submit" class="btn btn-primary">Save</button>
		</form>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
