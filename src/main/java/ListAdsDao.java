import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
            1,
            1,
            "playstation for sale",
            "This is a slightly used playstation"
        ));
        ads.add(new Ad(
            2,
            1,
            "Super Nintendo",
            "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
            3,
            2,
            "Junior Java Developer Position",
            "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
            4,
            2,
            "JavaScript Developer needed",
            "Must have strong Java skills"
        ));
        ads.add(new Ad(
                5,
                3,
                "Super System Attendant",
                "Minimum 7 years of experience required. You will be working in the scripting language of attendant"
        ));
        ads.add(new Ad(
                6,
                2,
                "Marry Me?",
                "Minimum 7 years of communication skills, and relationship and team building abilities."
        ));
        ads.add(new Ad(
                7,
                4,
                "Just looking for friends??",
                "Friendship wanted, friendship needed. Thank You."
        ));
        return ads;
    }
}
