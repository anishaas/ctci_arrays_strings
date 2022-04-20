// Implement an algorithm to determine if a string has all unique characters
// What if you cannot use an additional data structure?

public class StringQuestions {

    // Book Solution - using boolean array, characters' ascii values as indices to check for value true (indicating previous occurrence)  
    static boolean isUniqueChars(String str) {
        boolean isUnique = true;
        // false for each index meaning no occurrence of char (ascii value) yet
        boolean[] char_set = new boolean[128]; 
        for (int i= 0; i < str.length(); i++) {
            // get the ascii value of current char in string
            int val= str.charAt(i);
            // if a character with that ascii value has occurred in the string, this is a repeated char
            if (char_set[val]) {
                return false;
            }
            // at the index of ascii value, set boolean to true
            char_set[val] = true; 
        }
        for (boolean element: char_set) {
            System.out.println(element);
        }
        return true;
    }

    // solution without additional data structure
    static boolean isUniqueNoDS(String checkString) {
        boolean isUnique = true;
        
        for(int i = 0; i < checkString.length(); i++) {
            char currentChar = checkString.charAt(i);
            int comparisonIndex = i + 1;
            for(int j = comparisonIndex; j < checkString.length(); j++) {
                if(checkString.charAt(comparisonIndex) == currentChar) {
                    isUnique = false;
                }
                comparisonIndex = comparisonIndex + 1;
            }
        }
        return isUnique;
    }

    // review - public/private method cases
    static boolean isUnique(String checkString){
        boolean isUnique = true;
        char[] stringCharacters = new char[checkString.length()];

        //iterate through string, add each char to list
        for(int i = 0; i < checkString.length(); i++) {
            stringCharacters[i] = checkString.charAt(i);
        }
        // iteratively check for duplicate characters
        for(int i = 0; i < checkString.length(); i++) {
            char currentChar = checkString.charAt(i);
            int comparisonIndex = i + 1;
            for(int j = comparisonIndex; j < checkString.length(); j++) {
                if(checkString.charAt(comparisonIndex) == currentChar) {
                    isUnique = false;
                }
                comparisonIndex = comparisonIndex + 1;
            }
        }
        return isUnique;
    }

    public static void main(String []args){
        boolean isUniqueFalse = isUnique("notauniquestring");
        System.out.println(isUniqueFalse);
        
        boolean isUniqueTrue = isUnique("uniqstr");
        System.out.println(isUniqueTrue);

        isUniqueFalse = isUniqueNoDS("notauniquestring");
        System.out.println(isUniqueFalse);
        
        isUniqueTrue = isUniqueNoDS("uniqstr");
        System.out.println(isUniqueTrue);
     }
}