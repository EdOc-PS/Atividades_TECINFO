
package Modelo_LJBD;



/**
 * @author eeuar
 */

public class Modelo_Jogo {
    
    private String nomeJ;
    private double precoJ;
    private String datalancJ;
    private int faixaeJ;
    private String generoJ;
    private String idiomasJ;
    private String reqJ;
    private int CodJ;
    public Modelo_Jogo(String nomeJ, double precoJ, String datalancJ, int faixaeJ, String generoJ, String reqJ, int CodJ) {
        this.nomeJ = nomeJ;
        this.precoJ = precoJ;
        this.datalancJ = datalancJ;
        this.faixaeJ = faixaeJ;
        this.generoJ = generoJ;
        this.reqJ = reqJ;
        this.CodJ = CodJ;
    }

    public Modelo_Jogo() {
        this.nomeJ = "";
        this.precoJ = 0;
        this.datalancJ = "";
        this.faixaeJ = 0;
        this.generoJ = "";
        this.reqJ = "";
        this.CodJ = 0;
    }

    public int getCodJ() {
        return CodJ;
    }

    public void setCodJ(int CodJ) {
        this.CodJ = CodJ;
    }
    
    public String getNomeJ() {
        return nomeJ;
    }

    public void setNomeJ(String nomeJ) {
        this.nomeJ = nomeJ;
    }

    public double getPrecoJ() {
        return precoJ;
    }

    public void setPrecoJ(double precoJ) {
        this.precoJ = precoJ;
    }

    public String getDatalancJ() {
        return datalancJ;
    }

    public void setDatalancJ(String datalancJ) {
        this.datalancJ = datalancJ;
    }

    public int getFaixaeJ() {
        return faixaeJ;
    }

    public void setFaixaeJ(int faixaeJ) {
        this.faixaeJ = faixaeJ;
    }

    public String getGeneroJ() {
        return generoJ;
    }

    public void setGeneroJ(String generoJ) {
        this.generoJ = generoJ;
    }

    public String getIdiomasJ() {
        return idiomasJ;
    }

    public void setIdiomasJ(String idiomasJ) {
        this.idiomasJ = idiomasJ;
    }

    public String getReqJ() {
        return reqJ;
    }

    public void setReqJ(String reqJ) {
        this.reqJ = reqJ;
    }

    @Override
    public String toString() {
        return "| "+ CodJ + " - " + nomeJ + " - " + precoJ + " - " + datalancJ + " - " + faixaeJ + " |";
    }    
    
}

