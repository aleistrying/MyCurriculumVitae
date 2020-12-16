package com.peqa.example_name.structure.personStructure;

public class GeneralInfo {
    private String name;
    private String lastname;
    private String profesionalTitle;
    private String location;
    private String aboutMe;

    public GeneralInfo() {

    }

    public GeneralInfo(String _name, String _lastname, String _profesionalTitle, String _location, String _aboutMe) {
        name = _name;
        lastname = _lastname;
        location = _location;
        aboutMe = _aboutMe;
        profesionalTitle = _profesionalTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        name = _name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String _lastname) {
        lastname = _lastname;
    }

    public String getProfesionalTitle() {
        return profesionalTitle;
    }

    public void setProfesionalTitle(String _profesionalTitle) {
        profesionalTitle = _profesionalTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String _location) {
        location = _location;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String _aboutMe) {
        aboutMe = _aboutMe;
    }

}
