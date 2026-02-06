# Dependencies Note

## Build Requirements

This project depends on two ac4y framework libraries that are **not available in public Maven repositories**:

1. `ac4y.base:ac4yClass:2016.1207.1-SNAPSHOT`
2. `ac4y.base:ac4yBase4JsonAndXml:2016.0421.1-SNAPSHOT`

## Why This Matters

These dependencies provide:
- **Ac4yNoID** - Base class for Ac4yObjectList and Ac4yIdentificationList
- **Ac4yObject** - Domain object type for Ac4yObjectList
- **Ac4yIdentification** - Domain object type for Ac4yIdentificationList

Without these dependencies, the project **cannot be compiled**.

## Solutions

### Option 1: Install Dependencies Locally

If you have access to the ac4y framework libraries:

```bash
# Install ac4yClass
mvn install:install-file \
  -Dfile=path/to/ac4yClass-2016.1207.1-SNAPSHOT.jar \
  -DgroupId=ac4y.base \
  -DartifactId=ac4yClass \
  -Dversion=2016.1207.1-SNAPSHOT \
  -Dpackaging=jar

# Install ac4yBase4JsonAndXml
mvn install:install-file \
  -Dfile=path/to/ac4yBase4JsonAndXml-2016.0421.1-SNAPSHOT.jar \
  -DgroupId=ac4y.base \
  -DartifactId=ac4yBase4JsonAndXml \
  -Dversion=2016.0421.1-SNAPSHOT \
  -Dpackaging=jar
```

Then build normally:
```bash
mvn clean package
```

### Option 2: Use Private Repository

If the ac4y artifacts are hosted in a private Maven repository, add to pom.xml:

```xml
<repositories>
    <repository>
        <id>ac4y-repo</id>
        <url>https://your-private-repo-url/maven2</url>
    </repository>
</repositories>
```

### Option 3: Mock Dependencies (For Testing Only)

Create minimal stub implementations for compilation testing:

1. Create stub classes in your local repository
2. Package as JARs
3. Install to local Maven repository

**Note:** This is only for build verification, not for production use.

## Current Status

The project structure, tests, and documentation are complete, but the project **cannot be built** without access to the ac4y dependencies.

## Verification

To verify the project structure and documentation are correct:

1. Review the source code in `src/ac4y/base/domain/`
2. Review the test files in `src/test/java/ac4y/base/domain/`
3. Review the documentation in `meta/`
4. Check the pom.xml configuration

## For Project Maintainers

If you maintain this project:

1. **Publish ac4y dependencies** to a repository (GitHub Packages, private Nexus, etc.)
2. **Update pom.xml** with the repository location
3. **Update this file** with correct installation instructions
4. **Test the full build** to ensure it works for new developers

## Alternative: Refactor to Remove Dependencies

If the ac4y dependencies are permanently unavailable, consider:

1. Creating standalone versions of the base classes
2. Removing dependency on Ac4yNoID
3. Publishing as an independent library

This would require:
- Creating Ac4yNoID locally or removing the inheritance
- Creating type definitions for Ac4yObject and Ac4yIdentification
- Updating all references and imports

## Contact

For access to ac4y dependencies, contact: ac4y <info@ac4y.com>

Repository: https://github.com/ac4y/JAc4yObject
