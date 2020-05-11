<?php


    $con = mysqli_connect("localhost", "id13539602_smartbeltdbproyect", "Joselyne.Cruz123", "id13539602_smartbeltbd");

$User         = $_POST["User"];
$Password     = $_POST["Password"];
$Email        = $_POST["Email"];


$statement    = mysqli_prepare($con, "INSERT INTO profile (User, Password, Email) VALUES 
(?, ?, ?)");
mysqli_stmt_bind_param($statement, "ssis", $User, $Password, $Email);
mysqli_stmt_execute($statement);

$response = array();
$response["success"] = true;

echo json_encode($response);

?>