
package Modelo_LJBD;

/**
 * @author eeuar
 */

public class Modelo_Distribuidora {
    
    private String nomeD;
        private String dataiD;
                private String emailD;

    public Modelo_Distribuidora(String nomeD, String dataiD, String emailD) {
        this.nomeD = nomeD;
        this.dataiD = dataiD;
        this.emailD = emailD;
    }

    public Modelo_Distribuidora() {
        this.nomeD = "";
        this.dataiD = "";
        this.emailD = "";
    }

    public String getNomeD() {
        return nomeD;
    }

    public void setNomeD(String nomeD) {
        this.nomeD = nomeD;
    }

    public String getDataiD() {
        return dataiD;
    }

    public void setDataiD(String dataiD) {
        this.dataiD = dataiD;
    }

    public String getEmailD() {
        return emailD;
    }

    public void setEmailD(String emailD) {
        this.emailD = emailD;
    }
                
}