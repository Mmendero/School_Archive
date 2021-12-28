<?php
session_start();
$servername = 'localhost';
$username = 'TechGiant';
$password = 'TechGiantpass';
$databasename = 'TechGiantdatabase';

// Create connection
$dsn = "mysql:host=$servername;dbname=$databasename;charset=UTF8";

try {
  $pdo = new PDO($dsn, $username, $password);
  $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
  echo $e->getMessage();
}
