import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Empregado> listaEmpregados = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            System.out.println("Selecione uma op��o: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    criarNovoEmpregado();
                    break;
                case 2:
                    promoverEmpregado();
                    break;
                case 3:
                    aumentarSalarioEmpregado();
                    break;
                case 4:
                    demitirEmpregado();
                    break;
                case 5:
                    fazerAniversarioEmpregado();
                    break;
                case 6:
                    mostrarDetalhesEmpregados();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Op��o inv�lida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);

        input.close();
    }

    private static void exibirMenu() {
        System.out.println("\n### Menu ###");
        System.out.println("1. Criar novo empregado");
        System.out.println("2. Promover empregado");
        System.out.println("3. Aumentar sal�rio do empregado");
        System.out.println("4. Demitir empregado");
        System.out.println("5. Fazer anivers�rio do empregado");
        System.out.println("6. Mostrar detalhes dos empregados");
        System.out.println("7. Sair");
    }

    private static void criarNovoEmpregado() {
        System.out.println("Nome do empregado: ");
        String nome = input.nextLine();
        System.out.println("Idade do empregado: ");
        int idade = input.nextInt();
        System.out.println("Sal�rio do empregado: ");
        double salario = input.nextDouble();

        listaEmpregados.add(new Empregado(nome, idade, salario));
        System.out.println("Novo empregado criado com sucesso!");
    }

    private static void promoverEmpregado() {
        System.out.println("�ndice do empregado a ser promovido: ");
        int indice = input.nextInt();
        if (indice >= 0 && indice < listaEmpregados.size()) {
            listaEmpregados.get(indice).promover();
            System.out.println("Empregado promovido com sucesso!");
        } else {
            System.out.println("�ndice inv�lido.");
        }
    }

    private static void aumentarSalarioEmpregado() {
        System.out.println("�ndice do empregado a ter aumento salarial: ");
        int indice = input.nextInt();
        if (indice >= 0 && indice < listaEmpregados.size()) {
            System.out.println("Percentual de aumento de sal�rio: ");
            double percentual = input.nextDouble();

            listaEmpregados.get(indice).aumentarSalario(percentual);
            System.out.println("Sal�rio do empregado aumentado com sucesso!");
        } else {
            System.out.println("�ndice inv�lido.");
        }
    }

    private static void demitirEmpregado() {
        System.out.println("�ndice do empregado a ser demitido: ");
        int indice = input.nextInt();
        if (indice >= 0 && indice < listaEmpregados.size()) {
            System.out.println("Motivos de demiss�o: ");
            System.out.println("1. Justa causa");
            System.out.println("2. Decis�o do empregador");
            System.out.println("3. Aposentadoria");
            System.out.println("Escolha o motivo: ");
            int motivo = input.nextInt();

            listaEmpregados.get(indice).demitir(motivo);
            listaEmpregados.remove(indice);
            System.out.println("Empregado demitido com sucesso!");
        } else {
            System.out.println("�ndice inv�lido.");
        }
    }

    private static void fazerAniversarioEmpregado() {
        System.out.println("�ndice do empregado que faz anivers�rio: ");
        int indice = input.nextInt();
        if (indice >= 0 && indice < listaEmpregados.size()) {
            listaEmpregados.get(indice).fazerAniversario();
            System.out.println("Anivers�rio do empregado celebrado com sucesso!");
        } else {
            System.out.println("�ndice inv�lido.");
        }
    }

    private static void mostrarDetalhesEmpregados() {
        System.out.println("### Detalhes dos Empregados ###");
        for (int i = 0; i < listaEmpregados.size(); i++) {
            System.out.println("�ndice: " + i + " - " + listaEmpregados.get(i));
        }
    }
}
