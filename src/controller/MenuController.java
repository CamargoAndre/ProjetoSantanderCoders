package controller;

import view.MenuView;

public class MenuController {

    private MenuView menuView = new MenuView();
    private LojaController lojaController = new LojaController();
    private CarrinhoController carrinhoController = new CarrinhoController();

    public void menu() {
        lojaController.atualizaLoja();;
        Boolean continuar = true;

        while(continuar){
            String opcao = menuView.opcao();
            switch (opcao){
                case "1"-> editarLoja();
                case "2"-> comprarProduto();
                case "0"->{
                    sairPrograma();
                    continuar=false;
                }
                default-> System.out.println("Opção inválida");

            }
        }
    }
    private void sairPrograma() {
        menuView.sairPrograma();
    }

    private void comprarProduto() {
        carrinhoController.menuCarrinho();
    }

    private void editarLoja() {
        lojaController.menu();
    }
}
