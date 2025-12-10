import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTA = 5050;

    public static void main(String[] args) throws Exception {
        System.out.println("=== CLIENTE - Conectando ao servidor " + HOST + ":" + PORTA + " ===\n");

        Socket cliente = new Socket(HOST, PORTA);
        System.out.println("Conectado ao servidor!\n");

        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

        Scanner teclado = new Scanner(System.in);
        String mensagemDoServidor;

        do {
            System.out.print("CLIENT>>> ");
            String mensagem = "CLIENT>>> " + teclado.nextLine();
            saida.writeObject(mensagem);
            saida.flush();

            if (!mensagem.contains("sair")) {
                mensagemDoServidor = (String) entrada.readObject();
                System.out.println(mensagemDoServidor);
            }
        } while (!mensagem.toLowerCase().contains("sair"));

        System.out.println("\nDesconectando...");
        entrada.close();
        saida.close();
        cliente.close();
    }
}
