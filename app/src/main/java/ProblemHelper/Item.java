package ProblemHelper;

public enum Item {
    ONE_ONE_ONE("one_one_one", 1), TWO_TWO_TWO("two_two_two", 1), ONE_ONE_THREE("one_one_three", 3),
    ONE_TWO_TWO("one_two_two", 3), ONE_ONE_TWO("one_one_two", 3), ONE_TWO_THREE("one_two_three", 6),
    UNKOWN("UNKNOWN", 2);

    private final String stringName;
    private final int noOfOrientations;
    private static final String[] orientations = new String[] { "zero", "one", "two", "three", "four", "five" };

    private Item(String str, int noOfOrientations) {
        stringName = str;
        this.noOfOrientations = noOfOrientations;
    }

    public String toString(String itemName) {
        if (itemName == null) {
            itemName = "item";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\n; Item: ").append(itemName).append("\n").append(itemName).append(" - ").append(stringName)
                .append("\n ; Total Orientations\n")
                .append("(= (no_orientations " + itemName + ") " + noOfOrientations + ")").append("\n")
                .append("\n;" + itemName + " is in the bag \n").append("(in_bag " + itemName + ")\n");

        // If the object has orientations, print all orientations
        for (int i = 0; i < noOfOrientations; ++i) {
            builder.append("\n").append("(= (orientation_no " + orientations[i] + ") " + i + ")");
        }
        return builder.toString();
    }

    public static String assignOrientation(Item item, int orientationIndex, String itemName) {
        if (itemName == null)
            itemName = "item";
        if (orientationIndex < item.noOfOrientations) {
            return "\n(has_orientation " + itemName + " " + orientations[orientationIndex] + ")\n";
        }
        return "";
    }

}