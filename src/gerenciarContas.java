import java.util.ArrayList;

public class GerenciarContas {

    private ArrayList<Conta> contas = new ArrayList<>();

    public String buscarContasEspeciais() {

        StringBuilder dados = new StringBuilder();

        for (int i = 0; i < contas.size(); i++) {

            if(contas.get(i).getClass().equals(ContaEspecial.class)){
                dados.append("\nConta ").append(i).append(":\n").append(contas.get(i).imprimir());
            }

        }

        if(!dados.toString().isEmpty()) {
            return dados.toString();
        } else {
            return "Nenhuma conta especial localizada.";
        }

    }


    public String buscarClientesUsandoLimite() {
        StringBuilder dados = new StringBuilder();

        for (int i = 0; i < contas.size(); i++) {

            if(contas.get(i).getClass().equals(ContaCorrente.class)){

                dados.append("\nConta ").append(i).append(":\n").append(contas.get(i).imprimir());
            }

        }

        if(!dados.toString().isEmpty()) {
            return dados.toString();
        } else {
            return "Nenhum cliente localizada.";
        }

    }

}
