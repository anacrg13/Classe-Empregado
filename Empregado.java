public class Empregado {
    private String nome;
    private int idade;
    private double salario;

    public Empregado(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void promover() {
        if (this.idade > 18) {
            aumentarSalario(25);
        } else {
            System.out.println("A promo��o s� pode ser realizada se o funcion�rio tiver mais de 18 anos.");
        }
    }

    public void aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
    }

    public void demitir(int motivo) {
        switch (motivo) {
            case 1:
                System.out.println("Empregado demitido por justa causa. Deve cumprir aviso pr�vio.");
                break;
            case 2:
                double multa = this.salario * 0.40;
                System.out.println("Empregado demitido por decis�o do empregador. Receber� uma multa de 40% do sal�rio: R$ " + multa);
                break;
            case 3:
                double salarioAposentadoria;
                if (this.salario >= 1000 && this.salario < 2000) {
                    salarioAposentadoria = 1500;
                } else if (this.salario >= 2000 && this.salario < 3000) {
                    salarioAposentadoria = 2500;
                } else if (this.salario >= 3000 && this.salario < 4000) {
                    salarioAposentadoria = 3500;
                } else {
                    salarioAposentadoria = 4000;
                }
                System.out.println("Empregado aposentado. Sal�rio de aposentadoria: R$ " + salarioAposentadoria);
                break;
            default:
                System.out.println("Motivo de demiss�o inv�lido.");
        }
    }

    public void fazerAniversario() {
        this.idade += 1;
    }

    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Sal�rio: R$ " + salario;
    }
}
