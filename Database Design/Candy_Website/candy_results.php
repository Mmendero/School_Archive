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
      // create short variable names      
      $name=$_POST['p_name'];
      $id=$_POST['p_id'];
      $brand=$_POST['p_brand'];
      $category=$_POST['p_category'];
      $all_inputs = array();
      $query = array();
      $choices_txt = [];

      //Test if there is at least one input
      if(!empty($name)){
        $all_inputs["Name"] = ucwords($name);
      }
      if(!empty($id)){
        $all_inputs["Product ID"] = $id;
      }
      if(!empty($brand)){
        $all_inputs["Brand/Manufacturer"] = ucwords($brand);
      }
      if(!empty($category)){
        $all_inputs["Category"] = ucwords($category);
      }
      if(count($all_inputs) == 0){
        echo '<p class = "results-txt">Error: no inputs made. :(</p>';
        exit;
      }

      //Construct Query + retrieve results
      foreach($all_inputs as $key => $value){
        $query[] = "`".$key."` LIKE '%".$value."%'";
        $choices_txt[] = $value; 
      }
      $query = implode(' OR ', $query);
      $query = "SELECT * FROM Products WHERE ".$query;
      $result = $db->query($query);

      //Display
      $num_results = $result->num_rows;
      echo '<p class = "results-txt">'.$num_results." Results for: ".implode(', ',$choices_txt)."</p>";

      echo '<div class="row">';
      for ($i=0; $i <$num_results; $i++) {
        $row = $result->fetch_assoc();

        echo '<div class="column">';
        echo '<!-- Display Candy -->';
        echo '<div class="card search-card">';
        echo '<div class="card-body">';
        echo '<form action="checkout.php" method="POST">';
        echo '<h5 class="card-title">';
        echo htmlspecialchars(stripslashes($row['Name']));
        echo '</h5>';
        echo '';
        echo '<p>';
        echo 'Brand: ';
        echo stripslashes($row['Brand/Manufacturer']);
        echo '<br>';
        echo 'Category: ';
        echo stripslashes($row['Category']);
        echo '<br>';
        echo 'Product ID: ';
        echo stripslashes($row['Product ID']);
        echo '<br>';
        echo 'Price: $';
        echo stripslashes($row['Price']);
        echo '<br>';
        echo '</p>';
        echo '';
        echo '<div class="input-group mb-3">';
        echo '<input type="number" name="quantity" min="1" class="form-control" placeholder="Quantity" aria-label="Quantity" aria-describedby="basic-addon2">';
        echo '<input type="hidden" name="productid" value="'.stripslashes($row['Product ID']).'">';
        echo '<input type="hidden" name="unitprice" value="'.stripslashes($row['Price']).'">';
        echo '<div class="input-group-append">';
        echo '<button class="btn btn-primary" name="send_to_cart" type="submit">Add to Cart!</button>';
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

      $result->free();
      $db->close();

    ?>

    </body>
  </html>