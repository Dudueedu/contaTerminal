import java.util.Scanner;

public class contaBancaria {

    private static boolean logado = false;
    private static double saldo = 0;
    private static String nomeCliente;
    private static String agencia;
    private static int numeroConta;

    public static void entrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        System.out.println("Login realizado com sucesso!");
        logado = true;
        menuAposLogin();
    }

    public static void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite seu usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Por favor, digite o número da Agência: ");
        agencia = scanner.nextLine();
        
        System.out.print("Por favor, digite o número da Conta: ");
        numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consumir quebra de linha
        
        System.out.print("Por favor, digite seu Nome Completo: ");
        nomeCliente = scanner.nextLine();
        
        System.out.print("Por favor, digite seu Saldo Inicial: ");
        saldo = scanner.nextDouble();
        
        System.out.println("\nOlá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta " + numeroConta + " e seu saldo " + saldo + " já está disponível para saque.");
        entrar();
    }

    public static void sair() {
        System.out.println("Sistema encerrado com sucesso!");
        System.exit(0);
    }

    public static void depositar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor para depósito: ");
        double valor = scanner.nextDouble();
        saldo += valor;
        System.out.println("Depósito realizado! Saldo atual: " + saldo);
    }

    public static void sacar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o valor para saque: ");
        double valor = scanner.nextDouble();
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado! Saldo atual: " + saldo);
        }
    }

    public static void consultarSaldo() {
        System.out.println("Seu saldo atual é: " + saldo);
    }

    public static void menuAposLogin() {
        Scanner scanner = new Scanner(System.in);
        while (logado) {
            System.out.println("\nMenu Banco Dudueedu");
            System.out.println("----------------------------");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    consultarSaldo();
                    break;
                case 4:
                    logado = false;
                    System.out.println("Você saiu da conta.");
                    return;
                default:
                    System.out.println("Código inválido, tente novamente!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nBem-vindo ao Banco Dudueedu!");
            System.out.println("----------------------------");
            System.out.println("1 - Entrar");
            System.out.println("2 - Cadastrar-se");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            
            int menu = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            
            switch (menu) {
                case 1:
                    entrar();
                    break;
                case 2:
                    cadastrar();
                    break;
                case 3:
                    sair();
                    break;
                default:
                    System.out.println("Código inválido, tente novamente!");
            }
        }
    }
}
