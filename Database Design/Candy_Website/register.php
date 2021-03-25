<?php
  include "config.php";

  if(isset($_POST['register'])){
    //User inputs
    $userinput = mysqli_real_escape_string($db, $_POST['user']);
    $pass1input = mysqli_real_escape_string($db, $_POST['pass1']); 
    $pass2input = mysqli_real_escape_string($db, $_POST['pass2']); 
    
    if($pass1 != $pass2){
      echo "Passwords Dont Match :(";
    }
    else{
      //Create Hash for password
      $hashpass = password_hash($pass1input, PASSWORD_DEFAULT);

      //Insert New User
      $query = "INSERT INTO `Users` (`id`, `Name`, `Username`, `Password`) VALUES (NULL, ?, ?, ?)";
      $result = $db->prepare($query);
      if($result == FALSE){
        echo "Query Failed: ".$db->error;
      }
      else{
        $result->bind_param("sss", $name = "name", $userinput, $hashpass);
        $result->execute();
      }
    } 

    header('Location: login.php');
  }
?>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="sitestyles.css">

    <!-- FontAwesome Icons -->
    <script src="https://kit.fontawesome.com/2727c3ff62.js" crossorigin="anonymous"></script>

    <title>Register</title>
  </head>
  
  <body>
    
    <h1 class="company-name-login">Oishii Candy Co.</h1>

    <div class="card login-card">
        <div class="card-body">
            <h5 class="card-title">Login</h5>
            
            <form action="" method="post">
                <div class="form-group">
                  <label for="user">User</label>
                  <input type="text" name="user" class="form-control" id="user" aria-describedby="user">
                </div>

                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" name="pass1" class="form-control" id="password">
                </div>

                <div class="form-group">
                  <label for="email">Confirm Password</label>
                  <input type="password" name="pass2" class="form-control" id="email">
                </div>

                <div class="button-container">
                    <button type="submit" name="register" class="btn btn-primary">Register!</button>
                </div>
            </form> 

        </div>
    </div>
    
  </body>
</html>