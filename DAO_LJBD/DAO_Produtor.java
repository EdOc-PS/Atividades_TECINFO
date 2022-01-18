
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Produtor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 * @author eeuar
 */

public class DAO_Produtor {
    public boolean InserirProdutor (Modelo_Produtor PEBD){
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
                   return true;
                }
               
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
  public List<Modelo_Produtor> LUCP(){
        try {
            String SQL = "SELECT nome_produtor, datainclu_produtor, email_produtor, nacionalidade_produtor, codigo_produtor FROM eduardo_octavio.produtor";
            List<Modelo_Produtor> ListaU = new ArrayList<Modelo_Produtor>();
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            ResultSet Resul = PS.executeQuery();
            
            while (Resul.next()){
               Modelo_Produtor MUP = new Modelo_Produtor();
                MUP = this.PePU(Resul);
                ListaU.add(MUP);
            }
            return ListaU;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Modelo_Produtor PePU(ResultSet Resul){
        try {
            Modelo_Produtor MUP = new Modelo_Produtor();
            MUP.setNomePE(Resul.getString("nome_produtor"));
            MUP.setEmailPE(Resul.getString("email_produtor"));
            MUP.setDataiPE(Resul.getString("datainclu_produtor"));
            MUP.setNaciPE(Resul.getString("nacionalidade_produtor"));
            MUP.setCodigoPE(Resul.getInt("codigo_produtor"));
            return MUP;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Modelo_Produtor ConsultaPE(String codigo_produtor){
        try {
            String SQL = "SELECT nome_produtor, datainclu_produtor, email_produtor, nacionalidade_produtor, codigo_produtor FROM eduardo_octavio.produtor WHERE codigo_produtor = ?";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            PS.setInt(1, Integer.valueOf(codigo_produtor));
            ResultSet Resul = PS.executeQuery();
            
            if(Resul.next()){
               Modelo_Produtor MUP = new Modelo_Produtor();
                MUP = this.PePU(Resul);
                return MUP;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
                                      
           
     public Modelo_Produtor ConsultaP(Modelo_Produtor PDados){
        try {
            String SQL = "SELECT nome_produtor, datainclu_produtor, email_produtor, nacionalidade_produtor, codigo_produtor FROM eduardo_octavio.produtor";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            String Filtro ="";
            
            if(PDados != null && PDados.getNomePE()!= null && !PDados.getNomePE().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome_produtor ilike '%"+PDados.getNomePE()+"%'";
                }
                else{
                Filtro = " WHERE nome_produtor ilike'%" + PDados.getNomePE() +"%'";
                }
            }
            
             if(PDados != null && PDados.getDataiPE()!= null && !PDados.getDataiPE().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND datainclu_produtor = '" +PDados.getDataiPE()+"'";
                }
                else{
                Filtro = " WHERE datainclu_produtor = '" + PDados.getDataiPE() + "'";
                }
            }
              if(PDados != null && PDados.getEmailPE()!= null && !PDados.getEmailPE().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND email_produtor ilike '%"+PDados.getEmailPE()+"%'";
                }
                else{
                Filtro = " WHERE email_produtor ilike '%" + PDados.getEmailPE()+"%'";
                }
            }
              if(PDados != null && PDados.getNaciPE()!= null && !PDados.getNaciPE().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nacionalidade_produtor ilike '%"+PDados.getNaciPE()+"%'";
                }
                else{
                Filtro = " WHERE nacionalidade_produtor '%" + PDados.getNaciPE()+"%'";
                }
            }
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL + Filtro);         
            ResultSet Resul = PS.executeQuery();
            
            if(Resul.next()){
               Modelo_Produtor MUP = new Modelo_Produtor ();
                MUP = this.PePU(Resul);
                return MUP;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public boolean ATUPE(Modelo_Produtor DadosUA){
        try {
            String SQL = "UPDATE eduardo_octavio.produtor SET nome_produtor = ?, datainclu_produtor = ?, email_produtor = ?, nacionalidade_produtor = ? WHERE codigo_produtor = ?";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
              PreparedStatement comando = ConexaoLJBD.prepareStatement(SQL);
             
             comando.setString(1, DadosUA.getNomePE());
              comando.setString(2, DadosUA.getDataiPE());
               comando.setString(3, DadosUA.getEmailPE());
                comando.setString(4, DadosUA.getNaciPE());
                  comando.setInt (5, DadosUA.getCodigoPE());
                  
             int retornar = comando.executeUpdate();
             if (retornar > 0){
                   return true;
                }
                
                
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Produtor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
