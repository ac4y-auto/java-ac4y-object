# Testing Documentation

## Test Framework

**Framework:** JUnit 4.12
**Test Location:** `src/test/java/ac4y/base/domain/`

## Test Coverage

### Ac4yObjectListTest

**Class Under Test:** `Ac4yObjectList`
**Test File:** `Ac4yObjectListTest.java`

#### Test Cases

| Test Method | Purpose | Assertions |
|------------|---------|-----------|
| `testConstructorInitializesEmptyList` | Verify constructor creates empty list | List is not null, empty, size is 0 |
| `testGetAc4yObject` | Verify getter returns list reference | Non-null, same instance on multiple calls |
| `testSetAc4yObject` | Verify setter updates list | New list reference is stored |
| `testSetAc4yObjectWithNull` | Test null handling | Null is accepted (current behavior) |
| `testListIsModifiable` | Verify list can be modified after retrieval | Size increases, changes reflected |
| `testSetPopulatedList` | Test replacing with populated list | List size matches replacement |
| `testListPersistence` | Verify modifications persist | Multiple additions are retained |
| `testClearList` | Test clearing the list | List becomes empty after clear |
| `testMultipleInstances` | Verify instance independence | Each instance has separate list |
| `testInheritance` | Verify class hierarchy | Instance of Ac4yNoID |

**Total Test Cases:** 10
**Lines of Code:** ~135
**Coverage Target:** Core functionality and edge cases

### Ac4yIdentificationListTest

**Class Under Test:** `Ac4yIdentificationList`
**Test File:** `Ac4yIdentificationListTest.java`

#### Test Cases

| Test Method | Purpose | Assertions |
|------------|---------|-----------|
| `testConstructorInitializesEmptyList` | Verify constructor creates empty list | List is not null, empty, size is 0 |
| `testGetAc4yIdentification` | Verify getter returns list reference | Non-null, same instance on multiple calls |
| `testSetAc4yIdentification` | Verify setter updates list | New list reference is stored |
| `testSetAc4yIdentificationWithNull` | Test null handling | Null is accepted (current behavior) |
| `testListIsModifiable` | Verify list can be modified after retrieval | Size increases, changes reflected |
| `testSetPopulatedList` | Test replacing with populated list | List size matches replacement |
| `testListPersistence` | Verify modifications persist | Multiple additions are retained |
| `testClearList` | Test clearing the list | List becomes empty after clear |
| `testMultipleInstances` | Verify instance independence | Each instance has separate list |
| `testInheritance` | Verify class hierarchy | Instance of Ac4yNoID |

**Total Test Cases:** 10
**Lines of Code:** ~135
**Coverage Target:** Core functionality and edge cases

## Running Tests

### Run All Tests

```bash
mvn test
```

### Run Specific Test Class

```bash
mvn test -Dtest=Ac4yObjectListTest
mvn test -Dtest=Ac4yIdentificationListTest
```

### Run Specific Test Method

```bash
mvn test -Dtest=Ac4yObjectListTest#testConstructorInitializesEmptyList
```

### Run Tests with Verbose Output

```bash
mvn test -X
```

## Test Limitations

### Known Constraints

1. **Dependency Classes Not Mocked**
   - Tests cannot instantiate `Ac4yObject` or `Ac4yIdentification` (from dependencies)
   - Tests use `null` as placeholder elements in lists
   - Validates container behavior but not interaction with actual domain objects

2. **Integration Testing**
   - No integration tests with actual ac4y domain objects
   - JAXB serialization not tested (would require full dependency setup)
   - XML marshalling/unmarshalling not validated

3. **Thread Safety**
   - No concurrent access tests
   - Thread safety is not guaranteed by implementation

4. **Performance**
   - No performance benchmarks
   - No stress tests with large lists

## Test Design Principles

### Test Structure
All tests follow the AAA pattern:
- **Arrange:** Set up test data and objects
- **Act:** Execute the method under test
- **Assert:** Verify expected outcomes

### Test Independence
- Each test has a `@Before` setup method
- Tests create fresh instances
- No shared state between tests
- Tests can run in any order

### Naming Convention
```
test<MethodName><Scenario>
```
Examples:
- `testConstructorInitializesEmptyList`
- `testSetAc4yObjectWithNull`

## Adding New Tests

### Test Template

```java
@Test
public void testFeatureName() {
    // Arrange
    Ac4yObjectList objectList = new Ac4yObjectList();
    List<Ac4yObject> expected = new ArrayList<>();

    // Act
    objectList.setAc4yObject(expected);

    // Assert
    assertEquals("Description of expected behavior", expected, objectList.getAc4yObject());
}
```

### Best Practices

1. **One Assertion Per Concept**
   - Test one behavior per test method
   - Multiple assertions are OK if testing same concept

2. **Descriptive Names**
   - Test names should describe the scenario
   - Should be readable as documentation

3. **Clear Failure Messages**
   - Use descriptive assertion messages
   - Help debugging when tests fail

4. **Test Edge Cases**
   - Null values
   - Empty collections
   - Boundary conditions

## Continuous Integration

Tests run automatically on:
- Every commit (if CI configured)
- Pull requests
- Before deployment

### Maven Build Integration

Tests are part of the standard build lifecycle:
```bash
mvn clean package  # Automatically runs tests
```

Skip tests if needed:
```bash
mvn package -DskipTests
```

## Code Coverage

### Measuring Coverage

Use JaCoCo Maven plugin (add to pom.xml):

```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.7</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Generate coverage report:
```bash
mvn test jacoco:report
```

View report at: `target/site/jacoco/index.html`

## Future Test Enhancements

### Recommended Additions

1. **Integration Tests**
   - Create mock Ac4yObject and Ac4yIdentification instances
   - Test with actual domain objects if dependencies allow

2. **JAXB Serialization Tests**
   - Test XML marshalling
   - Test XML unmarshalling
   - Validate XML structure

3. **Concurrency Tests**
   - Test thread-safe access patterns
   - Identify race conditions

4. **Performance Tests**
   - Benchmark list operations
   - Test with large datasets

5. **Negative Tests**
   - Test exceptional conditions
   - Validate error handling (when implemented)

## Test Maintenance

### Regular Tasks

- Review test coverage after code changes
- Update tests when requirements change
- Refactor tests to maintain clarity
- Remove obsolete tests
- Keep test dependencies up to date

### Test Smells to Avoid

- ❌ Tests that depend on execution order
- ❌ Tests with hardcoded paths or values
- ❌ Tests that test implementation details
- ❌ Fragile tests that break with minor changes
- ❌ Tests without clear assertions
