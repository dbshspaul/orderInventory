package bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import model.Category;

@ManagedBean(name = "bean", eager = true)
@RequestScoped
public class ManageBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private bean.EJB ejb;

	

	public List<Category> getAllData() {
		return ejb.getAllData(Category.class);
	}

	public void setCategory(Category cat) {
		try {
			ejb.setData(cat);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","data added susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Message",e.getMessage()));
			e.printStackTrace();
		}
	}
	
	public void updateCategory(RowEditEvent evt) {
		try {
			ejb.updateData((Category)evt.getObject());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success","data updated susccessfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Message",e.getMessage()));
			e.printStackTrace();
		}
	}

}
