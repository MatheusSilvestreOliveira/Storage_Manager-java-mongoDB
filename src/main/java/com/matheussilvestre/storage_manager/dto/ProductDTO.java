package com.matheussilvestre.storage_manager.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.matheussilvestre.storage_manager.domain.Category;
import com.matheussilvestre.storage_manager.domain.Product;
import com.matheussilvestre.storage_manager.domain.Storage;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String product_name;
	private String product_brand;
	private double value;
	private Category category;
	private List<Storage> storages = new ArrayList<>();
	
	public ProductDTO() {}
	
	public ProductDTO(Product product) {
		id = product.getId();
		product_name = product.getProduct_name();
		product_brand = product.getProduct_brand();
		value = product.getValue();
		category = product.getCategory();
		storages = product.getStorages();
	}

	

	public List<Storage> getStorages() {
		return storages;
	}

	public void setStorages(List<Storage> storages) {
		this.storages = storages;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_brand() {
		return product_brand;
	}

	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
}
