public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroConta, String nomeCliente, String cpfCliente, double saldo) {
        super(numeroConta, nomeCliente, cpfCliente, saldo);
    }

    public void calcularRendimento(double porcentagemRendimento) {
        saldo += saldo * (porcentagemRendimento / 100);
    }

}
