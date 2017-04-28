//@autor: Cássio Gabriel
package ideias.nome;

import javax.swing.JOptionPane;

public class NomeIniciaisMaiusculas {

    public static void main(String[] args) {
        String nome = "";
        String inicial = "";
        String outrasIniciais = "";
        String nomeCompleto = "";
        nome = JOptionPane.showInputDialog(null, "Informe um nome").trim();
        StringBuilder sb = new StringBuilder(nome); //Instanciando o StringBuilder com a string 'nome'
        for (int i = 0; i < nome.length(); i++) { //Verificando cada caractere da string 'nome'
            inicial = nome.substring(0, 1); //Pegando o primeiro caractere da string 'nome'
            inicial = inicial.toUpperCase(); //Deixando a inicial maiúscula
            if (nome.substring(i, i + 1).equals(" ")) { //Verificando se tem espaço
                if (nome.substring(i + 1, i + 4).equals("dos") || nome.substring(i + 1, i + 3).equals("da")) { //Verificando se tem 'dos' ou 'da'...
                    System.out.println("dos ou da encontrado");
                } else {
                    int num = i + 1;
//					System.out.println(num);
                    outrasIniciais = nome.substring(num, num + 1); //Pegando o primeiro caractere da string 'nome' depois do espaço
//					System.out.println(outrasIniciais);
                    outrasIniciais = outrasIniciais.toUpperCase(); //Deixando o caractere maiúsculo
                    sb.replace(num, num + 1, outrasIniciais); //Reposicionando caractere na string 'nome(sb)'
                }
            }
        }
        nomeCompleto = inicial + sb.toString().substring(1);
        System.out.println(nomeCompleto);
        JOptionPane.showMessageDialog(null, "Nome: " + nomeCompleto);
    }
}
