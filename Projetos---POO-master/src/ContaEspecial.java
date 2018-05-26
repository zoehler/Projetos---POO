public class ContaEspecial extends ContaCorrente{

    private String nomeGerente;

    public ContaEspecial(String numeroConta, String nomeCliente, String cpfCliente, String nomeGerente){
        super(numeroConta, nomeCliente, cpfCliente);
        setNomeGerente(nomeGerente);
    }

    public ContaEspecial(String numeroConta, String nomeCliente, String cpfCliente, String nomeGerente, double limite){
        super(numeroConta, nomeCliente, cpfCliente);
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
