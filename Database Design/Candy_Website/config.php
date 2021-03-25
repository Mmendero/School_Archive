<?php
  session_start();  
  $servername = 'localhost';
  $username = 'menderm1_Admin';
  $password = 'master_pass';
  $databasename = 'menderm1_Oishii_Candy_Co.';

  // Create connection
  @ $db = new mysqli($servername, $username, $password, $databasename);
  if (mysqli_connect_errno()) {
    echo '<p class = "results-txt">Error: Could not connect to database.  Please try again later.</p>';
    exit;
  }

?>