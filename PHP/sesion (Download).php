<?PHP
$hostname="localhost";
$database="bd_prueba";
$username="root";
$password="";
$json=array();
	if(isset($_GET["User"]) && isset($_GET["Pasword"])){
		$user=$_GET['User'];
		$pwd=$_GET['Pasword'];
		
		$conexion=mysqli_connect($hostname,$username,$password,$database);
		
		$consulta="SELECT User, Pasword, names FROM usuarios WHERE User= '{$user}' AND Pasword = '{$pwd}'";
		$resultado=mysqli_query($conexion,$consulta);

		if($consulta){
		
			if($reg=mysqli_fetch_array($resultado)){
				$json['datos'][]=$reg;
			}
			mysqli_close($conexion);
			echo json_encode($json);
		}



		else{
			$results["User"]='';
			$results["Pasword"]='';
			$results["names"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
		
	}
	else{
		   	$results["User"]='';
			$results["Pasword"]='';
			$results["names"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
?>