package br.com.crudagencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crudagencia.factory.ConnectionFactory;
import br.com.crudagencia.model.Viagens;

public class ViagensDAO {
public void save(Viagens viagens) {
		
		String sql = "INSERT INTO viagens(destino,dataViagem)" + "VALUES(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viagens.getDestino());
			pstm.setString(2, viagens.getDataViagem());
			
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

	public void removeById(int viagemId) {
		
		String sql = "DELETE FROM viagens WHERE viagemId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, viagemId);
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

	public void update(Viagens viagens) {
		
		String sql = "UPDATE viagens SET destino = ?,dataViagem = ?" + "WHERE viagemId = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viagens.getDestino());
			pstm.setString(2, viagens.getDataViagem());
			pstm.setInt(3, viagens.getViagemId());
			
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

	public List<Viagens> getViagens(){
		String sql = "SELECT * FROM viagens";
		
		List<Viagens> viagensList = new ArrayList<Viagens>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnetionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Viagens viagens = new Viagens();				
				
				viagens.setViagemId(rset.getInt("viagemId"));
				viagens.setDestino(rset.getString("destino"));
				viagens.setDataViagem("dataViagem");
				
				viagensList.add(viagens);
				
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
		
		return viagensList;
	}

	
}
