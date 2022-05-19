/* 
Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards. 
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
*/

public class palindromePermutation {


    // for practice, start with only checking if palindrome
    boolean isPalindrome(String s) {
        // for a word to be a palindrome, the letters would mirror eachother, with one common letter in the middle
        // can find the middle char and then compare (mid_char - 1) and (mid_char + 1)
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