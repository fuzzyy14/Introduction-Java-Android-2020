package com.example.sorties2020.donnee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActiviteDAO {
    private static ActiviteDAO instance = null;
    private  List<HashMap<String, String>> listeActivites;

    private ActiviteDAO(){
        listeActivites = new ArrayList<HashMap<String, String>>();
        preparerListeActivites();
    }

    private void preparerListeActivites(){
        HashMap<String, String> activite;

        activite = new HashMap<String, String>();
        activite.put("activite","Scéance de cinéma avec les amis "+ "film Là Haut");
        activite.put("date","12 Juillet "+"à 15h20");
        listeActivites.add(activite);

        activite = new HashMap<String, String>();
        activite.put("activite","Parc Festiland "+ "avec mes amis du lycée");
        activite.put("date","24 Mars "+ "de 13h à 19h");
        listeActivites.add(activite);

        activite = new HashMap<String, String>();
        activite.put("activite","Parc aquatique H2O "+"avec ma tante, ma cousine, ma mère, mon frère et ma soeur");
        activite.put("date","12 Février "+"de 14h à 17h30");
        listeActivites.add(activite);
    }

    public static ActiviteDAO getInstance(){ // fonction pour initialiser une instance ActiviteDAO et ainsi preparer la liste
        if(null == instance){
            instance = new ActiviteDAO();
        }

        return instance;
    }

    public List<HashMap<String, String>> listerActivites(){
        return listeActivites;
    }

    public void ajouterActivite(HashMap<String, String> activite){
        listeActivites.add(activite);
    }

}
