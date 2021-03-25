<?php
  include "config.php";
   

  if(isset($_POST['but_submit'])){
    
    $userinput = mysqli_real_escape_string($db, $_POST['user']);
    $passinput = mysqli_real_escape_string($db, $_POST['password']); 
    
    if($userinput != "" && $passinput != ""){  
      $query = "SELECT * FROM `Users` WHERE `Username` = ?";
      $result = $db->prepare($query);
      $result->bind_param("s", $userinput);
      $result->execute();

      $user = $result->get_result()->fetch_assoc();
      $hashedpass = $user['Password'];
      
      if(password_verify($passinput, $hashedpass)) {
          $_SESSION['login_user'] = $user['id'];
          $_SESSION['ActiveShoppingCart'] = FALSE;
          header('Location: frontpage.php');
      }
      else {
          echo '<p class = "login-error">Invalid Username or Password :(</p>';
      }
    }
  }


?>

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

    <title>Login</title>
  </head>
  
  <body>
    
    <h1 class="company-name-login">Oishii Candy Co.</h1>

    <div class="card login-card">
        <div class="card-body">
            <h5 class="card-title">Login</h5>
            
            <form action="" method='post'>
                <div class="form-group">
                  <label for="user">User</label>
                  <input type="text" class="form-control" name="user" aria-describedby="user">
                </div>

                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" name="password">
                </div>

                <div class="button-container">
                    <button type="submit" class="btn btn-primary" name='but_submit'>Sign In</button>
                </div>

                <a class="nav-link card-title" href="register.php#">Don't have an account? Register Here!</a>
            </form> 

        </div>
    </div>
    
  </body>
</html>