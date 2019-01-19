package br.com.guacom.hotelternarios.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.guacom.hotelternarios.model.Pacote;

public class PacoteDAO {

    public List<Pacote> lista() {
        List<Pacote> pacotes = new ArrayList<>(Arrays.asList(
                new Pacote("Basic", "sp_basic", 1, new BigDecimal(243.99)),
                new Pacote("Standard", "sp_standart", 1, new BigDecimal(754.50)),
                new Pacote("Ultimate", "sp_ultimate", 1, new BigDecimal(1500.99))));
        return pacotes;
    }

}