package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.sorties2020.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueSorties extends AppCompatActivity {

    protected ListView vueSorties2020ListeActivites;
    protected List<HashMap<String, String>> listeActivites;
    protected Intent intentionNaviguerAjouterActivite;
    protected Intent intentionNaviguerModifierActivite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_sorties);
        vueSorties2020ListeActivites = (ListView)findViewById(R.id.vueSorties2020ListeActivites);

        listeActivites = preparerListeActivites();

        SimpleAdapter adapteur = new SimpleAdapter(
                this,
                listeActivites,
                android.R.layout.two_line_list_item,
                new String[]{"activite","date"},
                new int[]{android.R.id.text1, android.R.id.text2});

        vueSorties2020ListeActivites.setAdapter(adapteur);

        Button vueSorties2020AjouterActivite = (Button)findViewById(R.id.vueSorties2020AjouterActivite);

        intentionNaviguerAjouterActivite = new Intent(this, VueAjouterActivite.class);

        vueSorties2020AjouterActivite.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        // TODO : faire le code du bouton
                        /*
                        Toast message = Toast.makeText(
                                getApplicationContext(),
                                "Action ajouter activité",
                                Toast.LENGTH_SHORT);
                        message.show();
                        */
                        startActivity(intentionNaviguerAjouterActivite);
                    }
                }


        );

        intentionNaviguerModifierActivite = new Intent(this, VueModifierActivite.class);

        vueSorties2020ListeActivites.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View vue, int positionDansAdapteur, long positionItem) {
                        ListView vueListeActivites = (ListView)vue.getParent();

                        @SuppressWarnings("unchecked")
                        HashMap<String,String> activite =
                                (HashMap<String,String>)
                                        vueListeActivites.getItemAtPosition((int)positionItem);
                        /*Toast message = Toast.makeText(getApplicationContext(),
                                "Position "+positionItem + " activite " + activite.get("activite"),
                                Toast.LENGTH_SHORT);
                        message.show(); */
                        startActivity(intentionNaviguerModifierActivite);
                    }
                }

        );

    }

    public List<HashMap<String, String>> preparerListeActivites(){
        List<HashMap<String, String>> listeActivites = new ArrayList<HashMap<String, String>>();

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

        return listeActivites;
    }
}