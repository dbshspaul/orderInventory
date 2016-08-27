package model;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ManagedBean
@ApplicationScoped
@Entity
public class Product {

	@Id
	private int id;
	private String name;
	@Column(length = 2000)
	private String description;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		System.out.println("catid: " + category.getId());
		this.category = category;
	}
}
