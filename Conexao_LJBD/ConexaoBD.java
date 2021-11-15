
package Conexao_LJBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author eeuar
 */

public class ConexaoBD {
    private static String url = "jdbc:postgresql://200.18.128.54/aula";
        private static String usuario = "aula";
            private static String senha = "aula";
    
    private static Connection ConexaoLJBD = null;
    
    public static Connection getConexao(){
         try {
        if(ConexaoBD.ConexaoLJBD == null){
           ConexaoBD.ConexaoLJBD = DriverManager.getConnection(url, usuario, senha);
            } 
        return ConexaoLJBD;
    }
    catch (SQLException ex) {
                Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Ocorreu um erro ao se conectar ao banco de dados!");
                System.out.println("Erro: " + ex.getMessage());
        }
        return null;
 }
}