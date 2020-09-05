package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sorties2020.R;

public class VueAjouterActivite extends AppCompatActivity {

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

                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Action Annuler",
                                Toast.LENGTH_SHORT);
                        message.show();

                    }
                }


        );

    }
}