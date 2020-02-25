package com.example.projeto_tcc;

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
import android.widget.Toast;

import com.example.projeto_tcc.Grupos.TelaFluxoCriancas;
import com.example.projeto_tcc.Grupos.TelaFluxoTraumas;

public class TelaGruposFluxogramas extends AppCompatActivity {

    ListView listView;
    String mTitle[] =
            {"Crianças",
                    "Traumas",
                    "Partes do Corpo",
                    "Dores",
                    "Sintomas Mais Comuns",
                    "Sintomas Diversos"};
    String mDescription[] =
            {"Este grupo  mostra os fluxogramas relacionados a crianças.",
                    "Este grupo  mostra os fluxogramas relacionados a traumas",
                    "Descrição partes do Corpo",
                    "Descrição Dores",
                    "Descrição Sintomas Mais Comuns"
                    , "Descrição Sintomas Diversos"};
    int images[] =
            {R.drawable.criancas,
                    R.drawable.traumas,
                    R.drawable.partesdocorpo,
                    R.drawable.dor,
                    R.drawable.sintomascomuns,
                    R.drawable.variados};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_grupos_fluxogramas);

        listView = findViewById(R.id.novoId);

        setTitle("Grupos de Fluxogramas");

        final MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    String grupo = "criancas";//Essa variável tem que ir para a base de conhecimento
                    Toast.makeText(TelaGruposFluxogramas.this, "Grupo Selecionado\n" + grupo.toUpperCase(), Toast.LENGTH_SHORT).show();
                    irParaOutraTela();
                }
                if (position == 1) {
                    String grupo = "traumas";//Essa variável tem que ir para a base de conhecimento
                    Toast.makeText(TelaGruposFluxogramas.this, "Grupo Selecionado\n" + grupo.toUpperCase(), Toast.LENGTH_SHORT).show();
                    irParaTelaDeTraumas();
                }
            }
        });
    }

    public void irParaOutraTela() {//Se der pau colocar o parametro View view
        Intent intent = new Intent(getApplicationContext(), TelaFluxoCriancas.class);
        startActivity(intent);
    }
    public void irParaTelaDeTraumas() {//Se der pau colocar o parametro View view
        Intent intent = new Intent(getApplicationContext(), TelaFluxoTraumas.class);
        startActivity(intent);
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
