
package Modelo_LJBD;

/**
 * @author eeuar
 */

public class Modelo_Usuario {
        
    private String nomeU;
    private String nicknameU;
    private String datanascU;
    private String nidentificacaoCPFU;
    private String emailU;
    private String nacionalidadeU; 

    public Modelo_Usuario() {
        this.nomeU = "";
        this.nicknameU = "";
        this.datanascU = "";
        this.nidentificacaoCPFU = "";
        this.emailU = "";
        this.nacionalidadeU = "";
    }
  

    public Modelo_Usuario(String nomeU, String nicknameU, String datanascU, String nindentificacaoCPFU, String emailU, String nacionalidadeU) {
        this.nomeU = nomeU;
        this.nicknameU = nicknameU;
        this.datanascU = datanascU;
        this.nidentificacaoCPFU = nidentificacaoCPFU;
        this.emailU = emailU;
        this.nacionalidadeU = nacionalidadeU;
        
    }

    public String getNomeU() {
        return nomeU;
    }

    public void setNomeU(String nomeU) {
        this.nomeU = nomeU;
    }

    public String getNicknameU() {
        return nicknameU;
    }

    public void setNicknameU(String nicknameU) {
        this.nicknameU = nicknameU;
    }
   
    public String getDatanascU() {
        return datanascU;
    }
    
    public void setDatanascU(String datanascU) {
        this.datanascU = datanascU;
    }

    public String getNidentificacaoCPFU() {
        return nidentificacaoCPFU;
    }

    public void setNidentificacaoCPFU(String nindentificacaoCPFU) {
        this.nidentificacaoCPFU = nindentificacaoCPFU;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getNacionalidadeU() {
        return nacionalidadeU;
    }

    public void setNacionalidadeU(String nacionalidadeU) {
        this.nacionalidadeU = nacionalidadeU;
    }
   @Override
   public String toString(){
       return "| " + nidentificacaoCPFU + " - " + nomeU + " - " + nicknameU + " - " + emailU + " - " + datanascU + " |";
                    
    }
}
