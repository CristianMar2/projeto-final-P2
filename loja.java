import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;


public class loja {
    public static Scanner leia = new Scanner(System.in);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        inicializaDiretorio();
        int menu = 0;
        while (true) {
            try {
                System.out.println(
                        "Escolha uma opção: \n1:Cadastar produto \n2:saida \n3:balanço estoque: \n4:Alterar Produto \n5:Histótico de vendas \n6:Procurar produto");
                menu = scanner.nextInt();

                switch (menu) {
                    case 1:
                        cadastraProduto();
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:
                    
                        break;
                    default:
                        System.out.println("============================================");
                        System.out.println("escolha uma das opções do menu!");
                        System.out.println("============================================");
                }
            } catch (InputMismatchException teste) {
                System.out.println("============================================");
                System.out.println("escolha uma das opções do menu!");
                System.out.println("============================================");
                scanner.nextLine();
            }
        }
    }

    private static void inicializaDiretorio() {
        String caminho = "produtos/";
        Path diretorioPath = Paths.get(caminho);

        if (!Files.exists(diretorioPath)) {
            try {
                // Crie o diretório
                Files.createDirectories(diretorioPath);
            } catch (Exception e) {
                System.err.println("Falha ao criar o diretório: " + e.getMessage());
            }
        }
    }

    public static void cadastraProduto() {

        String nomedoproduto;
        System.out.println("============================================");
        System.out.println("Digite o nome do produto");
        nomedoproduto = leia.nextLine();
        String caminhoarquivo = "produtos/"+ nomedoproduto + ".txt";
        Path produtopath = Paths.get(caminhoarquivo);
        if (!Files.exists(produtopath)) {
            try {
                // Crie o arquivo
                Files.createFile(produtopath);
                System.out.println("============================================");
                System.out.println("produto cadastrado com sucesso!");
                System.out.println("============================================");
                informacoesProdutos(nomedoproduto);
                
            } catch (Exception e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }
            

        } else {
            System.out.println("============================================");
            System.out.println("O produto ja existe!");
            System.out.println("============================================");
        }
        
        

    }


    public static void informacoesProdutos (String nomedoproduto ) {
        try{
            FileWriter fileWriter = new FileWriter("produtos/"
            + nomedoproduto + ".txt");
            PrintWriter pw = new PrintWriter(fileWriter);

            System.out.println("Digite o Estoque");
            pw.println(leia.nextLine());
            pw.flush();

            System.out.println("DIgite o Valor unitário");
            pw.println(leia.nextLine());
            pw.flush();

            pw.close();
            fileWriter.close();

        }catch(IOException e){
            System.out.println("ocorreu um erro");
        }
        
    }
}