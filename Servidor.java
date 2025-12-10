import java.io.*;
import java.net.*;

public class Servidor {
    private static final int PORTA = 5050;

    public static void main(String[] args) throws Exception {
        System.out.println("=== SERVIDOR INICIADO - Aguardando conexão na porta " + PORTA + " ===\n");

        ServerSocket serverSocket = new ServerSocket(PORTA, 100);
        Socket conexao = serverSocket.accept();

        System.out.println("Cliente conectado: " + conexao.getInetAddress().getHostAddress() + "\n");

        ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

        String mensagem;
        do {
            mensagem = (String) entrada.readObject();
            System.out.println(mensagem);

            if (!mensagem.contains("SAIR")) {
                System.out.print("SERVER>>> ");
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                String resposta = "SERVER>>> " + teclado.readLine();
                saida.writeObject(resposta);
                saida.flush();
            }
        } while (!mensagem.contains("SAIR"));

        System.out.println("\nConexão encerrada pelo cliente.");
        entrada.close();
        saida.close();
        conexao.close();
        serverSocket.close();
    }
}
