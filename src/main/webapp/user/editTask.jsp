<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Edit Task</title>
  <%@include file="../css/allcss.jsp"%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%@ include file="../componant/navbar.jsp"%>
  <div class="container">
    <h1 class="text-center">Edit Task</h1>

    <form action="/tasks/update" method="post">

      <input type="hidden" name="task_id" value="${task.id}">

      <div class="mb-3">
        <label for="task_title">Task Title</label>
        <input type="text" class="form-control" id="task_title" name="task_title" value="${task.title}">
      </div>

      <div class="mb-3">
        <label for="task_description">Task Description</label>
        <textarea class="form-control" id="task_description" name="task_description">${task.description}</textarea>
      </div>

      <div class="mb-3">
        <label for="task_due_date">Due Date</label>
        <input type="date" class="form-control" id="task_due_date" name="task_due_date" value="${task.dueDate}">
      </div>

      <div class="mb-3">
        <label for="task_assigned_to">Assigned To</label>
        <select class="form-control" id="task_assigned_to" name="task_assigned_to">
          <option value="">Select a user</option>
          <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.name}</option>
          </c:forEach>
        </select>
      </div>

      <div class="mb-3">
        <label for="task_status">Status</label>
        <select class="form-control" id="task_status" name="task_status">
          
          <option value="in_progress">In Progress</option>
          <option value="completed">Completed</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary">Save</button>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
