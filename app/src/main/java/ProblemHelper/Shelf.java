package ProblemHelper;

/**
 * Represents a shelf
 * 
 * 
 * @author Stefanos Ioannou
 * @version 2021.03.25build
 */
public class Shelf {

    Position[][][] shelf;

    private final int x;
    private final int y;
    private final int z;

    // Where should the counting start
    private final int startCountingFrom;

    // Index of the shelf
    private final int index;

    public Shelf(int startCountingFrom, int index, int xIn, int yIn, int zIn) {
        this.index = index;
        this.x = xIn;
        this.y = yIn;
        this.z = zIn;

        shelf = new Position[x][y][z];

        this.startCountingFrom = startCountingFrom;
        int count = this.startCountingFrom;
        // Create position numbers
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < x; ++c) {
                for (int r = 0; r < y; ++r) {
                    shelf[c][r][d] = new Position(count);
                    ++count;
                }
            }
        }

        // Set Top of relation
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < x; ++c) {
                for (int r = 0; r < y - 1; ++r) {
                    shelf[c][r][d].setTopOf(shelf[c][r + 1][d]);
                }
            }
        }

        // Set Right of relation
        for (int d = 0; d < z; ++d) {
            for (int r = 0; r < y; ++r) {
                for (int c = 0; c < x - 1; ++c) {
                    shelf[c][r][d].setRight(shelf[c + 1][r][d]);
                }
            }
        }

        // Set in front of relation
        for (int d = 0; d < z - 1; ++d) {
            for (int c = 0; c < x; ++c) {
                for (int r = 0; r < y; ++r) {
                    shelf[c][r][d].setFrontOf(shelf[c][r][d + 1]);
                }
            }
        }

        // Set the last layer to sturdy
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < x; ++c) {
                shelf[c][y-1][d].setSturdy(true);
            }
        }
    }

    /**
     * String represenation of Shellf
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // Print shelf title
        builder.append("\n").append("\n").append("; Shelf #" + index).append("\n")
                .append("; Start counting from: " + startCountingFrom).append("\n")
                .append("; Shelve Dimensions: " + x + " * " + y + " * " + z).append("\n");

        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < x; ++c) {
                for (int r = 0; r < y; ++r) {
                    builder.append(shelf[c][r][d].getRelation());
                }
            }
        }

        builder.append("\n; Sturdiness\n");
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < x; ++c) {
                for (int r = 0; r < y; ++r) {
                    builder.append(shelf[c][r][d].getSturdy());
                }
            }
        }

        return builder.toString();
    }
}