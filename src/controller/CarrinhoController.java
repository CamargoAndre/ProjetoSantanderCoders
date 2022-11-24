package controller;

import view.CarrinhoView;
import view.LojaView;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoController {

    private CarrinhoView carrinhoView;
    private LojaView view;

    public void menuCarrinho() {

        carrinhoView = new CarrinhoView();
        view = new LojaView();
        Boolean continuar = true;

        while(continuar){
            String opcao = carrinhoView.opcao();
            switch (opcao) {
                case "1"-> adicionarCarrinho();
//                case "2"-> listarProduto();
//                case "3"-> pesquisarProduto();
//                case "4"-> listarCarrinho();
//                case "5"-> retirarProduto();
//                case "6"-> {
//                    finalizaCompra();
//                    continuar=false;
//                }
                case "0" -> {
                    System.out.println("Saindo!");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida");
            }

        }
    }

    private void adicionarCarrinho() {

        String id = view.pegarIdProduto();
        Map<String, Object> produto = new HashMap<>();
        LojaController lojaController;
        produto = lojaController.pesquisaProdutoId(Integer.valueOf(id));
        if(produto.isEmpty()){
            System.out.println("Produto não encontrado.");
        }

    }
}
