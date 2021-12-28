<?php
include "config.php";

// Check user login or not
if (!isset($_SESSION['login_user'])) {
  header('Location: login.php');
}

// If invalid user
if ($_SESSION['login_user'] != '1' && $_SESSION['login_user'] != '2') {
  $_SESSION['message'] = '<p class = "login-error">You are not Authorized to access this page >:(</p>';
  header('Location: frontpage.php');
}

// Logout Function
if (isset($_POST["logout"])) {
  session_destroy();
  header('Location: login.php');
}

// Insert into Database
if (isset($_POST["insert"])) {
  $name = $_POST['p_name'];
  $id = $_POST['p_id'];
  $brand = $_POST['p_brand'];
  $price = $_POST['p_price'];
  $stock = $_POST['p_stock'];
  $description = $_POST['p_description'];
  $category = $_POST['p_category'];

  if (empty($name) || empty($id) || empty($brand) || empty($price) || empty($name) || empty($stock) || empty($category) || empty($description)) {
    echo "One or  more inputs invalid";
  } else {

    $query = "INSERT INTO `Products` (`Product ID`, `Name`, `Brand/Manufacturer`, `Price`, `Stock`, `Description`, `Category`, `id`) VALUES (?, ?, ?, ?, ?, ?, ?, NULL)";
    $stmt = $db->prepare($query);
    $stmt->bind_param("sssssss", $id, $name, $brand, $price, $stock, $description, $category);
    $stmt->execute();
    printf("%d Row inserted.\n", $stmt->affected_rows);
  }

  $db->close();
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

  <title>Manage Inventory</title>
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
          <a class="nav-link" href="servicedash.php#">Service Dashboard</a>
        </li>

        <li class="nav-item active">
          <a class="nav-link" href="inventory.php#">Manage Inventory</a>
        </li>
      </ul>

      <form class="logout-form" action="" method="POST">
        <button name='logout' class="btn btn-info form-inline my-2 my-lg-0">Logout</button>
      </form>

    </div>
  </nav>


  <div class="row">
    <div class="col">
      <div class="frontpage-card">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Enter the Product to add to Inventory</h5>

            <form action="item_insert.php" method="post">
              <div class="form-group">
                <label for="p_name">Name</label>
                <input type="text" class="form-control" name="p_name" placeholder="Product Name" aria-describedby="p_id" required>
              </div>

              <div class="form-group">
                <label for="p_brand">Brand/Manufacturer</label>
                <input type="text" class="form-control" name="p_brand" placeholder="Manufacturer" aria-describedby="p_brand" required>
              </div>

              <div class="form-group">
                <label for="p_price">Price</label>
                <input type="number" step="any" class="form-control" name="p_price" placeholder="Price per unit (Double)" aria-describedby="p_category" required>
              </div>

              <div class="form-group">
                <label for="p_category">Category</label>
                <input type="text" class="form-control" name="p_category" placeholder="Product Category" aria-describedby="p_category" required>
              </div>

              <input type="hidden" value="NONE" name="p_description" placeholder="Product Description" aria-describedby="p_category" required>

              <div class="button-container">
                <button type="submit" class="btn btn-primary" name="insert">Insert!</button>
              </div>

            </form>

          </div>
        </div>
      </div>
    </div>
    <div class="col">
      <p class="inventory-text">OR</p>
    </div>
    <div class="col">
      <div class="frontpage-card">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">Search Within Current Inventory</h5>

            <form action="inventory_results.php" method="post">
              <div class="form-group">
                <label for="p_name">Name</label>
                <input type="text" class="form-control" name="p_name" placeholder="Ex. Laptop" aria-describedby="p_name">
              </div>

              <div class="form-group">
                <label for="p_id">ProductID</label>
                <input type="text" class="form-control" name="p_id" placeholder="Ex. 0001" aria-describedby="p_id">
              </div>

              <div class="form-group">
                <label for="p_brand">Brand</label>
                <input type="text" class="form-control" name="p_brand" placeholder="Ex. Lenovo, Dell" aria-describedby="p_brand">
              </div>

              <div class="form-group">
                <label for="p_category">Category</label>
                <input type="text" class="form-control" name="p_category" placeholder="Ex. Laptop, Gaming Console, Phone, etc" aria-describedby="p_category">
              </div>

              <div class="button-container">
                <button type="submit" class="btn btn-primary">Search!</button>
              </div>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>

</body>

</html>