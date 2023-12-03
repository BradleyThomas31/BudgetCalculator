package src;

import javax.swing.*;

//uses to create a chain of budget pages
public interface GUIHandler {
    
    //each class handles the data in a standard or custom way
    //returns JPanel so it can be added to pre-existing frame
    JPanel handle();
}
