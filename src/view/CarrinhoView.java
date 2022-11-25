package view;

import model.Carrinho;
import model.Loja;

import java.util.Map;
import java.util.Scanner;

public class CarrinhoView {

    Scanner sc = new Scanner(System.in);

    public String opcao() {
        System.out.println("\n");
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Adicionar Produto do carrinho");
        System.out.println("2 - Listar todos Produto");
        System.out.println("3 - Pesquisar Produto");
        System.out.println("4 - Listar meu carrinho");
        System.out.println("5 - Retirar Produto do carrinho");
        System.out.println("6 - Finalizar pedido");
        System.out.println("0 - Voltar ao menu inicial");

        System.out.println("\n");

        return sc.nextLine();
    }
    public void listarCarrinhoView(){
        System.out.println("\n");
        System.out.println("----Sua Lista de Compra-----");

        Double valorCompra = 0.0;
            for (int i = 0; i < Carrinho.listaCompra.size(); i++) {
            Map<String, Object> produto = Carrinho.listaCompra.get(i);

            Double preco = (Double)produto.get("preco");
            Integer qtde = (Integer) produto.get("quantidade");
            Double valorTotalProduto = preco * qtde;

            System.out.print("Id: " + i + " | ");
            System.out.print("Produto: " + produto.get("produto") + " | ");
            System.out.print("Quantidade: " + produto.get("quantidade") + " | ");
            System.out.printf("Preço Unitario: R$ %s | ", produto.get("preco"));
            System.out.printf("Valor Total: R$ %.2f \n", valorTotalProduto);
            valorCompra += valorTotalProduto;

        }

        System.out.printf("Valor Total do Seu Pedido é: R$ %.2f", valorCompra);
        System.out.println("\n");
    }


    public String pegarQuantidade() {

        System.out.println("Digite a quantidade que deseja comprar: ");
        return sc.nextLine();

    }

    public void produtoNaoEncontrado() {
        System.out.println("Produto não encontrado.");
    }

    public void qtdeAcimaLimite(Integer qtde) {
        System.out.println("Não tem a quantidade desejada. Nosso estoque total é: " + qtde);
    }

    public Boolean finalizarCompraView() {
        System.out.println("Deseja finalizar Compra: ");
        System.out.println("Digite 1 para Sim;");
        System.out.println("Digite 2 para Não.");

        Integer opcao = Integer.valueOf(sc.nextLine());

        if(opcao == 1){
            return true;
        }
        return false;
    }
}
