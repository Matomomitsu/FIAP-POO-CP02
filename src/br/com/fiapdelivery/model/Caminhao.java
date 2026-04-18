package br.com.fiapdelivery.model;

public class Caminhao extends Veiculo {
    private static final int EIXOS_MINIMOS = 2;
    private static final int EIXOS_MAXIMOS = 6;
    private static final int EIXOS_PADRAO = 2;
    private static final double CAPACIDADE_BASE_KG = 3000.0;
    private static final double ACRESCIMO_POR_EIXO_KG = 750.0;

    private int eixos;

    public Caminhao(String placa) {
        this(placa, EIXOS_PADRAO);
    }

    public Caminhao(String placa, int eixos) {
        super(placa, CAPACIDADE_BASE_KG);
        setEixos(eixos);
    }

    public int getEixos() {
        return eixos;
    }

    private void setEixos(int eixos) {
        if (eixos < EIXOS_MINIMOS) {
            System.out.println("Erro: caminhao deve ter no minimo 2 eixos. Ajustado para 2.");
            this.eixos = EIXOS_PADRAO;
            setCapacidadeKg(calcularCapacidadePadrao(this.eixos));
            return;
        }
        if (eixos > EIXOS_MAXIMOS) {
            System.out.println("Erro: caminhao deve ter no maximo 6 eixos. Ajustado para 6.");
            this.eixos = EIXOS_MAXIMOS;
            setCapacidadeKg(calcularCapacidadePadrao(this.eixos));
            return;
        }
        this.eixos = eixos;
        setCapacidadeKg(calcularCapacidadePadrao(eixos));
    }

    private double calcularCapacidadePadrao(int eixos) {
        return CAPACIDADE_BASE_KG + (eixos - EIXOS_MINIMOS) * ACRESCIMO_POR_EIXO_KG;
    }
}
