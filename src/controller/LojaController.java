package controller;

import model.Loja;
import view.LojaView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LojaController {

    private LojaView view = new LojaView();
    private LojaDAO lojaDAO = new LojaDAO();

    public void menu() {
        Boolean continuar = true;

        while(continuar){
            String opcao = view.opcao();
            switch (opcao){
                case "1"-> criarProduto();
                case "2"-> editarProduto();
                case "3"-> excluirProduto();
                case "4"-> pesquisarProduto();
                case "5"-> listarProdutos();
                case "0"-> continuar=false;
                default-> System.out.println("Opção inválida");

            }
        }
    }

    private void listarProdutos() {

        view.listarProduto();

    }

    public void atualizaLoja() {

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
        Map<String, Object> remover = Loja.listaProduto.get(id);
        Loja.listaProduto.remove(remover);

        LojaDAO.gravarProdutos(Loja.listaProduto);

    }

    public void pesquisarProduto() {

        String pesquisaProduto = view.pegarNomeProduto().toUpperCase();
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


    public Map<String, Object> pesquisaProdutoId(Integer id) {

        Map<String,Object> produto = new HashMap<>();
        if(id >= Loja.listaProduto.size()){
            return produto;
        }
        produto = Loja.listaProduto.get(id);
        return produto;

    }

    public void atualizarProdutos(List<Map<String, Object>> listaCompra) {

        for (int i = 0; i < Loja.listaProduto.size(); i++) {

            Map<String, Object> produtosLista = Loja.listaProduto.get(i);
            String nomeListaProduto = (String) produtosLista.get("produto");

            for (int j = 0; j < listaCompra.size(); j++) {

                Map<String, Object> produtoCarrinho = listaCompra.get(j);
                String nomeListaCarrinho = (String) produtoCarrinho.get("produto");

                if(nomeListaProduto.equals(nomeListaCarrinho)){

                    Integer qtdeListaProduto = (Integer) produtosLista.get("quantidade");
                    Integer qtdeListaCarrinho = (Integer) produtoCarrinho.get("quantidade");

                    Integer qtdeFinal = qtdeListaProduto - qtdeListaCarrinho;

                    produtosLista.put("quantidade", qtdeFinal);
                    Loja.listaProduto.set(i,produtosLista);
                }
            }
        }
        LojaDAO.gravarProdutos(Loja.listaProduto);
    }
}
