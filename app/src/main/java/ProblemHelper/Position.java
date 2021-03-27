package ProblemHelper;

/**
 * Position Class
 * Represents a position
 * 
 * @author Stefanos Ioannou
 * @version 2021.03.24
 */
public class Position {

    private int num;
    private Position topOf = null;
    private Position rightOf = null;
    private Position frontOf = null;
    private boolean isSturdy = false;

    public Position(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "p" + String.valueOf(num);
    }

    public String getRelation() {
        String top = "";
        String right = "";
        String front = "";
        if (topOf != null) {
            top = "(top " + this.toString() + " " + topOf.toString() + ")\n";
        }
        if (rightOf != null) {
            right = "(right " + this.toString() + " " +  rightOf.toString() + ")\n";
        }
        if (frontOf != null) {
            front = "(front " + this.toString() + " " +  frontOf.toString() + ")\n";
        }
        return top + right + front;
    }

    public void setTopOf(Position bottom) {
        this.topOf = bottom;
    }

    public void setRight(Position right) {
        this.rightOf = right;
    }

    public void setFrontOf(Position behind) {
        this.frontOf = behind;
    }

    public void setSturdy(boolean sturdy) {
        this.isSturdy = sturdy;
    }

    public String getSturdy() {
        String toReturn = "(sturdy " + this.toString() + ")";
        if (!isSturdy) {
            toReturn = "(not " +toReturn + ")";
        }
        return toReturn + "\n";
    }

}
