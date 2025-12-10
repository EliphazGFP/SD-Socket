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
        String mensagemEnviada;
        String mensagemRecebida;

        do {
            System.out.print("CLIENT>>> ");
            mensagemEnviada = "CLIENT>>> " + teclado.nextLine();
            saida.writeObject(mensagemEnviada);
            saida.flush();

            // Só lê resposta do servidor se não for a mensagem de saída
            if (!mensagemEnviada.toLowerCase().contains("sair")) {
                mensagemRecebida = (String) entrada.readObject();
                System.out.println(mensagemRecebida);
            }

        } while (!mensagemEnviada.toLowerCase().contains("sair"));

        System.out.println("\nDesconectando do servidor...");
        entrada.close();
        saida.close();
        cliente.close();
    }
}
