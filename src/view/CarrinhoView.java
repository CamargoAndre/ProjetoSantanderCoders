package view;

import java.util.Scanner;

public class CarrinhoView {

    Scanner sc = new Scanner(System.in);

    public String opcao() {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Adicionar Produto do carrinho");
        System.out.println("2 - Listar todos Produto");
        System.out.println("3 - Pesquisar Produto");
        System.out.println("4 - Listar meu carrinho");
        System.out.println("5 - Retirar Produto do carrinho");
        System.out.println("6 - Finalizar pedido");
        System.out.println("0 - Voltar ao menu inicial");

        String opcao = sc.nextLine();
        return opcao;
    }



}
