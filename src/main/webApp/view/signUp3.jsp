<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../assets/js/jquery.js"></script>
    <%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/signUp2.css">

</head>

<body>
<form>


    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>


                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="first_name" placeholder="First name" name="first_name"
                                               class="form-control form-control-lg"/>
                                        <label class="form-label" for="first_name"></label>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="last_name" placeholder="Last name" name="last_name"
                                               class="form-control form-control-lg"/>
                                        <label class="form-label" for="last_name"></label>
                                    </div>

                                </div>
                            </div>

                            <div class="row">


                                <div class="col-md-6 mb-4">

                                    <h6 class="mb-2 pb-1">Gender: </h6>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                               value="FEMALE" checked/>
                                        <label class="form-check-label" for="femaleGender">Female</label>
                                    </div>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                               value="MALE"/>
                                        <label class="form-check-label" for="maleGender">Male</label>
                                    </div>


                                </div>
                            </div>

                            <div class="row">


                                <div class="col-md-6 mb-4">

                                    <h6 class="mb-2 pb-1">Role: </h6>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="role" id="teacherRole"
                                               value="TEACHER" checked/>
                                        <label class="form-check-label" for="teacherRole">Teacher</label>
                                    </div>

                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="role" id="studentRole"
                                               value="STUDENT"/>
                                        <label class="form-check-label" for="studentRole">Student</label>
                                    </div>


                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">


                                </div>

                            </div>


                            <div class="row">
                                <div class="col-12">

                                    <label class="form-label select-label" for="major"></label>
                                    <select class="select form-control-lg" id="major">

                                        <option disabled>select Major</option>
                                        <option value="1">Math</option>
                                        <option value="2">physics</option>
                                        <option value="3">chemistry</option>
                                        <option value="4">Electricity</option>

                                    </select>

                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <button class="btn btn-primary btn-lg" type="button" onclick="signUp()">sign up</button>
                                <span id="message"></span>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>

        <button type="button" onclick="signUp()">Sign Up</button>
    </section>

</form>

</body>
</html>


<script>
    function signUp() {

        let major = {
            id: $('#major').val()

        }
        let user = {

            firstName: document.getElementById('first_name').value,
            lastName: document.getElementById('last_name').value,
            gender: document.querySelector('input[name=gender]:checked').value,
            role: document.querySelector('input[name=role]:checked').value,
            status: 'PENDING',
            major: major
        }


        $.ajax({

            type: 'post',
            url: '/api/user/sign-up',
            contentType: 'application/json',
            data: JSON.stringify(user),
            success: function (response) {
                document.getElementById('message').innerText = 'register successfully done!!'
                window.location.href = '/user?name=true'
            },
            error: function (error) {
                console.log(error);
            }
        });

    }

</script>