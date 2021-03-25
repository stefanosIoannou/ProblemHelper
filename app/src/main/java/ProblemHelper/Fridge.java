package ProblemHelper;

public class Fridge {
    Position[][][] fridge;

    private int y;
    private int z;
    private int x;

    private Boolean printObjects = true;

    private Boolean printStrudy = true;

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
        if (args.length >= 5) {
            printObjects = Boolean.valueOf(args[4]);
        }
        if (args.length >= 6) {
            printStrudy = Boolean.valueOf(args[5]);
        }

        y = Integer.valueOf(args[1]);
        x = Integer.valueOf(args[2]);
        z = Integer.valueOf(args[3]);

        fridge = new Position[x][y][z];

        int count = 0;
        // Create position numbers
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    fridge[r][c][d] = new Position(count);
                    ++count;
                }
            }
        }

        // Set Top of relation
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x - 1; ++r) {
                    fridge[r][c][d].setTopOf(fridge[r + 1][c][d]);
                }
            }
        }

        // Set Right of relation
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y - 1; ++c) {
                for (int r = 0; r < x; ++r) {
                    fridge[r][c][d].setRight(fridge[r][c + 1][d]);
                }
            }
        }

        // Set in front of relation
        for (int d = 0; d < z - 1; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    fridge[r][c][d].setFrontOf(fridge[r][c][d + 1]);
                }
            }
        }

        // Set the last layer to sturdy
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                fridge[x-1][c][d].setSturdy(true);
            }
        }
    }

    /**
     * String represenation of fridge
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (printObjects) {
            for (int i = 0; i < x * y * z; i++) {
                builder.append("p" + i + " ");
            }
            if (x * y * z > 0)
                builder.append("- position\n");
        }
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    builder.append(fridge[r][c][d].getRelation());
                }
            }
        }

        for (int d = 0; d < z && printStrudy; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    builder.append(fridge[r][c][d].getSturdy());
                }
            }
        }

        return builder.toString();
    }

}