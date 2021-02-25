package com.example.sorties2020.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sorties2020.R;
import com.example.sorties2020.donnee.MemoDAO;
import com.example.sorties2020.modele.Memo;

public class VueModifierSortie extends AppCompatActivity {

    protected EditText vueModifierSortieChampActivite;
    protected EditText vueModifierSortieChampDate;
    protected MemoDAO memoDAO;
    protected Memo memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_sortie);

        Button vueModifierActiviteActionAnnuler= (Button)findViewById(R.id.vueModifierActiviteActionAnnuler);
        vueModifierActiviteActionAnnuler.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0) {
                        //
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
        memoDAO = MemoDAO.getInstance();
        memo = memoDAO.chercherMemoParId(id);

        vueModifierSortieChampActivite = (EditText)findViewById(R.id.vueModifierSortieChampActivite);
        vueModifierSortieChampDate = (EditText)findViewById(R.id.vueModifierSortieChampDate);


        vueModifierSortieChampActivite.setText(memo.getActivite());
        vueModifierSortieChampDate.setText(memo.getDate());

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

        memo.setActivite(vueModifierSortieChampActivite.getText().toString());
        memo.setDate(vueModifierSortieChampDate.getText().toString());

        memoDAO.modifierMemo(memo);

    }

    public void naviguerRetourSorties()
    {
        this.finish();
    }
}