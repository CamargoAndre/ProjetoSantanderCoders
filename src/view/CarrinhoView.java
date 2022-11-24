package view;

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
}
