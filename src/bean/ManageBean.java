package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;

@ManagedBean(name = "bean", eager = true)
@RequestScoped
public class ManageBean {
	
	private Category c;
	
	@PersistenceContext
	EntityManager em;

	public Category getCategory(int id){
		return em.find(Category.class, id);
	}
	
	public void setCategory(){
		em.persist(c);
	}
}
