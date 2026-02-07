package ac4y.base.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ac4yObjectList extends Ac4yNoId {
	
	public Ac4yObjectList() {
		setAc4yObject(new ArrayList<Ac4yObject>());
	}
	
	protected List<Ac4yObject> ac4yObject;

	public List<Ac4yObject> getAc4yObject() {
		return ac4yObject;
	}

	public void setAc4yObject(List<Ac4yObject> ac4yObject) {
		this.ac4yObject = ac4yObject;
	}


}
