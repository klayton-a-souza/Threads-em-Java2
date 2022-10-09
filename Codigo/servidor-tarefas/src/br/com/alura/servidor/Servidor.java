package br.com.alura.servidor;

public class Servidor {

	public static void main(String[] args) throws Exception {
		ServidorTarefas servidor = new ServidorTarefas();
        servidor.rodar();
        servidor.parar();
	}

}
