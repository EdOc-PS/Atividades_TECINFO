
package DAO_LJBD;

import Conexao_LJBD.ConexaoBD;
import Modelo_LJBD.Modelo_Jogo;
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
    public List<Modelo_Jogo> LUC(){
        try {
            String SQL = "SELECT nome_jogo, requisitos_jogo, preco_jogo, temagenero_jogo, idioma_jogo, faixaeta_jogo, datalanc_jogo  FROM eduardo_octavio.jogo";
            List<Modelo_Jogo> ListaJ = new ArrayList<Modelo_Jogo>();
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL);
            ResultSet Resul = PS.executeQuery();
            
            while (Resul.next()){
                Modelo_Jogo MUJ = new Modelo_Jogo();
                MUJ = this.PeAJ(Resul);
                ListaJ.add(MUJ);
            }
            return ListaJ;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private Modelo_Jogo PeAJ(ResultSet Resul){
        try {
            Modelo_Jogo MUJ = new Modelo_Jogo();
            MUJ.setNomeJ(Resul.getString("nome_jogo"));
            MUJ.setReqJ(Resul.getString("requisitos_jogo"));
            MUJ.setPrecoJ(Resul.getDouble("preco_jogo"));
            MUJ.setGeneroJ(Resul.getString("temagenero_jogo"));
            MUJ.setIdiomasJ(Resul.getString("idioma_jogo"));
            MUJ.setFaixaeJ(Resul.getInt("faixaeta_jogo"));
            MUJ.setDatalancJ(Resul.getString("datalanc_jogo"));
                   
            return MUJ;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Modelo_Jogo ConsultaJ(Modelo_Jogo JDados){
        try {
            String SQL = "SELECT  nome_jogo,  temagenero_jogo, preco_jogo, idioma_jogo, requisitos_jogo, faixaeta_jogo, datalanc_jogo FROM eduardo_octavio.jogo";
            Connection ConexaoLJBD = ConexaoBD.getConexao();
            String Filtro ="";
            
            if(JDados != null && JDados.getNomeJ()!= null && !JDados.getNomeJ().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND nome_jogo ilike '%"+JDados.getNomeJ()+"%'";
                }
                else{
                Filtro = " WHERE nome_jogo ilike '%" + JDados.getNomeJ() +"%'";
                }
            }   
            if(JDados != null && JDados.getIdiomasJ()!= null && !JDados.getIdiomasJ().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND idioma_jogo ilike '%"+JDados.getIdiomasJ()+"%'";
                }
                else{
                Filtro = " WHERE idioma_jogo ilike '%" + JDados.getIdiomasJ() +"%'";
                }
            }   
             if(JDados != null && JDados.getDatalancJ()!= null && !JDados.getDatalancJ().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND datalanc_jogo ilike '%"+JDados.getDatalancJ()+"%'";
                }
                else{
                Filtro = " WHERE datalanc_jogo ilike '%" + JDados.getDatalancJ() + "%'";
                }
            }
               if(JDados != null && JDados.getReqJ()!= null && !JDados.getReqJ().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND requisitos_jogo ilike '%"+JDados.getReqJ()+"%'";
                }
                else{
                Filtro = " WHERE requisitos_jogo ilike '%" + JDados.getReqJ() + "%'";
                }
            }
            if(JDados != null && JDados.getFaixaeJ() >0){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " WHERE faixaeta_jogoo ilike '%"+JDados.getFaixaeJ()+"%'";
                }
                
            } 
             if(JDados != null && JDados.getPrecoJ()>0){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " WHERE preco_jogo ilike '%"+JDados.getPrecoJ()+"%'";
                }
                
            } 
              if(JDados != null && JDados.getGeneroJ()!= null && !JDados.getGeneroJ().equalsIgnoreCase("")){
                if(!Filtro.equalsIgnoreCase("")){
                    Filtro += " AND temagenero_jogo = '%"+JDados.getGeneroJ()+"&'";
                }
                else{
                Filtro = " WHERE temagenero_jogo = '%" + JDados.getGeneroJ()+"&'";
                }
            }
              
            PreparedStatement PS = ConexaoLJBD.prepareStatement(SQL + Filtro);         
            ResultSet Resul = PS.executeQuery();
            
            if(Resul.next()){
               Modelo_Jogo MUJ = new Modelo_Jogo();
                MUJ = this.PeAJ(Resul);
                return MUJ;
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Jogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
