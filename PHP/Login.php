<?php
$con = msqli_connect("localhost", "id13539602_smartbeltdbproyect", "Joselyne.Cruz123", "id13539602_smartbeltbd");

$username     = $_POST["User"];
$password     = $_POST["Password"];

$statement = mysqli_prepare($con, "SELECT * FROM profile WHERE User = ? AND Password = ?");
mysqli_stmt_bind_param($statement, "ss", $username, $password);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $ID, $User, $Password, $Email);

$response = array();
$response["success"] = false;

while(mysqli_stmt_fetch($statement)){
$response["success"] = true;
$response["User"] = $User;
$response["Password"] = $Password;
$response["Email"] = $Email;
}

echo json_encode($response);
?>
