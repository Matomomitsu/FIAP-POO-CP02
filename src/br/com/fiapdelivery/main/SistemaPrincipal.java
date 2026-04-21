package br.com.fiapdelivery.main;

import br.com.fiapdelivery.model.Caminhao;
import br.com.fiapdelivery.model.Entrega;
import br.com.fiapdelivery.model.Moto;
import br.com.fiapdelivery.model.Pedido;
import br.com.fiapdelivery.model.Veiculo;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Veiculo veiculoPadrao = new Veiculo("AAA1A23", 50.0);
        Caminhao caminhaoPadrao = new Caminhao("BRA1234");
        Caminhao caminhaoComMaisEixos = new Caminhao("ABC1D23", 9);
        Moto motoPadrao = new Moto("XYZ1234");
        Moto motoComBau = new Moto("XYZ9K88", true);

        Pedido pedidoLeve = new Pedido("BRA-0999", 10.0, "Pendente");
        Pedido pedidoPesado = new Pedido("CXS-7777", 1200.0, "Pendente");
        Pedido pedidoMuitoPesado = new Pedido("PES-9999", 9999.0, "Pendente");

        Entrega entregaComMoto = new Entrega(pedidoLeve, motoComBau);
        Entrega entregaComCaminhao = new Entrega(pedidoPesado, caminhaoComMaisEixos);
        Entrega tentativaEntregaInvalida = new Entrega(pedidoMuitoPesado, motoPadrao);

        System.out.println("=== Heranca: Veiculo -> Caminhao/Moto ===");
        System.out.println("Veiculo base: placa=" + veiculoPadrao.getPlaca() + ", capacidadeKg=" + veiculoPadrao.getCapacidadeKg());
        System.out.println("Caminhao: placa=" + caminhaoPadrao.getPlaca() + ", capacidadeKg=" + caminhaoPadrao.getCapacidadeKg() + ", eixos=" + caminhaoPadrao.getEixos());
        System.out.println("Caminhao com mais eixos: placa=" + caminhaoComMaisEixos.getPlaca() + ", capacidadeKg=" + caminhaoComMaisEixos.getCapacidadeKg() + ", eixos=" + caminhaoComMaisEixos.getEixos());
        System.out.println("Moto: placa=" + motoPadrao.getPlaca() + ", capacidadeKg=" + motoPadrao.getCapacidadeKg() + ", bau=" + motoPadrao.hasBau());
        System.out.println("Moto com bau: placa=" + motoComBau.getPlaca() + ", capacidadeKg=" + motoComBau.getCapacidadeKg() + ", bau=" + motoComBau.hasBau());
        System.out.println("\n=== Teste adicionar/remover bau ===");
        System.out.println("Moto padrao antes: capacidadeKg=" + motoPadrao.getCapacidadeKg() + ", bau=" + motoPadrao.hasBau());
        motoPadrao.adicionarBau();
        System.out.println("Moto padrao apos adicionar bau: capacidadeKg=" + motoPadrao.getCapacidadeKg() + ", bau=" + motoPadrao.hasBau());
        motoPadrao.removerBau();
        System.out.println("Moto padrao apos remover bau: capacidadeKg=" + motoPadrao.getCapacidadeKg() + ", bau=" + motoPadrao.hasBau());

        System.out.println("\n=== Pedido (antigo Pacote) ===");
        System.out.println("Pedido leve: codigo=" + pedidoLeve.getCodigo() + ", pesoKg=" + pedidoLeve.getPesoKg() + ", status=" + pedidoLeve.getStatus());
        System.out.println("Pedido pesado: codigo=" + pedidoPesado.getCodigo() + ", pesoKg=" + pedidoPesado.getPesoKg() + ", status=" + pedidoPesado.getStatus());

        System.out.println("\n=== Entrega (antiga Rota) aceita qualquer Veiculo ===");
        entregaComMoto.realizarEntrega();
        entregaComCaminhao.realizarEntrega();
        System.out.println("\n=== Teste de erro: pedido muito pesado para o veiculo ===");
        tentativaEntregaInvalida.realizarEntrega();

        System.out.println("\nStatus atualizado do pedido " + pedidoLeve.getCodigo() + ": " + pedidoLeve.getStatus());
    }
}
