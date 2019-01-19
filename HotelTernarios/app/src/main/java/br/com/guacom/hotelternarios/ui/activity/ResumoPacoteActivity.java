package br.com.guacom.hotelternarios.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.guacom.hotelternarios.model.Pacote;
import br.com.guacom.hotelternarios.util.DataUtil;
import br.com.guacom.hotelternarios.util.MoedaUtil;
import br.com.guacom.hotelternarios.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {
    private Pacote pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        getPacote(getIntent());
        setTitle(R.string.txt_name_resumo_pacote);
    }

    private void showTravelDate(int dia) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        data.setText(DataUtil.dateFormat(dia));
    }

    @NonNull
    private void getPacote(Intent intent) {

        if(intent.hasExtra(ListaPacotesActivity.KEY)) {
            pack = (Pacote)intent.getSerializableExtra(ListaPacotesActivity.KEY);
            showType(pack.getTipo());
            showImage(pack.getImagem());
            showDay(pack.getDias());
            showValue(pack.getPreco());
            showTravelDate(pack.getDias());
            showPayment();
        }
    }

    private void showType(String typ) {
        TextView type = findViewById(R.id.resumo_pacote_type);
        type.setText(typ);
    }

    private void showImage(String imagem) {
        ImageView image = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil.
                getDrawable(this, imagem);

        image.setImageDrawable(drawableDoPacote);
    }

    private void showDay(int dias) {
        TextView dia = findViewById(R.id.resumo_pacote_dias);
        String day = ResourceUtil.getString(this, (dias > 1 ? "txt_dias" : "txt_dia"));
        dia.setText(dias + " " + day);
    }

    private void showValue(BigDecimal valor) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String coinBr = MoedaUtil.formatBr(valor);
        preco.setText(coinBr);
    }

    private void showPayment() {
        Button btnPay = findViewById(R.id.resumo_pacote_botao_realiza_pag);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                putObject(intent, pack);
                startActivity(intent);
                finish();
            }
        });
    }

    private void putObject(Intent intent, Pacote pacote) {
        intent.putExtra(ListaPacotesActivity.KEY, pacote);
    }
}