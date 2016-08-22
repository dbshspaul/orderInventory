package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Category;

@ManagedBean(name = "bean", eager = true)
@ApplicationScoped
public class ManageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Category cate;
	@EJB
	private bean.EJB ejb;

	public List<Category> getAllData() {
		return ejb.getAllData(Category.class);
	}

	public void setCategory(Category cat) {
		try {
			ejb.setData(cat);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "data added susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Message", e.getMessage()));
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

	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

}
