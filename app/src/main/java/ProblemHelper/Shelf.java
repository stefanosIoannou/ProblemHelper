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

    private int y;
    private int z;
    private int x;

    // Where should the counting start
    private final int startCountingFrom;

    // Index of the shelf
    private final int index;

    public Shelf(int startCountingFrom, int index, int xIn, int yIn, int zIn) {
        this.index = index;
        this.y = yIn;
        this.x = xIn;
        this.z = zIn;

        shelf = new Position[x][y][z];

        this.startCountingFrom = startCountingFrom;
        int count = this.startCountingFrom;
        // Create position numbers
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    shelf[r][c][d] = new Position(count);
                    ++count;
                }
            }
        }

        // Set Top of relation
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x - 1; ++r) {
                    shelf[r][c][d].setTopOf(shelf[r + 1][c][d]);
                }
            }
        }

        // Set Right of relation
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y - 1; ++c) {
                for (int r = 0; r < x; ++r) {
                    shelf[r][c][d].setRight(shelf[r][c + 1][d]);
                }
            }
        }

        // Set in front of relation
        for (int d = 0; d < z - 1; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    shelf[r][c][d].setFrontOf(shelf[r][c][d + 1]);
                }
            }
        }

        // Set the last layer to sturdy
        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                shelf[x - 1][c][d].setSturdy(true);
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
                .append("; Start counting from: " + startCountingFrom).append("\n");

        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    builder.append(shelf[r][c][d].getRelation());
                }
            }
        }

        for (int d = 0; d < z; ++d) {
            for (int c = 0; c < y; ++c) {
                for (int r = 0; r < x; ++r) {
                    builder.append(shelf[r][c][d].getSturdy());
                }
            }
        }

        return builder.toString();
    }
}