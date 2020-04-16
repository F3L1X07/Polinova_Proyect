<?php 
error_reporting(0);

$conexion = mysqli_connect("localhost", "102751", "030998", "102751");

if(!$conexion)
{
	exit("Error al conectarse al servidor MYSQL");
}

$User = $_POST["Username_SU"];
$Email = $_POST["Email_SU"];
$Password = $_POST["Password_SU"];

if(empty($Email))
{
	exit("Para registrarse llenar el campo \"Email\"");
}

$consulta = "insert into register (User,Email,Password) values ('$Username_SU', '$Email_SU', '$Password_SU')";
mysqli_query($conexion,$consulta);

$num = mysql_affected_rows($conexion);

if ($num > 0) {
	echo "Registro Completado con Exito!!";
}
else {
	echo "Error, Su registro no se ha logrado completar";
}

mysqli_close($conexion);
?>