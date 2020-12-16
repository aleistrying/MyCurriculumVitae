package com.peqa.example_name.structure.personStructure;

import java.util.List;
import java.util.ArrayList;

public class SocialLinks {
    List<SocialLink> socialLinks = new ArrayList<>();

    public void addSocialLinks(String texts, String details, String pathToImages) {
        SocialLink socialLink = new SocialLink();
        socialLink.setText(texts);
        socialLink.setDetail(details);
        socialLink.setPathToImage(pathToImages);

        socialLinks.add(socialLink);
    }

    public List<SocialLink> getSocialLinks() {
        return socialLinks;
    }

    public int getSize() {
        return socialLinks.size();
    }
}