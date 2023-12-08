<?php
include ("db_connect.php");
if(is_numeric($_GET["id"])){
$SQL = "DELETE FROM clientes WHERE id = ".$_GET["id"];
if ($conn->query($SQL) === TRUE) {
echo "<script>alert('Cliente excluído com sucesso!');</script>";
echo "<script>window.location = 'index.php';</script>";
}
else{
echo "<script>alert('Erro ao excluir o Cliente!');</script>";
echo "<script>window.location = 'index.php';</script>";
}
}
?>