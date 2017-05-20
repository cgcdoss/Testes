package ideias.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class Cliente {

    private String nome;
    private int codigo;
    private Date dataNascimento;
    private String nomePai;
    private String nomeMae;
    private String enderecoCompleto;

    public static void mostrarValores(Object obj) {
        try {
            Class clazz = obj.getClass();
            for (Method m : clazz.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Mostrar.class)) {
                    if (m.getParameterTypes().length > 0) {
                        System.err.println(" " + m.getName() + " anotado com @Mostrar de forma errada, ignorando ...");
                        continue;
                    }
                    System.out.println(m.getName() + ": " + m.invoke(obj));
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(1010);
        cliente.setDataNascimento(new Date());
        cliente.setEnderecoCompleto("Rua ABC, Bairro YHU nº 190");
        cliente.setNome("Antonio da Silva Nunes");
        cliente.setNomeMae("Maria da Silva Nunes");
        cliente.setNomePai("Joao da Silva Nunes");

        mostrarValores(cliente);
    }

    @Mostrar
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Mostrar
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Mostrar
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    @Mostrar
    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

}
