package br.com.guacom.hotelternarios.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.guacom.hotelternarios.dao.PacoteDAO;
import br.com.guacom.hotelternarios.model.Pacote;
import br.com.guacom.hotelternarios.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Pacotes de quartos";
    public static final String KEY = "pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITLE_APPBAR);
        configureList();
    }
    //CRTL + N = Procurar uma classe

    private void configureList() {
        ListView listaDePacotes = findViewById(R.id.activity_lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        //Tratando o click na lista
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                putObject(intent, pacotes.get(position));
                startActivity(intent);
                finish();
            }
        });
    }

    private void putObject(Intent intent, Pacote pacote) {
        intent.putExtra(ListaPacotesActivity.KEY, pacote);
    }
}
