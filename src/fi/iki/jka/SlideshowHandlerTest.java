package fi.iki.jka;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class MockAlerter implements Alerter {
    public boolean shownMessage = false;

    public void showMessageDialog(Component component, Object message, String appName, int errorCode) throws HeadlessException {
        this.shownMessage = true;
    }
}

class MockShowCreator implements ShowCreator {
    public boolean showCreated = false;
    public int interval = 0;

    public void CreateNewShow(JPhotoCollection photos, int interval, JPhotoList list) {
        showCreated = true;
        this.interval = interval;
    }
}


public class SlideshowHandlerTest {
    private MockAlerter mockAlerter;
    private MockShowCreator mockShowCreator;
    private SlideshowHandler slideshowHandler;

    @Before
    public void setUp() {
        mockAlerter = new MockAlerter();
        mockShowCreator = new MockShowCreator();
        slideshowHandler = new SlideshowHandler(mockAlerter, mockShowCreator);
    }

    @Test
    public void testShowsMessageWhenNoPhotos() {
        slideshowHandler.HandleSlideshow(null, new JPhotoCollection(new String[]{}), null, 5000);

        assertTrue(mockAlerter.shownMessage);
    }

    @Test
    public void testCreatesNewShowWhenHasPhotos() {
        slideshowHandler.HandleSlideshow(null, new JPhotoCollection(new String[]{""}), null, 5000);

        assertTrue(mockShowCreator.showCreated);
    }

    @Test
    public void testNoMessageShownWhenHasPhotos() {
        slideshowHandler.HandleSlideshow(null, new JPhotoCollection(new String[]{""}), null, 5000);

        assertFalse(mockAlerter.shownMessage);
    }

    @Test
    public void testNoCreateNewShowWhenNoPhotos() {
        slideshowHandler.HandleSlideshow(null, new JPhotoCollection(new String[]{}), null, 5000);

        assertFalse(mockShowCreator.showCreated);
    }

    @Test
    public void testIntervalIsPassedOn() {
        int interval = 1337;

        slideshowHandler.HandleSlideshow(null, new JPhotoCollection(new String[]{""}), null, interval);

        assertEquals(interval, mockShowCreator.interval);
    }

}