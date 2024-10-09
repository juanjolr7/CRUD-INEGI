package com.objects;

/**
 *
 * @author juanj
 */
public class Localidad {
    private int identidad;
    private int idmunicipio;
    private int idlocalidad;
    private String nom_localidad;

    public Localidad() {
    }

    public Localidad(int identidad, int idmunicipio, int idlocalidad) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
    }

    public Localidad(int identidad, int idmunicipio, int idlocalidad, String nom_localidad) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.idlocalidad = idlocalidad;
        this.nom_localidad = nom_localidad;
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

    public String getNom_localidad() {
        return nom_localidad;
    }

    public void setNom_localidad(String nom_localidad) {
        this.nom_localidad = nom_localidad;
    }

    @Override
    public String toString() {
        return "Localidad{" + "identidad=" + identidad + ", idmunicipio=" + idmunicipio + ", idlocalidad=" + idlocalidad + ", nom_localidad=" + nom_localidad + '}';
    }
    
}
