package com.danielnatan.conversor.model;

public class Conversion {
    private final String origem;
    private final String destino;
    private final double valorOriginal;
    private final double valorConvertido;
    private final double taxa;
    private final String data;

    public Conversion(String origem, String destino, double valorOriginal, double valorConvertido, double taxa, String data) {
        this.origem = origem;
        this.destino = destino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxa = taxa;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s | Valor: %.2f | Convertido: %.2f | Taxa: %.4f | Data: %s",
                origem, destino, valorOriginal, valorConvertido, taxa, data);
    }
}