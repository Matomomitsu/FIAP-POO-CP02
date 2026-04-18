package br.com.fiapdelivery.model;

public class Pedido {
    private static final double PESO_PADRAO_KG = 1.0;
    private static final String STATUS_PADRAO = "Pendente";
    private static final String CODIGO_PADRAO = "AAA-0000";

    private String codigo = CODIGO_PADRAO;
    private double pesoKg = PESO_PADRAO_KG;
    private String status = STATUS_PADRAO;

    public Pedido(String codigo) {
        this(codigo, PESO_PADRAO_KG, STATUS_PADRAO);
    }

    public Pedido(String codigo, double pesoKg, String status) {
        setCodigo(codigo);
        setPesoKg(pesoKg);
        setStatus(status);
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            System.out.println("Erro: codigo deve ser preenchido.");
            return;
        }

        String codigoNormalizado = codigo.trim().toUpperCase();
        if (!validarCodigo(codigoNormalizado)) {
            System.out.println("Erro: codigo invalido. Use o formato AAA-1234.");
            return;
        }

        this.codigo = codigoNormalizado;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    private void setPesoKg(double pesoKg) {
        if (pesoKg <= 0) {
            System.out.println("Erro: peso deve ser maior que zero.");
            return;
        }
        this.pesoKg = pesoKg;
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            System.out.println("Erro: status deve ser preenchido.");
            return;
        }
        this.status = status.trim();
    }

    public void alterarStatus(String novoStatus) {
        setStatus(novoStatus);
    }

    private boolean validarCodigo(String codigo) {
        if (codigo == null) {
            return false;
        }

        String codigoLimpo = codigo.trim().toUpperCase();
        if (codigoLimpo.length() != 8) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(codigoLimpo.charAt(i))) {
                return false;
            }
        }

        if (codigoLimpo.charAt(3) != '-') {
            return false;
        }

        for (int i = 4; i < 8; i++) {
            if (!Character.isDigit(codigoLimpo.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
