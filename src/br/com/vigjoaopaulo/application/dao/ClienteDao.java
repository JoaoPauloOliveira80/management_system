package br.com.vigjoaopaulo.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.vigjoaopaulo.application.connection.ConexaoMSQL;
import br.com.vigjoaopaulo.application.model.Cliente;
import br.com.vigjoaopaulo.application.model.Contato;

public class ClienteDao {

	public static List<Cliente> getCliente() throws SQLException {

		String sql = "Select * from customers";
		List<Cliente> listaCliente = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;

		// RECUPERA DADOS DO BANCO
		ResultSet rs = null;

		try {

			conn = ConexaoMSQL.conectar();
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {
				Cliente cli = new Cliente();
				// RECUPERAR ID
				cli.setCustomer_id(rs.getInt("customer_id"));
				cli.setName(rs.getString("name"));
				cli.setLast_name(rs.getString("last_name"));
				cli.setPhone_number(rs.getString("phone_number"));
				cli.setIs_whatsapp(rs.getBoolean("is_whatsapp"));

				listaCliente.add(cli);
			}

			for (Cliente cliente : listaCliente) {

				if (listaCliente != null || listaCliente.size() > 0) {
					System.out.println(cliente);
					System.out.println();
				} else {

					System.out.println("Não há registro no banco");

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listaCliente;

	}

	public void save(Cliente cliente) {

		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		 * de dados
		 * 
		 * cli.setCustomer_id(rs.getInt("customer_id"));
		 * cli.setName(rs.getString("name"));
		 * cli.setLast_name(rs.getString("last_name"));
		 * cli.setPhone_number(rs.getString("phone_number"));
		 * cli.setIs_whatsapp(rs.getBoolean("is_whatsapp"));
		 */

		String sql = "INSERT INTO customers(name,last_name,phone_number,is_whatsapp)" + " VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConexaoMSQL.conectar();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cliente.getName());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cliente.getLast_name());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, cliente.getPhone_number());

			// Adiciona o valor do quarto parâmetro da sql
			pstm.setBoolean(4, cliente.isIs_whatsapp());
			// Executa a sql para inserção dos dados
			pstm.execute();
			System.out.println("Cliente salvo com sucesso...");
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public static void update(Cliente cli) throws SQLException {
		String sql = "update customers set name= ?, last_name= ?, phone_number= ?, is_whatsapp= ? where  customer_id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// cria conexao com banco
			conn = ConexaoMSQL.conectar();

			// cria classe para execuça
			pstm = conn.prepareStatement(sql);

			// adicionar valores pra atualizar
			pstm.setString(1, cli.getName());
			pstm.setString(2, cli.getLast_name());
			pstm.setString(3, cli.getPhone_number());
			pstm.setBoolean(4, cli.isIs_whatsapp());
			pstm.setInt(5, cli.getCustomer_id());

			pstm.execute();

			System.out.println("Cliente atualizado com sucesso");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	
	public static void deleteById(int id) {
		String sql = "DELETE FROM customers WHERE customer_id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConexaoMSQL.conectar();

			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			System.out.println("Deletado com sucesso...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
