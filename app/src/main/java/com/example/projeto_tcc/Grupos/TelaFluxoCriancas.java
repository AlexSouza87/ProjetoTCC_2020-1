package com.example.projeto_tcc.Grupos;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoDorAbominalEmCriancas;
import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoDispneiaEmCriancas;
import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoCriancaIrritadica;
import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoBebeChorando;
import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoCriancaMancando;
import com.example.projeto_tcc.Fluxogramas.Crianças.FluxoMalEstarEmCrianca;
import com.example.projeto_tcc.R;

public class TelaFluxoCriancas extends AppCompatActivity {
    ListView listView;
    String mTitle[] =
            {"Bebê chorando",
                    "Criança Irritadiça",
                    "Criança Mancando",
                    "Dispnéia em crianças",
                    "Mal estar em crianças",
                    "Dor abdominal em crianças"};
    String mDescription[] =
            {"Sintomas do fluxograma 06: Bebê chorando",
                    "Sintomas do fluxograma 10: Criança Irritadiça",
                    "Sintomas do fluxograma 11:  Criança Mancando",
                    "Sintomas do fluxograma 16:  Dispnéia em crianças",
                    "Sintomas do fluxograma 34:  Mal estar em crianças",
                    "Sintomas do fluxograma 20:  Dor abdominal em crianças"};
    int images[] =
            {R.drawable.fluxo_06,
                    R.drawable.fluxo_10,
                    R.drawable.fluxo_11,
                    R.drawable.fluxo_16,
                    R.drawable.fluxo_34,
                    R.drawable.fluxo_20
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fluxo_criancas);

        setTitle("Grupo \"Crianças\"");

        listView = findViewById(R.id.listviewFluxoCriancas);

        final MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    irParaOutraTela();
                }
                if (position == 1) {
                    irParaFluxoCriancaIrritadica();
                }
                if (position == 2) {
                    irParaFluxoCriancaMancando();
                }
                if (position == 3) {
                    irParaFluxoDispneiaEmCriancas();
                }
                if (position == 4) {
                    irParaFluxoMalEstarEmCriancas();
                }
                if (position == 5) {
                    irParaFluxoDorAbdominalEmCriancas();
                }

            }
        });
    }

    public void irParaOutraTela() {//Se der pau colocar o parametro View view
        Intent intent1 = new Intent(getApplicationContext(), FluxoBebeChorando.class);
        startActivity(intent1);
    }

    public void irParaFluxoCriancaIrritadica() {
        Intent intent2 = new Intent(getApplicationContext(), FluxoCriancaIrritadica.class);
        startActivity(intent2);
    }

    public void irParaFluxoCriancaMancando() {
        Intent intent3 = new Intent(getApplicationContext(), FluxoCriancaMancando.class);
        startActivity(intent3);
    }

    public void irParaFluxoDispneiaEmCriancas() {
        Intent intent4 = new Intent(getApplicationContext(), FluxoDispneiaEmCriancas.class);
        startActivity(intent4);
    }

    public void irParaFluxoMalEstarEmCriancas() {
        Intent intent5 = new Intent(getApplicationContext(), FluxoMalEstarEmCrianca.class);
        startActivity(intent5);
    }

    public void irParaFluxoDorAbdominalEmCriancas() {
        Intent intent6 = new Intent(getApplicationContext(), FluxoDorAbominalEmCriancas.class);
        startActivity(intent6);
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImage[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImage = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image_id);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImage[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }
    }

}
