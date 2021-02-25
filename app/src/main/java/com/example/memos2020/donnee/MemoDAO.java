package com.example.memos2020.donnee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.memos2020.modele.Memo;

import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
    private static MemoDAO instance = null;
    //private  List<HashMap<String, String>> listeActivites;
    private List<Memo> listeMemos;

    private BaseDeDonnees baseDeDonnees;

    private MemoDAO() {
        this.baseDeDonnees = BaseDeDonnees.getInstance();

        //listeActivites = new ArrayList<HashMap<String, String>>();
        listeMemos = new ArrayList<Memo>();
        //preparerListeMemos();
    }

    /*private void preparerListeMemos() {
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

        listeMemos.add(new Memo("Scéance de cinéma avec les amis " + "film Là Haut", "12 Juillet " + "15h20", 0));
        listeMemos.add(new Memo("Parc Festiland " + "avec mes amis du lycée", "24 Mars " + "de 13h à 19h", 1));
        listeMemos.add(new Memo("Parc aquatique H2O " + "avec ma tante, ma cousine, ma mère, mon frère et ma soeur", "12 Février " + "de 14h à 17h30", 2));
    }*/

    public static MemoDAO getInstance() { // fonction pour initialiser une instance ActiviteDAO et ainsi preparer la liste
        if (null == instance) {
            instance = new MemoDAO();
        }

        return instance;
    }

    /*public List<Memo> listerMemos(){
        return listeMemos;
    }*/

    public List<Memo> listerMemos() {
        String LISTER_MEMO = "SELECT * FROM table_memo";
        Cursor curseur = baseDeDonnees.getReadableDatabase().rawQuery(LISTER_MEMO, null);
        this.listeMemos.clear();
        Memo memo;

        int indexId = curseur.getColumnIndex("id");
        int indexActivite = curseur.getColumnIndex("activite");
        int indexDate = curseur.getColumnIndex("date");

        for (curseur.moveToFirst(); !curseur.isAfterLast(); curseur.moveToNext()) {
            int id = curseur.getInt(indexId);
            String activite = curseur.getString(indexActivite);
            String date = curseur.getString(indexDate);
            memo = new Memo(activite, date, id);
            this.listeMemos.add(memo);
        }

        return listeMemos;
    }

    /*
    public void ajouterMemo(HashMap<String, String> activite){
        //listeMemos.add(activite);
    }*/

    public void ajouterMemo(Memo memo){

        SQLiteDatabase baseDeDonneesEcriture = baseDeDonnees.getWritableDatabase();

        baseDeDonneesEcriture.beginTransaction();
        try {

            ContentValues sortieEnCleValeur = new ContentValues();
            sortieEnCleValeur.put("activite", memo.getActivite());
            sortieEnCleValeur.put("date", memo.getDate());

            baseDeDonneesEcriture.insertOrThrow("table_memo",null, sortieEnCleValeur);
            baseDeDonneesEcriture.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.d("MemoDAO","Erreur en tentant d'ajouter un memo dans la base de données");
        }
        finally {
            baseDeDonneesEcriture.endTransaction();
        }
    }

    public Memo chercherMemoParId(int id){
        listerMemos();
        for(Memo memoRecherche : this.listeMemos) //boucle pour chercher le memo correspondant à l'ID
        {
            if(memoRecherche.getId() == id) return memoRecherche;
        }
        return null; //si on a rien trouvé, on retourne null
    }

    public void modifierMemo(Memo memo){
        //
        SQLiteDatabase baseDeDonneesEcriture = baseDeDonnees.getWritableDatabase();

        baseDeDonneesEcriture.beginTransaction();
        try {

            ContentValues memoEnCleValeur = new ContentValues();
            memoEnCleValeur.put("activite", memo.getActivite());
            memoEnCleValeur.put("date", memo.getDate());

            baseDeDonneesEcriture.update("table_memo",memoEnCleValeur,"id = "+ memo.getId(), null);
            baseDeDonneesEcriture.setTransactionSuccessful();
        }
        catch (Exception e) {
            Log.d("MemoDAO","Erreur en tentant de modifier une memo dans la base de données");
        }
        finally {
            baseDeDonneesEcriture.endTransaction();
        }

    }

}
