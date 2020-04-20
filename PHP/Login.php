<?php
$hostname = "localhost";
$database = "polinova";
$username = "root";
$password = "";
$json = array();
	if (isset($_GET["Username_SI"]) && isset($_GET["Pasword_SI"])) {
		$User = $_GET['Username_SI'];
		$Password = $_GET['Pasword_SI'];
		
		$conexion = mysql_connect($hostname, $User, $Password, $database);

		$consulta = "SELECT Username_SI, Pasword_SI, names FROM usuario WHERE Username_SI = '{$User}' AND Pasword_SI = '{$Password}'";
		$resultado = mysql_query($conexion, $consulta);

		if ($consulta) {
			
			if ($reg = mysql_fetch_array($resultado)) {
				$json['datos'][] = $reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}

		else {
			$results["Username_SI"] = '';
			$results["Pasword_SI"] = '';
			$results["names"] = '';
			$json['datos'][] = $results;
			echo json_encode($json);
		}
	}

	else {
		$results["Username_SI"] = '';
		$results["Pasword_SI"] = ''; 
		$results["names"] = '';
		$json['datos'][] = $results;
		echo json_encode($json);
	}
?>
