package Models;

public class User {

    public String Name;
    public String Profile;
    public String Verified;
    public String Reddit_profile;
    public String Subscribers;
    public String Reddit_user;
    public String Total_Karma;

    /**
     * @author Kary Sutariya
     * @param Name name of writer
     * @param Profile profile name of writer
     * @param Verified is writer verified or not
     * @param Reddit_profile link of reddit profile of writer
     * @param Subscribers number of subscriber writer has
     * @param Reddit_user created account on
     * @param Total_Karma karma on reddit
     */
    public User(String Name, String Profile, String Verified, String Reddit_profile, String Subscribers, String Reddit_user, String Total_Karma)
    {
        this.Name = Name;
        this.Profile = Profile;
        this.Verified = Verified;
        this.Reddit_profile = Reddit_profile;
        this.Subscribers = Subscribers;
        this.Reddit_user = Reddit_user;
        this.Total_Karma = Total_Karma;
    }
}
