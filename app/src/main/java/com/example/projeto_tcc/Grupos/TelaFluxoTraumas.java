package com.example.projeto_tcc.Grupos;

import android.content.Context;
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

import com.example.projeto_tcc.R;

public class TelaFluxoTraumas extends AppCompatActivity {

    ListView listView;
    String mTitle[] =
            {"Trauma craneoencefálico",
                    "Trauma maior",
                    "Trauma toracoabdominal"};
    String mDescription[] =
            {"Sintomas do fluxograma 48: Trauma craneoencefálico",
                    "Sintomas do fluxograma 49: Trauma maior",
                    "Sintomas do fluxograma 50: Trauma toracoabdominal"};
    int images[] =
            {R.drawable.fluxo_48,
                    R.drawable.fluxo_49,
                    R.drawable.fluxo_50,
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_fluxo_traumas);

        setTitle("Grupo \"Traumas\"");

        listView = findViewById(R.id.listviewFluxoTraumas);

        final TelaFluxoTraumas.MyAdapter adapter = new TelaFluxoTraumas.MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {

                }
                if (position == 1) {

                }
                if (position == 2) {

                }

            }
        });
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
