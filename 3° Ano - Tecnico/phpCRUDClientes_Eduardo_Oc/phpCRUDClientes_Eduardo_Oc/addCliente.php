<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>CRUD Clientes</title>
</head>
<body> 
        <fieldset> 
            <legend>Inserir nova pessoa</legend>
              <form action="insertCliente.php" method="post">
              <label for="txtNome">Nome: </label>
                <input type="text" name="txtNome" required autofocus placeholder="Informe o Nome">
              <br><br>
              <label for="txtSobrenome">Sobrenome: </label>
                <input type="text" name="txtSobrenome" required placeholder="Informe o Sobrenome">
              <br><br>
              <label for="txtEmail">Email: </label>
                <input type="text" name="txtEmail" required placeholder="Informe o Email">
              <br><br>
              <label for="txtIdade">Idade: </label>
                <input type="number" name="txtIdade" required maxlength="3"
                    placeholder="Informe a Idade">
              <br><br>
              <input type="submit" name="btnSalvar" value="Salvar">
                <input type="reset" name="btnCancelar" value="Cancelar">
        </form>
              <br>
                <button><a href="index.php"> Listar Clientes</a></button>
    </fieldset>
</body>
</html>