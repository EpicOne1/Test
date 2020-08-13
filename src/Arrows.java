public class Arrows {
    public static int longestArrow(String s) {
        // Given a string, return the length of longest arrows

        // check if arrow exits
        int longestLength = 0;

        if (s.contains(Character.toString('>')) || s.contains(Character.toString('<'))) {
//            System.out.println("Arrow exits");
//            longestLength = 1;
            // check length of left arrow
            // we don't need to check the last char, because it will only contain one '<', we already count it
            int left_length = 0;
            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) == '<') {
                    // if string start with '<', count the arrow length of that particular '<'

                    // left single
                    int j = i;
                    int left_single = 1;
                    while (j < s.length() - 1 && s.charAt(j + 1) == '-') {
                        left_single += 1;
                        j++;
                    }
                    // left double
                    j = i;
                    int left_double = 1;
                    while (j < s.length() - 1 && s.charAt(j + 1) == '=') {
                        left_double += 1;
                        j++;
                    }
                    left_length = Math.max(Math.max(left_single, left_double), left_length);
                }
            }

            // check length of right arrow
            int right_length = 0;
            for (int i = s.length() - 1; i >= 0; i--) {

                if (s.charAt(i) == '>') {
                    // if string start with '<', count the arrow length of that particular '<'

                    // right single
                    int j = i;
                    int right_single = 1;
                    while (j > 0 && s.charAt(j - 1) == '-') {
                        right_single += 1;
                        j--;
                    }
                    // right double
                    j = i;
                    int right_double = 1;
                    while (j > 0 && s.charAt(j - 1) == '=') {
                        right_double += 1;
                        j--;
                    }
                    right_length = Math.max(Math.max(right_single, right_double), right_length);
                }
            }

            longestLength = Math.max(left_length, right_length);
        } else
            longestLength = -1;

        return longestLength;

    }

    public static void main(String[] args) {
        String s = "<=<==<===<====<=====<======<=======<==============";
        System.out.println(longestArrow(s));

    }

}


