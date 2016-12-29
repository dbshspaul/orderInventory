package model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@ManagedBean
@RequestScoped
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Column(length = 2000)
	private String description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public boolean equals(Object object) {
		return (object instanceof Category) ? id == (((Category) object).id) : (object == this);
	}

	@Override
	public int hashCode() {
		return (int) ((id != 0) ? (Category.class.hashCode() + id * 31) : super.hashCode());
	}

}
