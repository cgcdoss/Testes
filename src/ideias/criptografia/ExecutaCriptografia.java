package ideias.criptografia;

public class ExecutaCriptografia {

    public static void main(String[] args) {
        Criptografia crip = new Criptografia();
        crip.criptografa();
        crip.descriptografa(crip.getCripto());
    }
}
