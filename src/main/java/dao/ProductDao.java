package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import util.ConnectionFactory;

public class ProductDao {

	public boolean save(Product product) {
		String sql = "INSERT INTO product (name, category, model, price, quantity, created_at, in_stock) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.setString(1, product.getName());
			stmt.setString(2, product.getCategory());
			stmt.setString(3, product.getModel());
			stmt.setDouble(4, product.getPrice());
			stmt.setInt(5, product.getQuantity());
			stmt.setTimestamp(6, Timestamp.valueOf(product.getCreatedAt()));
			stmt.setBoolean(7, product.isInStock());

			int linhasAfetadas = stmt.executeUpdate();
			
			if(linhasAfetadas > 0) {
				return true;
			}
					
		} catch (SQLException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Product product) {
		String sql = "UPDATE product SET name =?, category=?, model=?, price =?, quantity=?, in_stock = ? where id=? ";
		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getCategory());
			stmt.setString(3, product.getModel());
			stmt.setDouble(4, product.getPrice());
			stmt.setInt(5, product.getQuantity());
			stmt.setBoolean(6, product.isInStock());
			stmt.setInt(7, product.getId());

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void delete(int id) {
		String sql = "DELETE FROM product WHERE id = ?";
		try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Product> findAll() {		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();
		String sql = "SELECT * FROM product";
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setModel(rs.getString("model"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("quantity"));
				LocalDateTime data = rs.getTimestamp("created_at").toLocalDateTime();
				p.setCreatedAt(data);
				p.setFormattedDate(data.format(formatter));
				p.setInStock(rs.getBoolean("in_stock"));

				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product findById(int id) {
	    String sql = "SELECT * FROM product WHERE id=?";
	    try (Connection con = ConnectionFactory.getConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	            	Product p = new Product();
	                p.setId(rs.getInt("id"));
	                p.setName(rs.getString("name"));
	                p.setCategory(rs.getString("category"));
	                p.setModel(rs.getString("model"));
	                p.setPrice(rs.getDouble("price"));
	                p.setQuantity(rs.getInt("quantity"));
	                p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
	                p.setInStock(rs.getBoolean("in_stock"));
	                return p;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
}
