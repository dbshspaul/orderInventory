package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import model.Category;
import model.Product;

@ManagedBean(name = "bean", eager = true)
@ApplicationScoped
public class ManageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{cate}")
	private Category cate;
	private List<Category> cates;
	@ManagedProperty("#{product}")
	private Product product;
	private String testStr;
	@EJB
	private bean.EJB ejb;

	public List<Category> getAllCategories() {
		return ejb.getAllData(Category.class);
	}

	public void setCategory(Category cat) {
		try {
			ejb.setData(cat);
			FacesContext.getCurrentInstance().addMessage("msg",
					new FacesMessage("data added susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("msg", new FacesMessage(e.getMessage()));
			e.printStackTrace();
		}
	}

	public void deleteCategory(Category cat) {
		System.out.println("Id: " + cat.getName());
		try {
			ejb.deleteData(cat.getId(), Category.class);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "data deleted susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message", e.getMessage()));
			e.printStackTrace();
		}
	}

	public void updateCategory(Category ct) {
		try {
			ejb.updateData(ct);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "data updated susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message", e.getMessage()));
			e.printStackTrace();
		}
	}

	public void setNewProduct(Product product) {
		try {			
			ejb.setData(product);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Product created susccessfully"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message", e.getMessage()));
			
		}
	}
	
	public void testfunc(Category cat){
		System.out.println("Method called.");
	}
	

	public List<Product> getAllProducts() {
		return ejb.getAllData(Product.class);
	}

	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}
	
	public List<Category> getCates() {
		return ejb.getAllData(Category.class);
	}

	public void setCates(List<Category> cates) {
		this.cates = cates;
	}

}
