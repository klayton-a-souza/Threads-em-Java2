package br.com.alura.cliente.teste;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class EnviandoComando implements Runnable {

	private Socket socket;

	public EnviandoComando(Socket socket) {
		this.socket = socket;
	}

	@Override
    public void run() {

        try {
            System.out.println("Pode enviar comandos!");
            PrintStream saida = new PrintStream(socket.getOutputStream());

            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()) {

                String linha = teclado.nextLine();

                if (linha.trim().equals("")) {
                    break;
                }

                saida.println(linha);
            }

            saida.close();
            teclado.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
