public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numeroConta, String nomeCliente, String cpfCliente) {
        super(numeroConta, nomeCliente, cpfCliente);
    }

    public void calcularRendimento(double porcentagemRendimento) {
        saldo += saldo * (porcentagemRendimento / 100);
    }

}
