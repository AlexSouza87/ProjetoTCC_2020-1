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

public class FluxoMalEstarEmCrianca extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<String>();
    int maiorPrioridade = 10;
    String sintomaMaisGrave;
    final HashMap<String, Integer> sintomas_e_prioridades = new HashMap<>();
    ArrayList<Integer> prioridades = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fluxo_mal_estar_em_crianca);

        ListView choi = (ListView) findViewById(R.id.listViewFluxo34);
        choi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        setTitle("Mal estar em crianças");

        //Vermelha
        sintomas_e_prioridades.put("Obstrução das vias aéreas", 1);
        sintomas_e_prioridades.put("Respiração Inadequada", 1);
        sintomas_e_prioridades.put("Choque", 1);
        sintomas_e_prioridades.put("Hipoglicemia", 1);
        sintomas_e_prioridades.put("Convulsionando", 1);
        sintomas_e_prioridades.put("Não Reativa", 1);
        //Laranja
        sintomas_e_prioridades.put("Sinais de dor intensa", 2);
        sintomas_e_prioridades.put("Resposta à voz ou a dor apenas", 2);
        sintomas_e_prioridades.put("Não reage aos pais", 2);
        sintomas_e_prioridades.put("Sinais de meningismo", 2);
        sintomas_e_prioridades.put("Erupção cultânea fixa", 2);
        sintomas_e_prioridades.put("Púrpura", 2);
        sintomas_e_prioridades.put("Criança quente", 2);
        sintomas_e_prioridades.put("Hipotermia", 2);
        //Amarelo
        sintomas_e_prioridades.put("Sinais de dor moderada", 3);
        sintomas_e_prioridades.put("História discordante", 3);
        sintomas_e_prioridades.put("Sinais de desidratação", 3);
        sintomas_e_prioridades.put("Sem urinar", 3);
        sintomas_e_prioridades.put("Não se alimenta", 3);
        //Verde
        sintomas_e_prioridades.put("Sinais de dor leve recente", 4);
        sintomas_e_prioridades.put("Febril", 4);
        sintomas_e_prioridades.put("Comportamento atípico", 4);
        sintomas_e_prioridades.put("Evento recente", 4);

        final String[] sintomasMalEstarEmCriancas = {"Obstrução das vias aéreas",
                "Respiração Inadequada",
                "Choque",
                "Hipoglicemia",
                "Convulsionando",
                "Não Reativa",
                "Sinais de dor intensa",
                "Resposta à voz ou a dor apenas",
                "Não reage aos pais",
                "Sinais de meningismo",
                "Erupção cultânea fixa",
                "Púrpura",
                "Criança quente",
                "Hipotermia",
                "Sinais de dor moderada",
                "História discordante",
                "Sinais de desidratação",
                "Sem urinar",
                "Não se alimenta",
                "Sinais de dor leve recente",
                "Febril",
                "Comportamento atípico",
                "Evento recente"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.specific_row, R.id.checkBox2, sintomasMalEstarEmCriancas);
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

    public void mostrarItensFluxo34(View view) {
        String items = "";
        for (String item : selectedItems) {
            items += "-" + item + "\n";
        }
        Toast.makeText(this, "Você selecionou os seguintes itens\n" + items + "sua prioridade é " + maiorPrioridade + "\nSintoma mais grave: " + sintomaMaisGrave, Toast.LENGTH_SHORT).show();
    }
}
