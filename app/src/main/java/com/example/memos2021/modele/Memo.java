package com.example.memos2021.modele;

import java.util.HashMap;

public class Memo {
    protected String activite;
    protected String date;
    protected int id;

    public Memo(String activite, String date, int id) {
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

    public HashMap<String,String> obtenirSortiePourAfficher(){
        HashMap<String,String> sortiePourAfficher = new HashMap<String,String>();
        sortiePourAfficher.put("activite", this.activite);
        sortiePourAfficher.put("date", this.date);
        sortiePourAfficher.put("id", "" + this.id);
        return sortiePourAfficher;
    }

}
