
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Distribuidora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author eeuar
 */

public class DAO_Distribuidora {
   public void InserirDistribuidora (Modelo_Distribuidora DBD){
        try {
            String SQL = "INSERT INTO eduardo_octavio.distribuidora (email_distribuidora, nome_distribuidora, datainclu_distribuidora) "
                    + "VALUES (?,?,?)";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, DBD.getEmailD());
              comando.setString(2, DBD.getNomeD());
               comando.setString(3, DBD.getDataiD());
                  
             int retornar = comando.executeUpdate();
                if (retornar > 0){
                    JOptionPane.showMessageDialog(null, "A conta da distribuidora " + DBD.getNomeD() + " foi criada com sucesso.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao criar a conta da distribuidora: " + DBD.getNomeD());
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
