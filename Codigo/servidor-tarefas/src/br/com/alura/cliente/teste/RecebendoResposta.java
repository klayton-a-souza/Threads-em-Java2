package br.com.alura.cliente.teste;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RecebendoResposta implements Runnable {

	private Socket socket;

	public RecebendoResposta(Socket socket) {
		this.socket = socket;
	}

	@Override
    public void run() {

        try {
            System.out.println("Recebendo dados do servidor");
            Scanner respostaServidor = new Scanner(socket.getInputStream());

            while (respostaServidor.hasNextLine()) {
                String linha = respostaServidor.nextLine();
                System.out.println(linha);
            }

            respostaServidor.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
