
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author eeuar
 */

public class DAO_Jogo {
    public void InserirJogo (Modelo_Jogo JBD){
        try {
            String SQL = "INSERT INTO eduardo_octavio.jogo(nome_jogo, preco_jogo, temagenero_jogo,"
                    + " idioma_jogo, faixaeta_jogo, requisitos_jogo, datalanc_jogo) VALUES (?,?,?,?,?,?,?)";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, JBD.getNomeJ());
              comando.setDouble(2,JBD.getPrecoJ());
               comando.setString(3, JBD.getGeneroJ());
                 comando.setString(4, JBD.getIdiomasJ());
                  comando.setInt(5, JBD.getFaixaeJ());
                   comando.setString(6, JBD.getReqJ());
                    comando.setString(7, JBD.getDatalancJ());
                  
             int retornar = comando.executeUpdate();
                if (retornar > 0){
                    JOptionPane.showMessageDialog(null, "O jogo " + JBD.getNomeJ() + " foi adicionado com sucesso.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado ao adicionar o jogo " + JBD.getNomeJ());
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
