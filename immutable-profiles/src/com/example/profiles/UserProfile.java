package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    private UserProfile(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.phone = builder.phone;
        this.displayName = builder.displayName;
        this.address = builder.address;
        this.marketingOptIn = builder.marketingOptIn;
        this.twitter = builder.twitter;
        this.github = builder.github;
    }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    public static class Builder{
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        public Builder(String id, String email){
            if(id == null || id.isBlank()){
                throw new Error("Id is must");
            }

            if(email == null || !email.contains("@")){
                throw new Error("email is must");
            }

            this.id = id;
            this.email = email;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }

        public Builder displayName(String displayName){
            this.displayName = displayName;
            return this;
        }

        public Builder address(String address){
            this.address = address;
            return this;
        }

        public Builder marketingOtpIn(boolean marketingOptIn){
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder twitter(String twitter){
            this.twitter = twitter;
            return this;
        }

        public Builder github(String github){
            this.github = github;
            return this;
        }

        public UserProfile build(){
            if(id == null || id.isBlank()){
                throw new Error("id is required");
            }

            if(email == null || !email.contains("@")){
                throw new Error("email is required");
            }

            return new UserProfile(this);
        }
    }
}
