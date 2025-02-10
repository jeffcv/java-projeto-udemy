package estudo.files;

import java.io.*;

public class CriadorArquivos {
    public static void main(String[] args) {

        CriadorArquivos criadorArquivo = new CriadorArquivos();
        //criadorArquivo.criarArquivo();
       /* criadorArquivo.lerArquivo();
        criadorArquivo.criarPasta();
        criadorArquivo.deletarPasta();*/
        criadorArquivo.lerConteudoArquivo();

    }

    public void deletarArquivo(){
        File arquivo = new File("C:\\sistemas\\arquivos\\arquivo.txt");
        boolean deletou = arquivo.delete();
        System.out.println("Deletou? " + deletou);
    }

    public void deletarPasta(){
        File arquivo = new File("C:\\sistemas\\arquivos\\pasta");
        boolean deletou = arquivo.delete();
        System.out.println("Pasta deletada? " + deletou);
    }

    public void lerArquivo(){
        File arquivo = new File("C:\\sistemas\\arquivos\\arquivo.txt");
        System.out.println("Caminho: " + arquivo.getAbsoluteFile());
        System.out.println("Nome: " +  arquivo.getName());
        System.out.println("Tamanho: " +  arquivo.length());
        System.out.println("É arquivo?: " + arquivo.isFile());
    }

    public void criarPasta(){
        File file = new File("C:\\sistemas\\arquivos\\pasta");
        boolean criou = file.mkdir();
        System.out.println("Pasta criada? " + criou);
    }

    public void lerConteudoArquivo(){
        try {
            File arquivo = new File("C:\\sistemas\\arquivos\\arquivo.txt");
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader reader = new BufferedReader(fileReader);

            String linha;
            while ( (linha = reader.readLine()) != null ){
                System.out.println(linha);
            }

            reader.close();

        } catch (IOException e){

        }
    }

    public void criarArquivo() {
        try {

            File arquivo = new File("C:\\sistemas\\arquivos\\arquivo.txt");
            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("conteudo do novo arquivo");
            writer.flush();
            writer.close();

        } catch (Exception e) {
            System.out.println("Ocorreu um erro " + e.getMessage());
        }
    }
}
