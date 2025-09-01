package com.example.profiles;

import java.util.Objects;

/**
 * Assembles profiles with scattered, inconsistent validation.
 */
public class ProfileService {

    // returns a fully built profile but mutates it afterwards (bug-friendly)
    public UserProfile createMinimal(String id, String email) {
        // if (id == null || id.isBlank()) throw new IllegalArgumentException("bad id");
        // if (email == null || !email.contains("@")) throw new IllegalArgumentException("bad email");

        // UserProfile p = new UserProfile(id, email);
        // // later code keeps mutating...
        // return p;

        UserProfile.Builder builder = new UserProfile.Builder(id, email);
        if (id == null || id.isBlank()){
            throw new Error("id is required");
        }
   
        if (email == null || !email.contains("@")){
            throw new Error("Id is required");
        }

        return new UserProfile.Builder(id, email).build();
        
    }

    public UserProfile createUserProfile(String id, String email, String phone, String displayName, String address, boolean marketingOptIn, String twitter, String github){
        UserProfile.Builder builder = new UserProfile.Builder(id, email);
        if(phone!=null) builder.phone(phone);
        if(displayName!=null) builder.displayName(displayName);
        if(address!=null) builder.address(address);
        builder.marketingOtpIn(marketingOptIn);
        if(twitter!=null) builder.twitter(twitter);
        if(github!=null) builder.github(github);

        return builder.build();
    }
}
