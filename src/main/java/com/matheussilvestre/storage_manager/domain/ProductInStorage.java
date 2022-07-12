package com.matheussilvestre.storage_manager.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_in_storage")
public class ProductInStorage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String storage_id;
	private String product_id;
	private int product_quantity;
	private double product_value;
	private double total_value;
	
	
	public ProductInStorage() {}


	public ProductInStorage(String id, Storage storage, Product product, int product_quantity) {
		super();
		this.id = id;
		this.storage_id = storage.getId();
		this.product_id = product.getId();
		this.product_quantity = product_quantity;
		this.product_value = product.getValue();
		this.total_value = this.product_quantity * this.product_value;
	}

	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getStorage_id() {
		return storage_id;
	}


	public void setStorage_id(String storage_id) {
		this.storage_id = storage_id;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public int getProduct_quantity() {
		return product_quantity;
	}


	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}


	public double getProduct_value() {
		return product_value;
	}


	public void setProduct_value(double product_value) {
		this.product_value = product_value;
	}


	public double getTotal_value() {
		return total_value;
	}


	public void setTotal_value(double total_value) {
		this.total_value = total_value;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInStorage other = (ProductInStorage) obj;
		if (product_id == null) {
			if (other.product_id != null)
				return false;
		} else if (!product_id.equals(other.product_id))
			return false;
		return true;
	}
	
	
	
}
