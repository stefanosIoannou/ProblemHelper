package ProblemHelper;

import java.util.ArrayList;
import java.util.List;

public class Fridge {
    private List<Shelf> shelfList;
    private int totalPositions = 0;

    /**
     * Build Fridge
     * 
     * @param args List of parameters
     * @throws Exception When the user inputs less than 3 values for dimensions
     */
    public Fridge(String... args) throws Exception {
        if (args.length < 4) {
            throw new Exception("Please input the dimensions as follows x y z (separated by space)");
        }

        shelfList = new ArrayList<>();
        // Calculate the number of shelves
        int noOfDimenstions = args.length - 1;
        int noOfShelves = noOfDimenstions / 3;
        // Dimensions

        for (int s = 0; s < noOfShelves; ++s) {
            int y = Integer.valueOf(args[1]);
            int x = Integer.valueOf(args[2]);
            int z = Integer.valueOf(args[3]);
            shelfList.add(new Shelf(totalPositions + 1, s, y, x, z));
            totalPositions += y * x * z;
        }
    }

    /**
     * String represenation of fridge
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("; Fridge\n").append("; Positions\n");

        // Positions
        for (int i = 0; i < totalPositions; ++i) {
            builder.append("p" + i + " ");
        }
        if (totalPositions > 0)
        builder.append("- position\n");

        // Shelves
        for (Shelf shelf : shelfList) {
            builder.append(shelf.toString());
        }
        return builder.toString();
    }

}