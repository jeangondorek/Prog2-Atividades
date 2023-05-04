package br.edu.projeto.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.sql.DataSource;

import br.edu.projeto.model.Camiseta;
import br.edu.projeto.model.Cliente;
import br.edu.projeto.util.DbUtil;

@Stateful
public class ClienteDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private DataSource ds;
	
    public Cliente findById(Integer id_clientes) {
    	Cliente u = new Cliente();
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			con = this.ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM clientes WHERE id_clientes = ?");
			ps.setInt(1, id_clientes);
			rs = ps.executeQuery();
			if (rs.next()) {
				u.setId_clientes(rs.getInt("id_clientes"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setCpf(rs.getInt("cpf"));
				u.setNome_social(rs.getString("nome_social"));
				u.setIdade(rs.getInt("idade"));
				u.setAltura(rs.getFloat("altura"));
				u.setMassa(rs.getInt("massa"));
				u.setGenero(rs.getString("genero"));
				
				u.setTelefone(rs.getInt("telefone"));
				u.setCelular(rs.getInt("celular"));
				u.setEndereco(rs.getString("endereco"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closeConnection(con);
		}
        return u;
    }
    
    public List<Cliente> listByNome(String nome) {
    	List<Cliente> cliente = new ArrayList<Cliente>();
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			con = this.ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM clientes WHERE nome = ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId_clientes(rs.getInt("id_clientes"));
				
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setCpf(rs.getInt("cpf"));
				c.setNome_social(rs.getString("nome_social"));
				c.setIdade(rs.getInt("idade"));
				c.setAltura(rs.getFloat("altura"));
				c.setMassa(rs.getInt("massa"));
				c.setGenero(rs.getString("genero"));
				
				c.setTelefone(rs.getInt("telefone"));
				c.setCelular(rs.getInt("celular"));
				c.setEndereco(rs.getString("endereco"));
				cliente.add(c);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closeConnection(con);
		}
        return cliente;
    }
    
    public List<Cliente> listAll() {
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try {
			con = this.ds.getConnection();
			ps = con.prepareStatement("SELECT * FROM clientes");
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente u = new Cliente();
				u.setId_clientes(rs.getInt("id_clientes"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setCpf(rs.getInt("cpf"));
				u.setNome_social(rs.getString("nome_social"));
				u.setIdade(rs.getInt("idade"));
				u.setAltura(rs.getFloat("altura"));
				u.setMassa(rs.getInt("massa"));
				u.setGenero(rs.getString("genero"));
				
				u.setTelefone(rs.getInt("telefone"));
				u.setCelular(rs.getInt("celular"));
				u.setEndereco(rs.getString("endereco"));
				clientes.add(u);
			}
			con.close();
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closeConnection(con);
		}
        return clientes;
    }
    
    
   public Boolean insert(Cliente u) {
   	Boolean resultado = false;
   	Connection con = null;
   	PreparedStatement ps = null;
   	PreparedStatement ps2 = null;
   	ResultSet rs = null;
   	try {
	    	con = this.ds.getConnection();
	    	con.setAutoCommit(false);
	    	try {				
				ps = con.prepareStatement("INSERT INTO clientes (id_clientes,nome,email,cpf,nome_social,idade,altura,massa,genero, telefone,celular, endereco) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, u.getId_clientes());
				ps.setString(2, u.getNome());
				ps.setString(3, u.getEmail());
				ps.setInt(4, u.getCpf());
				ps.setString(5, u.getNome_social());
				
				ps.setInt(6, u.getIdade());
				ps.setFloat(7, u.getAltura());
				ps.setInt(8, u.getMassa());
				
				
				
				ps.setString(9, u.getGenero());
				ps.setInt(10, u.getTelefone());
				ps.setInt(11, u.getCelular());
				
				ps.setString(12, u.getEndereco());
				
				ps.execute();
				resultado = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
   	} catch (SQLException e) {e.printStackTrace();
   	} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closePreparedStatement(ps2);
			DbUtil.closeConnection(con);
		}
   	return resultado;
   }
   
   public Boolean update(Cliente u) {
   	Boolean resultado = false;
   	Connection con = null;
   	PreparedStatement ps = null;
   	PreparedStatement ps2 = null;
   	PreparedStatement ps3 = null;
   	ResultSet rs = null;
   	try {
	    	con = this.ds.getConnection();
	    	con.setAutoCommit(false);
	    	try {				
				ps = con.prepareStatement("UPDATE clientes SET nome = ? ,id_clientes = ?,"
						+ "email = ? ,cpf = ? ,"
						+ "nome_social = ? ,idade= ? ,altura = ?,"
						+ "  massa = ?,  genero = ?, telefone = ?,"
						+ "celular = ? , endereco = ?  WHERE id_clientes = ?");
				ps.setInt(1, u.getId_clientes());
				ps.setString(2, u.getNome());
				ps.setString(3, u.getEmail());
				ps.setInt(4, u.getCpf());
				ps.setString(5, u.getNome_social());
				
				ps.setInt(6, u.getIdade());
				ps.setFloat(7, u.getAltura());
				ps.setInt(8, u.getMassa());
				
				
				
				ps.setString(9, u.getGenero());
				ps.setInt(10, u.getTelefone());
				ps.setInt(11, u.getCelular());
				
				ps.setString(12, u.getEndereco());				
				ps.execute();	
				
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
   	} catch (SQLException e) {e.printStackTrace();
   	} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closePreparedStatement(ps2);
			DbUtil.closePreparedStatement(ps3);
			DbUtil.closeConnection(con);
		}
   	return resultado;
   }
    
    public Boolean delete(Cliente u) {
    	Boolean resultado = false;
    	Connection con = null;
    	PreparedStatement ps = null;
    	PreparedStatement ps2 = null;
    	ResultSet rs = null;
    	try {
	    	con = this.ds.getConnection();
	    	con.setAutoCommit(false);
	    	try {				
				ps2 = con.prepareStatement("DELETE FROM clientes WHERE id_clientes = ?");
				ps2.setInt(1, u.getId_clientes());
				ps2.execute();
				
				con.commit();
				resultado = true;
			} catch (SQLException e) {
				e.printStackTrace();
				con.rollback();
			}
    	} catch (SQLException e) {e.printStackTrace();
    	} finally {
			DbUtil.closeResultSet(rs);
			DbUtil.closePreparedStatement(ps);
			DbUtil.closePreparedStatement(ps2);
			DbUtil.closeConnection(con);
		}
    	return resultado;
    }
}
