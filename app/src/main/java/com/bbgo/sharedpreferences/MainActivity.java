package com.bbgo.sharedpreferences;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * SHARED PREFERENCES
 * A classe android.content.SharedPreferences salva automaticamente os dados em um
 * banco de dados interno da aplicação.
 * Deve ser usada para salvar valores pequenos, como tipos primitivos e pequenas strings.
 *
 * Os valores ficam salvos em: /data/data/NOME_PACOTE/shared_prefs/
 */
public class MainActivity extends AppCompatActivity {
    public Button buttonSalvar;
    public Button buttonRemover;
    public TextView savedValue;
    public EditText text;
    public final String chave = "salvo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Botão de buttonSalvar
        buttonSalvar = (Button) findViewById(R.id.buttonSave);
        //Texto salvo
        savedValue = (TextView) findViewById(R.id.textViewSaved);
        //Resgata o valor associado a chave (se houver)
        savedValue.setText(Prefs.getString(this, chave));
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (EditText) findViewById(R.id.editText);
                //Após o click, associa o valor digitado a chave
                Prefs.setString(getBaseContext(), chave, text.getText().toString());
                //Escreve o valor digitado na tela
                savedValue.setText(Prefs.getString(getBaseContext(), chave));
            }
        });

        //Botão para remover o valor associado a chave
        buttonRemover = (Button) findViewById(R.id.buttonRemover);
        buttonRemover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs.remove(getBaseContext(), chave);
                //Tenta resgatar o valor associado a chave após a exclusão
                savedValue.setText(Prefs.getString(getBaseContext(), chave));
            }
        });

    }
}
