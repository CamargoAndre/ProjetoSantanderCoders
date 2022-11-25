package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LojaDAO {
    static Path path = Paths.get("C:\\Users\\ACER\\IdeaProjects\\ProjetoSantanderCoders\\src\\Loja.txt");
    public static void gravarProdutos(List<Map<String, Object>> listaProduto) {
        try {
                if (!Files.exists(path)) {
                    Files.createFile(path);
                }
            String produtos = "";
            for (Map<String, Object> p : listaProduto) {

                produtos += p.get("produto") + "|";
                produtos += p.get("preco") + "|";
                produtos += p.get("quantidade") + "\n";

            }

            Files.writeString(path, produtos);
        } catch (IOException e) {
            System.out.println("Não foi possivel gravar o produto no arquivo!");
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, Object>> pegarLista() {
        List<String> listaProdutos;
        List<Map<String, Object>> listaProd = new ArrayList<>();
        if (!Files.exists(path)) {
            return listaProd;
        }

        try {
            listaProdutos = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Lista não encontrada!" + e);
            return listaProd;
        }

        for (String s : listaProdutos ) {
            Map<String, Object> produto = new HashMap<>();

            produto.put("produto", s.split("\\|")[0]);
            produto.put("preco", Double.valueOf(s.split("\\|")[1]));
            produto.put("quantidade", Integer.valueOf(s.split("\\|")[2]));

            listaProd.add(produto);
        }

        return listaProd;

    }


}
