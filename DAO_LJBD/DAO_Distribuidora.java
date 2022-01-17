
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Distribuidora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 * @author eeuar
 */

public class DAO_Distribuidora {
   public boolean InserirDistribuidora (Modelo_Distribuidora DBD){
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
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

   public List<Modelo_Distribuidora> LUCD(){
        try {
            String SQL = "SELECT nome_distribuidora, datainclu_distribuidora, email_distribuidora, codigo_distribuidora FROM eduardo_octavio.distribuidora";
            List<Modelo_Distribuidora> ListaU = new ArrayList<Modelo_Distribuidora>();
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            ResultSet Resul = PS.executeQuery();
            
            while (Resul.next()){
               Modelo_Distribuidora MUD = new Modelo_Distribuidora();
                MUD = this.PeDU(Resul);
                ListaU.add(MUD);
            }
            return ListaU;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Modelo_Distribuidora PeDU(ResultSet Resul){
        try {
            Modelo_Distribuidora MUD = new Modelo_Distribuidora();
            MUD.setNomeD(Resul.getString("nome_distribuidora"));
            MUD.setEmailD(Resul.getString("email_distribuidora"));
            MUD.setDataiD(Resul.getString("datainclu_distribuidora"));
            MUD.setCodigoD(Resul.getInt("codigo_distribuidora"));
            return MUD;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Modelo_Distribuidora ConsultaD(Modelo_Distribuidora DDados){
        try {
            String SQL = "SELECT nome_distribuidora, datainclu_distribuidora, email_distribuidora, codigo_distribuidora FROM eduardo_octavio.distribuidora";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            String Filtro ="";
            
            if(DDados != null && DDados.getNomeD()!= null && !DDados.getNomeD().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome_distribuidora ilike '%"+DDados.getNomeD()+"%'";
                }
                else{
                Filtro = " WHERE nome_distribuidora ilike'%" + DDados.getNomeD() +"%'";
                }
            }
            
             if(DDados != null && DDados.getDataiD()!= null && !DDados.getDataiD().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND datainclu_distribuidora = '"+DDados.getDataiD()+"'";
                }
                else{
                Filtro = " WHERE datainclu_distribuidora = '" + DDados.getDataiD() + "'";
                }
            }
              if(DDados != null && DDados.getEmailD()!= null && !DDados.getEmailD().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND email_distribuidora ilike '%"+DDados.getEmailD()+"%'";
                }
                else{
                Filtro = " WHERE email_distribuidora ilike '%" + DDados.getEmailD()+"%'";
                }
            }
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL + Filtro);         
            ResultSet Resul = PS.executeQuery();
            
            if(Resul.next()){
               Modelo_Distribuidora MUD = new Modelo_Distribuidora();
                MUD = this.PeDU(Resul);
                return MUD;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Modelo_Distribuidora ConsultaDI(String codigo_distribuidora){
         try {
            String SQL = "SELECT nome_distribuidora, datainclu_distribuidora, email_distribuidora, codigo_distribuidora FROM eduardo_octavio.distribuidora WHERE codigo_distribuidora = ?";
            
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            PS.setInt(1, Integer.valueOf(codigo_distribuidora));
            ResultSet Resul = PS.executeQuery();
            
           if (Resul.next()){
                Modelo_Distribuidora MUD = new Modelo_Distribuidora();
                MUD= this.PeDU(Resul);
                return MUD;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     
    }
     public boolean ATUD(Modelo_Distribuidora DadosDIS){
        try {
            String SQL = "UPDATE eduardo_octavio.distribuidora SET nome_distribuidora = ?, datainclu_distribuidora = ?, email_distribuidora = ?  WHERE codigo_distribuidora = ?";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, DadosDIS.getNomeD());
              comando.setString(2, DadosDIS.getDataiD());
               comando.setString(3, DadosDIS.getEmailD());
                 comando.setInt(4, DadosDIS.getCodigoD());
                 
                  
             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public boolean DELETARD(Modelo_Distribuidora DEDIS ){
        try {
            String SQL = "DELETE FROM eduardo_octavio.distribuidora WHERE codigo_distribuidora = ?";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
                 comando.setInt(1, DEDIS.getCodigoD());
                 
                  
             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Distribuidora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}