package com.kurtas.designerkurtas.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class CategoryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ctid;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categorydetails")
	private Collection<ProductDetails> pdt = new ArrayList<ProductDetails>();

	public Collection<ProductDetails> getPdt() {
		return pdt;
	}

	public void setPdt(Collection<ProductDetails> pdt) {
		this.pdt = pdt;
	}

	@NotEmpty(message = "It should not be empty ")

	private String ctName;
	@NotEmpty(message = "It should not be empty ")

	private String ctDescription;

	public int getCtid() {
		return ctid;
	}

	public void setCtid(int ctid) {
		this.ctid = ctid;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public String getCtDescription() {
		return ctDescription;
	}

	public void setCtDescription(String ctDescription) {
		this.ctDescription = ctDescription;
	}

}
