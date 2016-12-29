package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Category;

@FacesConverter(forClass = Category.class, value = "categoryConverter")
public class CategoryConverter implements Converter {

	@EJB
	private bean.EJB ejb;

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		Category category = (Category) fc.getExternalContext().getApplicationMap().get("cate");
		//category=ejb.getDataById(Integer.parseInt(value), Category.class);
		//category.setName("sadsadsadcxvcxvcxv");
		return "sadsadsadcxvcxvcxv";
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		return String.valueOf(((Category) object).getId());

	}

}
