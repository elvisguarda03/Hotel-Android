package br.com.guacom.hotelternarios.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {


    public static final String DIA_E_MES = "dd/MM";

    public static String dateFormat(int dias) {
        //Pegando a data atual
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);//Acrescentando os dias requeridos na data atual que foi atribuida

        SimpleDateFormat formatBr = new SimpleDateFormat(DIA_E_MES);//Criando um objeto para formatar a data no padrão dia/mes

        String dataFormatadaIda = formatBr.format(dataIda.getTime());
        String dataFormatadaVolta = formatBr.format(dataVolta.getTime());

        return dataFormatadaIda + " - "
                + dataFormatadaVolta + " de "
                + dataVolta.get(Calendar.YEAR);
    }
}
