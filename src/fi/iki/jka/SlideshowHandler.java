package fi.iki.jka;

import javax.swing.*;
import java.awt.*;

import static fi.iki.jka.JPhotoFrame.APP_NAME;

public class SlideshowHandler {
    private final Alerter alerter;
    private final ShowCreator photoShowCreator;

    public SlideshowHandler(Alerter alerter, ShowCreator photoShowCreator) {
        this.alerter = alerter;
        this.photoShowCreator = photoShowCreator;
    }

    public void HandleSlideshow(Component component, JPhotoCollection photos, JPhotoList list, int interval) {
        if (photos.getSize()>0) {
            photoShowCreator.CreateNewShow(photos, interval, list);
        } else {
            alerter.showMessageDialog(component, "No photos to show!",
                    APP_NAME, JOptionPane.ERROR_MESSAGE);
        }
    }
}
