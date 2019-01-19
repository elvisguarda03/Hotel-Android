package br.com.guacom.hotelternarios.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.guacom.hotelternarios.model.Pacote;
import br.com.guacom.hotelternarios.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {
    private Button btnMakePayment;
    private Pacote pack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(R.string.txt_title_APPBAR_pagamento);
        startComponent();

        Intent intent = getIntent();
        if(intent.hasExtra(ListaPacotesActivity.KEY)) {
            pack = (Pacote) intent.getSerializableExtra(ListaPacotesActivity.KEY);

            showValue(pack.getPreco());
            makePayment();
        }
    }

    private void showValue(BigDecimal valor) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        int dias = pack.getDias();
        double value = 0;

        int i = 0;
        while(i < dias) {
            value += valor.doubleValue();
            valor = BigDecimal.valueOf(value);
            i++;
        }
        String coinBr = MoedaUtil.formatBr(valor);
        preco.setText(coinBr);
    }

    private void startComponent() {
        btnMakePayment = findViewById(R.id.pagamento_btn_finaliza_compra);
    }

    private void makePayment() {
        btnMakePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                intent.putExtra(ListaPacotesActivity.KEY, pack);
                startActivity(intent);
                finish();
            }
        });
    }
}
