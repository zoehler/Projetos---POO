public abstract class Conta {

    int numeroConta;
    String nomeCliente;
    String cpfCliente;
    double saldo;

    public int getNumeroConta() {
        return numeroConta;
    }

    private void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    private void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(int numeroConta, String nomeCliente, String cpfCliente) {
        setNumeroConta(numeroConta);
        setNomeCliente(nomeCliente);
        setCpfCliente(cpfCliente);
    }


    public boolean sacar(double valorSacado) {

        if(valorSacado <= getSaldo() && valorSacado > 0){
            setSaldo(getSaldo()-valorSacado);
            return true;
        } else {
            return false;
        }

    }


    public boolean depositar(double valorDepositado) {

        if(valorDepositado > 0){
            setSaldo(getSaldo()+valorDepositado);
            return true;
        } else {
            return false;
        }


    }

    public String imprimir() {

        return "\nNum. Conta: " + getNumeroConta()
                + "\nNome: " + getNomeCliente()
                + "\nCPF: " + getCpfCliente()
                + "\nSaldo: " + getSaldo();

    }
}
