<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>

<meta charset="utf-8" />
<title>I-Repo | Users</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta content="Premium Multipurpose Admin & Dashboard Template"
	name="description" />
<meta content="Themesbrand" name="author" />
<!-- App favicon -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResource/images/favicon.ico">

<!-- DataTables -->
<link
	href="<%=request.getContextPath()%>/adminResource/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="<%=request.getContextPath()%>/adminResource/css/buttons.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />

<!-- Responsive datatable examples -->
<link
	href="<%=request.getContextPath()%>/adminResource/css/responsive.bootstrap4.min.css"
	rel="stylesheet" type="text/css" />

<!-- Bootstrap Css -->
<link
	href="<%=request.getContextPath()%>/adminResource/css/bootstrap.min.css"
	id="bootstrap-style" rel="stylesheet" type="text/css" />



<!-- Bootstrap Css -->
<link href="<%=request.getContextPath()%>/adminResource/css/style.css"
	id="bootstrap-style" rel="stylesheet" type="text/css" />

<!-- Icons Css -->
<link
	href="<%=request.getContextPath()%>/adminResource/css/icons.min.css"
	rel="stylesheet" type="text/css" />
<!-- App Css-->
<link href="<%=request.getContextPath()%>/adminResource/css/app.min.css"
	id="app-style" rel="stylesheet" type="text/css" />
<!-- App js -->
<script src="<%=request.getContextPath()%>/adminResource/js/plugin.js"></script>

</head>

<body data-sidebar="dark">

	<!-- <body data-layout="horizontal" data-topbar="dark"> -->

	<!-- Begin page -->
	<div id="layout-wrapper">


		<jsp:include page="header.jsp"></jsp:include>

		<!-- ========== Left Sidebar Start ========== -->
		<jsp:include page="menu.jsp"></jsp:include>
		<!-- Left Sidebar End -->



		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<!-- ============================================================== -->
		<div class="main-content">

			<div class="page-content">
				<div class="container-fluid">

					<!-- start page title -->
					<div class="row">
						<div class="col-12">
							<div
								class="page-title-box d-sm-flex align-items-center justify-content-between">
								<h4 class="mb-sm-0 font-size-18">Users</h4>
								<ol class="breadcrumb m-0">
									<li class="breadcrumb-item"><a href="index">Home</a></li>
									<li class="breadcrumb-item active">Users</li>
								</ol>

								<div class="page-title-right">
									<button type="button"
										class="btn btn-primary waves-effect waves-light"
										data-bs-toggle="modal" data-bs-target="#myModal"
										onclick="closeModal()">Add</button>
								</div>
								<!-- sample modal content -->
								<!-- /.modal -->
							</div>
							<!-- end preview-->


						</div>
					</div>
				</div>
				<!-- end page title -->

				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">

								<table id="datatable"
									class="table table-bordered dt-responsive  nowrap w-100">
									<thead>
										<tr>
											<th>#</th>
											<th>Name</th>
											<th>Mobile Number</th>
											<th>Email</th>
											<th>Username</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${userList}" var="i" varStatus="j">
											<tr>
												<td>${j.count}</td>
												<td><a class="text-primary"
													onclick="showInfo('${i.id}')" href="javascript:void(0)">
														${i.firstName}&nbsp;${i.lastName} </a></td>
												<td>${i.mobileNumber}</td>
												<td>${i.email}</td>
												<td>${i.username}</td>
												<td><a class="btn-outline-primary"
													href="javascript:void(0)"
													onclick="handleClickOfEdit('${i.id}')"> <i
														class="fas fa-pencil-alt"></i></a>&nbsp;&nbsp; <a
													class="delete-icon-color" href="deleteUser?id=${i.id}">
														<i class="fas fa-trash-alt"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>

								</table>

							</div>
						</div>
					</div>
					<!-- end col -->
				</div>
				<!-- end row -->



			</div>
			<!-- container-fluid -->
		</div>
		<!-- End Page-content -->


		<jsp:include page="footer.jsp"></jsp:include>
		<!-- end main content-->

	</div>

	<!-- END layout-wrapper -->

	<!-- Right Sidebar -->

	<!-- /Right-bar -->


	<div id="myInfoModal" class="modal fade" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="myInfoModalLabel">Add User</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" id="infoModalBody"></div>


			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>


	<div id="myModal" class="modal fade" tabindex="-1"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="myModalLabel">Add User</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<f:form id="myForm" action="saveUser" method="post"
						modelAttribute="UserVO">
						<div class="row">
							<div class="mb-3 col-6">
								<label for="name" class="form-label">First Name</label>
								<f:input class="form-control" id="firstName" path="firstName"
									name="firstName" />
							</div>
							<div class="mb-3 col-6">
								<label for="name" class="form-label">Last Name</label>
								<f:input class="form-control" id="lastName" path="lastName"
									name="lastName" />
							</div>
						</div>

						<div class="mb-3">
							<label class="form-label">Gender</label><br>
							<div class="form-check form-check-inline">
								<f:radiobutton path="gender" value="male"
									cssClass="form-check-input" id="male" />
								<label class="form-check-label" for="male">Male</label>
							</div>
							<div class="form-check form-check-inline">
								<f:radiobutton path="gender" value="female"
									cssClass="form-check-input" id="female" />
								<label class="form-check-label" for="female">Female</label>
							</div>
						</div>
						<div class="row">
							<div class="mb-3 col-6">
								<label for="mobile" class="form-label">Mobile Number</label>
								<f:input type="text" class="form-control" id="mobile"
									path="mobileNumber" name="mobileNumber" />
							</div>
							<div class="mb-3 col-6">
								<label for="email" class="form-label">Email address</label>
								<f:input type="email" class="form-control" id="email"
									path="email" name="email" />
							</div>
						</div>
						<div class="mb-3">
							<label for="username" class="form-label">Username</label>
							<f:input type="text" class="form-control" id="username"
								path="username" name="username" />
						</div>
						<div class="row">
							<div class="mb-3 col-6">
								<label for="state" class="form-label">State</label>
								<f:select path="stateVO.id" class="form-select" id="stateName"
									onchange="getCityByState()">
									<option disabled="disabled" selected="selected">Select
										State</option>
									<c:forEach items="${stateList}" var="i">
										<option value="${i.id}">${i.stateName}</option>
									</c:forEach>
								</f:select>
							</div>
							<div class="mb-3 col-6">
								<label for="city" class="form-label">City</label>
								<f:select path="cityVO.id" class="form-select" id="cityName">
									<option disabled="disabled" selected="selected">Select
										City</option>
								</f:select>
							</div>
						</div>
						<div class="mb-3">
							<label for="address" class="form-label">Address</label>
							<f:textarea class="form-control" id="address" path="address"
								name="address" rows="3"></f:textarea>
						</div>
						<div class="modal-footer">

							<f:hidden path="id" />
							
							<f:hidden path="loginVO.id"  name="loginId" id="loginId"/>

							<button type="button" class="btn btn-secondary waves-effect"
								data-bs-dismiss="modal" onclick="closeModal()">Close</button>
							<button type="submit" id="saveBtn" onclick="findUsername()"
								class="btn btn-primary waves-effect waves-light">Save</button>
						</div>
					</f:form>
					
				</div>
			</div>
		</div>
	</div>





	<!-- JAVASCRIPT -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/custom/users.js"></script>

	<script
		src="<%=request.getContextPath()%>/adminResource/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/bootstrap.bundle.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/metisMenu.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/simplebar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/waves.min.js"></script>

	<!-- Required datatable js -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/dataTables.bootstrap4.min.js"></script>
	<!-- Buttons examples -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/buttons.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/vfs_fonts.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/buttons.colVis.min.js"></script>

	<!-- Responsive examples -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResource/js/responsive.bootstrap4.min.js"></script>

	<!-- Datatable init js -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/datatables.init.js"></script>

	<script src="<%=request.getContextPath()%>/adminResource/js/app.js"></script>



</body>
</html>