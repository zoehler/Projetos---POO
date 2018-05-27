import java.util.ArrayList;

public class gerenciarContas {

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

        for (int i = 0; i < contas.size(); i++) {

            if (contas.get(i).getClass().equals(ContaEspecial.class)) {

                dados.append("\nConta ").append(i).append(":\n").append(contas.get(i).imprimir());

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
        for (int i = 0; i <= contas.size(); i++) {
            if (contas.get(i).getNumeroConta() == numeroConta) {
                return contas.get(i);
            }
        }
        return null;
    }

    public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor) {

        int val = 0;
        for (int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumeroConta() == numeroContaFonte || contas.get(i).getNumeroConta() == numeroContaDestino) val++;
        }
        if(val == 2) {
            if (sacar(numeroContaFonte, valor)) {
                return depositar(numeroContaDestino, valor);
            }
        }

        return false;
    }
    
    public boolean sacar(int numeroConta, double valorSacado) {

        if (valorSacado > 0) {
            for (int i = 0; i <= contas.size(); i++) {
                if (contas.get(i).getNumeroConta() == valorSacado) {
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


}
