package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sorties2020.R;

public class VueAjouterAlarme extends AppCompatActivity {

    protected EditText vueAjouterAlarmeChampTemps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vue_ajouter_alarme);
        Button vueAjouterAlarmeActionAnnuler= (Button)findViewById(R.id.vueAjouterAlarmeActionAnnuler);
        vueAjouterAlarmeActionAnnuler.setOnClickListener(

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
                        naviguerRetour();
                    }
                }


        );

        vueAjouterAlarmeChampTemps = (EditText)findViewById(R.id.vueAjouterAlarmeTemps);
        Button vueAjouterAlarmeActionAjouter= (Button)findViewById(R.id.vueAjouterAlarmeActionAjouter);
        vueAjouterAlarmeActionAjouter.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {

                        enregistrerAlarme();
                        naviguerRetour();
                    }
                }


        );
    }
    public void naviguerRetour()
    {
        this.finish();
    }

    private void enregistrerAlarme(){


                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Ajout d'une alarme",
                                Toast.LENGTH_SHORT);
                        message.show();


    }
}

