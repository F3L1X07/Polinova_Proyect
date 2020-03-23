<?php
$hostname = "localhost";
$database = "";
$username = "root";
$password = "";
$json = array();
	if (isset($_GET["User"]) && isset($_GET["Pasword"])) {
		$user = $_GET['User'];
		$pwd = $_GET['Pasword'];
		
		$conexion = mysql_connect($hostname, $username, $password, $database);

		$consulta = "SELECT User, Pasword, names FROM usuario WHERE User = '{$user}' AND Pasword = '{$pwd}'";
		$resultado = mysql_query($conexion, $consulta);

		if ($consulta) {
			
			if ($reg = mysql_fetch_array($resultado)) {
				$json['datos'][] = $reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}

		else {
			$results["User"] = '';
			$results["Pasword"] = '';
			$results["names"] = '';
			$json['datos'][] = $results;
			echo json_encode($json);
		}
	}

	else {
		$results["User"] = '';
		$results["Pasword"] = ''; 
		$results["names"] = '';
		$json['datos'][] = $results;
		echo json_encode($json);
	}
?>
