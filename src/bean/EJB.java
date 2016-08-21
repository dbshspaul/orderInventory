package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Category;

@Stateless
public class EJB {

	@PersistenceContext
	private EntityManager em;
	
	public Category getCategory(int id){
		return em.find(Category.class, id);
	}
	
	public void setCategory(Category c){		
		em.persist(c);
	}
	
	public List<Category> getAllData(){
		return em.createQuery("select c from Category c",Category.class ).getResultList();
	}
}
