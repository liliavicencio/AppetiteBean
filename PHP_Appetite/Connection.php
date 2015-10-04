<?php

	class Connection {
		
		public function getConnection() {
			$host = "localhost";
			$dbName = "u616372138_app";
			$root = "u616372138_user";
			$password = "root15";
			
			try {
				$connect = new PDO("mysql:host=$host;dbname=$dbName;", $root, $password);
			} catch (PDOException $ex) {
				die("Failed to connect to the database: " . $ex->getMessage());
			}
			
			return $connect;
		}
	}
?>