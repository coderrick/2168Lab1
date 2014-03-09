
import java.awt.Color;
import simplegui.DrwImage;
import simplegui.RGB;
import simplegui.SimpleGUI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Programming PC ALT+F = Format CTRL + R = Rename CTRL + L + / =
 * Comment ALT + ENTER = Show error CTRL + E = Erase line CTRL + SHIFT + I =
 * Import
 */
public class Pixelator {
        public static DrwImage im = new DrwImage("Images/Pyramids.jpg");

    public static void main(String[] args) {
        SimpleGUI sg = new SimpleGUI();
        int width = im.getWidth();
        int height = im.getHeight();
        
        sg.drawImage(im, 0, 0, width, height, null);

        while (true) {
            sg.waitForButton1();
            int sliderValue = sg.getSliderValue();
            int pixsize = sliderValue / 5;
            for (int row = 0; row < width; row +=10 ) {
                for (int col = 0; col < height; col +=10) {
                    RGB temp = pixelize(row,col);
                   Color co = new Color(temp.r,temp.g,temp.b);
                   
                    sg.drawFilledBox(row, col, pixsize, pixsize, co, 1.0, null); 
                }
            }
            
        }
    }
    public static RGB pixelize(int x, int y) {
        int pixsize = 2;
        int red = 0;
        int green = 0;
        int blue = 0;
        int avgred = 0;
        int avggreen = 0;
        int avgblue = 0;


        
        RGB rgb = im.getPixelRGB(x, y);
        RGB color = new RGB();
        
        for (int i = x; i < x + (pixsize * pixsize)-1; i+=10) {
            for (int j = y; j < y + (pixsize * pixsize)-1; j+=10) { 
                red = red + rgb.r;
                green = green + rgb.g;
                blue = blue + rgb.b;
            }
        }
        avgred = (red);
        avggreen = (green);
        avgblue = (blue);
        color.r = avgred;
        color.g = avggreen;
        color.b = avgblue;
        return color;
    } 
}
