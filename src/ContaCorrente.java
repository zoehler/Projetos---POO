public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(int numeroConta, String nomeCliente, String cpfCliente) {
        super(numeroConta, nomeCliente, cpfCliente);
    }

    public ContaCorrente(int numeroConta, String nomeCliente, String cpfCliente, double limite) {
        super(numeroConta, nomeCliente, cpfCliente);
        setLimite(limite);

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valorSacado) {
        if (valorSacado > 0) {
            if (getSaldo() - valorSacado > (getLimite() * -1)) {
                setSaldo(getSaldo() - valorSacado);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean usandoLimite() {
        return getSaldo() < 0;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nLimite da Conta: " + getLimite();
    }
}
