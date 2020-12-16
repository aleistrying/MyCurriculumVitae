package com.peqa.example_name.structure.personStructure;

import java.util.List;
import java.util.ArrayList;

public class TechnicalSkills {
    List<TechnicalSkill> technicalSkills = new ArrayList<>();

    public void addTechnicalSkill(String categoryName, List<String> skills) {
        TechnicalSkill technicalSkill = new TechnicalSkill();
        technicalSkill.setCategoryName(categoryName);
        technicalSkill.setSkills(skills);
        technicalSkills.add(technicalSkill);
    }

    public List<TechnicalSkill> getTechnicalSkills() {
        return technicalSkills;
    }

    public int getSize() {
        return technicalSkills.size();
    }
}