<%@page import="java.util.ArrayList"%>
<%@page import="com.project.taskmanager.model.Task"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Task Management Dashboard</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<%@include file="../../../css/allcss.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/componant/navbar.jsp"%>
	<c:if test="${empty user }">
		<c:redirect url="login"></c:redirect>
	</c:if>
	<h1 class="text-center">Dashboard</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<form action="user/showTask" method="post">
					<div class="search-and-filter-bar">
						<input type="text" name="title" placeholder="Search tasks..."
							class="form-control"> <select name="status"
							class="form-select">
							<option value="">All statuses</option>

							<option value="0">In Progress</option>
							<option value="1">Completed</option>
						</select> <input type="date" name="due_date" class="form-control">
						<button type="submit" class="btn btn-primary">Search and
							Filter</button>
					</div>
				</form>
			</div>
			<div class="col-md-12">

				<div class="task-list">
					<c:if test="${not empty sessionScope.tasks}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Title</th>
									<th>Description</th>
									<th>Due Date</th>
									<th>Status</th>
									<th>Assigned To</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="task" items="${sessionScope.tasks}">
									<tr>
										<td>${task.title}</td>
										<td>${task.description}</td>
										<td>${task.dueDate}</td>
										<td>${task.status}</td>
										<td><select name="assigned_to">
												<option value="">Select a user</option>
												<option value="1">John Doe</option>
												<option value="2">Jane Doe</option>
										</select></td>
										<td><a class="btn btn-primary"
											href="editTask?id=${task.id }">Edit</a>
											<form action="user/deleteTask" method="post">
												<input type="hidden" name="taskId" value="${task.id }">
												<button type="submit" class="btn btn-danger">Delete</button>
											</form></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</c:if>
					<a class="btn btn-primary mt-3"
						href="addTask?userId=${user.getId() }">Create New Task</a>
				</div>

			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
