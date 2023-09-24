<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<%@include file="../css/allcss.jsp"%>
</head>
<body>
	<%@ include file="../componant/navbar.jsp"%>
	<h1 class="text-center">Dashboard</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="search-and-filter-bar">
					<input type="text" name="search" placeholder="Search tasks..."
						class="form-control"> <select name="category"
						class="form-select">
						<option value="">All categories</option>

						<option value="in_progress">In Progress</option>
						<option value="completed">Completed</option>
					</select> <select name="status" class="form-select">
						<option value="">All statuses</option>

						<option value="in_progress">In Progress</option>
						<option value="completed">Completed</option>
					</select> <input type="date" name="due_date" class="form-control">
					<button type="submit" class="btn btn-primary">Search and
						Filter</button>
				</div>
			</div>
			<div class="col-md-12">
				<div class="task-list">
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
							<tr>
								<td>Task 1</td>
								<td>To Do</td>
								<td>2023-09-25</td>
								<td>Pending</td>
								<td><select name="assigned_to">
										<option value="">Select a user</option>
										<option value="1">John Doe</option>
										<option value="2">Jane Doe</option>
								</select></td>
								<td><a class="btn btn-primary" href="editTask.jsp">Edit</a>
									<button type="button" class="btn btn-danger">Delete</button></td>
							</tr>

						</tbody>
					</table>
					<button type="button" class="btn btn-primary mt-3">Create
						New Task</button>
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
