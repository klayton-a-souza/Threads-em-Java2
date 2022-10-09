package br.com.alura.cliente.teste;

import java.net.Socket;

public class ClienteTarefas2 {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 12345);
		System.out.println("Conexao estabelecida");

		Thread threadEnviar = new Thread(new EnviandoComando(socket));
		Thread threadRecebe = new Thread(new RecebendoResposta(socket));

		threadEnviar.start();
		threadRecebe.start();

		threadEnviar.join();

		System.out.println("Fechando o socket do cliente");
		socket.close();
	}

}
