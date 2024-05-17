import java.util.Scanner;
class Pessoa {
    double altura;
    char sexo;
    
    Pessoa(double altura, char sexo) {
        this.altura = altura;
        this.sexo = sexo;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[10];

        // Ler os dados das 10 pessoas
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite a altura da pessoa " + (i + 1) + ": ");
            double altura = scanner.nextDouble();
            System.out.print("Digite o sexo da pessoa " + (i + 1) + " (M/F): ");
            char sexo = scanner.next().toUpperCase().charAt(0);

            pessoas[i] = new Pessoa(altura, sexo);
        }

        // Calcular e exibir as informações
        calcularEExibirInformacoes(pessoas);
    }

    public static void calcularEExibirInformacoes(Pessoa[] pessoas) {
        double somaAlturasFeminino = 0;
        double somaAlturasMasculino = 0;
        int countFeminino = 0;
        int countMasculino = 0;

        double maiorAltura = pessoas[0].altura;
        double menorAltura = pessoas[0].altura;

        for (Pessoa pessoa : pessoas) {
            if (pessoa.sexo == 'F') {
                somaAlturasFeminino += pessoa.altura;
                countFeminino++;
            } else if (pessoa.sexo == 'M') {
                somaAlturasMasculino += pessoa.altura;
                countMasculino++;
            }

            if (pessoa.altura > maiorAltura) {
                maiorAltura = pessoa.altura;
            }

            if (pessoa.altura < menorAltura) {
                menorAltura = pessoa.altura;
            }
        }


        double mediaAlturasMasculino = (countMasculino > 0) ? somaAlturasMasculino / countMasculino : 0;

        System.out.println("Maior altura do grupo: " + maiorAltura);
        System.out.println("Menor altura do grupo: " + menorAltura);

        System.out.println("Média das alturas dos homens: " + (countMasculino > 0 ? mediaAlturasMasculino : "Nenhum homem no grupo"));
        System.out.println("Número de mulheres: " + countFeminino);

    }
}