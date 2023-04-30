package br.com.vigjoaopaulo.application;

import br.com.vigjoaopaulo.application.connection.ConexaoMSQL;

public class Main {
	public static void main(String[] args) {
		ConexaoMSQL.conectar();
	}
}
