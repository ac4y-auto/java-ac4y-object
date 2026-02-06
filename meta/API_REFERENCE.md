# API Reference

## Package: ac4y.base.domain

### Class: Ac4yObjectList

**Full Name:** `ac4y.base.domain.Ac4yObjectList`
**Extends:** `Ac4yNoID`
**Annotations:** `@XmlRootElement`

#### Description
A JAXB-compatible container class for managing lists of `Ac4yObject` instances. Provides XML serialization support and follows JavaBean conventions.

#### Constructors

##### `public Ac4yObjectList()`
Constructs a new Ac4yObjectList with an empty ArrayList.

**Example:**
```java
Ac4yObjectList list = new Ac4yObjectList();
```

#### Fields

##### `protected List<Ac4yObject> ac4yObject`
The internal list containing Ac4yObject instances. Declared protected to allow subclass access.

#### Methods

##### `public List<Ac4yObject> getAc4yObject()`
Returns the list of Ac4yObject instances.

**Returns:** `List<Ac4yObject>` - The list of Ac4yObject instances, may be empty but typically not null

**Example:**
```java
List<Ac4yObject> objects = list.getAc4yObject();
for (Ac4yObject obj : objects) {
    // Process object
}
```

##### `public void setAc4yObject(List<Ac4yObject> ac4yObject)`
Sets the list of Ac4yObject instances. Replaces the current list reference with the provided list.

**Parameters:**
- `ac4yObject` - The list of Ac4yObject instances to set

**Example:**
```java
List<Ac4yObject> newList = new ArrayList<>();
// Populate newList...
list.setAc4yObject(newList);
```

**Note:** No defensive copying is performed. Modifications to the provided list will be reflected in this container.

---

### Class: Ac4yIdentificationList

**Full Name:** `ac4y.base.domain.Ac4yIdentificationList`
**Extends:** `Ac4yNoID`
**Annotations:** `@XmlRootElement`

#### Description
A JAXB-compatible container class for managing lists of `Ac4yIdentification` instances. Provides XML serialization support and follows JavaBean conventions.

#### Constructors

##### `public Ac4yIdentificationList()`
Constructs a new Ac4yIdentificationList with an empty ArrayList.

**Example:**
```java
Ac4yIdentificationList idList = new Ac4yIdentificationList();
```

#### Fields

##### `protected List<Ac4yIdentification> ac4yIdentification`
The internal list containing Ac4yIdentification instances. Declared protected to allow subclass access.

#### Methods

##### `public List<Ac4yIdentification> getAc4yIdentification()`
Returns the list of Ac4yIdentification instances.

**Returns:** `List<Ac4yIdentification>` - The list of Ac4yIdentification instances, may be empty but typically not null

**Example:**
```java
List<Ac4yIdentification> identifications = idList.getAc4yIdentification();
for (Ac4yIdentification id : identifications) {
    // Process identification
}
```

##### `public void setAc4yIdentification(List<Ac4yIdentification> ac4yIdentification)`
Sets the list of Ac4yIdentification instances. Replaces the current list reference with the provided list.

**Parameters:**
- `ac4yIdentification` - The list of Ac4yIdentification instances to set

**Example:**
```java
List<Ac4yIdentification> newList = new ArrayList<>();
// Populate newList...
idList.setAc4yIdentification(newList);
```

**Note:** No defensive copying is performed. Modifications to the provided list will be reflected in this container.

---

## Usage Examples

### Basic Usage

```java
// Create a new object list
Ac4yObjectList objectList = new Ac4yObjectList();

// Get the internal list and add items
List<Ac4yObject> objects = objectList.getAc4yObject();
objects.add(new Ac4yObject());
objects.add(new Ac4yObject());

// The list is now populated
System.out.println("Count: " + objectList.getAc4yObject().size());
```

### XML Serialization

```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

// Create and populate the list
Ac4yObjectList objectList = new Ac4yObjectList();
// ... add objects ...

// Marshal to XML
JAXBContext context = JAXBContext.newInstance(Ac4yObjectList.class);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(objectList, System.out);
```

### XML Deserialization

```java
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

// Unmarshal from XML
JAXBContext context = JAXBContext.newInstance(Ac4yObjectList.class);
Unmarshaller unmarshaller = context.createUnmarshaller();
Ac4yObjectList objectList = (Ac4yObjectList) unmarshaller.unmarshal(new File("objects.xml"));

// Access the objects
List<Ac4yObject> objects = objectList.getAc4yObject();
```

### Replacing the List

```java
Ac4yObjectList objectList = new Ac4yObjectList();

// Create a pre-populated list
List<Ac4yObject> newList = new ArrayList<>();
newList.add(new Ac4yObject());
newList.add(new Ac4yObject());
newList.add(new Ac4yObject());

// Replace the internal list
objectList.setAc4yObject(newList);
```

## Thread Safety Notes

These classes are **not thread-safe**. For concurrent access, wrap operations in synchronized blocks:

```java
synchronized (objectList) {
    objectList.getAc4yObject().add(newObject);
}
```

Or use external synchronization mechanisms as appropriate for your application.
