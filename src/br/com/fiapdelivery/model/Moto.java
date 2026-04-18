package br.com.fiapdelivery.model;

public class Moto extends Veiculo {
    private static final boolean BAU_PADRAO = false;
    private static final double CAPACIDADE_BASE_KG = 20.0;
    private static final double ACRESCIMO_BAU_KG = 10.0;

    private boolean hasBau;

    public Moto(String placa) {
        this(placa, BAU_PADRAO);
    }

    public Moto(String placa, boolean hasBau) {
        super(placa, CAPACIDADE_BASE_KG);
        setHasBau(hasBau);
        double capacidade = calcularCapacidade();
        setCapacidadeKg(capacidade);
    }

    public boolean hasBau() {
        return this.hasBau;
    }

    public void adicionarBau() {
        setHasBau(true);
        setCapacidadeKg(calcularCapacidade());
    }

    public void removerBau() {
        setHasBau(false);
        setCapacidadeKg(calcularCapacidade());
    }

    private void setHasBau(boolean hasBau) {
        this.hasBau = hasBau;
    }

    private double calcularCapacidade() {
        return hasBau() ? CAPACIDADE_BASE_KG + ACRESCIMO_BAU_KG : CAPACIDADE_BASE_KG;
    }
}
