
package DAO_LJBD;


import Conexao_LJBD.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import Modelo_LJBD.Modelo_Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

        
/**
 * @author eeuar
 */

public class DAO_Usuario {
    public boolean InserirUsuario (Modelo_Usuario UBD){
                
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
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Modelo_Usuario> LUC(){
        try {
            String SQL = "SELECT nome_usuario, nickname_usuario, email_usuario, datanasc_usuario, nidentificacaocpf FROM eduardo_octavio.usuario";
            List<Modelo_Usuario> ListaU = new ArrayList<Modelo_Usuario>();
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            ResultSet Resul = PS.executeQuery();
            
            while (Resul.next()){
                Modelo_Usuario MUA = new Modelo_Usuario();
                MUA = this.PeAU(Resul);
                ListaU.add(MUA);
            }
            return ListaU;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Modelo_Usuario PeAU(ResultSet Resul){
        try {
            Modelo_Usuario MUA = new Modelo_Usuario();
            MUA.setNomeU(Resul.getString("nome_usuario"));
            MUA.setNicknameU(Resul.getString("nickname_usuario"));
            MUA.setEmailU(Resul.getString("email_usuario"));
            MUA.setDatanascU(Resul.getString("datanasc_usuario"));
            MUA.setNidentificacaoCPFU(Resul.getString("nidentificacaocpf"));
            return MUA;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Modelo_Usuario ConsultaA(Modelo_Usuario ADados){
        try {
            String SQL = "SELECT nome_usuario, nickname_usuario, email_usuario, datanasc_usuario, nidentificacaocpf FROM eduardo_octavio.usuario";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            String Filtro ="";
            
            if(ADados != null && ADados.getNomeU()!= null && !ADados.getNomeU().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome_usuario ilike '%"+ADados.getNomeU()+"%'";
                }
                else{
                Filtro = " WHERE nome_usuario ilike '%" + ADados.getNomeU() +"%'";
                }
            }         
             if(ADados != null && ADados.getNicknameU()!= null && !ADados.getNicknameU().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nickname_usuario ilike '%"+ADados.getNicknameU()+"%'";
                }
                else{
                Filtro = " WHERE nickname_usuario ilike '%" + ADados.getNicknameU() + "%'";
                }
            }
            if(ADados != null && ADados.getEmailU()!= null && !ADados.getEmailU().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND email_usuario ilike '%"+ADados.getEmailU()+"%'";
                }
                else{
                Filtro = " WHEREemail_usuario ilike '%" + ADados.getEmailU() + "%'";
                }
            } 
            
              if(ADados != null && ADados.getDatanascU()!= null && !ADados.getDatanascU().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND datanasc_usuario = '"+ADados.getDatanascU()+"'";
                }
                else{
                Filtro = " WHERE datanasc_usuario = '" + ADados.getDatanascU()+"'";
                }
            }
               if(ADados != null && ADados.getNidentificacaoCPFU()!= null && !ADados.getNidentificacaoCPFU().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nidentificacaocpf = '"+ADados.getNidentificacaoCPFU()+ "'";
                }
                else{
                Filtro = " WHERE nidentificacaocpf = '" + ADados.getNidentificacaoCPFU() + "'";
                }
            }
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL + Filtro);         
            ResultSet Resul = PS.executeQuery();
            
            if(Resul.next()){
               Modelo_Usuario MUA = new Modelo_Usuario();
                MUA = this.PeAU(Resul);
                return MUA;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Modelo_Usuario ConsultaUS(String nidentificacaocpf){
         try {
            String SQL = "SELECT nidentificacaocpf, nome_usuario, nickname_usuario, email_usuario, datanasc_usuario FROM eduardo_octavio.usuario WHERE nidentificacaocpf = ?";
            
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            PS.setString(1, nidentificacaocpf);
            ResultSet Resul = PS.executeQuery();
            
           if (Resul.next()){
                Modelo_Usuario MUU = new Modelo_Usuario();
                MUU = this.PeAU(Resul);
                return MUU;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
    public boolean ATUU(Modelo_Usuario DadosUA){
        try {
            String SQL = "UPDATE eduardo_octavio.usuario SET nome_usuario = ?, nickname_usuario = ?, email_usuario = ?, nacionalidade_usuario = ?, datanasc_usuario = ? WHERE nidentificacaocpf = ?";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, DadosUA.getNomeU());
              comando.setString(2, DadosUA.getNicknameU());
               comando.setString(6, DadosUA.getNidentificacaoCPFU());
                comando.setString(3, DadosUA.getEmailU());
                 comando.setString(4, DadosUA.getNacionalidadeU());
                  comando.setString(5, DadosUA.getDatanascU());
                  
             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
