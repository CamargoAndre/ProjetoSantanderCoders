package view;

import java.util.Scanner;

public class MenuView {

    Scanner sc = new Scanner(System.in);

    public String opcao() {
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Para Editar Produtos da Loja");
        System.out.println("2 - Para Comprar produtos");
        System.out.println("0 - Sair");

        String opcao = sc.nextLine();
        return opcao;
    }

    public void sairPrograma(){

        System.out.println("Você esta saindo do sistema! Até a proxima!");
    }


}
