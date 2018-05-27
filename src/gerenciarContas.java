import java.util.ArrayList;

public class GerenciarContas {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta c) {

        boolean validation = false;
        int maior = 0;
        for (Conta conta : contas) {
            validation = conta.getNumeroConta() == c.getNumeroConta();
            if (conta.getNumeroConta() > maior) maior = conta.getNumeroConta();
        }
        if (validation) {
            contas.add(c);
        }

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
            if (conta.getClass().equals(ContaEspecial.class)) {
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

        for (int i = 0; i < contas.size(); i++) {

            if (contas.get(i).getClass().equals(ContaCorrente.class)) {
                ContaCorrente cCorrente = (ContaCorrente) contas.get(i);
                if (cCorrente.usandoLimite()) {
                    dados.append("\nConta ").append(i).append(":\n").append(contas.get(i).imprimir());
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
            for (int i = 0; i <= contas.size(); i++) {

                if (contas.get(i).getNumeroConta() == numeroConta) {
                    if (contas.get(i).getSaldo() >= valorSacado) {
                        contas.get(i).sacar(valorSacado);
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

    public boolean depositar(int numeroConta, double valorSacado) {

        if (valorSacado > 0) {
            for (int i = 0; i <= contas.size(); i++) {
                if (contas.get(i).getNumeroConta() == numeroConta) {
                    contas.get(i).depositar(valorSacado);
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
        for (int i = 0; i <= contas.size(); i++) {
            dadosContas.append(contas.get(i).imprimir()).append("\n");
        }

        if (!dadosContas.toString().isEmpty()) {
            return dadosContas.toString();
        } else {
            return "Nenhuma conta localizada.";
        }
    }

}
