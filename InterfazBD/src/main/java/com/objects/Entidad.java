package com.objects;

/**
 *
 * @author juanj
 */
public class Entidad {
    private int identidad;
    private String nom_entidad;

    public Entidad() {
    }

    public Entidad(int identidad) {
        this.identidad = identidad;
    }

    public Entidad(int identidad, String nom_entidad) {
        this.identidad = identidad;
        this.nom_entidad = nom_entidad;
    }

    public int getIdentidad() {
        return identidad;
    }

    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }

    public String getNom_entidad() {
        return nom_entidad;
    }

    public void setNom_entidad(String nom_entidad) {
        this.nom_entidad = nom_entidad;
    }

    
    
    @Override
    public String toString() {
        return "Entidad{" + "identidad=" + identidad + ", nom_entidad=" + nom_entidad + '}';
    }
    
    
}
