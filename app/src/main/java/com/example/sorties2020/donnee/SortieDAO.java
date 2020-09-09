package com.example.sorties2020.donnee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.sorties2020.modele.Sortie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SortieDAO {
    private static SortieDAO instance = null;
    //private  List<HashMap<String, String>> listeActivites;
    private List<Sortie> listeSorties;

    private BaseDeDonnees baseDeDonnees;

    private SortieDAO() {
        this.baseDeDonnees = BaseDeDonnees.getInstance();

        //listeActivites = new ArrayList<HashMap<String, String>>();
        listeSorties = new ArrayList<Sortie>();
        //preparerListeSorties();
    }

    /*private void preparerListeSorties() {
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

        listeSorties.add(new Sortie("Scéance de cinéma avec les amis " + "film Là Haut", "12 Juillet " + "15h20", 0));
        listeSorties.add(new Sortie("Parc Festiland " + "avec mes amis du lycée", "24 Mars " + "de 13h à 19h", 1));
        listeSorties.add(new Sortie("Parc aquatique H2O " + "avec ma tante, ma cousine, ma mère, mon frère et ma soeur", "12 Février " + "de 14h à 17h30", 2));
    }*/

    public static SortieDAO getInstance() { // fonction pour initialiser une instance ActiviteDAO et ainsi preparer la liste
        if (null == instance) {
            instance = new SortieDAO();
        }

        return instance;
    }

    /*public List<Sortie> listerSorties(){
        return listeSorties;
    }*/

    public List<Sortie> listerSorties() {
        String LISTER_SORTIE = "SELECT * FROM sortie";
        Cursor curseur = baseDeDonnees.getReadableDatabase().rawQuery(LISTER_SORTIE, null);
        this.listeSorties.clear();
        Sortie sortie;

        int indexId = curseur.getColumnIndex("id");
        int indexActivite = curseur.getColumnIndex("activite");
        int indexDate = curseur.getColumnIndex("date");

        for (curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            int id = curseur.getInt(indexId);
            String activite = curseur.getString(indexActivite);
            String date = curseur.getString(indexDate);
            sortie = new Sortie(activite, date, id);
            this.listeSorties.add(sortie);
        }

        return listeSorties;
    }

    /*
    public void ajouterSortie(HashMap<String, String> activite){
        //listeActivites.add(activite);
    }*/

    public void ajouterSortie(Sortie sortie){

        SQLiteDatabase baseDeDonneesEcriture = baseDeDonnees.getWritableDatabase();

        baseDeDonneesEcriture.beginTransaction();
        try {

            ContentValues sortieEnCleValeur = new ContentValues();
            sortieEnCleValeur.put("activite", sortie.getActivite());
            sortieEnCleValeur.put("date", sortie.getDate());

            baseDeDonneesEcriture.insertOrThrow("sortie",null, sortieEnCleValeur);
            baseDeDonneesEcriture.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.d("SortieDAO","Erreur en tentant d'ajouter une sortie dans la base de données");
        }
        finally {
            baseDeDonneesEcriture.endTransaction();
        }
    }

    public Sortie chercherSortieParId(int id){
        listerSorties();
        for(Sortie sortieRecherche : this.listeSorties) //boucle pour chercher la sortie correspondant à l'ID
        {
            if(sortieRecherche.getId() == id) return sortieRecherche;
        }
        return null; //si on a rien trouvé, on retourne null
    }

}
