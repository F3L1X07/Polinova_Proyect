<?php
$hostname = "localhost";
$database = "";
$username = "root";
$password = "";
$json = array();
	if (isset($_GET["user"]) && isset($_GET["pwd"])) {
		$user = $_GET['user'];
		$pwd = $_GET['pwd'];
		
		$conexion = mysql_connect($hostname, $username, $password, $database);

		$consulta = "SELECT user, pwd, names FROM usuario WHERE user = '{$user}' AND pwd = '{$pwd}'";
		$resultado = mysql_query($conexion, $consulta);

		if ($consulta) {
			
			if ($reg = mysql_fetch_array($resultado)) {
				$json['datos'][] = $reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}

		else {
			$results["user"] = '';
			$results["pwd"] = '';
			$results["names"] = '';
			$json['datos'][] = $results;
			echo json_encode($json);
		}
	}

	else {
		$results["user"] = '';
		$results["pwd"] = ''; 
		$results["names"] = '';
		$json['datos'][] = $results;
		echo json_encode($json);
	}
?>