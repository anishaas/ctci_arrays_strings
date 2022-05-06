public class URLify {

    // Book solution
    // A common approach in string manipulation is starting at the end
    // Useful because we have an extra buffer at the end
    // Algorithm uses two-scan approach
    // First scan - count # of spaces and *3 to compute additional chars in final string
    // Second scan - in reverse order, edit the string with replacement or copy original char

    void replaceSpaces(char[] str, int trueLength) {
        // LOOK UP - variable declaration multiple on one line
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        // REVIEW - Why spaceCount * 2
        index = trueLength + spaceCount * 2;
        // REVIEW - What is the str length? The length of the original string, right? 
        // Isn't true length also the original length?
        if (trueLength < str.length) str[trueLength] = '\0';
        // Go through string in reverse order
        for (i = trueLength - 1; i >= 0; i--) {
            // replace space by copying one char at a time
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index -3;
            }else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }
    
    
    // IN PROGRESS - initial thought (iterative approach, replace at detection)
    static String replaceSpaces(String s) {
        String replacementString = "%20";
        // iterate through each char in string
        for(int i=0; i<s.length();i++) {
            // find occurrence of a space
            if(s.charAt(i) == ' '){
                // copy replacement string char by char to this position
                // implementation of replacing char by char in book solution
            }
        }
        return s;
    }

    public static void main(String []args){

     }
}

// Future reading - Review implications of strings being immutable & why we use charArrays to  make changes
// Also, concept of editing in reverse order to avoid undesired overwriting