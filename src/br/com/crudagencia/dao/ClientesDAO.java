package br.com.crudagencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crudagencia.factory.ConnectionFactory;
import br.com.crudagencia.model.Clientes;


public class ClientesDAO {
	public void save(Clientes clientes) {
		
		String sql = "INSERT INTO clientes(nomeCliente,dataNascimento,cpf,email)" + "VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getNomeCliente());
			pstm.setString(2, clientes.getDataNascimento());
			pstm.setString(3, clientes.getCpf());
			pstm.setString(4, clientes.getEmail());

			pstm.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
				
				}
			}
		}

	public void removeById(int clienteId) {
		
		String sql = "DELETE FROM clientes WHERE clienteId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, clienteId);
			pstm.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
		
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Clientes clientes) {
		
		String sql = "UPDATE clientes SET nomeCliente = ?,dataNascimento = ?, cpf = ?, email = ?" +
		" WHERE clienteId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, clientes.getNomeCliente());
			pstm.setString(2, clientes.getDataNascimento());
			pstm.setString(3, clientes.getCpf());
			pstm.setString(4, clientes.getEmail());
			pstm.setInt(5, clientes.getClienteId());
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null ) {
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Clientes> getClientes(){
		String sql = "SELECT * FROM clientes";
		
		List<Clientes> clientesList = new ArrayList<Clientes>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Clientes clientes = new Clientes();
				
				clientes.setClienteId(rset.getInt("clienteId"));
				clientes.setNomeCliente(rset.getString("nomeCliente"));
				clientes.setDataNascimento(rset.getString("dataNascimento"));
				clientes.setCpf(rset.getString("cpf"));
				clientes.setEmail(rset.getString("email"));
				
				clientesList.add(clientes);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();	
				}
				if(conn != null){
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return clientesList;
	}

	}

