public class ContaEspecial extends ContaCorrente{

    private String nomeGerente;

    public ContaEspecial(String numeroConta, String nomeCliente, String cpfCliente, String nomeGerente, double saldo){
        super(numeroConta, nomeCliente, cpfCliente, saldo);
        setNomeGerente(nomeGerente);
    }

    public ContaEspecial(String numeroConta, String nomeCliente, String cpfCliente, String nomeGerente, double saldo, double limite){
        super(numeroConta, nomeCliente, cpfCliente, saldo);
        setNomeGerente(nomeGerente);
        setLimite(limite);
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    @Override
    public String imprimir(){
        return super.imprimir() + "\nNome do gerente: " + getNomeGerente();
    }
}
