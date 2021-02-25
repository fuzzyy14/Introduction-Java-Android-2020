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

    public HashMap<String,String> obtenirMemoPourAfficher(){
        HashMap<String,String> memoPourAfficher = new HashMap<String,String>();
        memoPourAfficher.put("activite", this.activite);
        memoPourAfficher.put("date", this.date);
        memoPourAfficher.put("id", "" + this.id);
        return memoPourAfficher;
    }

}
