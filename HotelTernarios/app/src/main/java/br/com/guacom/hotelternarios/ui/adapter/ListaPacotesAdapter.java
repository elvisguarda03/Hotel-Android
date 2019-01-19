package br.com.guacom.hotelternarios.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.guacom.hotelternarios.util.MoedaUtil;
import br.com.guacom.hotelternarios.util.ResourceUtil;
import br.com.guacom.hotelternarios.model.Pacote;
import br.com.guacom.hotelternarios.ui.activity.R;

public class ListaPacotesAdapter extends BaseAdapter {
    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    //Alt + enter = Implementar todos os métodos
    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pacotes.indexOf(pacotes.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Alt + Shift + f12 = Aumenta a tela
        //Inflando o layout
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);//O layout será criado depois, pois essa responsabilidade é do adapter

        Pacote pacote = pacotes.get(position);

        showType(viewCriada, pacote);
        showImage(viewCriada, pacote);
        showDay(viewCriada, pacote);
        showValue(viewCriada, pacote);

        return viewCriada;
    }

    private void showValue(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formatBr(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void showDay(View viewCriada, Pacote pacote) {
        TextView dia = viewCriada.findViewById(R.id.item_pacote_dias);
        String day = ResourceUtil.getString(context, (pacote.getDias() > 1 ? "txt_dias" : "txt_dia"));
        dia.setText(pacote.getDias() + " "+ day);
    }

    private void showImage(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        //Pegando os recursos
        Drawable drawableImagemPacote = ResourceUtil.getDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void showType(View viewCriada, Pacote pacote) {
        TextView tipo = viewCriada.findViewById(R.id.item_pacote_tipo);
        tipo.setText(pacote.getTipo());
    }
}
