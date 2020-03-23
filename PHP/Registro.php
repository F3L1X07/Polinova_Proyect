<?php 
error_reporting(0);

$conexion = mysql_connect("localhost", "", "", "register");

if(!$conexion)
{
	exit("Error al conectarse al servidor MYSQL");
}

$usuario = $_POST["Username_SU"];
$password = $_POST["Password_SU"];
$email = $_POST["Email_SU"];

if(empty($email))
{
	exit("Para registrarse llenar el campo \"Email\"");
}

$consulta = "insert into register (User,Password,Email) values ('$Username_SU', '$Password_SU', '$Email_SU')";
mysql_query($conexion,$consulta);

$num = mysql_affected_rows($conexion);

if ($num > 0) {
	echo "Registro Completado con Exito!!";
}
else {
	echo "Error, Su registro no se ha logrado completar";
}

mysqli_close($conexion);
?>