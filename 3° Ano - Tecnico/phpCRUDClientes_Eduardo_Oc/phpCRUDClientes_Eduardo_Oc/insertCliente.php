<?php
    include 'db_connect.php';
        $nome = $_POST["txtNome"];
         $sobrenome = $_POST["txtSobrenome"];
          $email = $_POST["txtEmail"];
           $idade = $_POST["txtIdade"];

        $sql = "INSERT INTO clientes (nome, sobrenome, email ,idade)        
         VALUES ('".$nome."', '".$sobrenome."', '" .$email."', " .$idade.")";

            if ($conn->query($sql) === TRUE) {
                echo "<script>alert('Cliente inserido com sucesso.');</script>";
                 echo "<script>window.location = 'index.php';</script>";
            }
            else {
                echo "Erro: " . $sql . "<br>" . $conn->error;
                 echo "<script>window.history.back();</script>";
        }
    $conn->close();
?>
