package ProblemHelper;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test {@link Fridge} class and instances
 * 
 * @author Stefanos Ioannou
 */
public class FridgeTest {

    /**
     * Test 2d fridge toString method The fridge is 3*2*1
     * 
     * @throws Exception When less than 3 args are used
     */
    @Test
    public void test2DFridge() throws Exception {
        Fridge foo = new Fridge("build", "3", "2", "1");

        // 0 - 2 - 4
        // 1 - 3 - 5
        Assert.assertEquals(
                "(top ?p0 ?p1)\n(right ?p0 ?p2)\n(right ?p1 ?p3)\n(top ?p2 ?p3)\n(right ?p2 ?p4)\n(right ?p3 ?p5)\n(top ?p4 ?p5)\n",
                foo.toString());
    }

    /**
     * Test 2d fridge toString method The fridge is 3*2*1
     * 
     * @throws Exception When less than 3 args are used
     */
    @Test
    public void test2DFridgeWithObjects() throws Exception {
        Fridge foo = new Fridge("build", "3", "2", "1", "true");

        // 0 - 2 - 4
        // 1 - 3 - 5
        Assert.assertEquals(
                "p0 p1 p2 p3 p4 p5 - position\n(top ?p0 ?p1)\n(right ?p0 ?p2)\n(right ?p1 ?p3)\n(top ?p2 ?p3)\n(right ?p2 ?p4)\n(right ?p3 ?p5)\n(top ?p4 ?p5)\n",
                foo.toString());
    }

    /**
     * Test 3d fridge toString method. The fridge is 2*2*2
     * 
     * @throws Exception When less than 3 args are used
     */
    @Test
    public void test3DFridge() throws Exception {
        Fridge foo = new Fridge("build", "2", "2", "2");

        // Front
        // 0 - 2
        // 1 - 3

        // Behind
        // 4 - 6
        // 5 - 7

        Assert.assertEquals(
                "(top ?p0 ?p1)\n(right ?p0 ?p2)\n(front ?p0 ?p4)\n(right ?p1 ?p3)\n(front ?p1 ?p5)\n(top ?p2 ?p3)\n(front ?p2 ?p6)\n(front ?p3 ?p7)\n(top ?p4 ?p5)\n(right ?p4 ?p6)\n(right ?p5 ?p7)\n(top ?p6 ?p7)\n",
                foo.toString());
    }

    /**
     * Test 3d fridge toString method. The fridge is 2*2*2
     * 
     * @throws Exception When less than 3 args are used
     */
    @Test
    public void test3DFridgeSturdy() throws Exception {
        Fridge foo = new Fridge("build", "2", "2", "2","","true");

        // Front
        // 0 - 2
        // 1 - 3

        // Behind
        // 4 - 6
        // 5 - 7

        Assert.assertEquals(
                "(top ?p0 ?p1)\n(right ?p0 ?p2)\n(front ?p0 ?p4)\n(right ?p1 ?p3)\n(front ?p1 ?p5)\n(top ?p2 ?p3)\n(front ?p2 ?p6)\n(front ?p3 ?p7)\n(top ?p4 ?p5)\n(right ?p4 ?p6)\n(right ?p5 ?p7)\n(top ?p6 ?p7)\n(not (sturdy ?p0))\n(sturdy ?p1)\n(not (sturdy ?p2))\n(sturdy ?p3)\n(not (sturdy ?p4))\n(sturdy ?p5)\n(not (sturdy ?p6))\n(sturdy ?p7)\n",
                foo.toString());
    }
}
