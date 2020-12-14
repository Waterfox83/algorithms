package in.algo.random;

public class FindFirstNonRepeatingCharInString {
    public static void main(String[] args)
    {
        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        System.out.println(
                index == -1
                        ? "Either all characters are repeating or string "
                        + "is empty"
                        : "First non-repeating character is "
                        + str.charAt(index));
    }

    private static int firstNonRepeating(String s) {
        int curIndex = 0;
        for (char c : s.toCharArray()) {
            System.out.println(c + " = " + s.lastIndexOf(c));
            if(s.lastIndexOf(c) > curIndex) {
                curIndex++;
            } else {
                System.out.println(c);
                return curIndex;
            }
        }
        return 0;
    }
}
