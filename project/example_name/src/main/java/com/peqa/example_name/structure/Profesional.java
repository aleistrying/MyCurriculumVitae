package com.peqa.example_name.structure;

import com.peqa.example_name.structure.personStructure.*;

public class Profesional {
    private int id;
    private GeneralInfo gi;
    private Educations ed;
    private Experiences ex;
    private Projects pr;
    private SocialLinks sl;
    private TechnicalSkills ts;

    public Profesional() {

    }

    public Profesional(int _id, GeneralInfo _gi, Educations _ed, Experiences _ex, Projects _pr, SocialLinks _sl,
            TechnicalSkills _ts) {
        id = _id;
        gi = _gi;
        ed = _ed;
        ex = _ex;
        pr = _pr;
        sl = _sl;
        ts = _ts;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        id = _id;
    }

    public GeneralInfo getGeneralInfo() {
        return gi;
    }

    public void setGeneralInfo(GeneralInfo _gi) {
        gi = _gi;
    }

    public Educations getEducations() {
        return ed;
    }

    public void setEducations(Educations _ed) {
        ed = _ed;
    }

    public Experiences getExperiences() {
        return ex;
    }

    public void setExperiences(Experiences _ex) {
        ex = _ex;
    }

    public Projects getProjects() {
        return pr;
    }

    public void setProjects(Projects _pr) {
        pr = _pr;
    }

    public SocialLinks getSocialLinks() {
        return sl;
    }

    public void setSocialLinks(SocialLinks _sl) {
        sl = _sl;
    }

    public TechnicalSkills getTechnicalSkills() {
        return ts;
    }

    public void setTechnicalSkills(TechnicalSkills _ts) {
        ts = _ts;
    }

}
