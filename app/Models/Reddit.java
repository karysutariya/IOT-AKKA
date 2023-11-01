package Models;

public class Reddit {

    public String author;
    public String title;
    public String reddit;

    /**
     * @author Kary Sutariya
     * @param author name of author
     * @param title title of article
     * @param reddit reddit of article
     */
    public Reddit(String author, String title, String reddit)
    {
        this.author = author;
        this.title = title;
        this.reddit = reddit;
    }

    /**
     * @author Kary Sutariya
     * @return reddit
     */
    public String getReddit() {
        return reddit;
    }

}
