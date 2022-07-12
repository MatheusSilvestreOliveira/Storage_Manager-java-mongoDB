package com.matheussilvestre.storage_manager.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storage")
public class Storage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String storage_unit;
	private String country;
	private String state;
	private String address;
	
	@DBRef(lazy = true)
	private List<Product> products = new ArrayList<>();
	
	public Storage() {}

	public Storage(String id, String storage_unit, String country, String state, String address) {
		super();
		this.id = id;
		this.storage_unit = storage_unit;
		this.country = country;
		this.state = state;
		this.address = address;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStorage_unit() {
		return storage_unit;
	}

	public void setStorage_unit(String storage_unit) {
		this.storage_unit = storage_unit;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Storage other = (Storage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
