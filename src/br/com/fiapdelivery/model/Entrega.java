package br.com.fiapdelivery.model;

public class Entrega {
    private Pedido pedido;
    private Veiculo veiculo;

    public Entrega(Pedido pedido, Veiculo veiculo) {
        setPedido(pedido);
        setVeiculo(veiculo);
    }

    public Pedido getPedido() {
        return pedido;
    }

    private void setPedido(Pedido pedido) {
        if (pedido == null) {
            System.out.println("Erro: pedido nao pode ser nulo.");
            return;
        }
        if (veiculo != null && pedido.getPesoKg() > veiculo.getCapacidadeKg()) {
            System.out.println("Erro: peso do pedido excede a capacidade do veiculo.");
            return;
        }
        this.pedido = pedido;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    private void setVeiculo(Veiculo veiculo) {
        if (veiculo == null) {
            System.out.println("Erro: veiculo nao pode ser nulo.");
            return;
        }
        if (pedido != null && pedido.getPesoKg() > veiculo.getCapacidadeKg()) {
            System.out.println("Erro: peso do pedido excede a capacidade do veiculo.");
            return;
        }
        this.veiculo = veiculo;
    }

    public void realizarEntrega() {
        if (pedido == null || veiculo == null) {
            System.out.println("Erro: entrega invalida, pedido e veiculo devem ser definidos.");
            return;
        }

        System.out.println("Levando pedido " + pedido.getCodigo() +
                " no veiculo " + veiculo.getPlaca() +
                " (" + veiculo.getClass().getSimpleName() + ")");

        pedido.alterarStatus("Entregue");
    }
}
