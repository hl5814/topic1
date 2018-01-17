package fi.iki.jka;

import java.awt.*;

public interface Alerter {
    void showMessageDialog(Component component, Object message, String appName, int errorCode) throws HeadlessException;
}
