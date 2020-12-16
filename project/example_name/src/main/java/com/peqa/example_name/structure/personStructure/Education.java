package com.peqa.example_name.structure.personStructure;

public class Education {
    private String entityName;
    private int startYear;// probably should not put this in a cv.
    private int endYear;
    private String titleEarned;

    public Education() {

    }

    public Education(String _entityName, int _startYear, int _endYear, String _titleEarned) {
        entityName = _entityName;
        startYear = _startYear;
        endYear = _endYear;
        titleEarned = _titleEarned;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String _entityName) {
        entityName = _entityName;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int _startYear) {
        startYear = _startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int _endYear) {
        endYear = _endYear;
    }

    public String getTitleEarned() {
        return titleEarned;
    }

    public void setTitleEarned(String _titleEarned) {
        titleEarned = _titleEarned;
    }

}
