<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../assets/css/adminDashboard.css">
</head>
<body>


<div>

    <div class="row1 "> ADMIN PAGE</div>
</div>

<div class=" parent">

    <div class="row2 cl-s-1 cl-m-2 cl-l-1 cl-bl-1"><b>ADMIN</b>
        <p>
            <br>

            person ( ${countAdmin} )
        </p>
        <br>
        <a href="/admin/show-admin">show</a>
    </div>

    <div class="row2 cl-s-1 cl-m-2 cl-l-1 cl-bl-1"><b>STUDENT</b>
        <p>
            <br>
            person ( ${countStudent} )

        </p>
        <br>
        <a href="/admin/show-student">show</a>


    </div>

    <div class="row2 cl-s-1 cl-m-3 cl-l-1 cl-bl-1"><b>TEACHER</b>
        <p>
            <br>

            person ( ${countTeacher} )
        </p>
        <br>
        <a href="/admin/show-teacher">show</a>
    </div>
</div>


<div class="parent">

    <div class=" row3  cl-s-1 cl-m-1 cl-l-1 cl-bl-2" id="color_blue"> MAJOR :<br> <br> ( ${countMajor} ) <br> <br>
        <a href="/admin/show-majors">show</a></div>

    <div class="row3 cl-s-1 cl-m-1 cl-l-1 cl-bl-2 " id="color_yellow">PENDING:<br> <br> person ( ${countPending} ) <br>
        <br>
        <a href="/admin/show-pending">show</a></div>

    <div class="row3 cl-s-1 cl-m-1 cl-l-1 cl-bl-2 " id="color_green"> ACTIVE:<br> <br> person ( ${countActive} ) <br>
        <br>
        <a href="/admin/show-active">show</a></div>


    <div class="row3 cl-m-1 cl-l-2 cl-bl-2 display-block display-none " id="color_red"> REJECT:<br> <br>person
        ( ${countReject} ) <br> <br>
        <a href="/admin/show-reject">show</a></div>


</div>
</div>

</body>
</body>
</html>
