package com.objects;

/**
 *
 * @author juanj
 */
public class Inegi {

    private int identidad;
    private int idmunicipio;
    private int idlocalidad;
    private int pob_total;
    private int pob_femenina;
    private int pob_masculina;

    private String nom_entidad;
    private String nom_localidad;
    private String nom_municipio;

    private int P_0A2_F;
    private int P_0A2_M;
    private int P_3YMAS_F;
    private int P_3YMAS_M;
    private int P_5YMAS_F;
    private int P_5YMAS_M;
    private int P_12YMAS_F;
    private int P_12YMAS_M;
    private int P_15YMAS_F;
    private int P_15YMAS_M;
    private int P_18YMAS_F;
    private int P_18YMAS_M;
    private int P_3A5_F;
    private int P_3A5_M;
    private int P_6A11_F;
    private int P_6A11_M;
    private int P_8A14_F;
    private int P_8A14_M;
    private int P_12A14_F;
    private int P_12A14_M;
    private int P_15A17_F;
    private int P_15A17_M;
    private int P_18A24_F;
    private int P_18A24_M;
    private int P_15A49_F;
    private int P_60YMAS_F;
    private int P_60YMAS_M;

    public Inegi() {
    }

    public Inegi(int identidad, int idmunicipio, int idlocalidad) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
    }
    
    
    
    public Inegi(int identidad, int idmunicipio, int idlocalidad, int pob_total, int pob_femenina, int pob_masculina) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
        this.pob_total = pob_total;
        this.pob_femenina = pob_femenina;
        this.pob_masculina = pob_masculina;
    }

    public Inegi(int identidad, String nom_entidad) {
        this.identidad = identidad;
        this.nom_entidad = nom_entidad;
    }

    public Inegi(int identidad, int idmunicipio, int idlocalidad, String nom_localidad) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
        this.nom_localidad = nom_localidad;
    }

    public Inegi(int identidad, int idmunicipio, String nom_municipio) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.nom_municipio = nom_municipio;
    }

    public Inegi(int identidad, int idmunicipio, int idlocalidad, int P_0A2_F, int P_0A2_M, int P_3YMAS_F, int P_3YMAS_M, int P_5YMAS_F, int P_5YMAS_M, int P_12YMAS_F, int P_12YMAS_M, int P_15YMAS_F, int P_15YMAS_M, int P_18YMAS_F, int P_18YMAS_M, int P_3A5_F, int P_3A5_M, int P_6A11_F, int P_6A11_M, int P_8A14_F, int P_8A14_M, int P_12A14_F, int P_12A14_M, int P_15A17_F, int P_15A17_M, int P_18A24_F, int P_18A24_M, int P_15A49_F, int P_60YMAS_F, int P_60YMAS_M) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
        this.P_0A2_F = P_0A2_F;
        this.P_0A2_M = P_0A2_M;
        this.P_3YMAS_F = P_3YMAS_F;
        this.P_3YMAS_M = P_3YMAS_M;
        this.P_5YMAS_F = P_5YMAS_F;
        this.P_5YMAS_M = P_5YMAS_M;
        this.P_12YMAS_F = P_12YMAS_F;
        this.P_12YMAS_M = P_12YMAS_M;
        this.P_15YMAS_F = P_15YMAS_F;
        this.P_15YMAS_M = P_15YMAS_M;
        this.P_18YMAS_F = P_18YMAS_F;
        this.P_18YMAS_M = P_18YMAS_M;
        this.P_3A5_F = P_3A5_F;
        this.P_3A5_M = P_3A5_M;
        this.P_6A11_F = P_6A11_F;
        this.P_6A11_M = P_6A11_M;
        this.P_8A14_F = P_8A14_F;
        this.P_8A14_M = P_8A14_M;
        this.P_12A14_F = P_12A14_F;
        this.P_12A14_M = P_12A14_M;
        this.P_15A17_F = P_15A17_F;
        this.P_15A17_M = P_15A17_M;
        this.P_18A24_F = P_18A24_F;
        this.P_18A24_M = P_18A24_M;
        this.P_15A49_F = P_15A49_F;
        this.P_60YMAS_F = P_60YMAS_F;
        this.P_60YMAS_M = P_60YMAS_M;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public int getIdlocalidad() {
        return idlocalidad;
    }

    public void setIdlocalidad(int idlocalidad) {
        this.idlocalidad = idlocalidad;
    }

    public int getPob_total() {
        return pob_total;
    }

    public void setPob_total(int pob_total) {
        this.pob_total = pob_total;
    }

    public int getPob_femenina() {
        return pob_femenina;
    }

    public void setPob_femenina(int pob_femenina) {
        this.pob_femenina = pob_femenina;
    }

    public int getPob_masculina() {
        return pob_masculina;
    }

    public void setPob_masculina(int pob_masculina) {
        this.pob_masculina = pob_masculina;
    }

    public String getNom_entidad() {
        return nom_entidad;
    }

    public void setNom_entidad(String nom_entidad) {
        this.nom_entidad = nom_entidad;
    }

    public String getNom_localidad() {
        return nom_localidad;
    }

    public void setNom_localidad(String nom_localidad) {
        this.nom_localidad = nom_localidad;
    }

    public String getNom_municipio() {
        return nom_municipio;
    }

    public void setNom_municipio(String nom_municipio) {
        this.nom_municipio = nom_municipio;
    }

    public int getP_0A2_F() {
        return P_0A2_F;
    }

    public void setP_0A2_F(int P_0A2_F) {
        this.P_0A2_F = P_0A2_F;
    }

    public int getP_0A2_M() {
        return P_0A2_M;
    }

    public void setP_0A2_M(int P_0A2_M) {
        this.P_0A2_M = P_0A2_M;
    }

    public int getP_3YMAS_F() {
        return P_3YMAS_F;
    }

    public void setP_3YMAS_F(int P_3YMAS_F) {
        this.P_3YMAS_F = P_3YMAS_F;
    }

    public int getP_3YMAS_M() {
        return P_3YMAS_M;
    }

    public void setP_3YMAS_M(int P_3YMAS_M) {
        this.P_3YMAS_M = P_3YMAS_M;
    }

    public int getP_5YMAS_F() {
        return P_5YMAS_F;
    }

    public void setP_5YMAS_F(int P_5YMAS_F) {
        this.P_5YMAS_F = P_5YMAS_F;
    }

    public int getP_5YMAS_M() {
        return P_5YMAS_M;
    }

    public void setP_5YMAS_M(int P_5YMAS_M) {
        this.P_5YMAS_M = P_5YMAS_M;
    }

    public int getP_12YMAS_F() {
        return P_12YMAS_F;
    }

    public void setP_12YMAS_F(int P_12YMAS_F) {
        this.P_12YMAS_F = P_12YMAS_F;
    }

    public int getP_12YMAS_M() {
        return P_12YMAS_M;
    }

    public void setP_12YMAS_M(int P_12YMAS_M) {
        this.P_12YMAS_M = P_12YMAS_M;
    }

    public int getP_15YMAS_F() {
        return P_15YMAS_F;
    }

    public void setP_15YMAS_F(int P_15YMAS_F) {
        this.P_15YMAS_F = P_15YMAS_F;
    }

    public int getP_15YMAS_M() {
        return P_15YMAS_M;
    }

    public void setP_15YMAS_M(int P_15YMAS_M) {
        this.P_15YMAS_M = P_15YMAS_M;
    }

    public int getP_18YMAS_F() {
        return P_18YMAS_F;
    }

    public void setP_18YMAS_F(int P_18YMAS_F) {
        this.P_18YMAS_F = P_18YMAS_F;
    }

    public int getP_18YMAS_M() {
        return P_18YMAS_M;
    }

    public void setP_18YMAS_M(int P_18YMAS_M) {
        this.P_18YMAS_M = P_18YMAS_M;
    }

    public int getP_3A5_F() {
        return P_3A5_F;
    }

    public void setP_3A5_F(int P_3A5_F) {
        this.P_3A5_F = P_3A5_F;
    }

    public int getP_3A5_M() {
        return P_3A5_M;
    }

    public void setP_3A5_M(int P_3A5_M) {
        this.P_3A5_M = P_3A5_M;
    }

    public int getP_6A11_F() {
        return P_6A11_F;
    }

    public void setP_6A11_F(int P_6A11_F) {
        this.P_6A11_F = P_6A11_F;
    }

    public int getP_6A11_M() {
        return P_6A11_M;
    }

    public void setP_6A11_M(int P_6A11_M) {
        this.P_6A11_M = P_6A11_M;
    }

    public int getP_8A14_F() {
        return P_8A14_F;
    }

    public void setP_8A14_F(int P_8A14_F) {
        this.P_8A14_F = P_8A14_F;
    }

    public int getP_8A14_M() {
        return P_8A14_M;
    }

    public void setP_8A14_M(int P_8A14_M) {
        this.P_8A14_M = P_8A14_M;
    }

    public int getP_12A14_F() {
        return P_12A14_F;
    }

    public void setP_12A14_F(int P_12A14_F) {
        this.P_12A14_F = P_12A14_F;
    }

    public int getP_12A14_M() {
        return P_12A14_M;
    }

    public void setP_12A14_M(int P_12A14_M) {
        this.P_12A14_M = P_12A14_M;
    }

    public int getP_15A17_F() {
        return P_15A17_F;
    }

    public void setP_15A17_F(int P_15A17_F) {
        this.P_15A17_F = P_15A17_F;
    }

    public int getP_15A17_M() {
        return P_15A17_M;
    }

    public void setP_15A17_M(int P_15A17_M) {
        this.P_15A17_M = P_15A17_M;
    }

    public int getP_18A24_F() {
        return P_18A24_F;
    }

    public void setP_18A24_F(int P_18A24_F) {
        this.P_18A24_F = P_18A24_F;
    }

    public int getP_18A24_M() {
        return P_18A24_M;
    }

    public void setP_18A24_M(int P_18A24_M) {
        this.P_18A24_M = P_18A24_M;
    }

    public int getP_15A49_F() {
        return P_15A49_F;
    }

    public void setP_15A49_F(int P_15A49_F) {
        this.P_15A49_F = P_15A49_F;
    }

    public int getP_60YMAS_F() {
        return P_60YMAS_F;
    }

    public void setP_60YMAS_F(int P_60YMAS_F) {
        this.P_60YMAS_F = P_60YMAS_F;
    }

    public int getP_60YMAS_M() {
        return P_60YMAS_M;
    }

    public void setP_60YMAS_M(int P_60YMAS_M) {
        this.P_60YMAS_M = P_60YMAS_M;
    }

    @Override
    public String toString() {
        return "Inegi{" + "identidad=" + identidad + ", idmunicipio=" + idmunicipio + ", idlocalidad=" + idlocalidad + ", pob_total=" + pob_total + ", pob_femenina=" + pob_femenina + ", pob_masculina=" + pob_masculina + ", nom_entidad=" + nom_entidad + ", nom_localidad=" + nom_localidad + ", nom_municipio=" + nom_municipio + ", P_0A2_F=" + P_0A2_F + ", P_0A2_M=" + P_0A2_M + ", P_3YMAS_F=" + P_3YMAS_F + ", P_3YMAS_M=" + P_3YMAS_M + ", P_5YMAS_F=" + P_5YMAS_F + ", P_5YMAS_M=" + P_5YMAS_M + ", P_12YMAS_F=" + P_12YMAS_F + ", P_12YMAS_M=" + P_12YMAS_M + ", P_15YMAS_F=" + P_15YMAS_F + ", P_15YMAS_M=" + P_15YMAS_M + ", P_18YMAS_F=" + P_18YMAS_F + ", P_18YMAS_M=" + P_18YMAS_M + ", P_3A5_F=" + P_3A5_F + ", P_3A5_M=" + P_3A5_M + ", P_6A11_F=" + P_6A11_F + ", P_6A11_M=" + P_6A11_M + ", P_8A14_F=" + P_8A14_F + ", P_8A14_M=" + P_8A14_M + ", P_12A14_F=" + P_12A14_F + ", P_12A14_M=" + P_12A14_M + ", P_15A17_F=" + P_15A17_F + ", P_15A17_M=" + P_15A17_M + ", P_18A24_F=" + P_18A24_F + ", P_18A24_M=" + P_18A24_M + ", P_15A49_F=" + P_15A49_F + ", P_60YMAS_F=" + P_60YMAS_F + ", P_60YMAS_M=" + P_60YMAS_M + '}';
    }    
    
}
