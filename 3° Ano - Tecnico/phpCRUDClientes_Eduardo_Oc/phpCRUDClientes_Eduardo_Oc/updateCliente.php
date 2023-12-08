<?php
    include("db_connect.php");
        if (isset($_POST["txtNome"])) {
            $nome = $_POST["txtNome"];
             $sobrenome = $_POST["txtSobrenome"];
              $email = $_POST["txtEmail"];
               $idade = $_POST["txtIdade"];
        if (empty($nome)) {
            echo "Preencha as informações corretamente.";
             exit;
        } 
        else {
            $SQL = "UPDATE clientes SET nome = '".$nome."', sobrenome=
            '".$sobrenome. "', email= '".$email. "', idade=".$idade." WHERE id=
              ".$_GET["id"];
        if ($conn->query($SQL) === TRUE) {
            echo "<script>alert('O cliente foi atualizado com sucesso.');</script>";
             echo "<script>window.location = 'index.php';</script>";
        }
        else {
            echo "<script>alert('Erro ao editar os dados cliente.');</script>";
             echo "<script>window.location = 'updateCliente.php';</script>";
            }
        }
    }
?>

<?php

        if (isset($_GET["id"])) { 
         if (is_numeric($_GET["id"])) {
            $SQL = "SELECT * FROM clientes WHERE id = " . $_GET["id"];
             $executa = $conn->query($SQL); 
              $resultado = $executa->fetch_assoc();
?>

        <fieldset>
           <legend>Atualizar</legend>
             <form name="frm_cliente" method="POST"
                action="updateCliente.php?id=<?php echo $_GET["id"];?>">
                 Nome:<input type="text" name="txtNome" required="required"
                value="<?php echo $resultado["nome"]; ?>"/>

        <br/>
                 Sobrenome:<input type="text" name="txtSobrenome"
                required="required" value="<?php echo $resultado["sobrenome"]; ?>"/>

        <br/>
                 Email:<input type="text" name="txtEmail"
                required="required" value="<?php echo $resultado["email"]; ?>"/>

        <br/>
                 Idade:<input type="text" name="txtIdade" required="required"
                value="<?php echo $resultado["idade"]; ?>"/>

        <br/><br/>
    
         <input type="submit" value="Atualizar">
         <input type="reset" value="Limpar">
            </form>
            <br>
            <button><a href="index.php"> Listar Clientes</a></button>
    </fieldset>
        <?php
        }
    }
?>
</body>
</html>