package com.example.sorties2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueSorties extends AppCompatActivity {

    protected ListView vueListeActivites;
    protected List<HashMap<String, String>> listeActivites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_sorties);
        vueListeActivites = (ListView)findViewById(R.id.vueListeActivites);

        listeActivites = preparerListeActivites();

        SimpleAdapter adapteur = new SimpleAdapter(
                this,
                listeActivites,
                android.R.layout.two_line_list_item,
                new String[]{"activite","date"},
                new int[]{android.R.id.text1, android.R.id.text2});

        vueListeActivites.setAdapter(adapteur);
    }

    public List<HashMap<String, String>> preparerListeActivites(){
        List<HashMap<String, String>> listeActivites = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> activite;

        activite = new HashMap<String, String>();
        activite.put("activite","Scéance de cinéma avec les amis");
        activite.put("date","12 Juillet");
        listeActivites.add(activite);

        activite = new HashMap<String, String>();
        activite.put("activite","Parc Festiland");
        activite.put("date","24 Mars");
        listeActivites.add(activite);

        activite = new HashMap<String, String>();
        activite.put("activite","Parc aquatique H2O");
        activite.put("date","12 Février");
        listeActivites.add(activite);

        return listeActivites;
    }
}