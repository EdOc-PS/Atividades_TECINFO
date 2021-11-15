
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Produtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author eeuar
 */

public class DAO_Produtor {
    public void InserirProdutor (Modelo_Produtor PEBD){
        try {
            String SQL = "INSERT INTO eduardo_octavio.produtor (email_produtor, nome_produtor, datainclu_produtor,"
                    + " nacionalidade_produtor) VALUES (?,?,?,?)";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, PEBD.getEmailPE());
              comando.setString(2,PEBD.getNomePE());
               comando.setString(3, PEBD.getDataiPE());
                 comando.setString(4, PEBD.getNaciPE());
                  
             int retornar = comando.executeUpdate();
                if (retornar > 0){
                    JOptionPane.showMessageDialog(null, "A conta do produtor " + PEBD.getNomePE() + " foi criada com sucesso.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao criar a conta do produtor: " + PEBD.getNomePE());
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
