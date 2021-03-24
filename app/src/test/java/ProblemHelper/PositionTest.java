package ProblemHelper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test {@link Position} class methods
 * 
 * @author Stefanos Ioannou
 */
public class PositionTest {

    private Position position1;
    private Position position2;
    private Position position3;
    private Position position4;

    @Before
    public void setUp() {
        position1 = new Position(1);
        position2 = new Position(2);
        position3 = new Position(3);
        position4 = new Position(4);
    }

    /**
     * Test toString() method of position instances
     */
    @Test
    public void TestPositionToString() {
        Assert.assertEquals("Should return ?p1", "?p1", (new Position(1).toString()));
    }

    /**
     * Test
     */
    @Test
    public void TestSetRight() {
        position1.setRight(position2);
        position2.setRight(position3);

        // p1 - p2 - p3

        Assert.assertEquals("(right ?p1 ?p2)\n", position1.getRelation());
        Assert.assertEquals("(right ?p2 ?p3)\n", position2.getRelation());
        Assert.assertEquals("", position3.getRelation());
    }

    /**
     * Test top of relation between positions and the how the relation is printed
     */
    @Test
    public void testSetTopOf() {
        position1.setTopOf(position2);
        position2.setTopOf(position3);

        // p1
        // p2
        // p3

        Assert.assertEquals("(top ?p1 ?p2)\n", position1.getRelation());
        Assert.assertEquals("(top ?p2 ?p3)\n", position2.getRelation());
        Assert.assertEquals("", position3.getRelation());
    }

    /**
     * Test top of relation between positions and the how the relation is printed
     */
    @Test
    public void testSetFrontOf() {
        position1.setFrontOf(position2);
        position2.setFrontOf(position3);

        // p1
        // p2
        // p3

        Assert.assertEquals("(front ?p1 ?p2)\n", position1.getRelation());
        Assert.assertEquals("(front ?p2 ?p3)\n", position2.getRelation());
        Assert.assertEquals("", position3.getRelation());
    }

    /**
     * Test getRelation() with a combination of right and top assignments
     */
    @Test
    public void testGetRealation() {
        // p1 - p4
        // p2

        position1.setTopOf(position2);
        position2.setFrontOf(position3);
        position1.setRight(position4);

        Assert.assertEquals("(top ?p1 ?p2)\n(right ?p1 ?p4)\n", position1.getRelation());
        Assert.assertEquals("(front ?p2 ?p3)\n", position2.getRelation());
        Assert.assertEquals("", position3.getRelation());
    }

    /**
     * Test whether the system prints not sturdy
     */
    @Test
    public void testGetUnsturdy() {
        Assert.assertEquals("(not (sturdy ?p3))\n", position3.getSturdy());
    }

    /**
     * Test whether the system prints sturdy
     */
    @Test
    public void testGetSturdy() {
        position3.setSturdy(true);
        Assert.assertEquals("(sturdy ?p3)\n", position3.getSturdy());
    }

}
