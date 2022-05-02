//Given two strings, write a method to decide if one is a permutation of the
// other.

// Implement an algorithm to determine if a string has all unique characters
// What if you cannot use an additional data structure?

public class StringQuestions {

    // compare sums of ascii values
    static boolean isPermutation(String a, String b) {
        int aCharSum = 0;
        int bCharSum = 0;

        if(a == b | a.length() != b.length()) return false;

        // false if strings don't contain exact same characters
        for(int i=0; i < a.length(); i++) {
            aCharSum += a.charAt(i);
            bCharSum += a.charAt(i);
        }

        return aCharSum == bCharSum;
    }

    // bit vector solution
    static boolean isPermutation(String a, String b) {
        boolean isPermutation = false;
        if(a != b && a.length() == b.length()) {
            int vectorA= 0;
            int vectorB = 0;

            for(int i=0; i < a.length(); i++) {
                int bitIndexA = a.charAt(i);
                int bitIndexB = b.charAt(i);
                vectorA |= 1 << bitIndexA;
                vectorB |= 1 << bitIndexB ;
            }
            if(vectorA == vectorB) isPermutation = true;
        }
        return isPermutation;
    }
    
    // 05/03 - FIX BUGS
    // list of characters comparison solution
    // false if strings don't contain exact same characters
    static boolean isPermutation1(String a, String b) {
        boolean isPermutation = true;
        char[] aChars = new char[a.length()];
        char[] bChars = new char[b.length()];

        if(a == b | a.length() != b.length()) return false;

        // add characters into arrays
        for(int i=0; i < a.length(); i++) {
            aChars.append(a.charAt(i));
            bChars.append(b.charAt(i));
        }

        // for each character in array, check for non-common character
        boolean charAPresent = false;
        boolean currentAChar = false;
        boolean currentBChar = false;
        for(int i=0; i < a.length(); i++) {
            currentAChar = a.charAt(i);
            for(int j=0; j < b.length(); j++) {
                currentBChar = b.charAt(j);
                if (currentAChar == currentBChar) charAPresent = true;
                // this feels like a hack, re-visit and refactor
                if (j == (b.length -1) && charAPresent == false) isPermutation = false;
            }   
        return isPermutation;
    }

    public static void main(String []args){
        
        // Equal case (false)
        isPermutation1("same", "same");
        
        // True case
        print(isPermutation1("abcd", "dcba");

        // False case
        isPermutation1("notpermutation", "random");
     }
}