
<?php
define('HOST', 'localhost:3307');
define('USER', 'root');
define('PASSWORD', ''); 
define('DB', 'bdclientes');
$conn = new mysqli(HOST, USER, PASSWORD, DB);
if ($conn->connect_error) {
die("Falha na conexão: " . $conn->connect_error); 
}
?>