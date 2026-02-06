package ac4y.base.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A container class for managing a list of {@link Ac4yIdentification} instances.
 * <p>
 * This class provides a JAXB-compatible wrapper for a list of Ac4yIdentification items,
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
public class Ac4yIdentificationList extends Ac4yNoID {


	/**
	 * Constructs a new Ac4yIdentificationList with an empty ArrayList.
	 * <p>
	 * The list is initialized as an empty {@link ArrayList} ready to accept
	 * {@link Ac4yIdentification} instances.
	 * </p>
	 */
	public Ac4yIdentificationList() {
		setAc4yIdentification(new ArrayList<Ac4yIdentification>());
	}

	/**
	 * The internal list containing Ac4yIdentification instances.
	 * <p>
	 * This field is declared protected to allow subclass access while maintaining
	 * encapsulation from external classes.
	 * </p>
	 */
	protected List<Ac4yIdentification> ac4yIdentification;

	/**
	 * Returns the list of Ac4yIdentification instances.
	 *
	 * @return the list of {@link Ac4yIdentification} instances, may be empty but typically not null
	 */
	public List<Ac4yIdentification> getAc4yIdentification() {
		return ac4yIdentification;
	}

	/**
	 * Sets the list of Ac4yIdentification instances.
	 * <p>
	 * This method replaces the current list reference with the provided list.
	 * No defensive copying is performed, so modifications to the provided list
	 * will be reflected in this container.
	 * </p>

	 * @param ac4yIdentification the list of {@link Ac4yIdentification} instances to set
	 */
	public void setAc4yIdentification(List<Ac4yIdentification> ac4yIdentification) {
		this.ac4yIdentification = ac4yIdentification;
	}




}
