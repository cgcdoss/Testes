/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.criptografia.simetrica;

import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author gabri
 */
public class EncriptaDescriptaAES {

    static String IV = "AAAAAAAAAAAAAAAA";
    static String textopuro = "teste texto 12345678";
    static String chaveencriptacao = "0123456789abcdef";

    public static void main(String[] args) {

        try {

            System.out.println("Texto Puro: " + textopuro);

            byte[] textoencriptado = encrypt(textopuro, chaveencriptacao);

            System.out.print("Texto Encriptado: ");

            for (int i = 0; i < textoencriptado.length; i++) {
                System.out.print(new Integer(textoencriptado[i]) + " ");
            }
            byte[] teste = textoencriptado;
//            System.out.println("\n" + Arrays.toString(teste));

//            System.out.println(new String(textoencriptado, "UTF-8"));

            String textodecriptado = decrypt(textoencriptado, chaveencriptacao);

            System.out.println("\nTexto Decriptado: " + textodecriptado);
            
//            System.out.println("teste:\n" + decrypt("Pg=����t�I�7Ɲ|S�-6����õ8".getBytes(), chaveencriptacao));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }

    public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception {
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado), "UTF-8");
    }

}
