package bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EJB {

	@PersistenceContext
	private EntityManager em;

	///////////////// common methode form all entity
	///////////////// classes///////////////////////////////
	public <T> T getDataById(int id, Class<T> t) {
		return em.find(t, id);
	}

	public <T> List<T> getAllData(Class<T> t) {
		return em.createQuery("select c from " + t.getCanonicalName() + " c", t).getResultList();
	}

	public <T> void setData(T obj) {
		em.persist(obj);
	}

	public <T> void updateData(T obj) {
		em.merge(obj);
	}

	public <T> void deleteData(int id, Class<T> t) {
		em.remove(getDataById(id, t));
	}

	///////////////// END of common methode form all entity
	///////////////// classes///////////////////////////////
}
