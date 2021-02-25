package com.example.memos2021.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.memos2021.R;
import com.example.memos2021.donnee.MemoDAO;
import com.example.memos2021.modele.Memo;

public class VueAjouterMemo extends AppCompatActivity {

    protected EditText vueAjouterActiviteChampActivite;
    protected EditText vueAjouterActiviteChampDescription;
    protected EditText vueAjouterActiviteChampDate;
    protected EditText vueAjouterActiviteChampHeure;
    protected MemoDAO memoDAO;
    protected Intent intentionNaviguerAlarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_sortie);

        Button vueAjouterActiviteActionAnnuler= (Button)findViewById(R.id.vueAjouterActiviteActionAnnuler);
        vueAjouterActiviteActionAnnuler.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        // TODO : faire le code du bouton
                        /*
                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Action Annuler",
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        naviguerRetourSorties();
                    }
                }


        );

        vueAjouterActiviteChampActivite = (EditText)findViewById(R.id.vueAjouterActiviteChampActivite);
        vueAjouterActiviteChampDescription= (EditText)findViewById(R.id.vueAjouterActiviteChampDescription);
        vueAjouterActiviteChampDate = (EditText)findViewById(R.id.vueAjouterActiviteChampDate);
        vueAjouterActiviteChampHeure = (EditText)findViewById(R.id.vueAjouterActiviteChampHeure);


        Button vueAjouterActiviteActionAjouter= (Button)findViewById(R.id.vueAjouterActiviteActionAjouter);
        vueAjouterActiviteActionAjouter.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        /*Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Champ Titre :"+vueAjouterActiviteChampActivite.getText().toString(),
                                Toast.LENGTH_SHORT);
                        message.show(); */
                        enregistrerSortie();
                        naviguerRetourSorties();
                    }
                }


        );
        intentionNaviguerAlarme = new Intent(this, VueAjouterAlarme.class);
        Button vueAjouterActiviteActionAlarme= (Button)findViewById(R.id.vueAjouterActiviteActionAlarme);
        vueAjouterActiviteActionAlarme.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        /*Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Appui sur le bouton ajouter une alarme",
                                Toast.LENGTH_SHORT);
                        message.show();*/

                        startActivity(intentionNaviguerAlarme);
                    }
                }


        );




    }
    private void enregistrerSortie() {
        /*
        HashMap<String, String> memo;

        memo = new HashMap<String, String>();
        memo.put("activite", vueAjouterActiviteChampActivite.getText().toString() +" "+ vueAjouterActiviteChampDescription.getText().toString());
        memo.put("date", vueAjouterActiviteChampDate.getText().toString() +" "+ vueAjouterActiviteChampHeure.getText().toString());
        memoDAO = MemoDAO.getInstance();
        memoDAO.ajouterSortie(memo);*/

        Memo memo = new Memo(vueAjouterActiviteChampActivite.getText().toString() +" "+ vueAjouterActiviteChampDescription.getText().toString(),
                vueAjouterActiviteChampDate.getText().toString() +" "+ vueAjouterActiviteChampHeure.getText().toString(),0);
        memoDAO = MemoDAO.getInstance();

        memoDAO.ajouterMemo(memo);

    }

    public void naviguerRetourSorties()
    {
        this.finish();
    }
}