package br.com.vigjoaopaulo.application;

import java.sql.SQLException;

import br.com.vigjoaopaulo.application.dao.ClienteDao;
import br.com.vigjoaopaulo.application.model.Cliente;

public class Main {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws SQLException {
		
		ClienteDao dao = new ClienteDao();			
		Cliente cli =  new Cliente();
		
		//salvando cliente
		cli.setName("Dundaki007");
		cli.setLast_name("Teste05555");
		cli.setPhone_number("111122333333");
		cli.setIs_whatsapp(true);
	//	dao.save(cli);
		
		
		//atualiza cliente
		cli.setName("Dundaki0071000");
		cli.setLast_name("Brasil");
		cli.setPhone_number("000000000000");
		cli.setIs_whatsapp(false);
		cli.setCustomer_id(24);
		
		//dao.update(cli);
		
		//Deleta cliente por id
		//dao.deleteById(23);
		
		
		//lsita banco atualizado
		dao.getCliente();
	}
}
