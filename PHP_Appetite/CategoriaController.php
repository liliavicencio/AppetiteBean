<?php 
	require("Connection.php");
	
	$model = new Connection();
	$db = $model->getConnection();
	
	$query = "SELECT * FROM menu";
	
	try {
		$stmt = $db->prepare($query);
		$result = $stmt->execute();
	} catch (PDOException $ex) {
		$response["success"] = 0;
		$response["message"] = "Problema con la base de datos, vuelve a intetarlo";
		die(json_encode($response));
	}
	
	if ($stmt->rowCount()) {
		$response["categoria_array"] = array();
		
		while(($row = $stmt->fetch())) {
			$element = array();
			$element["id_categoria"] = $row["id_categoria"];
			$element["nombre_categoria"] = $row["nombre_categoria"];
			$element["color"] = $row["color"];
			array_push($response["categoria_array"], $element);
		}
		$response["success"] = 1;
		$response["message"] = "Respuesta a Aplicacion Android";
 
		echo json_encode($response);
	} else {
		$response["success"] = 0;
		$response["message"] = "No products found";
	 
		echo json_encode($response);
	}
?>