import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Before: " + p.getEmail());
        // p.setEmail("evil@example.com"); // demonstrates mutability problem
        UserProfile p2 = new UserProfile.Builder(p.getId(), "evil@example.com")
        .phone(p.getPhone())
        .displayName(p.getDisplayName())
        .address(p.getAddress())
        .marketingOtpIn(p.isMarketingOptIn())
        .twitter(p.getTwitter())
        .github(p.getGithub())
        .build();

        System.out.println("After:  " + p.getEmail());
        System.out.println("=> In the solution, this setter disappears and object becomes immutable.");
    }
}
