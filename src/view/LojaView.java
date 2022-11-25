package view;

import model.Loja;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LojaView {

        Scanner sc = new Scanner(System.in);

        public String opcao() {
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Criar Produto");
            System.out.println("2 - Editar Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Pesquisar Produto");
            System.out.println("5 - Comprar Produto");
            System.out.println("0 - Sair");

            String opcao = sc.nextLine();
            return opcao;
        }


    public Map<String, Object> pegarInformacaoProduto() {

            Map<String, Object> produto = new HashMap<>();

            System.out.println("Digite o nome do produto: ");
            produto.put("produto", sc.nextLine());
            System.out.println("Digite o preço do produto: ");
            produto.put("preco", sc.nextDouble());
            System.out.println("Digite a quantidade do produto: ");
            produto.put("quantidade", sc.nextInt());
            sc.nextLine();

            return produto;

    }

    public void listarProduto() {

        System.out.println("\n");

        for (int i = 0; i < Loja.listaProduto.size(); i++) {

            Map<String, Object> produto = Loja.listaProduto.get(i);

            System.out.print("Id: " + i + " | ");
            System.out.print("Produto: " + produto.get("produto") + " | ");
            System.out.print("Preço: " + produto.get("preco") + " | ");
            System.out.print("Quantidade: " + produto.get("quantidade") + "\n");

        }
        System.out.println("\n");

    }

    public String pegarIdProduto() {

            System.out.println("Digite o Id do produto: ");
            return sc.nextLine();
    }

    public String pegarNomeProduto() {

            System.out.println("Digite o nome do produto que deseja pesquisar: ");
            return sc.nextLine();

    }

    public void resultadoPesquisa(List<Map<String, Object>> resultadoBusca) {

        System.out.println("\n");


        for (int i = 0; i < resultadoBusca.size(); i++) {

            Map<String, Object> produto = resultadoBusca.get(i);

            System.out.print("Id: " + produto.get("id") + " | ");
            System.out.print("Produto: " + produto.get("produto") + " | ");
            System.out.print("Preço: " + produto.get("preco") + " | ");
            System.out.print("Quantidade: " + produto.get("quantidade") + "\n");

        }
        System.out.println("\n");

    }
}
