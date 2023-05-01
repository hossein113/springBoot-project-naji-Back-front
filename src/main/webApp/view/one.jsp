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

                                    <h6 class="mb-2 pb-1">Ezafekar: </h6>

                                    <div class="col-md-6 mb-4">

                                        <div class="form-outline">
                                            <input type="text" id="ezafekar" placeholder="ezafekar" name="ezafekar"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="ezafekar"></label>
                                        </div>


                                    </div>
                                </div>

                                <div class="row">


                                    <div class="col-md-6 mb-4">


                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6 mb-4 pb-2">


                                    </div>

                                </div>


                                <div class="row">
                                    <div class="col-12">

                                        <label class="form-label select-label" for="darage"></label>
                                        <select class="select form-control-lg" id="darage">

                                            <option disabled>select Darage</option>
                                            <option value="sardar">Sardar</option>
                                            <option value="sarhang">Sarhang</option>
                                            <option value="sargord">Sargord</option>
                                            <option value="sotvan">Sotvan</option>

                                        </select>

                                    </div>
                                </div>

                                <div class="mt-4 pt-2">
                                    <button class="btn btn-primary btn-lg" type="button" onclick="signUp()">sign up
                                    </button>
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

        // let darage = {
        //     id: $('#darage').val()
        //
        // }
        let userw = {

            firstName: document.getElementById('first_name').value,
            lastName: document.getElementById('last_name').value,
            ezafekar: document.getElementById('ezafekar').value,
            darege: $('#darage').val()
        }


        $.ajax({

            type: 'post',
            url: '/api/userw/sign-up',
            contentType: 'application/json',
            data: JSON.stringify(userw),
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