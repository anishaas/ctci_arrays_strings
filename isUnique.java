// Implement an algorithm to determine if a string has all unique characters
// What if you cannot use an additional data structure?

public class StringQuestions {

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