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

        if (valorSacado > 0 && getSaldo() > 0) {

            double tempSaldo = getSaldo() - valorSacado;

            if (tempSaldo < 0) {
                if (getLimite() >= getSaldo()) {
                    setSaldo(tempSaldo);
                    setLimite(getLimite() + getSaldo());
                    return true;
                } else {
                    return false;
                }
            } else {
                setSaldo(tempSaldo);
                return true;
            }


        } else {
            if (getLimite() >= valorSacado) {
                setLimite(getLimite() - valorSacado);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean usandoLimite() {
        if (getSaldo() < 0) {
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
