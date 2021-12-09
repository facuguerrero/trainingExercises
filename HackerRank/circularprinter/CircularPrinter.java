
class Solution {
    private static final String FIRST_CHARACTER = "A";
    private static final char LAST_CHARACTER = 'Z';
    private static final int MOVEMENT = 64; // Place the letters bettwen 1 and 26

    public static void main(String[] args) {
        circularPrinter("BDE"); //4
        circularPrinter("BDZ"); //7
    }

    public static void circularPrinter(String s) {
        int steps = 0;
        String newString = FIRST_CHARACTER + s;

        int SECOND_CHARACTER_ASCII = ((int) LAST_CHARACTER) - MOVEMENT;

        for (int x = 0; x < newString.length() - 1; x++) {
            int characterFromAscii = ((int) newString.charAt(x)) - MOVEMENT;
            int characterToAscii = ((int) newString.charAt(x+1)) - MOVEMENT;

            int firstPath = characterToAscii - characterFromAscii;
            int secondPath = SECOND_CHARACTER_ASCII - firstPath;
            steps += Math.min(firstPath, secondPath);
        }
        System.out.println(steps);
    }
}