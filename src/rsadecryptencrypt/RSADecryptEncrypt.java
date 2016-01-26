/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsadecryptencrypt;

import decrypt.Decrypt;
import encrypt.Encrypt;
import java.util.Scanner;

/**
 *
 * @author danieljunior
 */
public class RSADecryptEncrypt {

    /**
     * @param args the command line arguments
     */
    public static int INPUT_FILE = 0;
    public static int OUTPUT_FILE = 1;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        int option, e, d;
        //tem 16 bits e vale como um unsigned short 0-65535
        char n;
        String[] files;
        do {
            System.out.println("Escolha a operação realizada:");
            System.out.println("1- Cifrar\n2- Decifrar\n0- Sair");
            option = in.nextInt();
            in.nextLine();
            switch (option) {
                case 0:
                    run = false;
                    break;
                case 1:
                    files = getFilesNames();
                    System.out.println("Digite o valor de n:");
                    n = (char) in.nextInt();
                    System.out.println("Digite o valor de e");
                    e = in.nextInt();
                    in.nextLine();
                    Encrypt encrypter = new Encrypt(files[INPUT_FILE], files[OUTPUT_FILE], n, e);
                    encrypter.encrypt();
                    break;
                case 2:
                    files = getFilesNames();
                    System.out.println("Digite o valor de n:");
                    n = (char) in.nextInt();
                    System.out.println("Digite o valor de d");
                    d = in.nextInt();
                    in.nextLine();
                    Decrypt decrypter = new Decrypt(files[INPUT_FILE], files[OUTPUT_FILE], n, d);
                    //TODO implementar decifrador
                    decrypter.decrypt();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (run);
        System.out.println("Programa finalizado...");
    }

    private static String[] getFilesNames() {
        System.out.println("Digite o caminho do arquivo de entrada:");
        String input = in.nextLine();
        System.out.println("Digite o caminho do arquivo de saída:");
        String output = in.nextLine();
        return new String[]{input, output};
    }
}
