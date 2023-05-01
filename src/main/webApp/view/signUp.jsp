<%--
  Created by IntelliJ IDEA.
  User: Hossein
  Date: 10/27/2022
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../assets/js/jquery-3.6.1.min.js"></script>

    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../folder/assets/css/signUp.css">

</head>

<body>
<form>


    <h1>Sign Up</h1>

    <label for="first_name">First name:</label>
    <input type="text" id="first_name" name="first_name">

    <label for="last_name">Last name:</label>
    <input type="text" id="last_name" name="last_name">


    <label>Gender:</label>

    <label for="male" class="light">male</label>
    <input type="radio" id="male" value="MALE" name="gender">

    <label for="female" class="light">female</label>
    <input type="radio" id="female" value="FEMALE" name="gender">


    <label>Role:</label>

    <label for="student" class="light">student</label>
    <input type="radio" id="student" value="STUDENT" name="role">

    &emsp;

    <label for="techer" class="light">teacher</label>
    <input type="radio" id="techer" value="TEACHER" name="role">

    <label>Major:</label>


    <label for="math" class="light">Math</label>
    <input type="radio" id="math" value="1" name="major">

    &emsp;

    <label for="physics" class="light">physics</label>
    <input type="radio" id="physics" value="2" name="major">

    <label for="chemistry" class="light">chemistry</label>
    <input type="radio" id="chemistry" value="3" name="major">

    &emsp;

    <label for="Electricity" class="light">Electricity</label>
    <input type="radio" id="Electricity" value="4" name="major">


    <button type="button" onclick="signUp()">Sign Up</button>
</form>

</body>
</html>


<script>
    function signUp() {

        let major = {
            id: document.querySelector('input[name=major]:checked').value,

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
                window.location.href = '/api/user/sucessfuly'

            },
            error: function (error) {
                console.log(error);
            }
        });

    }

</script>