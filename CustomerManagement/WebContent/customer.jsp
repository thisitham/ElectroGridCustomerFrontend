<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer</title>
<link rel="stylesheet" href="View/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/customer.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="jumbotron" style="background-color: #1c2331;color:white;">
			<h1>ElectroGrid Systems</h1>
			<h3>Customer Management</h3>
			<h3>IT20124076</h3>
			<div class="navigation" style="float: right">
				<ul class="nav nav-pills">
					<li class="nav-item"><a class="nav-link text-light" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link disabled text-light" href="#">Power
							Management</a></li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Billing</a>
					</li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Customer
							Management</a></li>
					<li class="nav-item"><a class="nav-link text-light" href="#">Help</a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4">
				<div class="card border border-dark rounded">
					<div class="card-header text-light" style="background-color: #1c2331">
						<h4>Customer Details</h4>
					</div>
					<div class="card-body">
						<form id="formCustomer" name="formCustomer" method="post" action="customer.jsp">
                            
                            name: 
							<input id="name" name="name" type="text" class="form-control form-control-sm" placeholder="name"><br>
							email: 
							<input id="email" name="email" type="text" class="form-control form-control-sm" placeholder="email"><br>
							address: 
							<input id="address" name="address" type="text" class="form-control form-control-sm" placeholder="address"><br>
							district: 
							<select id="district" name="district" class="form-control form-control-sm">
							<option selected>Select a District</option>
							<option value="Gampaha">Gampaha</option>
							 <option value="Minuwangoda">Minuwangoda</option>
							<option value="Badulla">Badulla</option>
							<option value="Colombo">Colombo</option>
							<option value="Kadawatha">Kadawatha</option>
							<option value="Anuradhapura">Anuradhapura</option>
							<option value="Malabe">Malabe</option>  
							  </select>	
							  				
							
							<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
							<input type=" " id="hidCustomerIDSave" name="hidCustomerIDSave" value="">
						</form>

						<div id="alertSuccess" class="alert alert-success"></div>
						<div id="alertError" class="alert alert-danger"></div>
					</div>
					<div class="card-footer text-light" style="background-color: #1c2331">
						<h6 >Customer Management Module</h6>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="" >
					<h3 style="text-align:center;">Customer details</h3>
					<hr>
					<br>
				</div>
				<div class="card">
					<div class="table-responsive-md">

						<div id="divCustomerGrid">

							<%
							Customer customerObj = new Customer();
							out.print(customerObj.readCustomer());
							%>
						</div>
					</div>
					<div class="">
						<nav aria-label="...">
							<ul class="pagination justify-content-center">
								<li class="page-item"><a class="page-link" href="#"
									tabindex="-1">Previous</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">1</a></li>
								<li class="page-item disabled"><a class="page-link"
									href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		  <footer
          class="text-center text-lg-start text-white mt-3"
          style="background-color: #1c2331"
          >
    <!-- Section: Social media -->
    <section
             class="d-flex justify-content-between p-4"
             style="background-color: #6351ce"
             >
      <!-- Left -->
      <div class="me-5">
        <span>Get connected with us on social networks:</span>
      </div>
      <!-- Left -->

      <!-- Right -->
      <div>
        <a href="" class="text-white me-4">
          <i class="fab fa-facebook-f"></i>
        </a>
        <a href="" class="text-white me-4">
          <i class="fab fa-twitter"></i>
        </a>
        <a href="" class="text-white me-4">
          <i class="fab fa-google"></i>
        </a>
        <a href="" class="text-white me-4">
          <i class="fab fa-instagram"></i>
        </a>
        <a href="" class="text-white me-4">
          <i class="fab fa-linkedin"></i>
        </a>
        <a href="" class="text-white me-4">
          <i class="fab fa-github"></i>
        </a>
      </div>
      <!-- Right -->
    </section>
    <!-- Section: Social media -->

    <!-- Section: Links  -->
    <section class="">
      <div class="container text-center text-md-start mt-5">
        <!-- Grid row -->
        <div class="row mt-3">
          <!-- Grid column -->
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <!-- Content -->
            <h6 class="text-uppercase fw-bold">PAF Project</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p>
              Customer Management<br/>
              IT20124076<br/>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold">Project</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p>
              <a href="#!" class="text-white">Home</a>
            </p>
            <p>
              <a href="#!" class="text-white">Bill</a>
            </p>
            <p>
              <a href="#!" class="text-white">Power</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold">Useful links</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p>
              <a href="#!" class="text-white">Your Account</a>
            </p>
            <p>
              <a href="#!" class="text-white">Become an Affiliate</a>
            </p>
            <p>
              <a href="#!" class="text-white">Shipping Rates</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <!-- Links -->
            <h6 class="text-uppercase fw-bold">Contact</h6>
            <hr
                class="mb-4 mt-0 d-inline-block mx-auto"
                style="width: 60px; background-color: #7c4dff; height: 2px"
                />
            <p><i class="fas fa-home mr-3"></i> New York, NY 10012, US</p>
            <p><i class="fas fa-envelope mr-3"></i> info@example.com</p>
            <p><i class="fas fa-phone mr-3"></i> + 01 234 567 88</p>
            
          </div>
          <!-- Grid column -->
        </div>
        <!-- Grid row -->
      </div>
    </section>
    <!-- Section: Links  -->

    <!-- Copyright -->
    <div
         class="text-center p-3"
         style="background-color: rgba(0, 0, 0, 0.2)"
         >
      © 2020 Copyright:
      <a class="text-white" href="https://mdbootstrap.com/"
         >MDBootstrap.com</a
        >
    </div>
    <!-- Copyright -->
  </footer>
	</div>
	<script>
            //Date picker
            $(function () {
                $('#reservationdate').datetimepicker({
                    format: 'L'
                });
            });
        </script>
</body>
</html>
