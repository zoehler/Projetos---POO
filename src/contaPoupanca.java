public class contaPoupanca extends Conta {

    public contaPoupanca(String numeroConta, String nomeCliente, String cpfCliente, double saldo) {
        super(numeroConta, nomeCliente, cpfCliente, saldo);
    }

    public void calcularRendimento(double porcentagemRendimento){
        saldo += saldo*porcentagemRendimento/100;
    }
}
