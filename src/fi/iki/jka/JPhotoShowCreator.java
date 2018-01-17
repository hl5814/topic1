package fi.iki.jka;

public class JPhotoShowCreator implements ShowCreator {
    public void CreateNewShow(JPhotoCollection photos, int interval, JPhotoList list) {
            JPhotoShow show = new JPhotoShow(photos, interval, list);
            show.setVisible(true);
    }
}
