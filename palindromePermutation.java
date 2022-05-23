/* 
Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards. 
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
*/

public class palindromePermutation {

/* Book solution #1 - Use a hash table to count character frequency. 
Then check that only one character has an odd count */

    boolean isPalindromePermutation(String s) {
        // true if even count of all chars except middle one
        // use a hash table to keep track of character counts
        int[] table = buidCharFrequencyTable(s);
        return checkMaxOneOdd(table);
    }

    // Check that only one character has one odd count
    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
            }
            foundOdd = true;
        }
        return true;
    }

    // Map characters to numeric value
    int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    // Count how many times each character appears
    int[] buidCharFrequencyTable(String s) {
        int table[] = new int[Character.getNumericValue('z') - 
        Character.getNumericValue('a') + 1];
        for (char c : s.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1){
                table[x]++;
            }
        }
        return table;
    }

    // for practice, start with only checking if palindrome
    boolean isPalindrome(String s) {
        // for a word to be a palindrome, the letters would mirror eachother, with one common letter in the middle
        // TO DO, try this: find the middle char and then compare (mid_char - 1) and (mid_char + 1)
        // pointers for beginning and end
        int startOfString = 0;
        int endOfString = s.length() - 1;
        
        while (startOfString < endOfString) {
            if (s.charAt(startOfString) != s.charAt(endOfString)) return false;
            startOfString++;
            endOfString--;
        }
        return true;
    }

    public static void main(String []args){

    }
    

}