<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" charset="UTF-8">
    <title>User Registration</title>
    <!-- css link bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <!-- javascript link -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
      <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/additional-methods.min.js"></script>

</head>
<body>
    <div class="row mt-5 align-items-center justify-content-center">
        <div class="col-md-4">
            <div class="card shadow border-0">
                <div class="card-body">
                    <div class="m-5 align-items-center">
                        <img src="https://www.zra.org.zm/wp-content/uploads/2019/10/logo-01-01-300x300-e1595946239397.png"/>
                    </div>
                    <h3 class="text-center my-4">Create your account</h3>
                    <form id="register-form" action="registerUser" method="post">
                        <div class="row mb-3 ">
                        <label for="fullName">Full name</label>
                            <div class="col">
                                <input type="text" name="fName" value="" class="form-control" id="fName" placeholder="First name" required>
                            </div>
                            <div class="col">
                                <input type="text" name="lName" value="" class="form-control" id="lName" placeholder="Last name" required>
                            </div>
                        </div>
                        <div class="form-group mb-3">
                          <label for="email">Email address</label>
                          <input type="email" name="username" value="" class="form-control" id="username" placeholder="Enter email" required>
                        </div>
                        <div class="form-group mb-3">
                          <label for="email">Phone</label>
                          <input type="text" name="phone" value="" class="form-control" id="phone" placeholder="Phone" required>
                        </div>
                        <div class="form-group mb-3">
                          <label for="password">Password</label>
                          <input type="password" name="password" value="" class="form-control" id="password" placeholder="Password" required>
                          <small id="" class="form-text text-muted">We will never share your email with anyone else.</small>
                        </div>
                        <div class="form-group mb-3">
                          <label for="password">Confirm Password</label>
                          <input type="password" name="confirmPassword" value="" class="form-control" id="confirm_password" placeholder="Confirm Password" required>
                        </div>
                        <button type="submit" value="register" class="btn btn-primary w-100 my-3">Register User</button>
                    </form>
                    <p>Already have an account?<a href="login"> Login</a></p>
                </div>
            </div>
        </div>
    </div
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
          $('#register-form').submit(function(event) {
            event.preventDefault(); // prevent form submission

            var firstName = $(this).attr('#fName').val();
            var lastName = $(this).attr('#lName').val();
            var email = $(this).attr('#username').val();
            var phone = $(this).attr('#phone').val();
            var password = $(this).attr('#password').val();
            var confirmPassword = $(this).attr('#confirm_password').val();

            // check if first name is empty
            if (firstName.trim() == '') {
              $('#fName').addClass('is-invalid'); // add is-invalid class to input field
              return false; // Stop form submission
            }

            // check if last name is empty
            if (lastName.trim() == '') {
              $('#lName').addClass('is-invalid'); // Add is-invalid class to input field
              return false; // Stop form submission
            }

            // check if email is valid
            var emailRegex = /\S+@\S+\.\S+$/;
            if (!emailRegex.test(email)) {
              $('#username').addClass('is-invalid'); // Add is-invalid class to input field
              return false; // Stop form submission
            }

            // checking if phone number is valid
            var phoneRegex = ^\+\d{1,3}\d{9}$;
            if (!phoneRegex.test(phone)) {
              $('#phone').addClass('is-invalid'); // Add is-invalid class to input field
              return false; // Stop form submission
            }

            // Check if password is empty
            if (password.trim() == '') {
              $('#password').addClass('is-invalid'); // Add is-invalid class to input field
              return false; // Stop form submission
            }

            // Check if confirm password matches password
            if (confirmPassword != password) {
              $('#confirm_password').addClass('is-invalid'); // Add is-invalid class to input field
              return false; // Stop form submission
            }

            // Submit form if all inputs are valid
            $("form").submit();
          });
        });
    </script>
</body>
</html>