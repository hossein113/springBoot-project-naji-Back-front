<%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 1/2/2023
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>

    <title>
        Admin Page </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport'/>
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet"/>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../assets/css/paper-dashboard.css" rel="stylesheet"/>
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/demo/demo.css" rel="stylesheet"/>

    <title>Admin Page </title>
</head>


<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="https://www.creative-tim.com" class="simple-text logo-mini">
                <div class="logo-image-small">
                </div>
                <!-- <p>CT</p> -->
            </a>
            <a href="/admin/dashboard" class="simple-text logo-normal">
                HOME
                <!-- <div class="logo-image-big">
                  <img src="../assets/img/logo-big.png">
                </div> -->
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="active ">
                    <a href="/admin/show-users">
                        <i></i>
                        <p>List Users</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-admin">
                        <i></i>
                        <p>List Admins</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-teacher">
                        <i></i>
                        <p>List Teachers</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-student">
                        <i></i>
                        <p>List Students</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-reject">
                        <i></i>
                        <p>List Rejects</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-pending">
                        <i></i>
                        <p>List Pendings</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-active">
                        <i></i>
                        <p>List Actives</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/show-majors">
                        <i></i>
                        <p>List Majors</p>
                    </a>
                </li>
                <li>
                    <a href="/admin/search-users">
                        <i></i>
                        <p>Search Users</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="javascript:;"></a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
                        aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <form>
                        <div class="input-group no-border">
                            <input type="text" value="" class="form-control" placeholder="Search...">
                            <div class="input-group-append">
                                <div class="input-group-text">
                                    <i></i>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="row">


                <div class="row">
                    <div class="col-md-12">
                        <div class="card ">
                            <div class="card-header ">
                                <h5 class="card-title"> Show All Teachers</h5>
                            </div>

                            <div style="padding: 15px;">


                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">FirstName</th>
                                        <th scope="col">LastName</th>
                                        <th scope="col"> Gender</th>
                                        <th scope="col"> Role</th>
                                        <th scope="col"> Major</th>
                                        <th scope="col"> Status</th>

                                    </tr>
                                    </thead>

                                    <tbody>
                                    <% int i = 1; %>
                                    <c:forEach items="${teacherList}" var="users">
                                        <tr>
                                            <th><% out.print(i);%></th>
                                            <th>${users.firstName}</th>
                                            <th>${users.lastName}</th>
                                            <th>${users.gender}</th>
                                            <th>${users.role}</th>
                                            <th>${users.major.name}</th>
                                            <th>${users.status}</th>
                                        </tr>
                                        <%i++;%>

                                    </c:forEach>
                                    </tbody>
                                </table>


                            </div>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <div class="card ">
                            <div class="card-header ">


                                <!-- Footer -->
                                <footer class="text-center text-lg-start bg-white text-muted">
                                    <!-- Section: Social media -->
                                    <section
                                            class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
                                        <!-- Left -->
                                        <div class="me-5 d-none d-lg-block">
                                            <span>Get connected with us on social networks:</span>
                                        </div>
                                        <!-- Left -->

                                        <!-- Right -->
                                        <!-- <div>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-facebook-f"></i>
                                          </a>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-twitter"></i>
                                          </a>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-google"></i>
                                          </a>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-instagram"></i>
                                          </a>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-linkedin"></i>
                                          </a>
                                          <a href="" class="me-4 link-secondary">
                                            <i class="fab fa-github"></i>
                                          </a>
                                        </div> -->
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
                                                    <h6 class="text-uppercase fw-bold mb-4">
                                                        <i class="fas fa-gem me-3 text-secondary"></i>Tosee Naji
                                                    </h6>
                                                    <p>
                                                        Here you can use rows and columns to organize your footer
                                                        content. Lorem ipsum
                                                        dolor sit amet, consectetur adipisicing elit.
                                                    </p>
                                                </div>
                                                <!-- Grid column -->

                                                <!-- Grid column -->

                                                <!-- Grid column -->

                                                <!-- Grid column -->
                                                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                                                    <!-- Links -->
                                                    <h6 class="text-uppercase fw-bold mb-4">
                                                        Products
                                                    </h6>
                                                    <p>
                                                        <a href="#!" class="text-reset">Pricing</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">Settings</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">Orders</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">Help</a>
                                                    </p>
                                                </div>
                                                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                                                    <!-- Links -->
                                                    <h6 class="text-uppercase fw-bold mb-4">

                                                        Useful links

                                                    </h6>
                                                    <p>
                                                        <a href="#!" class="text-reset">www.Angular.com</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">www.React.com</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">www.Java.com</a>
                                                    </p>
                                                    <p>
                                                        <a href="#!" class="text-reset">www.Laravel.com</a>
                                                    </p>
                                                </div>
                                                <!-- Grid column -->

                                                <!-- Grid column -->
                                                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                                                    <!-- Links -->
                                                    <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                                                    <p><i class="fas fa-home me-3 text-secondary"></i> Iran , Tehran</p>
                                                    <p>
                                                        <i class="fas fa-envelope me-3 text-secondary"></i>
                                                        H.Marjani133@Gmail.com
                                                    </p>
                                                    <p><i class="fas fa-phone me-3 text-secondary"></i> +98 9196309368
                                                    </p>
                                                </div>
                                                <!-- Grid column -->
                                            </div>
                                            <!-- Grid row -->
                                        </div>
                                    </section>
                                    <!-- Section: Links  -->

                                    <!-- Copyright -->
                                    <div class="text-center p-4" style="background-color: rgba(0, 0, 0, 0.025);">
                                        © 2022 - 2023
                                        <a class="text-reset fw-bold" href="https://mdbootstrap.com/"></a>
                                    </div>
                                    <!-- Copyright -->
                                </footer>


                            </div>
                        </div>

                    </div>


                </div>


                <!-- Footer -->
            </div>
        </div>
    </div>
</div>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.min.js"></script>
<script src="../assets/js/core/popper.min.js"></script>
<script src="../assets/js/core/bootstrap.min.js"></script>
<script src="../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!-- Chart JS -->
<script src="../assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="../assets/js/paper-dashboard.min.js?v=2.0.1" type="text/javascript"></script>
<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/demo/demo.js"></script>
<script>
    $(document).ready(function () {
        // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
        demo.initChartsPages();
    });
</script>
</body>


</html>
