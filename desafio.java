package desaF;

import java.util.Scanner;

public class desafio {
    public static void menu(){
        System.out.println("       ---Menu Pincipal---");
        System.out.println("1 = Cadastrar novo Contato na Agenda:");
        System.out.println("2 = Excluir Contato da Agenda:");
        System.out.println("3= Listar contatos da Agenda:");
        System.out.println("4 = Limpar todos os Contatos:");
        System.out.println("99 = sair:");
    }

    static Scanner teclado = new Scanner(System.in);

    static String[] nomes = new String[6];

    static String[] telefones = new String[6];

    static int posicao = 0;

    //cadastro
    public static void cadastrarContato(String nome, String telefone){
        nomes[posicao] = nome;
        telefones[posicao] = telefone;
    }

    //lista de contato
    public static void listarContato(){
        System.out.println("Lista de contatos:");
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i] != null){
                String contato = "Nome: " + nomes[i] + " Telefone: " + telefones[i];
                System.out.println(contato);
            }
        }

    }

    // excluir contatos

    public static void excluirContato(String nome){
        boolean depois = false;

        for (int i = 0; i < nomes.length; i++) {
            if (depois){
                nomes[i - 1] = nomes[i];
                telefones[i - 1] = telefones[i];
            }
            if (nome.equals(nomes[i])){
                nomes[i] = null;
                telefones[i] = null;
                depois = true;
            }
        }

    }

    // limpar todos os contatos
    public static void limparContatos(){
        for (int i = 0; i < nomes.length; i++) {
            nomes[i] = null;
            telefones[i] = null;
        }

    }

    // onde o codigo vai rodar
    public static void main(String[] args) {

        String nome, telefone;

        String opicoes;


        do{
            menu();
            opicoes = teclado.nextLine();
            switch (opicoes){
                case "1":
                    //cadastrar contato
                    if (posicao < nomes.length){
                        System.out.println("Informe seu nome:");
                        nome = teclado.nextLine();
                        System.out.println("Informe seu telefone:");
                        telefone = teclado.nextLine();
                        cadastrarContato(nome,telefone);
                        posicao++;
                    }else{
                        System.out.println("Lista de contatos cheia!");
                    }
                    break;
                case "2":
                    //excluir contato
                    System.out.println("Qual nome você deseja excluir?");
                    nome = teclado.nextLine();
                    excluirContato(nome);
                    System.out.println("Contato excluido com sucesso!");
                    break;
                case "3":
                    //listar contatos
                    listarContato();

                    break;
                case "4":
                    //limpar todos os contatos1
                    limparContatos();
                    System.out.println("Todos os contatos foram limpos com sucesso!");
                    break;
                case "99":
                    //sair
                    System.out.println("Você saiu da agenda!");

                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente");

            }

        }while (!opicoes.equals("99"));


    }

}