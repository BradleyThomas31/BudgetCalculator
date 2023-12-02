package src;

import javax.swing.*;
import java.awt.FlowLayout;

public abstract class BasePage implements GUIHandler {

    protected JPanel panel;
    protected BasePage next;

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

