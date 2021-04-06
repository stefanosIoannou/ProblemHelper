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

        int startIndex = 0;
        for (int s = 0; s < noOfShelves; ++s) {
            int x = Integer.valueOf(args[++startIndex]);
            int y = Integer.valueOf(args[++startIndex]);
            int z = Integer.valueOf(args[++startIndex]);
            shelfList.add(new Shelf(totalPositions + 1, s, x, y, z));
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
        for (int i = 1; i <= totalPositions; ++i) {
            builder.append("p" + i + " ");
        }
        if (totalPositions > 0)
        builder.append("- position\n");

        // Shelves
        for (Shelf shelf : shelfList) {
            builder.append(shelf.toString());
        }

        // No items in the fridge
        builder.append("\n; Currently no items in the fridge\n(= (items_in_fridge) 0)\n");
        return builder.toString();
    }

}