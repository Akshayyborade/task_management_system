<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/css/allcss.jsp"%>
</head>
<body>
<%@ include file="/WEB-INF/componant/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Register Here</p>
						<c:if test="${not empty msg }">
							<div class="alert alert-success text-center" role="alert">${msg }</div>
							<c:remove var="msg" />

						</c:if>
						<c:if test="${not empty error }">
							<div class="alert alert-danger text-center" role="alert">${error }</div>
							<c:remove var="error" />
						</c:if>


					</div>
					<div class="card-body">
						<form action="register" method="post">
							<div class="mb-3">
								<label>Enter Full Name</label> <input type="text" name="name"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Email</label> <input type="email" name="email"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Password</label> <input type="password" name="password"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>About</label> <input type="text" name="about"
									class="form-control">
							</div>
							<button class="btn btn-dark col-md-12">Register</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>