import java.awt.*;
import java.util.Arrays;

/*
--- Day 3: Spiral Memory ---
http://adventofcode.com/

You come across an experimental new kind of memory stored on an infinite two-dimensional grid.

Each square on the grid is allocated in a spiral pattern starting at a location marked 1 and then
counting up while spiraling outward. For example, the first few squares are allocated like this:

17  16  15  14  13
18   5   4   3  12
19   6   1   2  11
20   7   8   9  10
21  22  23---> ...
While this is very space-efficient (no squares are skipped), requested data must be carried back
to square 1 (the location of the only access port for this memory system) by programs that can
only move up, down, left, or right. They always take the shortest path: the Manhattan Distance
between the location of the data and square 1.

For example:

Data from square 1 is carried 0 steps, since it's at the access port.
Data from square 12 is carried 3 steps, such as: down, left, left.
Data from square 23 is carried only 2 steps: up twice.
Data from square 1024 must be carried 31 steps.
How many steps are required to carry the data from the square identified in your puzzle input
all the way to the access port?

Your puzzle answer was 480.


--- Part Two ---

As a stress test on the system, the programs here clear the grid and then store the value 1 in
square 1. Then, in the same allocation order as shown above, they store the sum of the values
in all adjacent squares, including diagonals.

So, the first few squares' values are chosen as follows:

Square 1 starts with the value 1.
Square 2 has only one adjacent filled square (with value 1), so it also stores 1.
Square 3 has both of the above squares as neighbors and stores the sum of their values, 2.
Square 4 has all three of the aforementioned squares as neighbors and stores the sum of their
values, 4.
Square 5 only has the first and fourth squares as neighbors, so it gets the value 5.
Once a square is written, its value does not change. Therefore, the first few squares would
receive the following values:

147  142  133  122   59
304    5    4    2   57
330   10    1    1   54
351   11   23   25   26
362  747  806--->   ...

What is the first value written that is larger than your puzzle input?
 */


public class dec3 {

    // Change for different scenarios
    // size is the closest odd number from the calc sqrt(findNum)
    private static int size = 591;
    private static int findNum = 347991;  // This is the input for the number in the question
    
    private static int minCol = 0;
    private static int minRow = 0;
    private static int maxRow = size-1;
    private static int maxCol = size-1;
    private static int[][] m  = new int[size][size];


    public static void main(String[] args){
        // Calculates the answer and prints the distance for part one
        m = createSpiralMatrix();
        int distance = calcPath(findNumber(m));
        System.out.println("First question:\nThe distance to " + findNum + " is: " + distance);

        // Prints the answer for part 2
        m = new int[size][size];
        int num = createSpiralMatrixV2();
        System.out.println("\nSecond question:\nThe first number bigger then " + findNum + " is: " + num);
    }


    // This method creates a spiral forming from the inside.
    // It also quits the process when the number bigger then the requested one appears.
    private static int createSpiralMatrixV2(){
        int counter = 2;
        int sum = 0;
        int xpos = size/2;
        int ypos = size/2;
        int steps = 1;
        m[xpos][ypos] = 1;  // Initiating the middle element
        xpos++;   // Jumps to the element where the loop start
        // This loops from the mid out and add +2 to step to get outside the area.
        while(counter < size*size){
                // Right side
            for (int i = ypos; i >= ypos-steps; i--) {
                sum = calcNeighbours(m,i,xpos);
                m[i][xpos] = sum;
                if (sum > findNum){ return sum; }  // checks the number
                counter++;
            }
                // Top side
            xpos--; ypos -= steps;
            for (int i = xpos; i >= xpos-steps; i--) {
                sum = calcNeighbours(m,ypos,i);
                m[ypos][i] = sum;
                if (sum > findNum){ return sum; }  // checks the number
                counter++;
            }
                // Left side
            ypos++; xpos -= steps;
            for (int i = ypos; i <= ypos+steps; i++) {
                sum = calcNeighbours(m,i,xpos);
                m[i][xpos] = sum;
                if (sum > findNum){ return sum; }  // checks the number
                counter++;
            }
                // Bottom side
            xpos++; ypos += steps;
            for (int i = xpos; i <= xpos+steps; i++) {
                sum = calcNeighbours(m,ypos,i);
                m[ypos][i] = sum;
                if (sum > findNum){ return sum; }  // checks the number
                counter++;
            }
            xpos++; xpos += steps;
            steps += 2;
        }
        return sum;
    }


    // First version of the spiral, This one goes from the bottom right corner
    // And ends upp at the centre of the matrix.
    private static int[][] createSpiralMatrix(){
        int num = size*size;
        int[][] m = new int[size][size];
        while(num > 0){
                // Bottom
            for (int i = maxCol; i >= minCol; i--) {
                m[maxRow][i] = num;
                num--;
            }   // left side
            for (int i = maxRow-1; i >= minRow+1; i--) {
                m[i][minCol] = num;
                num--;
            }   // Top side
            for (int i = minCol; i <= maxCol; i++) {
                m[minRow][i] = num;
                num--;
            }   // Right side
            for (int i = minRow+1; i < maxRow; i++) {
                m[i][maxCol] = num;
                num--;
            }
            if (num == 1){
                int mid = (size/2);
                m[mid][mid] = 1;
                num--;
            }
            maxCol-- ;maxRow-- ;minCol++ ;minRow++ ;
        }
        return m;
    }


    // finds the position of the number requested.
    private static Point findNumber(int[][] m){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(m[i][j] == findNum){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }


    // Using the point from findNumber to calc the path
    private static int calcPath(Point p){
        double distX = (p.getX())-(size/2);
        double distY = (p.getY())-(size/2);
        return (int)(Math.abs(distX) + Math.abs(distY));
    }


    // Checks valid location for the calcNeighbours method
    private static boolean isValidLocation(int size, int row, int col) {
        return 0 <= row && row < size && 0 <= col && col < size;
    }


    // Sums upp the Neighbours so that we can get right number in createMatrixV2
    private static int calcNeighbours(int[][] m, int x, int y){
        int sum = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isValidLocation(m.length, i, j)) {
                    sum += m[i][j];
                }
            }
        }
        return sum;
    }


    // Prints a matrix to help me with tests
    static void printMatrix(int[][] m){
        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
