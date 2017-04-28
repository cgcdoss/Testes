package trabalhos;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Inverter {

    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog(null);
        StringBuffer sb = new StringBuffer(text);
        System.out.println("Antes do reverse: " + sb);
        sb.reverse();
        System.out.println("Depois do reverse: " + sb);
        char c = '=';
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == c) {
                int pos = sb.indexOf("=");
                String ult = sb.substring(pos + 1);
                System.out.println(ult);
                Desktop d = Desktop.getDesktop();
                try {
                    d.browse(new URI(ult));
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Inverter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
///1-egap-tnemmoc/841/82/50/3102/moc.sserpdrow.aerroczemogolbap//:sptth=5/29983/avaj-ogidoc-rop-onretxe-amargorp-mu-ramahc-arap-ocaf-ue-omoc/t/rb.moc.jug.www//:ptth