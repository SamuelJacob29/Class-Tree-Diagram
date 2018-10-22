
import csci338.drawings.*;

/**
 * @Author Samuel
 * @Version 1.00,  7 September 2018
 *
 * This program outlines a static class diagram with the parent class at the
 * very top of the window with all the subclasses linking below it.
 */

public class RunTest extends SimpleDrawing {
    
    /**
    *Variables:
    *
    *Boolean line is just a trigger used to determine weather a box has a line
    * pointing down to a subclass
    *
    *Integer lineSize is a number used to increase the size of all of the lines 
    *
    *Integer adjust is a variable used to adjust the length of some lines 
    * to make sure everything fits cleanly into the window
    */
     public static SimpleDrawing test = new SimpleDrawing();
    boolean line = true;
    public static int lineSize  = 75;
    public static int adjust = 25;

    /**
    *This method draws 6 lines to make up a single box. This method gets called 
    * in main with 3 parameters to determine its location.
    *
    *@param x Integer value to determine the horizontal location of the box
    *@param y Integer value to determine the vertical location of the box
    *@param line Boolean value if true it draws a line pointing 
    * down from the box, if false no line is drawn.
    */
    public static void drawRect(int x, int y, boolean line) {
        x = x - 75;

        for (int i = 0; i <= lineSize; i++) {
            //Top Lines
            test.showPoint(i + x, y);
            test.showPoint((lineSize + i) + x, y);
            //Bottom Lines
            test.showPoint(i + x, lineSize + y);
            test.showPoint((lineSize + i) + x, lineSize + y);
            //Left Line and Right Line
            test.showPoint(x, i + y);
            test.showPoint((lineSize + lineSize) + x, i + y);
            if (line == true) {
                test.showPoint(x + lineSize, i + y + lineSize);
            }
        }

    }
    /**
    *This method draws a single line that connects two boxes
    *
    *@param x Integer value to determine the horizontal location of the line
    *@param y Integer value to determine the vertical location of the line
    *@param line Boolean if true has an extension coming down on the right, if 
    * false the line comes down on the left side.
    */
    public static void connectingLines(int x, int y, boolean line) {
        x = x - 75;

        for (int i = 0; i <= lineSize; i++) {
            if (line == true) { // Extends Right
                test.showPoint(i + x + lineSize, y);
                test.showPoint((i + x + lineSize * 2) - adjust, y); //top
                test.showPoint((((lineSize * 3) + i) - adjust) + x, y);   //top 2
                test.showPoint(((lineSize * 4) + x) - adjust, i + y);    //Down

            } else { //Extends Left
                test.showPoint((i + x + lineSize), y);
                test.showPoint((i + x + lineSize) - adjust, y);  //top
                test.showPoint((((lineSize * 2) + i) + x) - adjust, y);   //top
                test.showPoint(x + lineSize - adjust, i + y);      //down

            }
        }
    }
    /**
    *Main method used for testing my other classes, i.e. drawing pixels on the 
    * screen to form diagram.
    */
    public static void main(String args[]) {
        //Parent
        drawRect(300, 1, true);

        connectingLines(300, 150, true);
        connectingLines(100, 150, true);
        connectingLines(125, 150, false);
        //First Row
        drawRect(100, 225, true);
        connectingLines(100, 375, true);
        drawRect(300, 225, false);
        connectingLines(100, 375, false);
        drawRect(500, 225, true);

        //Second Row
        drawRect(100, (375 + lineSize), false);
        drawRect(500, (300 + lineSize), false);
        drawRect(300, (375 + lineSize), false);

    }
}
