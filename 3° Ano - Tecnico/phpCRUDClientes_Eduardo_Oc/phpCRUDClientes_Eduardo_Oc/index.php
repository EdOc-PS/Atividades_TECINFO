<html>
    <head>
        <title>Exemplo PHP</title>
            <script type="text/javascript">
                function apagar(id, nm, sn) {
                if (window.confirm("Deseja realmente apagar este Cliente:\n" + nm + " " +
                    sn)) {
                window.location = 'deleteCliente.php?id=' + id;
    }
}
            </script>
        <link rel="stylesheet" href="style.css">
    </head>
<body>

    <fieldset>
       <legend>Lista de pessoas cadastradas</legend>
    <?php

    include 'db_connect.php';
        $sql = "SELECT * FROM clientes";
         $result = $conn->query($sql);

    if ($result->num_rows > 0) {
    ?>

<table border="1">
    <tr> <th>Código</th><th>Nome</th> <th>Sobrenome</th><th>Email</th><th>Idade</th>
     <th></th><th></th></tr>

    <?php
     while ($exibir = $result->fetch_assoc()){
    ?>

    <tr>
     <td><?php echo $exibir["id"] ?> </td>
      <td><?php echo $exibir["nome"] ?> </td>
       <td><?php echo $exibir["sobrenome"] ?> </td>
      <td><?php echo $exibir["email"] ?> </td>
    <td><?php echo $exibir["idade"] ?> </td>

    <td><a href="updateCliente.php?id=<?php echo
        $exibir["id"] ?>">Editar</a></td>

        <td><a href="#" onclick="apagar('<?php echo
            $exibir["id"] ?>', '<?php echo $exibir["nome"] ?>','<?php echo
             $exibir["sobrenome"] ?>');">
              Excluir</a></td>
    </tr>
<?php
    }
?>
    </table>
        <?php
    }
    else {
      echo "Nenhum cliente encontrado.";
    }
        $conn->close();
    ?>
    <br>
        <button> <a class=lin1 href="addCliente.php"> Adicionar </a></button>
    </fieldset>
 </body>
</html>
