
package Modelo_LJBD;



/**
 * @author eeuar
 */

public class Modelo_Produtor {
    
    private String nomePE;
    private String dataiPE;
    private String emailPE;
    private String naciPE; 
    private int CodigoPE;
    
    public Modelo_Produtor(String nomePE, String dataiPE, String emailPE, String naciPE, int CodigoPE) {
        this.nomePE = nomePE;
        this.dataiPE = dataiPE;
        this.emailPE = emailPE;
        this.naciPE = naciPE;
        this.CodigoPE = CodigoPE;
    }
    public Modelo_Produtor() {
        this.nomePE = "";
        this.dataiPE = "";
        this.emailPE = "";
        this.naciPE = "";
        this.CodigoPE = 0;
    }

    public int getCodigoPE() {
        return CodigoPE;
    }

    public void setCodigoPE(int CodigoP) {
        this.CodigoPE = CodigoP;
    }

    public String getNomePE() {
        return nomePE;
    }

    public void setNomePE(String nomePE) {
        this.nomePE = nomePE;
    }

    public String getDataiPE() {
        return dataiPE;
    }

    public void setDataiPE(String dataiPE) {
        this.dataiPE = dataiPE;
    }

    public String getEmailPE() {
        return emailPE;
    }

    public void setEmailPE(String emailPE) {
        this.emailPE = emailPE;
    }

    public String getNaciPE() {
        return naciPE;
    }

    public void setNaciPE(String naciPE) {
        this.naciPE = naciPE;
    }

    @Override
    public String toString() {
        return "| " + nomePE + " - " + emailPE + " - " + naciPE + " - " + CodigoPE + " |";
    }
    
 
            
}
