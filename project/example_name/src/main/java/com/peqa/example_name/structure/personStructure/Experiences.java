package com.peqa.example_name.structure.personStructure;

import java.util.List;
import java.util.ArrayList;

public class Experiences {
    List<Experience> experiences = new ArrayList<>();

    public void addExperience(String organizationName, int year, String position, List<String> details) {
        Experience experience = new Experience();
        experience.setOrganizationName(organizationName);
        experience.setYear(year);
        experience.setPosition(position);
        experience.setDetails(details);

        experiences.add(experience);
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public int getSize() {
        return experiences.size();
    }
}