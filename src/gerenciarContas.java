import java.util.ArrayList;

public class GerenciarContas {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta c) {
        contas.add(c);
    }

    public boolean removerConta(int numeroConta) {

        for (int i = 0; i <= contas.size(); i++) {
            if (contas.get(i).getNumeroConta() == numeroConta) {
                contas.remove(i);
                return true;
            }
        }

        return false;
    }

    public String buscarContasEspeciais() {

        StringBuilder dados = new StringBuilder();

        for (Conta conta : contas) {
            if (conta instanceof ContaEspecial) {
                dados.append(conta.imprimir()).append("\n");
            }

        }

        if (!dados.toString().isEmpty()) {
            return dados.toString();
        } else {
            return "Nenhuma conta especial localizada.";
        }

    }

    public String buscarClientesUsandoLimite() {
        StringBuilder dados = new StringBuilder();

        for (Conta conta : contas) {

            if (conta instanceof ContaCorrente) {
                if (((ContaCorrente) conta).usandoLimite()) {
                    dados.append(conta.imprimir()).append("\n");
                }
            }
        }

        if (!dados.toString().isEmpty()) {
            return dados.toString();
        } else {
            return "Nenhum cliente localizado.";
        }

    }

    public Conta buscarConta(int numeroConta) {
        if (contas.size() > 0) {
            for (Conta conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    return conta;
                }
            }
        }
        return null;

    }

    public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor) {

        int validation = 0;
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroContaFonte || conta.getNumeroConta() == numeroContaDestino) {
                validation++;
            }
        }
        if (validation == 2) {
            if (sacar(numeroContaFonte, valor)) {
                return depositar(numeroContaDestino, valor);
            }
        }

        return false;
    }

    public boolean sacar(int numeroConta, double valorSacado) {

        if (valorSacado > 0) {
            for (Conta conta : contas) {

                if (conta.getNumeroConta() == numeroConta) {
                    if (conta.getSaldo() >= valorSacado) {
                        conta.sacar(valorSacado);
                        return true;
                    } else {
                        return false;
                    }
                }

            }
        } else {
            return false;
        }

        return false;
    }

    public boolean depositar(int numeroConta, double valorDepositado) {

        if (valorDepositado > 0) {
            for (Conta conta : contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    conta.depositar(valorDepositado);
                    return true;
                }
            }
        } else {
            return false;
        }

        return false;

    }

    public String listarContas() {
        StringBuilder dadosContas = new StringBuilder();

        for (Conta conta : contas) {
            dadosContas.append(conta.imprimir()).append("\n");
        }

        if (!dadosContas.toString().isEmpty()) {
            return dadosContas.toString();
        } else {
            return "Nenhuma conta localizada.";
        }
    }

}
