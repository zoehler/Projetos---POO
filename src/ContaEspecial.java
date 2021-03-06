public class ContaEspecial extends ContaCorrente {

    private String nomeGerente;

    public ContaEspecial(int numeroConta, String nomeCliente, String cpfCliente, String nomeGerente) {
        super(numeroConta, nomeCliente, cpfCliente);
        setNomeGerente(nomeGerente);
    }

    public ContaEspecial(int numeroConta, String nomeCliente, String cpfCliente, double limite, String nomeGerente) {
        super(numeroConta, nomeCliente, cpfCliente, limite);
        setNomeGerente(nomeGerente);
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nNome do gerente: " + getNomeGerente();
    }
}
