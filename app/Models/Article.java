package Models;

public class Article {
    private String title;
    private String selftext;
    private String subreddit;
    private String post_date;

    /**
     * @author Kary Sutariya
     * @param title title of article
     * @param selftext content of article
     * @param subreddit subreddit category of article
     * @param post_date date of post
     */
    public Article(String title, String selftext, String subreddit, String post_date)
    {
        this.title = title;
        this.selftext = selftext;
        this.subreddit = subreddit;
        this.post_date = post_date;
    }

    /**
     * @author Kary Sutariya
     * @return title
     */
    public String get_title()
    {
        return title;
    }

    /**
     * @author Kary Sutariya
     * @return selftext
     */
    public String get_selftext()
    {
        return selftext;
    }

    /**
     * @author Kary Sutariya
     * @return subreddit
     */
    public String get_subreddit()
    {
        return subreddit;
    }

    /**
     * @author Kary Sutariya
     * @return post_date
     */
    public String get_post_date()
    {
        return post_date;
    }
}
