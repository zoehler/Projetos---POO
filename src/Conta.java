public abstract class Conta {

    String numeroConta;
    String nomeCliente;
    String cpfCliente;
    double saldo;

    public String getNumeroConta() {
        return numeroConta;
    }

    private void setNumeroConta(String numeroConta) {
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

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(String numeroConta, String nomeCliente, String cpfCliente, double saldo) {
        setNumeroConta(numeroConta);
        setNomeCliente(nomeCliente);
        setCpfCliente(cpfCliente);
        setSaldo(saldo);
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
