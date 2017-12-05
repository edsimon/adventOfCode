import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class dec5 {

    static ArrayList<Integer> instructions = new ArrayList<>();
    static ArrayList<Integer> test = new ArrayList<>();

    public static void main(String[] args){
        readFile();
        test.add(0);
        test.add(3);
        test.add(0);
        test.add(1);
        test.add(-3);
        System.out.println(calcNumberOfJumps());

    }


    static int calcNumberOfJumps(){
        int index = 0;
        int temp = 0;
        int totalJumps= 0;
        int nextJump = 0;

        while (index < instructions.size() ) {
            nextJump = instructions.get(index);

            if(nextJump > 2){
                temp = nextJump - 1;
            }else{
                temp = nextJump + 1;
            }

            instructions.set(index,temp);
            index += nextJump;
            totalJumps++;




            //System.out.println(index);
            //System.out.println(test);

            /*
            index = nextIndex;
            nextJump = test.get(index);
            test.set(index, nextJump +1);
            System.out.println(test);
            nextIndex += nextJump;
            totalJumps++;
*/
        }
        return totalJumps;
    }

    // Reads the dec5.txt and returns an ArrayList of type Integers
    private static ArrayList<Integer> readFile() {
        try {
            File file = new File("src/2017/resources/dec5.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                instructions.add(Integer.parseInt(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return instructions;
    }
}
