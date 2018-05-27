import java.util.ArrayList;

public class GerenciarContas {

    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta c){
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
                if(cCorrente.usandoLimite()) {
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

    public Conta buscarConta(int numeroConta){
        for (int i=0;i<=contas.size();i++){
            if (contas.get(i).getNumeroConta()==numeroConta){
                return contas.get(i);
            }
        }
        return null;
    }

    public boolean transferirValor(int numeroContaFonte, int numeroContaDestino, double valor){
        for (int i=0;i<=contas.size();i++){
            if (contas.get(i).getNumeroConta()==numeroContaFonte){
                if (contas.get(i).getSaldo()>=valor){
                    contas.get(i).sacar(valor);

                    for (i=0;i<=contas.size();i++){
                        if (contas.get(i).getNumeroConta()==numeroContaDestino){
                            contas.get(i).depositar(valor);
                        }
                    }
                }else return false;
            }

        }
        return false;
    }


    public String listarContas(){
        String dadosContas = null;
        for (int i=0;i<=contas.size();i++){
            dadosContas += "Conta: " + contas.get(i).getNumeroConta()
                    +"\nNome do cliente: " + contas.get(i).getNomeCliente()
                    +"\nCPF: " + contas.get(i).getCpfCliente()
                    +"\nSaldo: " + contas.get(i).getSaldo()
                    +"\n";
        }
        return dadosContas;
    }

}
