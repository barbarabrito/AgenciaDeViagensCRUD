package br.com.crudagencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crudagencia.factory.ConnectionFactory;
import br.com.crudagencia.model.Compras;

public class ComprasDAO {
public void save(Compras compras) {
		
		String sql = "INSERT INTO compras(clienteId,viagemId)" + "VALUES(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, compras.getClienteId());
			pstm.setInt(2, compras.getViagemId());

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

	public void removeById(int compraId) {
		
		String sql = "DELETE FROM compras WHERE compraId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, compraId);
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

	public void update(Compras compras) {
		
		String sql = "UPDATE compras SET clienteId = ?,viagemId = ?" + "WHERE compraId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, compras.getClienteId());
			pstm.setInt(2, compras.getViagemId());
			pstm.setInt(3, compras.getCompraId());
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

	public List<Compras> getCompras(){
		String sql = "SELECT * FROM compras";
		
		List<Compras> comprasList = new ArrayList<Compras>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Compras compras = new Compras();				
				
				compras.setCompraId(rset.getInt("compraId"));
				compras.setClienteId(rset.getInt("clienteId"));
				compras.setViagemId(rset.getInt("viagemId"));
				
				comprasList.add(compras);
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
		
		return comprasList;
	}
}
