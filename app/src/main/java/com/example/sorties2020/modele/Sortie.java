package com.example.sorties2020.modele;

import java.util.HashMap;

public class Sortie {
    protected String activite;
    protected String date;
    protected int id;

    public Sortie(String activite, String date, int id) {
        this.activite = activite;
        this.date = date;
        this.id = id;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String,String> obtenirActivitePourAfficher(){
        HashMap<String,String> activitePourAfficher = new HashMap<String,String>();
        activitePourAfficher.put("activite", this.activite);
        activitePourAfficher.put("date", this.date);
        activitePourAfficher.put("id", "" + this.id);
        return activitePourAfficher;
    }

}
