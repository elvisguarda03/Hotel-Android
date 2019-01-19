package br.com.guacom.hotelternarios.util;

import android.support.annotation.NonNull;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.guacom.hotelternarios.model.Pacote;

public class MoedaUtil {


    public static final String IDIOM = "pt";
    public static final String COUNTRY = "br";
    public static final String COIN = "R$";
    public static final String COIN_WITH_SPACE = "R$ ";

    @NonNull
    public static String formatBr(BigDecimal precoDoPacote) {
        NumberFormat formatBr = DecimalFormat.getCurrencyInstance(
                new Locale(IDIOM, COUNTRY));
        return formatBr.format(precoDoPacote)
                .replace(COIN, COIN_WITH_SPACE);
    }
}
