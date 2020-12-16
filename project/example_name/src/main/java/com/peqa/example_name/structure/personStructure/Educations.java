package com.peqa.example_name.structure.personStructure;

import java.util.List;
import java.util.ArrayList;


public class Educations {
    List<Education> educations = new ArrayList<>();

    public void addEducation(String entityName, int startYear, int endYear, String titleEarned) {
        Education education = new Education();
        education.setEntityName(entityName);
        education.setStartYear(startYear);
        education.setEndYear(endYear);
        education.setTitleEarned(titleEarned);
        educations.add(education);
    }

    public List<Education> getEducations() {
        return educations;
    }

    public int getSize() {
        return educations.size();
    }
}