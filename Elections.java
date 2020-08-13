public class Elections {
    public static int visit(String[] likelihoods){
        // Given a String[] likelihoods
        // return the lowest index (0-based) which has the lowest percentage of '1'
//        {"1222","1122","1222"}
//        Returns: 0
        int lowest_index = 0;
        double lowest_percentage = 10000;
        for (int i = 0; i < likelihoods.length; i++) {
            // calculate each state's percentage
//            System.out.println("State");
            double vote = 0; // if use int vote = 0; then vote/(likelihoods[i].length()) is 0.0
            for (int j = 0; j < likelihoods[i].length(); j++) {
//                System.out.println(likelihoods[i].charAt(j));
                if (likelihoods[i].charAt(j) == '1') vote++;
            }
            double percentage = vote/(likelihoods[i].length());
            if (lowest_percentage > percentage){
                lowest_index = i;
                lowest_percentage = percentage;
            }
        }


        return lowest_index;
    }

    public static void main(String[] args){
        String[] likelihoods = {"11112222111121","1211221212121","112111222","11122222222111","112121222","1212122211112"};
        System.out.println(visit(likelihoods));
    }
}
