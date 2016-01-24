package xu.ferris.tab360;

/**
 * Created by Administrator on 2016/1/24.
 */
public class Tab {
    private String title;
    private int preview_image;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPreview_image() {
        return preview_image;
    }

    public void setPreview_image(int preview_image) {
        this.preview_image = preview_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
