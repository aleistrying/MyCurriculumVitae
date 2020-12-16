package com.peqa.example_name.structure.personStructure;

import java.util.ArrayList;
import java.util.List;

public class Experience {
    private String organizationName;
    private int year;
    private String position;
    private List<String> details = new ArrayList<>();

    public Experience() {

    }

    public Experience(String _organizationName, int _year, String _position, List<String> _details) {
        organizationName = _organizationName;
        year = _year;
        position = _position;
        details = _details;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String _organizationName) {
        organizationName = _organizationName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int _year) {
        year = _year;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String _position) {
        position = _position;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> _details) {
        details = _details;
    }
}
