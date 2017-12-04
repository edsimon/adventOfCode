import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*

--- Day 4: High-Entropy Passphrases ---

A new system policy has been put in place that requires all accounts to use a passphrase instead of simply a password. A passphrase consists of a series of words (lowercase letters) separated by spaces.

To ensure security, a valid passphrase must contain no duplicate words.

For example:

aa bb cc dd ee is valid.
aa bb cc dd aa is not valid - the word aa appears more than once.
aa bb cc dd aaa is valid - aa and aaa count as different words.
The system's full passphrase list is available as your puzzle input. How many passphrases are valid?


--- Part Two ---

For added security, yet another system policy has been put in place. Now, a valid passphrase must contain no two words that are anagrams of each other - that is, a passphrase is invalid if any word's letters can be rearranged to form any other word in the passphrase.

For example:

abcde fghij is a valid passphrase.
abcde xyz ecdab is not valid - the letters from the third word can be rearranged to form the first word.
a ab abc abd abf abj is a valid passphrase, because all letters need to be used when forming another word.
iiii oiii ooii oooi oooo is valid.
oiii ioii iioi iiio is not valid - any of these words can be rearranged to form any other word.
Under this new system policy, how many passphrases are valid?

 */




public class dec4{

    static int passPhrases = 0;
    static int newPassPhrases = 0;

    public static void main(String[] args){
        readFile("src/2017/resources/dec4.txt");
        System.out.println("Part one:\nTotal pass phrases is: " + passPhrases);
        System.out.println("\nPart two:\nTotal phrases is: " + newPassPhrases);
    }

    // sorts a string to be able to compare two strings.
    public static String sorted(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }

    // Reads a txt file with all the inputs.
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                passPhrase(scanner.nextLine());   // Calls the passPhrase method with each line
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Compare each string with the other one and adds one to the two
    // global variables, these are later printed as the resoult.
    static void passPhrase(String s){
        String[] str = s.split(" ");
        int totalPassPhrases = 0;
        int totalNewPassPhrases = 0;
        for(int i = 0; i < str.length;i++){
            for(int j = i; j < str.length; j++){
                if(i != j && str[i].equals(str[j])){
                    totalPassPhrases++;
                }
                if(i != j && sorted(str[i]).equals(sorted(str[j]))){
                    totalNewPassPhrases++;
                }
            }
        }
        // Adds to the global variables
        if (totalPassPhrases == 0){
            passPhrases++;
        }
        if (totalNewPassPhrases == 0){
            newPassPhrases++;
        }
    }
}