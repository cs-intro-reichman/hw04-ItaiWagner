public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // System.out.println(capVowelsLowRest("One two tHRee world"));
        // System.out.println(camelCase(" tWo    wordS"));
        // int[] testArray = allIndexOf("hello world", 'l');
        // for (int i = 0; i < testArray.length; i++) {
        //     System.out.print(testArray[i]);
        // }
    }

    /*
     * This function takes a string and uppercasing only the vowels, 
     * while lowecsing all of the other chars
     */
    public static String capVowelsLowRest (String string) {
        // Setting the constants
        String outStr = "";
        String lowVowels = "aeiou";
        String upVowels = "AEIOU";

        // looping through the entire input string
        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);
            boolean isLowVowel = false;
            boolean isUpVowel = false;
            // Checking if the tmpChar is a lower case or upper case vowel
            for (int v = 0; v < lowVowels.length(); v++) {
                if (tmpChar == lowVowels.charAt(v)) {
                    isLowVowel = true;
                    break;
                } else {
                    for (int V = 0; V < upVowels.length(); V++) {
                        if (tmpChar == upVowels.charAt(V)) {
                            isUpVowel = true;
                            break;
                        }
                    }
                }
            }
            // Appending the tmpChar to the outStr while manipulting its case
            if (isUpVowel) {
                outStr += tmpChar;
            } else if (isLowVowel) {
                tmpChar = upper(tmpChar);
                outStr += tmpChar;
            } else {
                if ((tmpChar != ' ') && (isUpperCase(tmpChar))) {
                    tmpChar = lower(tmpChar);
                    outStr += tmpChar;
                } else {
                    outStr += tmpChar;
                }
            }
        }
        return outStr;
    }


    /*
     * This function takes a string and CamelCasing it while removing whitespaces
     * and keeping the first word lowercased.
     */
    public static String camelCase (String string) {
        String outStr = "";
        int numOfWhiteSpaces = 0;
        int whiteSpaceIndex = 0;
        
        // Looping thorugh the entire input string
        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);
            // Handling the first word
            if (numOfWhiteSpaces == 0) {
                if (isLowerCase(tmpChar)) {
                    outStr += tmpChar;
                } else if (isUpperCase(tmpChar)) {
                    tmpChar = lower(tmpChar);
                    outStr += tmpChar;
                } else if ((tmpChar == ' ') && (i != 0)) {
                    numOfWhiteSpaces++;
                    whiteSpaceIndex = i;
                } else if ((tmpChar == ' ') && (i == 0)) {
                    numOfWhiteSpaces = 0;
                }
            // Handling the second word and beyond
            } else {
                if ((tmpChar != ' ') && (i == whiteSpaceIndex + 1)) {
                    if (isLowerCase(tmpChar)) {
                        tmpChar = upper(tmpChar);
                        outStr += tmpChar;
                    } else outStr += tmpChar;
                } else if (tmpChar != ' ') {
                    if (isUpperCase(tmpChar)) {
                        tmpChar = lower(tmpChar);
                        outStr += tmpChar;
                    } else outStr += tmpChar;
                } else if (tmpChar == ' ') {
                    whiteSpaceIndex = i;
                }
            }
        }
        return outStr;
    }




    /*
     * This function receives two parameters: A string and a character. 
     * The function returns an array containing all the indexes
     * in which the character appears in the string.
     */
    public static int[] allIndexOf (String string, char chr) {
        int incidents = 0;
        // checks the number of inciednts to determine the size of the array
        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);
            if (tmpChar == chr) {
                incidents++;
            }
        }
        // Creating the array
        int[] allIndexes = new int[incidents];
        int newIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            char tmpChar = string.charAt(i);            
            if (tmpChar == chr) {
                allIndexes[newIndex] = i;
                newIndex++;
            }
        }
        return allIndexes;
    }

    /*
     * This function gets a char and lower case it
     */
    public static char lower (char character) {
        character += 32;
        return character;
    }
    
    /*
     * This function gets a char and upper case it
     */
    public static char upper (char character) {
        character -= 32;
        return character;
    }

    /*
     * This function gets a char and checks if its upper case
     */
    public static boolean isUpperCase (char character) {
        if (character > 'A' && character < 'Z') return true;
        else return false;
    }

    /*
     * This function gets a char and checks if its lower case
     */
    public static boolean isLowerCase (char character) {
        if (character > 'a' && character < 'z') return true;
        else return false;
    }
}
