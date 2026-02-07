package ac4y.base.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ac4yIdentificationList extends Ac4yNoId {
	
	public Ac4yIdentificationList() {
		setAc4yIdentification(new ArrayList<Ac4yIdentification>());
	}
	
	protected List<Ac4yIdentification> ac4yIdentification;

	public List<Ac4yIdentification> getAc4yIdentification() {
		return ac4yIdentification;
	}

	public void setAc4yIdentification(List<Ac4yIdentification> ac4yIdentification) {
		this.ac4yIdentification = ac4yIdentification;
	}




}
