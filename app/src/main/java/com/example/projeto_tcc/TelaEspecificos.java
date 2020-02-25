package com.example.projeto_tcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TelaEspecificos extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_especificos);
        ListView choi = (ListView) findViewById(R.id.listViewEspecificosID);
        choi.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        final String[] sintomas = {"Apresentação de Partes Fetais",
                "Baba-se",
                "Choque",
                "Convulsionando",
                "Criança não reativa",
                "Estridor",
                "Hemorragia Enxaguitante",
                "Hiperglicemia",
                "Hipoglicemia",
                "Lesão Ocular química aguda",
                "Não reativa",
                "Obstrução das vias aéreas",
                "Prolapso de cordão umbilical",
                "Respiração Inadequada"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.specific_row,R.id.checkBox2,sintomas);
        choi.setAdapter(adapter);
        choi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                if (selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }else{
                    selectedItems.add(selectedItem);
                }
            }
        });
    }
    public void showSelectedItems(View view){
        String items ="";
        for (String item:selectedItems){
    items+="-"+item+"\n";
    }
        Toast.makeText(this,"Você selecionou os seguintes itens\n"+items,Toast.LENGTH_LONG).show();
    }
}
