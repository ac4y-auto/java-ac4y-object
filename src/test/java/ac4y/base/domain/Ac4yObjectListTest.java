package ac4y.base.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Ac4yObjectList.
 *
 * Tests the basic functionality of the Ac4yObjectList container class including:
 * - Constructor initialization
 * - Getter and setter methods
 * - List manipulation operations
 * - Edge cases and null handling
 *
 * @author Claude Code
 * @version 1.0
 */
public class Ac4yObjectListTest {

    private Ac4yObjectList objectList;

    @Before
    public void setUp() {
        objectList = new Ac4yObjectList();
    }

    /**
     * Test that constructor initializes an empty list.
     */
    @Test
    public void testConstructorInitializesEmptyList() {
        assertNotNull("List should not be null after construction", objectList.getAc4yObject());
        assertTrue("List should be empty after construction", objectList.getAc4yObject().isEmpty());
        assertEquals("List size should be 0", 0, objectList.getAc4yObject().size());
    }

    /**
     * Test getting the list returns the correct reference.
     */
    @Test
    public void testGetAc4yObject() {
        List<Ac4yObject> list = objectList.getAc4yObject();
        assertNotNull("Getter should return non-null list", list);
        assertSame("Multiple calls should return same list instance", list, objectList.getAc4yObject());
    }

    /**
     * Test setting a new list.
     */
    @Test
    public void testSetAc4yObject() {
        List<Ac4yObject> newList = new ArrayList<Ac4yObject>();
        objectList.setAc4yObject(newList);
        assertSame("Setter should update the list reference", newList, objectList.getAc4yObject());
    }

    /**
     * Test setting a null list (edge case).
     * Note: Current implementation allows null, which may cause NullPointerException.
     */
    @Test
    public void testSetAc4yObjectWithNull() {
        objectList.setAc4yObject(null);
        assertNull("Setter should accept null (current behavior)", objectList.getAc4yObject());
    }

    /**
     * Test that the list can be modified after retrieval.
     */
    @Test
    public void testListIsModifiable() {
        List<Ac4yObject> list = objectList.getAc4yObject();
        int initialSize = list.size();

        // Note: We cannot instantiate Ac4yObject directly as it's from a dependency,
        // but we can test list operations with null elements
        list.add(null);

        assertEquals("List size should increase after adding element", initialSize + 1, list.size());
        assertEquals("List should reflect changes", initialSize + 1, objectList.getAc4yObject().size());
    }

    /**
     * Test replacing the list with a populated list.
     */
    @Test
    public void testSetPopulatedList() {
        List<Ac4yObject> newList = new ArrayList<Ac4yObject>();
        newList.add(null); // Using null as placeholder since Ac4yObject is from dependency
        newList.add(null);
        newList.add(null);

        objectList.setAc4yObject(newList);

        assertEquals("List should have 3 elements", 3, objectList.getAc4yObject().size());
    }

    /**
     * Test that list modifications are reflected in subsequent getters.
     */
    @Test
    public void testListPersistence() {
        objectList.getAc4yObject().add(null);
        objectList.getAc4yObject().add(null);

        assertEquals("List should persist modifications", 2, objectList.getAc4yObject().size());
    }

    /**
     * Test clearing the list.
     */
    @Test
    public void testClearList() {
        objectList.getAc4yObject().add(null);
        objectList.getAc4yObject().clear();

        assertTrue("List should be empty after clear", objectList.getAc4yObject().isEmpty());
        assertEquals("List size should be 0 after clear", 0, objectList.getAc4yObject().size());
    }

    /**
     * Test that Ac4yObjectList can be instantiated multiple times independently.
     */
    @Test
    public void testMultipleInstances() {
        Ac4yObjectList list1 = new Ac4yObjectList();
        Ac4yObjectList list2 = new Ac4yObjectList();

        list1.getAc4yObject().add(null);

        assertEquals("First list should have 1 element", 1, list1.getAc4yObject().size());
        assertEquals("Second list should remain empty", 0, list2.getAc4yObject().size());
        assertNotSame("Different instances should have different list objects",
                     list1.getAc4yObject(), list2.getAc4yObject());
    }

    /**
     * Test inheritance from Ac4yNoID.
     */
    @Test
    public void testInheritance() {
        assertTrue("Ac4yObjectList should extend Ac4yNoID",
                  objectList instanceof Ac4yNoID);
    }
}
