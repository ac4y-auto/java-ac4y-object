package ac4y.base.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A container class for managing a list of {@link Ac4yObject} instances.
 * <p>
 * This class provides a JAXB-compatible wrapper for a list of Ac4yObject items,
 * enabling XML serialization and deserialization through the {@code @XmlRootElement} annotation.
 * It extends {@link Ac4yNoID} as part of the ac4y framework's domain model hierarchy.
 * </p>
 * <p>
 * The internal list is initialized as an empty ArrayList upon construction and can be
 * accessed or replaced via getter and setter methods.
 * </p>
 *
 * @author ac4y
 * @version 2017.0505.1-SNAPSHOT
 * @since 1.0
 */
@XmlRootElement
public class Ac4yObjectList extends Ac4yNoID {

	/**
	 * Constructs a new Ac4yObjectList with an empty ArrayList.
	 * <p>
	 * The list is initialized as an empty {@link ArrayList} ready to accept
	 * {@link Ac4yObject} instances.
	 * </p>
	 */
	public Ac4yObjectList() {
		setAc4yObject(new ArrayList<Ac4yObject>());
	}

	/**
	 * The internal list containing Ac4yObject instances.
	 * <p>
	 * This field is declared protected to allow subclass access while maintaining
	 * encapsulation from external classes.
	 * </p>
	 */
	protected List<Ac4yObject> ac4yObject;

	/**
	 * Returns the list of Ac4yObject instances.
	 *
	 * @return the list of {@link Ac4yObject} instances, may be empty but typically not null
	 */
	public List<Ac4yObject> getAc4yObject() {
		return ac4yObject;
	}

	/**
	 * Sets the list of Ac4yObject instances.
	 * <p>
	 * This method replaces the current list reference with the provided list.
	 * No defensive copying is performed, so modifications to the provided list
	 * will be reflected in this container.
	 * </p>
	 *
	 * @param ac4yObject the list of {@link Ac4yObject} instances to set
	 */
	public void setAc4yObject(List<Ac4yObject> ac4yObject) {
		this.ac4yObject = ac4yObject;
	}


}
