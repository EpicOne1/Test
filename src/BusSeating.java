public class BusSeating {

    public static double Distance(int i, int j) {
        double xi, xj, yi, yj;
        // i < 10 means point i is in left row, > 10 means point i is in right row
        if (i < 10)
            xi = 0;
        else
            xi = 2;
        if (j < 10)
            xj = 0;
        else
            xj = 2;
        // yi, yj means coordinate in row
        yi = i % 10;
        yj = j % 10;
        return Math.hypot(xi - xj, yi - yj);
    }

    public static double getArrangement(String leftRow, String rightRow) {
        double min_distance = 100000;


        // create a single boolean array to represent occupied or not
        boolean[] occupied = new boolean[20];
        for (int i = 0; i < 10; i++) {
            occupied[i] = (leftRow.charAt(i) == 'X');
            occupied[i + 10] = (rightRow.charAt(i) == 'X');
        }

        // find all possible combinations of three points
        for (int i = 0; i < 20; i++) {
            for (int j = i + 1; j < 20; j++) {
                for (int k = j + 1; k < 20; k++) {
                    if (!occupied[i] && !occupied[j] && !occupied[k]) {
                        double distance = Distance(i, j) + Distance(j, k) + Distance(i, k);
                        if (distance < min_distance) min_distance = distance;
                    }
                }
            }
        }


        return min_distance;
    }

    // test
    public static void main(String[] args) {
        String left = "XXX-X-XX-X";
        String right = "XXX-X-XX-X";
        System.out.println(getArrangement(left, right));
    }
}
