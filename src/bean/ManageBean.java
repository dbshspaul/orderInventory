package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Category;

@ManagedBean(name = "bean", eager = true)
@RequestScoped
public class ManageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@EJB
	bean.EJB ejb;
	private Category cat;
	

	public Category getCategory(int id){
		return ejb.getCategory(id);
	}
	
	public List<Category> getAllData(){
		return ejb.getAllData();
	}
	
	public void setCategory(){
		ejb.setCategory(getCat());
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}
	
}
