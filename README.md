# JAc4yObject

A lightweight Java library providing JAXB-compatible container classes for managing lists of ac4y domain objects.

## Overview

JAc4yObject is part of the ac4y framework, a modular object-oriented architecture for Java applications. This library provides two simple container classes that wrap lists of domain objects, enabling seamless XML serialization and deserialization.

## Features

- **XML Serialization**: JAXB-compatible annotations for XML marshalling/unmarshalling
- **Simple API**: Clean getter/setter interface following JavaBean conventions
- **Minimal Dependencies**: Only depends on core ac4y libraries
- **Java 7 Compatible**: Targets Java 1.7 for broad compatibility

## Components

### Ac4yObjectList
Container class for managing lists of `Ac4yObject` instances.

```java
Ac4yObjectList objectList = new Ac4yObjectList();
List<Ac4yObject> objects = objectList.getAc4yObject();
// Add, modify, or process objects
objectList.setAc4yObject(objects);
```

### Ac4yIdentificationList
Container class for managing lists of `Ac4yIdentification` instances.

```java
Ac4yIdentificationList idList = new Ac4yIdentificationList();
List<Ac4yIdentification> identifications = idList.getAc4yIdentification();
// Add, modify, or process identifications
idList.setAc4yIdentification(identifications);
```

## Dependencies

### Runtime Dependencies
- `ac4yClass` (v2016.1207.1-SNAPSHOT) - Base class definitions
- `ac4yBase4JsonAndXml` (v2016.0421.1-SNAPSHOT) - JSON/XML serialization support

### Test Dependencies
- `JUnit` (v4.12) - Unit testing framework

## Building

This project uses Maven for build management.

### Compile
```bash
mvn compile
```

### Run Tests
```bash
mvn test
```

### Package JAR
```bash
mvn package
```

The compiled JAR will be located at `target/ac4yObject-2017.0505.1-SNAPSHOT.jar`.

## Installation

### Maven
Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>ac4y.base</groupId>
    <artifactId>ac4yObject</artifactId>
    <version>2017.0505.1-SNAPSHOT</version>
</dependency>
```

## Requirements

- Java 7 or higher
- Maven 3.x (for building)

## Project Structure

```
JAc4yObject/
├── src/
│   ├── ac4y/base/domain/
│   │   ├── Ac4yObjectList.java
│   │   └── Ac4yIdentificationList.java
│   └── test/java/ac4y/base/domain/
│       ├── Ac4yObjectListTest.java
│       └── Ac4yIdentificationListTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## License

Part of the ac4y framework.

## Repository

https://github.com/ac4y/JAc4yObject

## Version

Current version: 2017.0505.1-SNAPSHOT

## Author

ac4y <info@ac4y.com>

## Contributing

This is a legacy library maintained for compatibility with existing ac4y framework applications.
