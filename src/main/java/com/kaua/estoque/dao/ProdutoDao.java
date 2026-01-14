package com.kaua.estoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.kaua.estoque.model.Produto;
import com.kaua.estoque.util.ConnectionFactory;

public class ProdutoDao {

	public void save(Produto produto) {
		String sql = "INSERT INTO produto (nome, descricao, preco, quantidade, data_cadastro, ativo) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getQuantidade());
			stmt.setTimestamp(5, Timestamp.valueOf(produto.getDataCadastro()));
			stmt.setBoolean(6, produto.isAtivo());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Produto produto) {
		String sql = "UPDATE produto SET nome =?, descricao=?, preco =?, quantidade=? where id=? ";
		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getPreco());
			stmt.setInt(4, produto.getQuantidade());
			stmt.setInt(5, produto.getId());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void desativar(int id) {
		String sql = "UPDATE produto SET ativo = false where id = ?";
		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Produto> findAll() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM produto Where ativo = true ORDER BY nome";
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setPreco(rs.getDouble("preco"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
				p.setAtivo(rs.getBoolean("ativo"));

				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Produto findById(int id) {
	    String sql = "SELECT * FROM produto WHERE id=?";
	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                Produto p = new Produto();
	                p.setId(rs.getInt("id"));
	                p.setNome(rs.getString("nome"));
	                p.setDescricao(rs.getString("descricao"));
	                p.setPreco(rs.getDouble("preco"));
	                p.setQuantidade(rs.getInt("quantidade"));
	                p.setDataCadastro(rs.getTimestamp("data_cadastro").toLocalDateTime());
	                p.setAtivo(rs.getBoolean("ativo"));
	                return p;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
