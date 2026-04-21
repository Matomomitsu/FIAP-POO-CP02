package br.com.fiapdelivery.model;

public class Pedido {
    private String codigo;
    private double pesoKg;
    private String status;

    public Pedido(String codigo, double pesoKg, String status) {
        setCodigo(codigo);
        setPesoKg(pesoKg);
        alterarStatus(status);
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
        if (novoStatus == null || novoStatus.trim().isEmpty()) {
            System.out.println("Erro: status deve ser preenchido.");
            return;
        }

        if (status != null && status.equalsIgnoreCase("Entregue")) {
            System.out.println("Erro: pedido ja esta entregue, status nao pode ser alterado.");
            return;
        }

        if (!novoStatus.equalsIgnoreCase("Entregue") &&
            !novoStatus.equalsIgnoreCase("Pendente") &&
            !novoStatus.equalsIgnoreCase("A Caminho")) {
            System.out.println("Erro: status invalido. Use 'Pendente', 'A Caminho' ou 'Entregue'.");
            return;
        }

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
