package model;

import java.time.LocalDateTime;

public class Product {
	private int id;
	private String name;
	private String category;
	private double price;
	private int quantity;
	private LocalDateTime createdAt;
	private boolean inStock;
	private String formattedDate;
	private String model;
	
	public Product() {}
	
	public Product(String name, String category,String model, double price, int quantity) {
		this.name = name;
		this.category = category;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
		this.createdAt = LocalDateTime.now();
		this.inStock = quantity > 0;
	}
	
	public void updateStock() {
		inStock = this.quantity > 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
			this.inStock = inStock;

	}

	public String getFormattedDate() {
		return formattedDate;
	}

	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descripition=" + category + ", price=" + price
				+ ", quantity=" + quantity + ", createdAt=" + createdAt + ", inStock=" + inStock + ", formattedDate="
				+ formattedDate + "]";
	}
	
}
