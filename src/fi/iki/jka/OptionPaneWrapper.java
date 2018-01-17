package fi.iki.jka;

import javax.swing.*;
import java.awt.*;

public class OptionPaneWrapper implements Alerter {
    public void showMessageDialog(Component component, Object message, String appName, int errorCode) throws HeadlessException {
        JOptionPane.showMessageDialog(component, message, appName, errorCode);
    }
}
