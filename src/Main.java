import controller.LojaController;
import controller.MenuController;

public class Main {

    public static void main(String[] args) {


        MenuController menuController = new MenuController();
        LojaController controller = new LojaController();

        menuController.menu();

    }
}