/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package decrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import utils.Exponentiation;

/**
 *
 * @author danieljunior
 */
public class Decrypt {

    String inputFile;
    String outputFile;
    char n;
    int d;

    public Decrypt(String inputFile, String outputFile, char n, int d) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.n = n;
        this.d = d;
    }

    public void decrypt() {
        try (FileReader in = new FileReader(inputFile);Writer out = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")) {
            System.out.println("\n*******************************\nMensagem descriptografada:");
            char c = 0;
            boolean desc = true;
            do {
                // esse read do fileReader lê um caracter sendo um inteiro entre 0 e 65535 (16 bits)
                c = (char) in.read();
                char m = Exponentiation.binaryExponentiation(c, d, n);
                
                if((int) m > 255 && c != 65535){ // abortar execução (texto plano maior que 255)
                    System.out.println("Execução abortada. Arquivo de entrada inválido.\n"
                                      +"Mensagem em texto plano maior que 255.");
                    break;
                }
                
                if(c < 65535){ // se c = 65535 (final do arquivo)
                    System.out.print(m);
                    out.write(m);
                } else {
                   desc = false;
                }

            } while(desc);
            System.out.println("\n*******************************\n");
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo não encontrado!");    
        } catch (IOException ex) {
            System.err.println("Houve um erro na manipulação do arquivo");;
        }
    }
}
