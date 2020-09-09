package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sorties2020.R;
import com.example.sorties2020.donnee.SortieDAO;
import com.example.sorties2020.modele.Sortie;

public class VueModifierSortie extends AppCompatActivity {

    protected EditText vueModifierSortieChampActivite;
    protected EditText vueModifierSortieChampDate;
    protected SortieDAO sortieDAO;
    protected Sortie sortie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_sortie);

        Button vueModifierActiviteActionAnnuler= (Button)findViewById(R.id.vueModifierActiviteActionAnnuler);
        vueModifierActiviteActionAnnuler.setOnClickListener(

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

        Bundle parametres = this.getIntent().getExtras();
        String idParametre = (String) parametres.get("id");
        int id = Integer.parseInt(idParametre);
        sortieDAO = SortieDAO.getInstance();
        sortie = sortieDAO.chercherSortieParId(id);

        vueModifierSortieChampActivite = (EditText)findViewById(R.id.vueModifierSortieChampActivite);
        vueModifierSortieChampDate = (EditText)findViewById(R.id.vueModifierSortieChampDate);


        vueModifierSortieChampActivite.setText(sortie.getActivite());
        vueModifierSortieChampDate.setText(sortie.getDate());

        Button vueModifierSortieActionModifier = (Button)findViewById(R.id.vueModifierSortieActionModifier);

        vueModifierSortieActionModifier.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0){
                        //TODO : coder !
                        enregistrerSortie();
                        naviguerRetourSorties();

                    }

                }
        );

    }

    private void enregistrerSortie() {

        sortie.setActivite(vueModifierSortieChampActivite.getText().toString());
        sortie.setDate(vueModifierSortieChampDate.getText().toString());

        sortieDAO.modifierSortie(sortie);

    }

    public void naviguerRetourSorties()
    {
        this.finish();
    }
}