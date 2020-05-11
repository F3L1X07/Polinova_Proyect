<?PHP
$hostname="localhost";
$database="polinova";
$username="root";
$password="";
$json=array();
	if(isset($_GET["User"]) && isset($_GET["Pasword"])){
		$user=$_GET['User'];
		$pwd=$_GET['Password'];
		
		$conexion=mysqli_connect($hostname,$username,$password,$database);
		
		$consulta="SELECT User, Password, ID FROM profile WHERE User= '{$user}' AND Password = '{$pwd}'";
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
			$results["ID"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
		
	}
	else{
		   	$results["User"]='';
			$results["Pasword"]='';
			$results["ID"]='';
			$json['datos'][]=$results;
			echo json_encode($json);
		}
?>