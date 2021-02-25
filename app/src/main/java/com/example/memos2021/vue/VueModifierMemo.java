package com.example.memos2021.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.memos2021.R;
import com.example.memos2021.donnee.MemoDAO;
import com.example.memos2021.modele.Memo;

public class VueModifierMemo extends AppCompatActivity {

    protected EditText vueModifierMemoChampActivite;
    protected EditText vueModifierMemoChampDate;
    protected MemoDAO memoDAO;
    protected Memo memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_memo);

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
                        naviguerRetourMemos();
                    }
                }


        );

        Bundle parametres = this.getIntent().getExtras();
        String idParametre = (String) parametres.get("id");
        int id = Integer.parseInt(idParametre);
        memoDAO = MemoDAO.getInstance();
        memo = memoDAO.chercherMemoParId(id);

        vueModifierMemoChampActivite = (EditText)findViewById(R.id.vueModifierMemoChampActivite);
        vueModifierMemoChampDate = (EditText)findViewById(R.id.vueModifierMemoChampDate);


        vueModifierMemoChampActivite.setText(memo.getActivite());
        vueModifierMemoChampDate.setText(memo.getDate());

        Button vueModifierMemoActionModifier = (Button)findViewById(R.id.vueModifierMemoActionModifier);

        vueModifierMemoActionModifier.setOnClickListener(

                new View.OnClickListener()
                {
                    public void onClick(View arg0){
                        //TODO : coder !
                        enregistrerMemo();
                        naviguerRetourMemos();

                    }

                }
        );

    }

    private void enregistrerMemo() {

        memo.setActivite(vueModifierMemoChampActivite.getText().toString());
        memo.setDate(vueModifierMemoChampDate.getText().toString());

        memoDAO.modifierMemo(memo);

    }

    public void naviguerRetourMemos()
    {
        this.finish();
    }
}