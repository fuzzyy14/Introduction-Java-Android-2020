package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sorties2020.R;
import com.example.sorties2020.donnee.ActiviteDAO;

import java.util.HashMap;

public class VueAjouterActivite extends AppCompatActivity {

    protected EditText vueAjouterActiviteChampActivite;
    protected EditText vueAjouterActiviteChampDescription;
    protected EditText vueAjouterActiviteChampDate;
    protected EditText vueAjouterActiviteChampHeure;
    protected ActiviteDAO activiteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_activite);

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
                        // TODO : faire le code du bouton
                        /*Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Champ Titre :"+vueAjouterActiviteChampActivite.getText().toString(),
                                Toast.LENGTH_SHORT);
                        message.show(); */
                        enregistrerActivite();
                        naviguerRetourSorties();
                    }
                }


        );



    }
    private void enregistrerActivite() {

        HashMap<String, String> activite;

        activite = new HashMap<String, String>();
        activite.put("activite", vueAjouterActiviteChampActivite.getText().toString() +" "+ vueAjouterActiviteChampDescription.getText().toString());
        activite.put("date", vueAjouterActiviteChampDate.getText().toString() +" "+ vueAjouterActiviteChampHeure.getText().toString());
        activiteDAO = ActiviteDAO.getInstance();
        activiteDAO.ajouterActivite(activite);

    }

    public void naviguerRetourSorties()
    {
        this.finish();
    }
}