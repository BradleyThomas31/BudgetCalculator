package src;

import javax.swing.*;
import java.awt.FlowLayout;

public abstract class BasePage implements GUIHandler {

    protected JPanel panel;
    protected BasePage next;
//add other fields, like expected percent, improtance from 1-10, estiamted current value, etc.

    public BasePage() {
    }

    public BasePage getNext() {
        return next;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setNext(BasePage nextHandler) {
        this.next = nextHandler;
    }

    public abstract JPanel handle();
}

