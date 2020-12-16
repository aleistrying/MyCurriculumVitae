package com.peqa.example_name.structure.personStructure;

import java.util.List;

public class TechnicalSkill {
    private String categoryName;
    private List<String> skills;

    public TechnicalSkill() {

    }

    public TechnicalSkill(String _categoryName, List<String> _skills) {

        categoryName = _categoryName;
        skills = _skills;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String _categoryName) {
        categoryName = _categoryName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> _skills) {
        skills = _skills;
    }
}
