<?php
include "config.php";

// If user is not logged in
if (!isset($_SESSION['login_user'])) {
  header('Location: login.php');
}

// If logout Button is Pressed
if (isset($_POST['but_logout'])) {
  session_destroy();
  header('Location: login.php');
}

// if item sent to cart
if (isset($_POST['send_to_cart'])) {
  $productid = $_POST['productid'];
  $quantity = $_POST['quantity'];
  $unitprice = $_POST['unitprice'];
  $subtotal = bcmul($unitprice, $quantity, $scaleVal = 2);

  if ($_SESSION['ActiveShoppingCart'] == FALSE) {
    do {
      $ordernum = rand(1, 1000);
      $query = "SELECT count(*) as count FROM `Shopping Cart` WHERE `OrderID` = ?";
      $stmt = $pdo->prepare($query);
      $stmt->bindParam(1, $ordernum, PDO::PARAM_INT);
      $stmt->execute();

      $num = $stmt->rowCount();
    } while ($num != 1);

    $_SESSION['OrderNum'] = $ordernum;
    $_SESSION['ActiveShoppingCart'] = TRUE;
  }

  // Make sure when we insert into shopping cart we account for the right value
  // currently we link random number when the inserted # should equal Orders['id']
  $query = "INSERT INTO `Shopping Cart` (`id`, `OrderID`, `Users`, `ItemID`, `Subtotal`, `Item Quantity`) VALUES (NULL, ?, ?, ?, ?, ?)";
  $result = $pdo->prepare($query);
  $result->bindParam(1, $_SESSION['OrderNum'], PDO::PARAM_INT);
  $result->bindParam(2, $_SESSION['login_user'], PDO::PARAM_STR);
  $result->bindParam(3, $productid, PDO::PARAM_STR);
  $result->bindParam(4, $subtotal, PDO::PARAM_INT);
  $result->bindParam(5, $quantity, PDO::PARAM_INT);
  $result->execute();
}


// if item deleted from cart
if (isset($_POST['delete_item'])) {
  $itemid = $_POST['productid'];

  $query = "DELETE FROM `Shopping Cart` WHERE `OrderID` = ? AND `ItemID` = ?";
  $result = $pdo->prepare($query);
  $result->bindParam(1, $_SESSION['OrderNum'], PDO::PARAM_INT);
  $result->bindParam(2, $itemid, PDO::PARAM_INT);
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

  <title>Technology Search Results</title>
</head>

<body>
  <div class="company-name-frontpage">
    <h1>Tech R. Us</h1>
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
                <input type="text" class="form-control" name="" placeholder="" aria-describedby="p_name" required>
              </div>

              <div class="form-group">
                <label for="p_name">Address</label>
                <input type="text" class="form-control" name="" placeholder="" aria-describedby="p_id" required>
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
  $order_count = 0;

  //Query to retrieve price
  $query = "SELECT * FROM `Shopping Cart` WHERE `OrderID` = ?";
  $result = $pdo->prepare($query);
  $result->bindParam(1, $_SESSION['OrderNum'], PDO::PARAM_INT);
  $result->execute();

  $num_results = 0;
  while ($item = $result->fetch()) {
    $num_results += $item['Item Quantity'];
    $totalprice += $item['Subtotal'];
  }

  //Query for all Shopping Cart Items
  $query = "SELECT * FROM `Shopping Cart` WHERE `OrderID` = ?";
  $result = $pdo->prepare($query);
  $result->bindParam(1, $_SESSION['OrderNum'], PDO::PARAM_INT);
  $result->execute();

  echo '<h3 class="card-title">Total Price: $' . $totalprice . '</h3>';
  echo '<p class = "results-txt">' . $num_results . ' Items in Shopping Cart</p>';
  echo '<div class="row">';
  while ($row = $result->fetch()) {
    //Query to retrieve Product Info.
    $query = "SELECT * FROM `products` WHERE `Product ID` = ?";
    $item = $pdo->prepare($query);
    $item->bindParam(1, $row['ItemID'], PDO::PARAM_INT);
    $item->execute();
    $item = $item->fetch();

    echo '<div class="column">';
    echo '<!-- Display Candy -->';
    echo '<div class="card search-card">';
    echo '<div class="card-body">';
    echo '<form action="" method="POST">';
    echo '<h5 class="card-title">';
    echo htmlspecialchars(stripslashes($item['Name']));
    echo '</h5>';
    echo '';
    echo '<p>';
    echo 'Brand: ';
    echo stripslashes($item['Brand/Manufacturer']);
    echo '<br>';
    echo 'Category: ';
    echo stripslashes($item['Category']);
    echo '<br>';
    echo 'Product ID: ';
    echo stripslashes($item['Product ID']);
    echo '<br>';
    echo '</p>';
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
    echo '<input type="hidden" name="productid" value="' . stripslashes($row['ItemID']) . '">';
    echo '<div class="input-group-append">';
    echo '<button class="btn btn-primary" name="delete_item" type="submit">Remove Item</button>';
    echo '</div>';
    echo '</div>';
    echo '</form>';
    echo '</div>';
    echo '</div>';
    echo '</div>';

    if ($order_count + 1 % 4 == 0) {
      echo '</div>';
      echo '';
      echo '<div class="row">';
    }
    $order_count++;
  }
  echo '</div>';

  ?>



</body>

</html>