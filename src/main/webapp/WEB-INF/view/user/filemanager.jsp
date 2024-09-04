<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">

<head>

<meta charset="utf-8" />
<title>File Manager | Skote - Admin & Dashboard Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta content="Premium Multipurpose Admin & Dashboard Template"
	name="description" />
<meta content="Themesbrand" name="author" />
<!-- App favicon -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResource/images/favicon.ico">

<!-- Bootstrap Css -->
<link
	href="<%=request.getContextPath()%>/adminResource/css/bootstrap.min.css"
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
								<h4 class="mb-sm-0 font-size-18">File Manager</h4>

								<div class="dropdown">
									<button class="btn btn-light w-100 px-5" type="button"
										data-bs-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false">
										<i class="mdi mdi-plus me-1"></i> Create New
									</button>
									<div class="dropdown-menu">
										<a class="dropdown-item" href="#" id="folderOption"><i
											class="bx bx-folder me-1"></i> Folder</a> <a
											class="dropdown-item" href="#"><i class="bx bx-file me-1"></i>
											File</a>
									</div>
								</div>
								<!-- New Folder Dialog -->
								<div id="newFolderDialog" class="modal" tabindex="-1"
									aria-labelledby="newFolderLabel" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered">
										<div class="modal-content">
											<div class="modal-header">
												<h5 class="modal-title" id="newFolderLabel">New Folder</h5>
												<button type="button" class="btn-close"
													data-bs-dismiss="modal" aria-label="Close"></button>
											</div>
											<div class="modal-body">
												<input type="text" id="folderNameInput" class="form-control"
													placeholder="Untitled folder" autofocus>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													id="cancelButton" data-bs-dismiss="modal">Cancel</button>
												<button type="button" class="btn btn-primary">Create</button>
											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
					</div>
					<!-- end page title -->

					<div class="d-xl-flex">
						<div class="w-100">
							<div class="d-md-flex">

								<!-- filemanager-leftsidebar -->

								<div class="w-100">
									<div class="card">
										<div class="card-body">
											<div>
												<div class="row mb-3">
													<div class="col-xl-3 col-sm-6">
														<div class="mt-2">
															<h5>My Files</h5>
														</div>
													</div>
													<div class="col-xl-9 col-sm-6">
														<form
															class="mt-4 mt-sm-0 float-sm-end d-flex align-items-center">
															<div class="search-box mb-2 me-2">
																<div class="position-relative">
																	<input type="text"
																		class="form-control bg-light border-light rounded"
																		placeholder="Search..."> <i
																		class="bx bx-search-alt search-icon"></i>
																</div>
															</div>

															<div class="dropdown mb-0">
																<a class="btn btn-link text-muted mt-n2" role="button"
																	data-bs-toggle="dropdown" aria-haspopup="true"> <i
																	class="mdi mdi-dots-vertical font-size-20"></i>
																</a>

																<div class="dropdown-menu dropdown-menu-end">
																	<a class="dropdown-item" href="#">Share Files</a> <a
																		class="dropdown-item" href="#">Share with me</a> <a
																		class="dropdown-item" href="#">Other Actions</a>
																</div>
															</div>


														</form>
													</div>
												</div>
											</div>

											<div>
												<div class="row">
													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Design</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">12 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">6GB</p>
																		</div>
																	</div>

																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Development</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">20 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">8GB</p>
																		</div>
																	</div>

																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Project
																					A</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">06 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">2GB</p>
																		</div>
																	</div>

																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Admin</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">08 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">4GB</p>
																		</div>
																	</div>
																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Sketch
																					Design</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">12 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">6GB</p>
																		</div>
																	</div>

																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

													<div class="col-xl-4 col-sm-6">
														<div class="card shadow-none border">
															<div class="card-body p-3">
																<div class="">
																	<div class="float-end ms-2">
																		<div class="dropdown mb-2">
																			<a class="font-size-16 text-muted" role="button"
																				data-bs-toggle="dropdown" aria-haspopup="true">
																				<i class="mdi mdi-dots-horizontal"></i>
																			</a>

																			<div class="dropdown-menu dropdown-menu-end">
																				<a class="dropdown-item" href="#">Open</a> <a
																					class="dropdown-item" href="#">Edit</a> <a
																					class="dropdown-item" href="#">Rename</a>
																				<div class="dropdown-divider"></div>
																				<a class="dropdown-item" href="#">Remove</a>
																			</div>
																		</div>
																	</div>
																	<div class="avatar-xs me-3 mb-3">
																		<div class="avatar-title bg-transparent rounded">
																			<i class="bx bxs-folder font-size-24 text-warning"></i>
																		</div>
																	</div>
																	<div class="d-flex">
																		<div class="overflow-hidden me-auto">
																			<h5 class="font-size-14 text-truncate mb-1">
																				<a href="javascript: void(0);" class="text-body">Applications</a>
																			</h5>
																			<p class="text-muted text-truncate mb-0">20 Files</p>
																		</div>
																		<div class="align-self-end ms-2">
																			<p class="text-muted mb-0">8GB</p>
																		</div>
																	</div>

																</div>
															</div>

														</div>
													</div>
													<!-- end col -->

												</div>
												<!-- end row -->
											</div>

											<div class="mt-4">
												<div class="d-flex flex-wrap">
													<h5 class="font-size-16 me-3">Recent Files</h5>

													<div class="ms-auto">
														<a href="javascript: void(0);"
															class="fw-medium text-reset">View All</a>
													</div>
												</div>
												<hr class="mt-2">

												<div class="table-responsive">
													<table
														class="table align-middle table-nowrap table-hover mb-0">
														<thead>
															<tr>
																<th scope="col">Name</th>
																<th scope="col">Date modified</th>
																<th scope="col" colspan="2">Size</th>
															</tr>
														</thead>
														<tbody>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-file-document font-size-16 align-middle text-primary me-2"></i>
																		index.html</a></td>
																<td>12-10-2020, 09:45</td>
																<td>09 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-folder-zip font-size-16 align-middle text-warning me-2"></i>
																		Project-A.zip</a></td>
																<td>11-10-2020, 17:05</td>
																<td>115 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-image font-size-16 align-middle text-muted me-2"></i>
																		Img-1.jpeg</a></td>
																<td>11-10-2020, 13:26</td>
																<td>86 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-text-box font-size-16 align-middle text-muted me-2"></i>
																		update list.txt</a></td>
																<td>10-10-2020, 11:32</td>
																<td>08 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-folder font-size-16 align-middle text-warning me-2"></i>
																		Project B</a></td>
																<td>10-10-2020, 10:51</td>
																<td>72 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-text-box font-size-16 align-middle text-muted me-2"></i>
																		Changes list.txt</a></td>
																<td>09-10-2020, 17:05</td>
																<td>07 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-image font-size-16 align-middle text-success me-2"></i>
																		Img-2.png</a></td>
																<td>09-10-2020, 15:12</td>
																<td>31 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="mdi mdi-folder font-size-16 align-middle text-warning me-2"></i>
																		Project C</a></td>
																<td>09-10-2020, 10:11</td>
																<td>20 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
															<tr>
																<td><a href="javascript: void(0);"
																	class="text-dark fw-medium"><i
																		class="bx bxs-file font-size-16 align-middle text-primary me-2"></i>
																		starter-page.html</a></td>
																<td>08-10-2020, 03:22</td>
																<td>11 KB</td>
																<td>
																	<div class="dropdown">
																		<a class="font-size-16 text-muted" role="button"
																			data-bs-toggle="dropdown" aria-haspopup="true"> <i
																			class="mdi mdi-dots-horizontal"></i>
																		</a>

																		<div class="dropdown-menu dropdown-menu-end">
																			<a class="dropdown-item" href="#">Open</a> <a
																				class="dropdown-item" href="#">Edit</a> <a
																				class="dropdown-item" href="#">Rename</a>
																			<div class="dropdown-divider"></div>
																			<a class="dropdown-item" href="#">Remove</a>
																		</div>
																	</div>
																</td>
															</tr>
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
									<!-- end card -->
								</div>
								<!-- end w-100 -->
							</div>
						</div>


					</div>
					<!-- end row -->

				</div>
				<!-- container-fluid -->
			</div>
			<!-- End Page-content -->


			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<!-- end main content-->

	</div>
	<!-- END layout-wrapper -->

	<!-- Right Sidebar -->

	<!-- /Right-bar -->

	<!-- Right bar overlay-->
	<div class="rightbar-overlay"></div>

	<!-- JAVASCRIPT -->
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

	<!-- apexcharts -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/apexcharts.min.js"></script>

	<!-- file-manager js -->
	<script
		src="<%=request.getContextPath()%>/adminResource/js/file-manager.init.js"></script>

	<script src="<%=request.getContextPath()%>/adminResource/js/app.js"></script>

	<script
		src="<%=request.getContextPath()%>/adminResource/js/custom/Document.js"></script>



</body>


</html>