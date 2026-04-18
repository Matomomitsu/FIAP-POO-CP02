package br.com.fiapdelivery.model;

public class Veiculo {
    private String placa;
    private double capacidadeKg;

    public Veiculo(String placa, double capacidadeKg) {
        setPlaca(placa);
        setCapacidadeKg(capacidadeKg);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (!validarPlaca(placa)) {
            System.out.println("Erro: placa invalida. Use formato antigo (AAA1234) ou Mercosul (AAA1A23).");
            return;
        }
        this.placa = placa.replace("-", "").trim().toUpperCase();
    }

    public double getCapacidadeKg() {
        return capacidadeKg;
    }

    protected void setCapacidadeKg(double capacidadeKg) {
        if (capacidadeKg <= 0) {
            System.out.println("Erro: capacidade deve ser maior que zero.");
            return;
        }
        this.capacidadeKg = capacidadeKg;
    }

    private boolean validarPlaca(String placa) {
        if (placa == null) {
            return false;
        }

        String placaLimpa = placa.replace("-", "").trim().toUpperCase();
        if (placaLimpa.length() != 7) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(placaLimpa.charAt(i))) {
                return false;
            }
        }

        if (!Character.isDigit(placaLimpa.charAt(3))) {
            return false;
        }

        if (!Character.isLetterOrDigit(placaLimpa.charAt(4))) {
            return false;
        }

        if (!Character.isDigit(placaLimpa.charAt(5))) {
            return false;
        }

        return Character.isDigit(placaLimpa.charAt(6));
    }
}
