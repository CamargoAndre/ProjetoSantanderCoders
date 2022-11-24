package controller;

import model.Loja;
import view.LojaView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LojaController {

    private LojaView view;


    public void menu() {
        view = new LojaView();
        Boolean continuar = true;

        while(continuar){
            String opcao = view.opcao();
            switch (opcao){
                case "1"-> criarProduto();
                case "2"-> editarProduto();
                case "3"-> excluirProduto();
                case "4"-> pesquisarProduto();
                case "5"-> comprarProduto();
                case "0"->{
                    System.out.println("Saindo!");
                    continuar=false;
                }
                default-> System.out.println("Opção inválida");

            }
        }
    }

    public void atualizaLoja() {

        LojaDAO lojaDAO = new LojaDAO();
        Loja.listaProduto = lojaDAO.pegarLista();

    }

    private void criarProduto(){

        Map<String, Object> produto = view.pegarInformacaoProduto();
        Loja.listaProduto.add(produto);
        LojaDAO.gravarProdutos(Loja.listaProduto);

    }

    private void editarProduto(){

        view.listarProduto();
        Integer id = Integer.valueOf(view.pegarIdProduto());
        Map<String, Object> produtoAlterado = view.pegarInformacaoProduto();
        Map<String, Object> produtoAtual = Loja.listaProduto.get(id);
        produtoAtual.put("produto", produtoAlterado.get("produto"));
        produtoAtual.put("preco", produtoAlterado.get("preco"));
        produtoAtual.put("quantidade", produtoAlterado.get("quantidade"));

        LojaDAO.gravarProdutos(Loja.listaProduto);
        System.out.println("\n");

    }

    private void excluirProduto() {

        view.listarProduto();
        Integer id = Integer.valueOf(view.pegarIdProduto());
        System.out.println(id);
        Map<String, Object> remover = Loja.listaProduto.get(id);
        Loja.listaProduto.remove(remover);

        LojaDAO.gravarProdutos(Loja.listaProduto);

    }

    private void pesquisarProduto() {

        String pesquisaProduto = view.pegarNomeProduto();
        List<Map<String,Object>> resultadoBusca = new ArrayList<>();

        for (int i = 0; i < Loja.listaProduto.size() ; i++) {
            Map<String, Object> produto = Loja.listaProduto.get(i);
            String nomeProduto = (String) produto.get("produto");
            if(nomeProduto.contains(pesquisaProduto)){
                produto.put("id", i);
                resultadoBusca.add(produto);
            }
        }

        view.resultadoPesquisa(resultadoBusca);
    }

    private void comprarProduto() {

        CarrinhoController carrinhoController = new CarrinhoController();
        carrinhoController.menuCarrinho();



    }

    public Map<String, Object> pesquisaProdutoId(Integer id) {

        Map<String,Object> produto = new HashMap<>();
        if(id >= Loja.listaProduto.size()){
            return produto;
        }
        produto = Loja.listaProduto.get(id);
        return produto;

    }
}
