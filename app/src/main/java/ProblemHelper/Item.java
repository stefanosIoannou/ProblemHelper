package ProblemHelper;

public enum Item {
    ONE_ONE_ONE("one_one_one", 1), TWO_TWO_TWO("two_two_two", 1), ONE_ONE_THREE("one_one_three", 2),
    ONE_TWO_TWO("one_two_two", 2), ONE_ONE_TWO("one_one_two", 2), ONE_TWO_THREE("one_two_three", 6),
    UNKOWN("UNKNOWN", 2);

    private final String stringName;
    private final int noOfOrientations;
    private static final String[] orientations = new String[] { "zero", "one", "two", "three", "four", "five" };

    private Item(String str, int noOfOrientations) {
        stringName = str;
        this.noOfOrientations = noOfOrientations;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n;Item\n").append("item - ").append(stringName).append("\n ; Total Orientations\n")
                .append("(= (no_orientations item) " + noOfOrientations + ")").append("\n")
                .append("\n;Item is in the bag \n").append("(in_bag item)\n");

        // If the object has orientations, print all orientations
        for (int i = 0; i < noOfOrientations; ++i) {
            builder.append("\n").append("(= (orientation_no " + orientations[i] + ") " + i + ")");
        }
        return builder.toString();
    }

    public static String assignOrientation(Item item, int orientationIndex) {
        if (orientationIndex < item.noOfOrientations) {
            return "\n(has_orientation item " + orientations[orientationIndex] + ")\n";
        }
        return "";
    }

}