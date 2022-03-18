import java.awt.Color;

import javax.swing.plaf.ColorUIResource;

public class MyColor {
    private static Color color;
    //Color [] colors = {Color.CYAN,Color.GRAY,Color.GREEN,Color.YELLOW,Color.LIGHT_GRAY,Color.PINK,Color.WHITE,Color.BLACK,Color.BLUE,Color.DARK_GRAY,Color.MAGENTA,Color.ORANGE,
    		           //Color.RED};
    
//    public MyColor(){
//        color = Color.WHITE;
//    }
    
    
    static Color getColor(String col) {
    	switch (col.toLowerCase()) {
        case "black":
            color = Color.BLACK;
            break;
        case "blue":
            color = Color.BLUE;
            break;
        case "cyan":
            color = Color.CYAN;
            break;
        case "darkgray":
            color = Color.DARK_GRAY;
            break;
        case "gray":
            color = Color.GRAY;
            break;
        case "green":
            color = Color.GREEN;
            break;

        case "yellow":
            color = Color.YELLOW;
            break;
        case "lightgray":
            color = Color.LIGHT_GRAY;
            break;
        case "magneta":
            color = Color.MAGENTA;
            break;
        case "orange":
            color = Color.ORANGE;
            break;
        case "pink":
            color = Color.PINK;
            break;
        case "red":
            color = Color.RED;
            break;
        case "white":
            color = Color.WHITE;
            break;
        }
        return color;
    }
}
