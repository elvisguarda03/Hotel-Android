package br.com.guacom.hotelternarios.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.guacom.hotelternarios.model.Pacote;
import br.com.guacom.hotelternarios.util.MoedaUtil;
import br.com.guacom.hotelternarios.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        setTitle(R.string.txt_resume_compra);
        Intent intent = getIntent();

        if(intent.hasExtra(ListaPacotesActivity.KEY)) {
            Pacote pack = (Pacote) intent.getSerializableExtra(ListaPacotesActivity.KEY);
            showType(pack.getTipo());
            showImage(pack.getImagem());
            showValue(pack.getPreco());
        }
    }

    private void showType(String typ) {
        TextView type = findViewById(R.id.resumo_compra_type);
        type.setText(typ);
    }

    private void showImage(String imagem) {
        ImageView image = findViewById(R.id.resumo_compra_ft);
        Drawable drawableDoPacote = ResourceUtil.
                getDrawable(this, imagem);

        image.setImageDrawable(drawableDoPacote);
    }

    private void showValue(BigDecimal valor) {
        TextView preco = findViewById(R.id.resumo_compra_valor);
        String coinBr = MoedaUtil.formatBr(valor);
        preco.setText(coinBr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_resumo_compra, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_action_back:
                Intent intent = new Intent(this, ListaPacotesActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}