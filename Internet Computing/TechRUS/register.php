<?php
include "config.php";

if (isset($_POST['register'])) {
  // User inputs.
  $userinput = $_POST['user'];
  $emailinput = $_POST['email'];
  $pass1input = $_POST['pass1'];
  $pass2input = $_POST['pass2'];

  if (!$userinput || !$emailinput || !$pass1input || !$pass2input) {
    echo '<p class = "login-error">Invalid User Credentials :(</p>';
  } elseif ($pass1input != $pass2input) {
    echo '<p class = "login-error">Passwords Dont Match :(</p>';
  } else {
    // Create Hash for password.
    $hashpass = password_hash($pass1input, PASSWORD_DEFAULT);

    // Insert New User.
    try {
      $query = "INSERT INTO `users` (`u_id`, `user`, `email`, `pass`) VALUES (NULL, ?, ?, ?)";
      $result = $pdo->prepare($query);
      $result->bindParam(1, $userinput, PDO::PARAM_STR);
      $result->bindParam(2, $emailinput, PDO::PARAM_STR);
      $result->bindParam(3, $hashpass, PDO::PARAM_STR);
      $result->execute();
      header('Location: login.php');
    } catch (PDOException $e) {
      echo '<p class = "login-error">Query Failed: ' . $e->getMessage() . '</p>';
    }
  }
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

  <title>Tech R' Us Register</title>
</head>

<body>

  <h1 class="company-name-login">Tech R' Us</h1>

  <div class="card login-card">
    <div class="card-body">
      <h5 class="card-title">Account Registration</h5>

      <form action="" method="post">
        <div class="form-group">
          <label for="user">User</label>
          <input type="text" name="user" class="form-control" id="user" aria-describedby="user">
        </div>

        <div class="form-group">
          <label for="user">Email</label>
          <input type="text" name="email" class="form-control" id="email" aria-describedby="email">
        </div>

        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" name="pass1" class="form-control" id="password">
        </div>

        <div class="form-group">
          <label for="password">Confirm Password</label>
          <input type="password" name="pass2" class="form-control" id="password">
        </div>

        <div class="button-container">
          <button type="submit" name="register" class="btn btn-primary">Register!</button>
        </div>
      </form>

    </div>
  </div>

</body>

</html>