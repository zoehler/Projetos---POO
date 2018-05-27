import java.util.ArrayList;

public class gerenciarContas {

    ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta c){
        contas.add(c);
    }

    public boolean removerConta(int numeroConta){
        for (int i=0;i<=contas.size();i++){
            if (contas.get(i).getNumeroConta()==numeroConta){
                contas.remove(i);
                return true;
            }
        }
        return false;
    }


}
