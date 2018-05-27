public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(String numeroConta, String nomeCliente, String cpfCliente, double saldo) {
        super(numeroConta, nomeCliente, cpfCliente, saldo);
    }

    public ContaCorrente(double limite, String numeroConta, String nomeCliente, String cpfCliente, double saldo) {
        super(numeroConta, nomeCliente, cpfCliente, saldo);
        setLimite(limite);

    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public boolean sacar(double valorSacado) {

        if (valorSacado <= getLimite() && valorSacado > 0) {
            setLimite(getLimite() - valorSacado);
            return true;
        } else {
            return false;
        }
    }

    public boolean usandoLimite() {
        if (saldo < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nLimite da Conta: " + getLimite();
    }
}
