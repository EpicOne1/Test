public class FingerCounting {
    public static int maxNumber(int weakFinger, int maxCount) {
        // forward = true, backward = false


        int num = 0;
        int current = 1, direction = -1;
        while (true) {
            if (current == 1 || current == 5) direction = -direction; // change direction
            if (current == weakFinger && maxCount == 0) return num;
            if (current == weakFinger) maxCount--;
            current = current + direction;
            num++;
        }
    }

    public static void main(String[] args){
        System.out.println(maxNumber(3,99999));
    }
}
