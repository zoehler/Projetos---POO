import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GerenciarContas manager = new GerenciarContas();
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaText = new Scanner(System.in);
        boolean loopPrincipal = true;
        System.out.println("Bem vindo ao Santo André, o vermelhinho!");

        do {
            System.out.println("\nPara criar uma nova conta pressione 1;" +
                    "\nPara acessar uma conta existente pressione 2;" +
                    "\nPara opções administrativas pressione 3;" +
                    "\nPara sair pressione 0.");
            try {
                boolean loopConta = true;
                switch (Integer.parseInt(entradaInt.next())) {
                    case 1:
                        //Inserção de nova conta
                        do {
                            try {
                                System.out.println("Insira seu nome completo: ");
                                String nomeCliente = entradaText.nextLine();
                                System.out.println("Insira seu CPF: ");
                                String cpfCliente = entradaText.nextLine();
                                int nConta = 0;
                                boolean contaValida = false;
                                do {
                                    try {
                                        System.out.println("Insira o numero de sua conta (valor inteiro e positivo):");
                                        nConta = Integer.parseInt(entradaInt.next());
                                        if (nConta > 0) {
                                            if (manager.buscarConta(nConta) == null) {
                                                contaValida = true;
                                            } else {
                                                System.out.println("Conta já existente, insira outro número para prosseguir.");
                                            }
                                        } else {
                                            System.out.println("Insira um número positivo e maior que zero.");
                                        }
                                    }
                                    catch (Exception e) {
                                        System.out.println("Insira um valor válido. Erro: " + e.getLocalizedMessage());
                                    }
                                } while (!contaValida);

                                double depositoInicial = 0;
                                do {
                                    try {
                                        System.out.println("Insira primeiro depósito de sua conta (valor positivo):");
                                        depositoInicial = Integer.parseInt(entradaInt.next());
                                    }
                                    catch (Exception e) {
                                        System.out.println("Insira um valor válido.");
                                    }
                                } while (depositoInicial <= 0);
                                System.out.println("Selecione o tipo de conta: ");
                                System.out.println("\nPara conta corrente pressione 1;" +
                                        "\nPara conta poupança pressione 2;" +
                                        "\nPara conta especial pressione 3;" +
                                        "\nPara voltar ao menu inicial pressione 0");

                                switch (entradaInt.nextInt()) {
                                    case 1:
                                        manager.adicionarConta(new ContaCorrente(nConta, nomeCliente, cpfCliente, depositoInicial, 1500));
                                        System.out.println("Conta corrente selecionada; ");
                                        System.out.println("Seu limite inicial é de 1500;");
                                        System.out.println("Voltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    case 2:
                                        manager.adicionarConta(new ContaPoupanca(nConta, nomeCliente, cpfCliente, depositoInicial));
                                        System.out.println("Conta poupança criada; ");
                                        System.out.println("Voltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    case 3:
                                        System.out.println("Insira o nome de seu Gerente: ");
                                        String nomeGerente = entradaText.nextLine();
                                        manager.adicionarConta(new ContaEspecial(nConta, nomeCliente, cpfCliente, depositoInicial, 3000, nomeGerente));
                                        System.out.println("Conta especial criada; ");
                                        System.out.println("Seu limite inicial é de 3000;");
                                        System.out.println("Voltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    case 0:
                                        loopConta = false;
                                        break;
                                    default:
                                        System.out.println("Insira um caracter válido!");
                                        break;
                                }
                            }
                            catch (Exception e) {
                                System.out.println("Insira somente números!");
                            }
                        } while (loopConta);
                        break;
                    case 2:
                        //Edição de conta ativa
                        int thisConta = 0;
                        do {
                            try {
                                System.out.println("Insira o numero da conta desejada: ");
                                thisConta = entradaInt.nextInt();
                            }
                            catch (Exception e) {
                                System.out.println("Insira um valor válido.");
                            }
                        } while (thisConta <= 0);

                        do {
                            System.out.println("\nPara depósito pressione 1;" +
                                    "\nPara saque pressione 2;" +
                                    "\nPara transferência pressione 3;" +
                                    "\nPara remover a conta do sistema pressione 4;" +
                                    "\nPara voltar ao menu inicial pressione 0");
                            switch (Integer.parseInt(entradaInt.next())) {
                                case 1:
                                    double valorD = 0;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para depositar: ");
                                            valorD = entradaInt.nextDouble();
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (valorD <= 0);
                                    if (manager.depositar(thisConta, valorD)) {
                                        System.out.println("Depósito realizado com sucesso.");
                                    } else {
                                        System.out.println("Falha ao depositar.");
                                    }
                                    break;
                                case 2:
                                    double valorS = 0;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para sacar: ");
                                            valorS = entradaInt.nextDouble();
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (valorS <= 0);
                                    if (manager.sacar(thisConta, valorS)) {
                                        System.out.println("Saque realizado com sucesso.");
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                    }
                                    break;
                                case 3:
                                    Conta contaDestino = null;
                                    do {
                                        try {
                                            System.out.println("Insira o numero da conta de destino: ");
                                            int tempConta = entradaInt.nextInt();
                                            contaDestino = manager.buscarConta(tempConta);
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (contaDestino == null);
                                    double valorT = 0;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para realizar a transferência: ");
                                            valorT = entradaInt.nextDouble();
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (valorT <= 0);
                                    if (manager.transferirValor(thisConta, contaDestino.getNumeroConta(), valorT)) {
                                        System.out.println("Transferência realizada com sucesso.");
                                    } else {
                                        System.out.println("Transferência não efetuada. Saldo insufiente.");
                                    }
                                    break;
                                case 4:
                                    if (!manager.removerConta(thisConta)) {
                                        System.out.println("Erro no sistema. A conta não foi removida.");
                                        break;
                                    } else {
                                        System.out.println("Conta removida com sucesso.\nVoltando ao menu principal.");
                                    }
                                case 0:
                                    loopConta = false;
                                    break;
                                default:
                                    System.out.println("Insira um caracter válido!");
                                    break;
                            }
                        } while (loopConta);
                        break;
                    case 3:
                        //Opções de administração
                        do {
                            System.out.println("\nPara exibir as contas especiais pressione 1;" +
                                    "\nPara buscar as contas corrente utilizando o limite pressione 2;" +
                                    "\nPara exibir as informações de todas as contas pressione 3;" +
                                    "\nPara voltar ao menu inicial pressione 0");

                            switch (entradaInt.nextInt()){
                                case 1:
                                    System.out.println(manager.buscarContasEspeciais());
                                    break;
                                case 2:
                                    System.out.println(manager.buscarClientesUsandoLimite());
                                case 3:
                                    System.out.println(manager.listarContas());
                                case 0:
                                    loopConta = false;
                                    break;
                                default:
                                    System.out.println("Insira um caracter válido!");
                                    break;
                            }
                        } while (loopConta);
                        break;
                    case 0:
                        loopPrincipal = false;
                        break;
                    default:
                        System.out.println("Insira um caracter válido!");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Insira somente números!");
            }
        } while (loopPrincipal);

        System.out.println("Obrigado pela preferência e volte sempre AO INFERNO!");
    }
}
