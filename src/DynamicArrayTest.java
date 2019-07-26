import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DynamicArrayTest {

    private DynamicArray<String> sut;

    @Before
    public void setUp() throws Exception {
        sut = new DynamicArray<>(5);
    }

    @Test
    public void dynamicArray_add() {
        sut.add("a");
        sut.add("b");
        sut.add("c");
        Assert.assertEquals("a", sut.get(0));
        Assert.assertEquals("b", sut.get(1));
        Assert.assertEquals("c", sut.get(2));
        Assert.assertEquals(3, sut.getSize());
    }

    @Test
    public void dynamicArray_remove() {
        sut.add("a");
        sut.add("b");
        sut.add("c");
        sut.add("d");
        sut.add("e");

        Assert.assertEquals(5, sut.getSize());
        sut.remove(1);
        Assert.assertEquals("a", sut.get(0));
        Assert.assertNotEquals("b", sut.get(1));
        Assert.assertEquals("c", sut.get(1));

        Assert.assertEquals(4, sut.getSize());
    }

    @Test
    public void dynamicArray_insert() {
        sut.add("a");
        sut.add("b");
        sut.add("c");
        sut.add("d");
        sut.add("e");

        Assert.assertEquals(5, sut.getSize());
        Assert.assertEquals("d", sut.get(3));
        sut.insert(3, "zz");
        sut.insert(3, "xx");
        Assert.assertEquals(7, sut.getSize());
        Assert.assertEquals("xx", sut.get(3));
        Assert.assertEquals("zz", sut.get(4));
        Assert.assertEquals("d", sut.get(5));
    }

    @Test
    public void dynamicArray_set() {
        sut.add("a");
        sut.add("b");
        sut.add("c");
        sut.add("d");
        sut.add("e");
        Assert.assertEquals(5, sut.getSize());
        Assert.assertEquals("b", sut.get(1));
        sut.set(1, "zz");

        Assert.assertEquals("zz", sut.get(1));
    }

    @After
    public void tearDown() throws Exception {
        sut = null;
    }
}