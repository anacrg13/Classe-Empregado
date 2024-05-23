Implemente uma classe Empregado com os seguintes atributos: nome, idade e salario. Crie os métodos promover(), aumentarSalario(), demitir() e fazerAniversario() com as seguintes regras:
Regras dos Métodos:
Todos os atributos devem ser privados e os métodos públicos.
 Você deve implementar métodos get e set para todos os atributos, independentemente do uso.
 Implementar método toString.
promover()
A promoção só poderá ser realizada se o funcionário tiver mais de 18 anos.
A promoção resultará em um aumento de 25% no salário, utilizando o método aumentarSalario().
aumentarSalario()
Deve receber um percentual de aumento como parâmetro.
Deve realizar o aumento do salário do funcionário de acordo com o percentual informado.
demitir()
Deve receber um motivo como parâmetro (1, 2 ou 3):
1: Justa causa.
2: Decisão do empregador.
3: Aposentadoria.
Se o motivo for decisão do empregador, o empregado deverá receber uma multa de 40% do salário (realizar este cálculo e informar).
Se o motivo for justa causa, o funcionário deverá cumprir aviso prévio.
Se o motivo for aposentadoria, o salário de aposentadoria deve ser calculado conforme a tabela do INSS abaixo:
Salário entre 1000 e 2000 reais: receberá 1500 reais.
Salário entre 2000 e 3000 reais: receberá 2500 reais.
Salário entre 3000 e 4000 reais: receberá 3500 reais.
Salário acima de 4000 reais: receberá 4000 reais.
fazerAniversario()
Aumenta a idade do empregado em 1 ano.






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
            System.out.println("A promoção só pode ser realizada se o funcionário tiver mais de 18 anos.");
        }
    }

    public void aumentarSalario(double percentual) {
        this.salario += this.salario * (percentual / 100);
    }

    public void demitir(int motivo) {
        switch (motivo) {
            case 1:
                System.out.println("Empregado demitido por justa causa. Deve cumprir aviso prévio.");
                break;
            case 2:
                double multa = this.salario * 0.40;
                System.out.println("Empregado demitido por decisão do empregador. Receberá uma multa de 40% do salário: R$ " + multa);
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
                System.out.println("Empregado aposentado. Salário de aposentadoria: R$ " + salarioAposentadoria);
                break;
            default:
                System.out.println("Motivo de demissão inválido.");
        }
    }

    public void fazerAniversario() {
        this.idade += 1;
    }

    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Salário: R$ " + salario;
    }
}
