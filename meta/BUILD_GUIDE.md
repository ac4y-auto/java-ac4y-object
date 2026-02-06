# Build and Deployment Guide

## Prerequisites

### Required Software
- **JDK 7 or higher** - Java Development Kit
- **Maven 3.x** - Build automation tool
- **Git** - Version control (for cloning repository)

### Optional Tools
- **IDE** - IntelliJ IDEA, Eclipse, or NetBeans
- **GitHub Account** - For publishing packages

## Building the Project

### Clone the Repository

```bash
git clone https://github.com/ac4y/JAc4yObject.git
cd JAc4yObject
```

### Compile

Compile the source code without running tests:

```bash
mvn compile
```

### Run Tests

Execute all unit tests:

```bash
mvn test
```

### Package JAR

Create the JAR file (includes compilation and testing):

```bash
mvn package
```

The compiled artifacts will be in the `target/` directory:
- `ac4yObject-2017.0505.1-SNAPSHOT.jar` - Main JAR
- `ac4yObject-2017.0505.1-SNAPSHOT-sources.jar` - Source code JAR
- `ac4yObject-2017.0505.1-SNAPSHOT-javadoc.jar` - JavaDoc JAR

### Clean Build

Remove all generated files:

```bash
mvn clean
```

Full clean and rebuild:

```bash
mvn clean package
```

## Maven Build Lifecycle

### Common Goals

| Command | Description |
|---------|-------------|
| `mvn compile` | Compile source code |
| `mvn test` | Run unit tests |
| `mvn package` | Create JAR file |
| `mvn install` | Install JAR to local Maven repository |
| `mvn deploy` | Deploy to remote repository (GitHub Packages) |
| `mvn clean` | Delete target directory |
| `mvn javadoc:javadoc` | Generate JavaDoc documentation |

### Build Profiles

Default profile includes:
- Java 1.7 compilation
- Unit test execution
- JAR packaging with manifest
- Source JAR generation
- JavaDoc JAR generation

## Publishing to GitHub Packages

### Setup Authentication

1. Create a GitHub Personal Access Token (PAT):
   - Go to GitHub Settings → Developer Settings → Personal Access Tokens
   - Generate new token with `write:packages` and `read:packages` scopes
   - Copy the token

2. Configure Maven settings (`~/.m2/settings.xml`):

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <password>YOUR_GITHUB_TOKEN</password>
    </server>
  </servers>
</settings>
```

### Deploy to GitHub Packages

```bash
mvn deploy
```

This will publish:
- Main JAR
- Sources JAR
- JavaDoc JAR
- POM file

to `https://maven.pkg.github.com/ac4y/JAc4yObject`

## Using the Published Package

### Maven Dependency

Add to your project's `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/ac4y/JAc4yObject</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>ac4y.base</groupId>
    <artifactId>ac4yObject</artifactId>
    <version>2017.0505.1-SNAPSHOT</version>
  </dependency>
</dependencies>
```

### Gradle Dependency

Add to your `build.gradle`:

```gradle
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/ac4y/JAc4yObject")
        credentials {
            username = project.findProperty("gpr.user") ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    implementation 'ac4y.base:ac4yObject:2017.0505.1-SNAPSHOT'
}
```

## Continuous Integration

### GitHub Actions Workflow Example

Create `.github/workflows/maven.yml`:

```yaml
name: Java CI with Maven

on:
  push:
    branches: [ master ]
  pull_request:
    branches: [ master ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
    - uses: actions/checkout@v2

    - name: Set up JDK 7
      uses: actions/setup-java@v2
      with:
        java-version: '7'
        distribution: 'adopt'

    - name: Build with Maven
      run: mvn -B package --file pom.xml

    - name: Publish to GitHub Packages
      if: github.event_name == 'push' && github.ref == 'refs/heads/master'
      run: mvn deploy
      env:
        GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```

## Troubleshooting

### Build Fails - Dependencies Not Found

If ac4y dependencies cannot be resolved:
1. Check that ac4yClass and ac4yBase4JsonAndXml are available
2. Configure repository locations in pom.xml
3. Install dependencies to local Maven repository manually if needed

### Tests Fail

```bash
# Skip tests during build
mvn package -DskipTests

# Run specific test
mvn test -Dtest=Ac4yObjectListTest
```

### JavaDoc Errors

```bash
# Skip JavaDoc generation
mvn package -Dmaven.javadoc.skip=true
```

### Deployment Issues

- Verify GitHub token has correct permissions
- Check settings.xml server configuration
- Ensure repository URL matches pom.xml

## Version Management

### Creating a Release

1. Update version in `pom.xml`:
```xml
<version>2017.0505.1</version>  <!-- Remove -SNAPSHOT -->
```

2. Build and deploy:
```bash
mvn clean deploy
```

3. Tag the release:
```bash
git tag -a v2017.0505.1 -m "Release version 2017.0505.1"
git push origin v2017.0505.1
```

4. Update to next snapshot version:
```xml
<version>2017.0506.1-SNAPSHOT</version>
```

## IDE Integration

### IntelliJ IDEA
1. File → Open → Select `pom.xml`
2. Maven tool window → Lifecycle goals
3. Run/Debug configurations from Maven goals

### Eclipse
1. File → Import → Maven → Existing Maven Projects
2. Right-click project → Run As → Maven build
3. Configure build goals in launch configuration

### NetBeans
1. File → Open Project → Select JAc4yObject folder
2. Right-click project → Build / Test / Clean and Build
3. Maven actions available in context menu
