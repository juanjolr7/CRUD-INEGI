package com.objects;

/**
 *
 * @author juanj
 */
public class Censo2020 {
    private int identidad;
    private int idmunicipio;
    private int idlocalidad;
    private int pob_total;
    private int pob_femenina;
    private int pob_masculina;

    public Censo2020() {
    }

    public Censo2020(int identidad, int idmunicipio, int idlocalidad) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
    }

    public Censo2020(int identidad, int idmunicipio, int idlocalidad, int pob_total, int pob_femenina, int pob_masculina) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
        this.pob_total = pob_total;
        this.pob_femenina = pob_femenina;
        this.pob_masculina = pob_masculina;
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

    
    
    @Override
    public String toString() {
        return "Censo2020{" + "identidad=" + identidad + ", idmunicipio=" + idmunicipio + ", idlocalidad=" + idlocalidad + ", pob_total=" + pob_total + ", pob_femenina=" + pob_femenina + ", pob_masculina=" + pob_masculina + '}';
    }
    
    
}
