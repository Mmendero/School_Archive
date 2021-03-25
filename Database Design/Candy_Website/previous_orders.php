<?php
  include "config.php";

  // If user is not logged in
  if(!isset($_SESSION['login_user'])){
    header('Location: login.php');
  }

  // If logout Button is Pressed
  if(isset($_POST['but_logout'])){
    session_destroy();
    header('Location: login.php');
  }

  // if item sent to cart
  if(isset($_POST['send_to_cart'])){
    $productid = $_POST['productid'];
    $quantity = $_POST['quantity'];
    $unitprice = $_POST['unitprice'];
    $subtotal = bcmul($unitprice, $quantity, $scaleVal = 2);

    if($_SESSION['ActiveShoppingCart'] == FALSE){
      do {
        $ordernum = rand(1,1000);
        $query = "SELECT count(*) as count FROM `Shopping Cart` WHERE `Order id` = ?";
        $stmt = $db->prepare($query);
        $stmt->bind_param("i", $ordernum);
        $stmt->execute();

        $num = $stmt->get_result()->fetch_assoc()['count'];
      } while ($num != 0);

      $query = "INSERT INTO `Orders` (`row_id`, `id`, `Customer Details`, `Previous Items`, `Quantity`, `Total`) VALUES (NULL, ?, ?, ?, ?, ?)";
      $stmt = $db->prepare($query);
      $stmt->bind_param("issii", $ordernum, $_SESSION['login_user'], $default = "none", $defaultnum1 = 0, $defaultnum2 = 0);
      $stmt->execute();

      $_SESSION['OrderNum'] = $ordernum;
      $_SESSION['ActiveShoppingCart'] = TRUE;
    }

    // Make sure when we insert into shopping cart we account fo rthe right value
    // currently we link random number when the inserted # should equal Orders['id']
    $query = "INSERT INTO `Shopping Cart` (`id`, `Order id`, `Users`, `ItemID`, `Subtotal`, `Item Quantity`) VALUES (NULL, ?, ?, ?, ?, ?)";
    $result = $db->prepare($query);
    $result->bind_param("issii", $_SESSION['OrderNum'], $_SESSION['login_user'], $productid, $subtotal, $quantity);
    $result->execute();
  }


  // if item sent to cart
  if(isset($_POST['delete_item'])){
    $itemid = $_POST['itemid'];
    $Orderid = $_POST['orderid'];

    $query = "DELETE FROM `Shopping Cart` WHERE `Order id` = ? AND `ItemID` = ?";
    $result = $db->prepare($query);
    $result->bind_param("is", $Orderid, $itemid);
    $result->execute();
  }

?>


<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="sitestyles.css">

    <!-- FontAwesome Icons -->
    <script src="https://kit.fontawesome.com/2727c3ff62.js" crossorigin="anonymous"></script>

    <title>Candy Search Results</title>
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

          <li class="nav-item">
            <a class="nav-link" href="sitestats.php#">Site Stats</a>
          </li>

        </ul>
        
        <a href="checkout.php#" class="btn btn-info btn-lg form-inline my-2 my-lg-0">
          <i class="fas fa-shopping-cart"></i>
        </a>

        <form class="logout-form" action="" method="POST">
          <button name='but_logout' class="btn btn-info form-inline my-2 my-lg-0">Logout</button>
        </form>
        
      </div>
    </nav>
    
    
    <?php
      foreach($_SESSION['Previous_Orders'] as $order){
        $count = 1;
        $query = "SELECT * FROM `Orders` WHERE `id` = ?";
        $result = $db->prepare($query);
        $result->bind_param("i", $order);
        $result->execute();
        $items = $result->get_result();
        $num_results = $items->num_rows;

        echo '<p class = "results-txt">'.$num_results.' Items in Order#'.$order.'</p>';
        echo '<div class="row">';
        for ($i=0; $i <$num_results; $i++) {
          if($count == 0){
            $row = $items->fetch_assoc();
          }
          $row = $items->fetch_assoc();
          
          echo '<div class="column">';
          echo '<!-- Display Candy -->';
          echo '<div class="card search-card">';
          echo '<div class="card-body">';
          echo '<form action="" method="POST">';
          echo '<h5 class="card-title">Item #'.$count.'</h5>';
          echo '';
          echo '<p>';
          echo 'ItemID: ';
          echo stripslashes($row['ItemID']);
          echo '<br>';
          echo 'Quantity: ';
          echo stripslashes($row['Quantity']);
          echo '<br>';
          echo 'Cost: $';
          echo stripslashes($row['Total']);
          echo '<br>';
          echo '</p>';
          echo '';
          echo '</form>';
          echo '</div>';
          echo '</div>';
          echo '</div>';
          
          if($i+1 % 4 == 0){
            echo '</div>';
            echo '';
            echo '<div class="row">';
          }
          $count += 1;
        }
      }
    ?>



  </body>
</html>