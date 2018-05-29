import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GerenciarContas manager = new GerenciarContas();
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaText = new Scanner(System.in);
        boolean loopPrincipal = true;
        System.out.println("Bem vindo ao Santo André, o vermelhinho!");

        do {
            System.out.println("\nPara criar uma nova conta pressione 1;" + "\nPara acessar uma conta existente pressione 2;" + "\nPara opções administrativas pressione 3;" + "\nPara sair pressione 0.");
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

                                System.out.println("Selecione o tipo de conta: ");
                                System.out.println("\nPara conta corrente pressione 1;" + "\nPara conta poupança pressione 2;" + "\nPara conta especial pressione 3;");

                                switch (Integer.parseInt(entradaInt.next())) {
                                    case 1:
                                        manager.adicionarConta(new ContaCorrente(nConta, nomeCliente, cpfCliente, 1500));
                                        System.out.println("Conta corrente criada; ");
                                        System.out.println("Seu limite inicial é de 1500;");
                                        System.out.println("Voltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    case 2:
                                        manager.adicionarConta(new ContaPoupanca(nConta, nomeCliente, cpfCliente));
                                        System.out.println("Conta poupança criada; ");
                                        System.out.println("Voltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    case 3:
                                        System.out.println("Insira o nome de seu Gerente: ");
                                        String nomeGerente = entradaText.nextLine();
                                        manager.adicionarConta(new ContaEspecial(nConta, nomeCliente, cpfCliente, 3000, nomeGerente));
                                        System.out.println("Conta especial criada; ");
                                        System.out.println("Seu limite inicial é de 3000;");
                                        System.out.println("Voltando ao menu principal.");
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
                        Conta thisConta = null;
                        boolean contaOk = false;
                        do {
                            try {
                                System.out.println("Insira o numero da conta desejada: ");
                                int tempN = Integer.parseInt(entradaInt.next());
                                thisConta = manager.buscarConta(tempN);
                                if (thisConta != null) {
                                    if (thisConta instanceof ContaCorrente) {
                                        System.out.println("Conta Corrente do(a) senhor(a) " + thisConta.getNomeCliente());
                                    }
                                    if (thisConta instanceof ContaPoupanca) {
                                        System.out.println("Conta Poupança do(a) senhor(a) " + thisConta.getNomeCliente());
                                    }
                                    if (thisConta instanceof ContaEspecial) {
                                        System.out.println("Conta Especial do(a) senhor(a) " + thisConta.getNomeCliente());
                                    }
                                    System.out.println("Saldo: " + thisConta.getSaldo());
                                    contaOk = true;
                                }
                            }
                            catch (Exception e) {
                                System.out.println("Insira um valor válido.");
                            }
                        } while (!contaOk);

                        do {
                            System.out.println("\nPara depósito pressione 1;" + "\nPara saque pressione 2;" + "\nPara transferência pressione 3;" + "\nPara remover a conta do sistema pressione 4;");
                            if (thisConta instanceof ContaCorrente) {
                                System.out.println("Para solicitar mais limite pressione 5");
                            } else if (thisConta instanceof ContaPoupanca) {
                                System.out.println("Para aplicar o rendimento pressione 5");
                            }
                            if (thisConta instanceof ContaEspecial) {
                                System.out.println("Para escolher outro gerente pressione 6");
                            }
                            System.out.println("Para voltar ao menu inicial pressione 0");
                            switch (Integer.parseInt(entradaInt.next())) {
                                case 1:
                                    double valorD = 0;
                                    boolean depositoOk = false;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para depositar: ");
                                            valorD = Double.parseDouble(entradaInt.next());
                                            if (valorD > 0) {
                                                depositoOk = true;
                                            }
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (!depositoOk);

                                    if (manager.depositar(thisConta.getNumeroConta(), valorD)) {
                                        thisConta = manager.buscarConta(thisConta.getNumeroConta());
                                        System.out.println("Depósito realizado com sucesso.\nNovo saldo: " + thisConta.getSaldo());
                                    } else {
                                        System.out.println("Falha ao depositar.");
                                    }
                                    break;
                                case 2:
                                    double valorS = 0;
                                    boolean saqueOk = false;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para sacar: ");
                                            valorS = Double.parseDouble(entradaInt.next());
                                            if (valorS > 0) {
                                                saqueOk = true;
                                            }
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (!saqueOk);

                                    if (manager.sacar(thisConta.getNumeroConta(), valorS)) {
                                        thisConta = manager.buscarConta(thisConta.getNumeroConta());
                                        System.out.println("Saque realizado com sucesso.\nNovo saldo: " + thisConta.getSaldo());
                                        if(thisConta instanceof ContaCorrente) System.out.println("Limite: " + ((ContaCorrente) thisConta).getLimite());
                                    } else {
                                        System.out.println("Saldo insuficiente.");
                                        System.out.println("Saldo: " + thisConta.getSaldo());
                                        if(thisConta instanceof ContaCorrente) System.out.println("Limite: " + ((ContaCorrente) thisConta).getLimite());
                                    }
                                    break;
                                case 3:
                                    Conta contaDestino = null;
                                    do {
                                        try {
                                            System.out.println("Insira o numero da conta de destino: ");
                                            int tempConta = Integer.parseInt(entradaInt.next());

                                            contaDestino = manager.buscarConta(tempConta);

                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (contaDestino == null);

                                    double valorT = 0;
                                    boolean transferenciaOk = false;
                                    do {
                                        try {
                                            System.out.println("Insira o valor desejado para realizar a transferência: ");
                                            valorT = Double.parseDouble(entradaInt.next());
                                            if (valorT > 0) {
                                                transferenciaOk = true;
                                            }
                                        }
                                        catch (Exception e) {
                                            System.out.println("Insira um valor válido.");
                                        }
                                    } while (!transferenciaOk);

                                    if (manager.transferirValor(thisConta.getNumeroConta(), contaDestino.getNumeroConta(), valorT)) {
                                        thisConta = manager.buscarConta(thisConta.getNumeroConta());
                                        System.out.println("Transferência realizada com sucesso.\nNovo saldo da conta de origem: " + thisConta.getSaldo());
                                    } else {
                                        System.out.println("Transferência não efetuada. Saldo insufiente.");
                                    }
                                    break;
                                case 4:
                                    if (!manager.removerConta(thisConta.getNumeroConta())) {
                                        System.out.println("Erro no sistema. A conta não foi removida.");
                                        break;
                                    } else {
                                        System.out.println("Conta removida com sucesso.\nVoltando ao menu principal.");
                                        loopConta = false;
                                        break;
                                    }
                                case 5:
                                    if (thisConta instanceof ContaCorrente) {
                                        double valorL = 0;
                                        boolean limiteOk = false;
                                        do {
                                            try {
                                                System.out.println("Insira o adicional de limite desejado: ");
                                                valorL = Double.parseDouble(entradaInt.next());
                                                if (valorL > 0) {
                                                    limiteOk = true;
                                                }
                                            }
                                            catch (Exception e) {
                                                System.out.println("Insira um valor válido.");
                                            }
                                        } while (!limiteOk);
                                        ((ContaCorrente) thisConta).setLimite(((ContaCorrente) thisConta).getLimite() + valorL);
                                        System.out.println("Limite autorizado!\nNovo limite: " + ((ContaCorrente) thisConta).getLimite());
                                    } else if (thisConta instanceof ContaPoupanca) {
                                        ((ContaPoupanca) thisConta).calcularRendimento(5);
                                        System.out.println("Cálculo efetuado com sucesso!\nNovo Saldo: " + thisConta.getSaldo());
                                    } else {
                                        System.out.println("Insira um caracter válido!");
                                    }
                                    break;
                                case 6:
                                    if (thisConta instanceof ContaEspecial) {
                                        System.out.println("Insira o nome de seu novo gerente: ");
                                        String nomeGerente = entradaText.nextLine();
                                        ((ContaEspecial) thisConta).setNomeGerente(nomeGerente);
                                        System.out.println("Novo gerente definido!");
                                    } else {
                                        System.out.println("Insira um caracter válido!");
                                    }
                                    break;
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
                            System.out.println("\nPara exibir as contas especiais pressione 1;" + "\nPara buscar as contas corrente utilizando o limite pressione 2;" + "\nPara exibir as informações de todas as contas pressione 3;" + "\nPara voltar ao menu inicial pressione 0");

                            switch (Integer.parseInt(entradaInt.next())) {
                                case 1:
                                    System.out.println(manager.buscarContasEspeciais());
                                    break;
                                case 2:
                                    System.out.println(manager.buscarClientesUsandoLimite());
                                    break;
                                case 3:
                                    System.out.println(manager.listarContas());
                                    break;
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
