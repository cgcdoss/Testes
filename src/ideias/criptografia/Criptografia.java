package ideias.criptografia;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Criptografia {

    String cripto = "";
    String descripto = "";

    public String getCripto() {
        return cripto;
    }

    public void setCripto(String cripto) {
        this.cripto = cripto;
    }

    public String getDescripto() {
        return descripto;
    }

    public void setDescripto(String descripto) {
        this.descripto = descripto;
    }

    public void criptografa() throws HeadlessException {
        String a = JOptionPane.showInputDialog(null, "Digite sua frase.");
        String b;
        String c = "";
        int i = 0;
        System.out.println("Tamanho de a: " + a.length());
        System.out.println("a: " + a.substring(0));
        while (i < a.length()) {
            b = a.substring(i, i + 1);
            //Números...
            if (b.equals("0")) {
                b = "J6";
            } else if (b.equals("1")) {
                b = "5E";
            } else if (b.equals("2")) {
                b = "7F";
            } else if (b.equals("3")) {
                b = "K2";
            } else if (b.equals("4")) {
                b = "LK";
            } else if (b.equals("5")) {
                b = "90";
            } else if (b.equals("6")) {
                b = "ML";
            } else if (b.equals("7")) {
                b = "AB";
            } else if (b.equals("8")) {
                b = "P7";
            } else if (b.equals("9")) {
                b = "6Y";
            } //Letras...
            else if (b.equals("a") || b.equals("A")) {
                b = "KK";
            } else if (b.equals("b") || b.equals("B")) {
                b = "PO";
            } else if (b.equals("c") || b.equals("C")) {
                b = "FC";
            } else if (b.equals("d") || b.equals("D")) {
                b = "1C";
            } else if (b.equals("e") || b.equals("E")) {
                b = "55";
            } else if (b.equals("f") || b.equals("F")) {
                b = "8A";
            }
            System.out.println("Substring: " + b + " de " + a.substring(i, i + 1));
            i++;
            c += b;
        }
        System.out.println(c);
        JOptionPane.showMessageDialog(null, "Criptografado:\n" + c);
        cripto = c;
        System.out.println("---------------------------");
    }

    public void descriptografa(String cripto) throws HeadlessException {
        cripto = this.cripto;
        String a = cripto;
        String b;
        String c = "";
        int i = 0;
        while (i < a.length()) {
            b = a.substring(i, i + 2);
            if (b.equals("J6")) {
                b = "0";
            } else if (b.equals("5E")) {
                b = "1";
            } else if (b.equals("7F")) {
                b = "2";
            } else if (b.equals("K2")) {
                b = "3";
            } else if (b.equals("LK")) {
                b = "4";
            } else if (b.equals("90")) {
                b = "5";
            } else if (b.equals("ML")) {
                b = "6";
            } else if (b.equals("AB")) {
                b = "7";
            } else if (b.equals("P7")) {
                b = "8";
            } else if (b.equals("6Y")) {
                b = "9";
            } //Letras
            else if (b.equals("KK")) {
                b = "A";
            } else if (b.equals("PO")) {
                b = "B";
            } else if (b.equals("FC")) {
                b = "C";
            }
            i += 2;
            c += b;
        }
        System.out.println(c);
    }
}
