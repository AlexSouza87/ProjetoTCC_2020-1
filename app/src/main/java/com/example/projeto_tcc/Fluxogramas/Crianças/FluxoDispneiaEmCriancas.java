package com.example.projeto_tcc.Fluxogramas.Crianças;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projeto_tcc.R;

import java.util.ArrayList;
import java.util.HashMap;

public class FluxoDispneiaEmCriancas extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<String>();
    int maiorPrioridade = 10;
    String sintomaMaisGrave;
    final HashMap<String, Integer> sintomas_e_prioridades = new HashMap<>();
    ArrayList<Integer> prioridades = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluxo_dispneia_em_criancas);

        ListView choi = (ListView) findViewById(R.id.listViewFluxo16);
        choi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        setTitle("Dispnéia em crianças");

        //Vermelha
        sintomas_e_prioridades.put("Obstrução das vias aéreas", 1);
        sintomas_e_prioridades.put("Respiração Inadequada", 1);
        sintomas_e_prioridades.put("Estridor", 1);
        sintomas_e_prioridades.put("Baba-se", 1);
        sintomas_e_prioridades.put("Choque", 1);
        sintomas_e_prioridades.put("Criança não reativa", 1);
        //Laranja
        sintomas_e_prioridades.put("Sat O2 muito baixa", 2);
        sintomas_e_prioridades.put("Esforço respiratório aumentado", 2);
        sintomas_e_prioridades.put("Frases entrecortadas", 2);
        sintomas_e_prioridades.put("Hemoptise", 2);
        sintomas_e_prioridades.put("Historia respiratória significativa", 2);
        sintomas_e_prioridades.put("Inicio agudo após trauma", 2);
        sintomas_e_prioridades.put("Resposta à voz ou a dor apenas", 2);
        sintomas_e_prioridades.put("Exaustão", 2);
        sintomas_e_prioridades.put("PFE muito baixo", 2);
        //Amarelo
        sintomas_e_prioridades.put("Sat O2 baixa", 3);
        sintomas_e_prioridades.put("História de hemoptise", 3);
        sintomas_e_prioridades.put("História discordante", 3);
        sintomas_e_prioridades.put("Dor pleurítica", 3);
        sintomas_e_prioridades.put("PFE baixo", 3);
        //Verde
        sintomas_e_prioridades.put("Chieira", 4);
        sintomas_e_prioridades.put("Tosse produtiva", 4);
        sintomas_e_prioridades.put("Trauma toráxico", 4);
        sintomas_e_prioridades.put("Inchaço", 4);
        sintomas_e_prioridades.put("Evento recente", 4);


        final String[] sintomasDispneiaEmCriancas = {"Obstrução das vias aéreas",
                "Respiração Inadequada",
                "Estridor",
                "Baba-se",
                "Choque",
                "Criança não reativa",
                "Sat O2 muito baixa",
                "Esforço respiratório aumentado",
                "Frases entrecortadas",
                "Hemoptise",
                "Historia respiratória significativa",
                "Inicio agudo após trauma",
                "Resposta à voz ou a dor apenas",
                "Exaustão",
                "PFE muito baixo",
                "Sat O2 baixa",
                "História de hemoptise",
                "História discordante",
                "Dor pleurítica",
                "PFE baixo",
                "Chieira",
                "Tosse produtiva",
                "Trauma toráxico",
                "Inchaço",
                "Evento recente"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.specific_row, R.id.checkBox2, sintomasDispneiaEmCriancas);
        choi.setAdapter(adapter);
        choi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();

                if (selectedItems.contains(selectedItem)) {
                    selectedItems.remove(selectedItem);
                    finish();
                } else {
                    selectedItems.add(selectedItem);
                    //Ir na base e retornar com o sintoma e a prioridade
                    if (sintomas_e_prioridades.get(selectedItem).intValue() < maiorPrioridade) {
                        maiorPrioridade = sintomas_e_prioridades.get(selectedItem).intValue();
                        sintomaMaisGrave = selectedItem;//Essa variável tem que ir para a base de conhecimento
                    }
                }
            }
        });
    }

    public void mostrarItensFluxo16(View view) {
        String items = "";
        for (String item : selectedItems) {
            items += "-" + item + "\n";
        }
        Toast.makeText(this, "Você selecionou os seguintes itens\n" + items + "sua prioridade é " + maiorPrioridade + "\nSintoma mais grave: " + sintomaMaisGrave, Toast.LENGTH_SHORT).show();
    }
}
