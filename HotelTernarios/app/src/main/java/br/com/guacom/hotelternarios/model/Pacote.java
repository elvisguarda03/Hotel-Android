package br.com.guacom.hotelternarios.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pacote implements Serializable {

    private final String tipo;
    private final String imagem;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String tipo, String imagem, int dias, BigDecimal preco) {
        this.tipo = tipo;
        this.imagem = imagem;
        this.dias = dias;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImagem() {
        return imagem;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}