
package DAO_LJBD;


import Conexao_LJBD.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo_LJBD.Modelo_Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

        
/**
 * @author eeuar
 */

public class DAO_Usuario {
    public void InserirUsuario (Modelo_Usuario UBD){
                
        try {
            String SQL = "INSERT INTO eduardo_octavio.usuario (nome_usuario, nickname_usuario, nidentificacaocpf, "
                    + "email_usuario, nacionalidade_usuario, datanasc_usuario) VALUES (?,?,?,?,?,?)";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, UBD.getNomeU());
              comando.setString(2, UBD.getNicknameU());
               comando.setString(3, UBD.getNidentificacaoCPFU());
                comando.setString(4, UBD.getEmailU());
                 comando.setString(5, UBD.getNacionalidadeU());
                  comando.setString(6, UBD.getDatanascU());
                  
             int retornar = comando.executeUpdate();
                if (retornar > 0){
                    JOptionPane.showMessageDialog(null, "A conta do usuário " + UBD.getNomeU() + " foi criada com sucesso.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao criar a conta do usuário: " + UBD.getNomeU());
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
