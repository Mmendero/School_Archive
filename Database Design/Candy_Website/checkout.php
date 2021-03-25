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

      <!--Checkout Card -->
      <div class="row">
      <div class="col">
        <div class="frontpage-card">
          <div class="card">
            <div class="card-body">
                <h5 class="card-title">Checkout</h5>
                
                <form action="order_placed.php" method="post">
                    <div class="form-group">
                      <label for="p_id">Name</label>
                      <input type="text" class="form-control" name="" placeholder="" aria-describedby="p_name">
                    </div>
    
                    <div class="form-group">
                      <label for="p_name">Address</label>
                      <input type="text" class="form-control" name="" placeholder=""aria-describedby="p_id">
                    </div>

                    <div class="form-group checkout-text">
                      <p class="h2 card-title">Congratulations! You won a FREE Order!</p>
                      <p class="h3 card-title">No Payment Required at this Time</p>
                    </div>
    
                    <div class="button-container">
                        <button type="submit" class="btn btn-primary" name="place_order">Place Order!</button>
                    </div>
    
                </form> 
                
              </div>
          </div>
        </div>
      </div>
    </div>


      <?php
      $totalprice = 0.0;

      //Query to retrieve price
      $query = "SELECT * FROM `Shopping Cart` WHERE `Order id` = ?";
      $result = $db->prepare($query);
      $result->bind_param("i", $_SESSION['OrderNum']);
      $result->execute();

      $prices = $result->get_result();
      $num_results = $prices->num_rows;

      for ($i=0; $i < $num_results; $i++) {
        $price = $prices->fetch_assoc();
        $totalprice += $price['Subtotal'];
      }

      //Query for all Shopping Cart Items
      $query = "SELECT * FROM `Shopping Cart` WHERE `Order id` = ?";
      $result = $db->prepare($query);
      $result->bind_param("i", $_SESSION['OrderNum']);
      $result->execute();
      $items = $result->get_result();

      echo '<h3 class="card-title">Total Price: $'.$totalprice.'</h3>';
      echo '<p class = "results-txt">'.$num_results.' Items in Shopping Cart</p>';
      echo '<div class="row">';
      for ($i=0; $i <$num_results; $i++) {
        $row = $items->fetch_assoc();
        
        echo '<div class="column">';
        echo '<!-- Display Candy -->';
        echo '<div class="card search-card">';
        echo '<div class="card-body">';
        echo '<form action="" method="POST">';
        echo '<h5 class="card-title">';
        echo htmlspecialchars(stripslashes($row['Name']));
        echo '</h5>';
        echo '';
        echo '<p>';
        echo 'ItemID: ';
        echo stripslashes($row['ItemID']);
        echo '<br>';
        echo 'Quantity: ';
        echo stripslashes($row['Item Quantity']);
        echo '<br>';
        echo 'Cost: $';
        echo stripslashes($row['Subtotal']);
        echo '<br>';
        echo '</p>';
        echo '';
        echo '<div class="input-group mb-3">';
        echo '<input type="hidden" name="orderid" value="'.stripslashes($row['Order id']).'">';
        echo '<input type="hidden" name="itemid" value="'.stripslashes($row['ItemID']).'">';
        echo '<div class="input-group-append">';
        echo '<button class="btn btn-primary" name="delete_item" type="submit">Remove Item</button>';
        echo '</div>';
        echo '</div>';
        echo '</form>';
        echo '</div>';
        echo '</div>';
        echo '</div>';
        
        if($i+1 % 4 == 0){
          echo '</div>';
          echo '';
          echo '<div class="row">';
        }
      }
      echo '</div>';

      $items->free();
      $db->close();

    ?>



    </body>
  </html>