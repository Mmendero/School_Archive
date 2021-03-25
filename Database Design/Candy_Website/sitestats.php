<?php
  include "config.php";

  // Check user login or not
  if(!isset($_SESSION['login_user'])){
    header('Location: login.php');
  }

  // If invalid user
  if($_SESSION['login_user'] != 1){
    header('Location: frontpage.php');
    echo "You are not Authorized to access this page >:(";
    
  }

  // Logout Function
  if(isset($_POST["logout"])){
    session_destroy();
    header('Location: login.php');
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

    <title>Oishii Candy Co.</title>
  </head>

  <body>
    <div class="company-name-frontpage">
        <h1>Oishii Candy Co.</h1>
    </div>
    
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="frontpage.php#">Home<span class="sr-only">(current)</span></a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="servicedash.php#">Service Dashboard</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="inventory.php#">Manage Inventory</a>
              </li>

              <li class="nav-item active">
                <a class="nav-link" href="sitestats.php#">Site Stats</a>
              </li>

            </ul>
            
            <a href="checkout.php#" class="btn btn-info btn-lg form-inline my-2 my-lg-0">
              <i class="fas fa-shopping-cart"></i>
            </a>

            <form class="logout-form" action="" method="POST">
              <button name='logout' class="btn btn-info form-inline my-2 my-lg-0">Logout</button>
            </form>
            
          </div>
        </nav>
    
  </body>
</html>
