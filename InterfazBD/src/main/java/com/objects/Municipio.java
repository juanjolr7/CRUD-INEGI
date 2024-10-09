package com.objects;

/**
 *
 * @author juanj
 */
public class Municipio {
    private int identidad;
    private int idmunicipio;
    private String nom_municipio;
    
    public Municipio(){
        
    }
    
    public Municipio(int identidad, int idmunicipio){
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
    }

    public Municipio(int identidad, int idmunicipio, String nom_municipio) {
        this.identidad = identidad;
        this.idmunicipio = idmunicipio;
        this.nom_municipio = nom_municipio;
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

    public String getNom_municipio() {
        return nom_municipio;
    }

    public void setNom_municipio(String nom_municipio) {
        this.nom_municipio = nom_municipio;
    }

    @Override
    public String toString() {
        return "Municipio{" + "identidad=" + identidad + ", idmunicipio=" + idmunicipio + ", nom_municipio=" + nom_municipio + '}';
    }
    
}
