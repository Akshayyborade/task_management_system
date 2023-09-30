<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-dark navbar-expand-lg bg-dark ">
	<div class="container-fluid">
		<div>
			<a class="navbar-brand" href="#"><i
				class="fa-solid fa-list-check"></i></i> Task</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
			</ul>
		</div>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<c:if test="${not empty user}">
					<li class="nav-item"><a class="nav-link active"
						href="../user/user.jsp"><i class="fa-solid fa-user-plus"></i>
							${user.getName() }</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="logOut"><i
							class="fa-solid fa-right-to-bracket"></i> Logout</a></li>
				</c:if>
				<c:if test="${empty user }">
					<li class="nav-item"><a class="nav-link active"
						href="register"><i class="fa-solid fa-user-plus"></i> Register</a></li>
					<li class="nav-item"><a class="nav-link active" href="login"><i
							class="fa-solid fa-right-to-bracket"></i> Login</a></li>
				</c:if>



			</ul>
		</div>
	</div>

</nav>