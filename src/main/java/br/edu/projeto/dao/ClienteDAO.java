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
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setNome_social(rs.getString("nome_social"));
				u.setCpf(rs.getString("cpf"));
				u.setAltura(rs.getFloat("altura"));
				u.setMassa(rs.getFloat("massa"));
				u.setGenero(rs.getString("genero"));
				u.setIdade(rs.getInt("idade"));
				u.setTelefone(rs.getString("telefone"));
				u.setCelular(rs.getString("celular"));
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
    	Connection con = null;//Conexão com a base
    	PreparedStatement ps = null;//Instrução SQL
    	ResultSet rs = null;//Resposta do SGBD
    	try {
			con = this.ds.getConnection();//Pegar um conexão
			ps = con.prepareStatement("SELECT * FROM clientes WHERE nome = ?");
			ps.setString(1, nome);
			rs = ps.executeQuery();
			while (rs.next()) {//Pega próxima linha do retorno
				Cliente c = new Cliente();
				c.setId_clientes(rs.getInt("id_clientes"));
				c.setEmail(rs.getString("email"));
				c.setNome(rs.getString("nome"));
				c.setNome_social(rs.getString("nome_social"));
				c.setCpf(rs.getString("cpf"));
				c.setAltura(rs.getFloat("altura"));
				c.setMassa(rs.getFloat("massa"));
				c.setGenero(rs.getString("genero"));
				c.setIdade(rs.getInt("idade"));
				c.setTelefone(rs.getString("telefone"));
				c.setCelular(rs.getString("celular"));
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
			ps = con.prepareStatement("SELECT id_clientes, nome, email FROM clientes");
			rs = ps.executeQuery();
			while (rs.next()) {
				Cliente u = new Cliente();
				u.setId_clientes(rs.getInt("id_clientes"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
				u.setNome_social(rs.getString("nome_social"));
				u.setCpf(rs.getString("cpf"));
				u.setAltura(rs.getFloat("altura"));
				u.setMassa(rs.getFloat("massa"));
				u.setGenero(rs.getString("genero"));
				u.setIdade(rs.getInt("idade"));
				u.setTelefone(rs.getString("telefone"));
				u.setCelular(rs.getString("celular"));
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
				ps = con.prepareStatement("INSERT INTO clientes (nome,nome_social,idade,massa,altura,genero"
						+ ", email, senha, cpf, celular, telefone, endereco)"
						+ " VALUES (?, ?, ?) RETURNING id_clientes");
				ps.setString(1, u.getNome());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getNome_social());
				ps.setInt(4, u.getId_clientes());
				ps.setInt(5, u.getIdade());
				ps.setFloat(6, u.getMassa());
				ps.setFloat(7, u.getAltura());
				ps.setString(8, u.getEndereco());
				ps.setString(9, u.getCpf());
				ps.setString(10, u.getSenha());
				ps.setString(11, u.getTelefone());
				ps.setString(12, u.getCelular());
				ps.setString(13, u.getGenero());	
				
				rs = ps.executeQuery();
				rs.next();
				u.setId_clientes(rs.getInt("id_clientes"));
				
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
				ps = con.prepareStatement("UPDATE clientes SET celular = ? ,"
						+ "telefone = ? ,cpf = ? ,"
						+ "endereco = ? ,genero= ? ,nome = ?,"
						+ "  nome_social = ?,  email = ?, senha = ?, idade = ?,"
						+ "massa = ? , altura = ?  WHERE id_clientes = ?");
				ps.setString(1, u.getNome());
				ps.setString(2, u.getEmail());
				ps.setString(3, u.getNome_social());
				ps.setInt(4, u.getId_clientes());
				ps.setInt(5, u.getIdade());
				ps.setFloat(6, u.getMassa());
				ps.setFloat(7, u.getAltura());
				ps.setString(8, u.getEndereco());
				ps.setString(9, u.getCpf());
				ps.setString(10, u.getSenha());
				ps.setString(11, u.getTelefone());
				ps.setString(12, u.getCelular());
				ps.setString(13, u.getGenero());				
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
