package info.sigmaproject.jat.converters;

import info.sigmaproject.jat.entities.Entity7;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("converters.Entity7Converter")
public class Entity7Converter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
	if (!Entity7.validateString(value)) {
	    FacesMessage msg =
		new FacesMessage("Conversion error.",
				"Invalid format.");
	    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	    throw new ConverterException(msg);
	}
	
	String name = value.split(" ")[1].split(":")[0];
	Integer ident = Integer.parseInt(value.split(" ")[1].split(":")[1]);
	
	return new Entity7(name, ident);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
	if (!(value instanceof Entity7)) return null;
	
	return value.toString();
    }
    
}
