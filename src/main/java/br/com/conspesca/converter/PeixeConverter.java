package br.com.conspesca.converter;

import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.conspesca.model.Peixe;

@FacesConverter("peixeConverter")
public class PeixeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null) {
			return this.getAttributesFrom(component).get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null && !"".equals(value)) {

			Peixe entity = (Peixe) value;

			this.addAttribute(component, entity);

			Integer codigo = entity.getIdPeixe();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;

	}

	protected void addAttribute(UIComponent component, Peixe o) {
		String key = o.getIdPeixe().toString();
		this.getAttributesFrom(component).put(key, o);
	}

	protected Map<String, Object> getAttributesFrom(UIComponent component) {
		return component.getAttributes();
	}

}
