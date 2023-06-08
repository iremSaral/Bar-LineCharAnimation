package sample;

public abstract class Chart {

    public String title;
    public String xAxisLabel;

    public Chart(String title, String xAxisLabel) {
        this.title = title;
        this.xAxisLabel = xAxisLabel;
    }

    public void setCaption(String caption) {
        this.title = caption;
    }

    public void reset(Bar bar) {
        bar.groupBar.clear();
    }
}
