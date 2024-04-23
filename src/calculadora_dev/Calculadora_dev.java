/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora_dev;

import java.util.Scanner;

public class Calculadora_dev {

    public static void main(String[] args) {

// Exemplos Polinomiais
        resolverExemplo("x^2 + 3x - 1", "2x + 3");
        resolverExemplo("4x^3 - 2x^2 + x", "12x^2 - 4x + 1");
        resolverExemplo("5x^4 - 3x^2 + 2x - 1", "20x^3 - 6x + 2");

// Exemplos Funcionais
        resolverExemplo("e^(2x)", "2e^(2x)");
        resolverExemplo("e^(3x^2)", "6xe^(3x^2)");
        resolverExemplo("2e^(x^3)", "6x^2e^(x^3)");
        
 // Exemplos com funções trigonométricas
        resolverExemplo("sin(x)", "cos(x)");
        resolverExemplo("cos(x)", "-sin(x)");
        resolverExemplo("tan(x)", "sec(x)^2");

// Exemplos com funções logarítmicas
        resolverExemplo("log(x)", "1/x");
        resolverExemplo("ln(x)", "1/x");

// Exemplos com funções exponenciais e trigonométricas
        resolverExemplo("e^(sin(x))", "cos(x) * e^(sin(x))");
        resolverExemplo("cos(e^x)", "-e^x * sin(e^x)");

// Solicita ao usuário que digite se deseja testar mais funções (opcional)
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDeseja testar mais funções? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("\nDigite sua função a ser derivada: ");
            String funcaoUsuario = scanner.nextLine();
            resolverFuncaoUsuario(funcaoUsuario);
        } else {
            System.out.println("Finalizando o programa.");
        }
    }

    private static void resolverExemplo(String funcao, String derivadaEsperada) {
        System.out.println("\nExemplo:");
        System.out.println("Função: " + funcao);

        // Cria uma instância da classe Derivadas
        Derivadas derivadas = new Derivadas();

        // Define a função a ser derivada
        derivadas.setFuncionADerivar(funcao);

        // Chama o método para derivar a função
        derivadas.derivar();

        // Obtém a função derivada
        String funcaoDerivada = derivadas.getFuncionDerivada();

        // Exibe a função derivada e verifica se a derivada está correta
        System.out.println("Derivada: " + funcaoDerivada);
        if (funcaoDerivada.equals(derivadaEsperada)) {

        }

    }

    private static void resolverFuncaoUsuario(String funcaoUsuario) {
        System.out.println("\nFunção do usuário: " + funcaoUsuario);

        // Cria uma instância da classe Derivadas
        Derivadas derivadas = new Derivadas();

        // Define a função a ser derivada
        derivadas.setFuncionADerivar(funcaoUsuario);

        // Chama o método para derivar a função
        derivadas.derivar();

        // Obtém a função derivada
        String funcaoDerivadaUsuario = derivadas.getFuncionDerivada();

        // Exibe a função derivada
        System.out.println("Derivada: " + funcaoDerivadaUsuario);
    }
}
